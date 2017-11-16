package org.thatscloud.pubj.util.json;

import java.io.IOException;
import java.time.Instant;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class LenientInstantDeserialiser extends StdDeserializer<Instant>
{
    private static final long serialVersionUID = 1L;

    public LenientInstantDeserialiser()
    {
        super( Instant.class );
    }

    @Override
    public Instant deserialize( final JsonParser p, final DeserializationContext ctxt )
        throws IOException, JsonProcessingException
    {
        final String rawValue = p.getValueAsString();
        return Instant.parse( rawValue.endsWith( "Z" ) ? rawValue : rawValue + "Z" );
    }
}
