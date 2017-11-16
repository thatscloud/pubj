package org.thatscloud.pubj.rest.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties( ignoreUnknown = true )
public abstract class BaseJsonEntity
{
    private final Map<String, Object> myUnknownProperties = new HashMap<>();;

    @JsonAnyGetter
    public Object get( final String key )
    {
        return myUnknownProperties.get( key );
    }

    @JsonAnySetter
    public void setUnknownProperties( final String key, final String value )
    {
        myUnknownProperties.put( key, value );
    }

    public Set<Entry<String, Object>> unknownProperties()
    {
        return myUnknownProperties.entrySet();
    }

    public boolean hasUnknownProperties()
    {
        return !myUnknownProperties.isEmpty();
    }
}
