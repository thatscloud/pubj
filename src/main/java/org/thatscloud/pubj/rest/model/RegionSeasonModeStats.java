package org.thatscloud.pubj.rest.model;

import java.util.Map;
import java.util.function.Function;

import org.thatscloud.pubj.rest.model.constant.Mode;
import org.thatscloud.pubj.rest.model.constant.Region;
import org.thatscloud.pubj.rest.model.constant.StatField;
import org.thatscloud.pubj.util.json.ArrayToMapDeserialiser;
import org.thatscloud.pubj.util.json.annotation.JsonKey;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class RegionSeasonModeStats extends BaseJsonEntity
{
    private Region myRegion;
    private String mySeason;
    private Mode myMode;
    private Map<StatField, Stat> myStats;

    public Region getRegion()
    {
        return myRegion;
    }

    public void setRegion( final Region region )
    {
        myRegion = region;
    }

    public String getSeason()
    {
        return mySeason;
    }

    public void setSeason( final String season )
    {
        mySeason = season;
    }

    public Mode getMode()
    {
        return myMode;
    }
    public void setMode( final Mode mode )
    {
        myMode = mode;
    }

    public static class StatsKeyMapper implements Function<Stat, StatField>
    {
        @Override
        public StatField apply( final Stat t )
        {
            return t.getField();
        }
    }

    @JsonKey( StatsKeyMapper.class )
    @JsonDeserialize( using = ArrayToMapDeserialiser.class )
    public Map<StatField, Stat> getStats()
    {
        return myStats;
    }

    public void setStats( final Map<StatField, Stat> stats )
    {
        myStats = stats;
    }
}
