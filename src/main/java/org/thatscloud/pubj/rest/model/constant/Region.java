package org.thatscloud.pubj.rest.model.constant;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Region
{
    @JsonProperty( "agg" )
    AGGREGATE,
    @JsonProperty( "na" )
    NORTH_AMERICA,
    @JsonProperty( "eu" )
    EUROPE,
    @JsonProperty( "as" )
    ASIA,
    @JsonProperty( "oc" )
    OCEANIA,
    @JsonProperty( "sa" )
    SOUTH_AMERICA,
    @JsonProperty( "sea" )
    SOUTH_EAST_ASIA,
    @JsonProperty( "krjp" )
    KOREA_JAPAN
}
