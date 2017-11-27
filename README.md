# pubj

A Java wrapper for the [TRN PUBG REST API](https://pubgtracker.com/site-api).

## Prerequisites

This API requires a key. Visit [the TRN PUBG REST API page](https://pubgtracker.com/site-api) 
to generate a key.

## Obtaining the Library

The library is currently available on [jcenter](https://bintray.com/bintray/jcenter?filterByPkgName=pubj) and [Maven Central](https://search.maven.org/#search%7Cga%7C1%7Ca%3A%22pubj%22).

### Gradle

    compile 'org.thatscloud:pubj:0.1.0'
    
### Maven
   
    <dependency> 
      <groupId>org.thatscloud</groupId>
      <artifactId>pubj</artifactId>
      <version>0.1.0</version> 
      <type>pom</type>
    </dependency>

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
the rate limiting imposed by [TRN](https://thetrackernetwork.com/) is respected.

## Building

To build the library, execute the following command in the root directory in *nix:

    ./gradlew build

In Windows:

    gradlew.bat build
    
The output is located under the `build/libs` directory.