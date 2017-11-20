# pubj

A Java wrapper for the [TRN PUBG REST API]((https://pubgtracker.com/site-api).

## Prerequisites

This API requires a key. Visit [the TRN PUBG REST API page](https://pubgtracker.com/site-api) 
to generate a key.

## Sample Code

### Lookup a player
    
    import org.thatscloud.pubj.Pubg;
    import org.thatscloud.pubj.rest.model.Player;
    
    ...
    
    final String apiKey = "MY-TRN-API-KEY";
    try( final Pubg pubg = new Pubg( apiKey ) )
    {
        final Player player = pubg.getPlayer( playerName );
    }

### Get match statistics
    
    import static org.thatscloud.pubj.rest.model.constant.Mode.SOLO;
    import static org.thatscloud.pubj.rest.model.constant.Region.AGGREGATE;
    import static org.thatscloud.pubj.rest.model.constant.StatField.KILLS;
    import org.thatscloud.pubj.rest.model.RegionSeasonModeStatsKey;
    
    ...
    
    final Player player = ...
    final long kills =
        player.getStats()
            .get( new RegionSeasonModeStatsKey( AGGREGATE, "2017-pre5", SOLO ) )
            .getStats()
            .get( KILLS )
            .getValueInt();

## Rate limiting

Use no more than one `org.thatscloud.pubj.Pubg` instance per application. This will ensure that
the rate-limiting imposed by [TRN](https://thetrackernetwork.com/) is respected.

