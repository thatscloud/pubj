package org.thatscloud.pubj.rest.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.thatscloud.pubj.rest.model.constant.Mode;
import org.thatscloud.pubj.rest.model.constant.Region;

public final class RegionSeasonModeStatsKey
{
    private final Region myRegion;
    private final String mySeason;
    private final Mode myMode;

    public RegionSeasonModeStatsKey( final Region region,
                                     final String season,
                                     final Mode mode )
    {
        myRegion = region;
        mySeason = season;
        myMode = mode;
    }

    @Override
    public int hashCode()
    {
        return new HashCodeBuilder()
            .append( myRegion )
            .append( mySeason )
            .append( myMode )
            .build();
    }

    @Override
    public boolean equals( final Object obj )
    {
        return
            obj instanceof RegionSeasonModeStatsKey &&
            new EqualsBuilder()
                .append( myRegion, ( (RegionSeasonModeStatsKey)obj ).getRegion() )
                .append( mySeason, ( (RegionSeasonModeStatsKey)obj ).getSeason() )
                .append( myMode, ( (RegionSeasonModeStatsKey)obj ).getMode() )
                .build();
    }

    public Region getRegion()
    {
        return myRegion;
    }

    public String getSeason()
    {
        return mySeason;
    }

    public Mode getMode()
    {
        return myMode;
    }
}
