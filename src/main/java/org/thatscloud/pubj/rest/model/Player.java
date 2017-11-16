package org.thatscloud.pubj.rest.model;

import java.time.Instant;
import java.util.Map;
import java.util.function.Function;

import org.thatscloud.pubj.util.json.ArrayToMapDeserialiser;
import org.thatscloud.pubj.util.json.LenientInstantDeserialiser;
import org.thatscloud.pubj.util.json.annotation.JsonKey;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class Player extends BaseJsonEntity
{
    private Long myPubgTrackerId;
    private String myAccountId;
    private Long myPlatform;
    private String myNickname;
    private String myAvatar;
    private String mySteamName;
    private Instant myLastUpdated;
    private Map<RegionSeasonModeStatsKey, RegionSeasonModeStats> myStats;

    public Long getPubgTrackerId()
    {
        return myPubgTrackerId;
    }

    public void setPubgTrackerId( final Long pubgTrackerId )
    {
        myPubgTrackerId = pubgTrackerId;
    }

    public String getAccountId()
    {
        return myAccountId;
    }

    public void setAccountId( final String accountId )
    {
        myAccountId = accountId;
    }

    public Long getPlatform()
    {
        return myPlatform;
    }

    public void setPlatform( final Long platform )
    {
        myPlatform = platform;
    }

    public String getNickname()
    {
        return myNickname;
    }

    public void setNickname( final String nickname )
    {
        myNickname = nickname;
    }

    public String getAvatar()
    {
        return myAvatar;
    }

    public void setAvatar( final String avatar )
    {
        myAvatar = avatar;
    }

    public String getSteamName()
    {
        return mySteamName;
    }

    public void setSteamName( final String steamName )
    {
        mySteamName = steamName;
    }

    @JsonDeserialize( using = LenientInstantDeserialiser.class )
    public Instant getLastUpdated()
    {
        return myLastUpdated;
    }

    public void setLastUpdated( final Instant lastUpdated )
    {
        myLastUpdated = lastUpdated;
    }

    public static class RegionSeasonModeStatsKeyMapper implements
        Function<RegionSeasonModeStats, RegionSeasonModeStatsKey>
    {
        @Override
        public RegionSeasonModeStatsKey apply( final RegionSeasonModeStats t )
        {
            return new RegionSeasonModeStatsKey( t.getRegion(),
                                                 t.getSeason(),
                                                 t.getMode() );
        }
    }

    @JsonKey( RegionSeasonModeStatsKeyMapper.class )
    @JsonDeserialize( using = ArrayToMapDeserialiser.class )
    public Map<RegionSeasonModeStatsKey, RegionSeasonModeStats> getStats()
    {
        return myStats;
    }

    public void setStats( final Map<RegionSeasonModeStatsKey, RegionSeasonModeStats> stats )
    {
        myStats = stats;
    }
}
