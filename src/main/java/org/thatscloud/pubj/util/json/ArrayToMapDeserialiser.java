package org.thatscloud.pubj.util.json;

import static java.util.function.Function.identity;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.thatscloud.pubj.util.json.annotation.JsonKey;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class ArrayToMapDeserialiser<K, V>
  extends StdDeserializer<Map<K, V>>
  implements ContextualDeserializer
{
    private static final long serialVersionUID = 1L;

    private final Function<V, K> myKeyMapper;
    private final JavaType myValueType;

    public ArrayToMapDeserialiser()
    {
        this( null, null );
    }

    private ArrayToMapDeserialiser( final Function<V, K> keyMapper,
                                    final JavaType valueType )
    {
        super( Map.class );
        myKeyMapper = keyMapper;
        myValueType = valueType;
    }

    @SuppressWarnings( "unchecked" )
    @Override
    public Map<K, V> deserialize( final JsonParser p, final DeserializationContext ctxt )
        throws IOException, JsonProcessingException
    {
        return ( (List<V>)p.getCodec()
            .readValue( p, ctxt.getTypeFactory()
                               .constructCollectionType( List.class, myValueType ) ) )
            .stream()
            .filter( value -> myKeyMapper.apply( value ) != null )
            .collect( Collectors.toMap( myKeyMapper, identity() ) );
    }

    @SuppressWarnings( "unchecked" )
    @Override
    public JsonDeserializer<?> createContextual( final DeserializationContext ctxt,
                                                 final BeanProperty property )
        throws JsonMappingException
    {
        try
        {
            return new ArrayToMapDeserialiser<>(
                (Function<V, K>)property
                    .getAnnotation( JsonKey.class )
                    .value()
                    .newInstance(),
                property.getType().getContentType() );
        }
        catch( final IllegalAccessException | InstantiationException e )
        {
            throw new RuntimeException( e );
        }
    }
}
