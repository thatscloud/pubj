package org.thatscloud.pubj;

import static com.fasterxml.jackson.databind.DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL;
import static java.time.Instant.now;
import static org.glassfish.jersey.CommonProperties.FEATURE_AUTO_DISCOVERY_DISABLE;
import static org.glassfish.jersey.CommonProperties.JSON_PROCESSING_FEATURE_DISABLE;
import static org.glassfish.jersey.CommonProperties.METAINF_SERVICES_LOOKUP_DISABLE;

import java.io.Closeable;
import java.time.Duration;
import java.time.Instant;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import org.thatscloud.pubj.rest.model.Player;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

public class Pubg implements Closeable
{
    private final long myMillisBetweenCalls;
    private final String myApiKey;
    private final String myBaseRestUrl;
    private final Client myClient;

    private Instant myLastApiCallTime;

    public Pubg( final PubgConfig pubgConfig )
    {
        myMillisBetweenCalls = pubgConfig.getDelayBetweenApiCallsInMilliseconds();
        myBaseRestUrl = pubgConfig.getBaseRestUrl();
        myApiKey = pubgConfig.getApiKey();
        myLastApiCallTime = Instant.MIN;
        myClient =
            ClientBuilder.newClient()
                .property( FEATURE_AUTO_DISCOVERY_DISABLE, true )
                .property( JSON_PROCESSING_FEATURE_DISABLE, true )
                .property( METAINF_SERVICES_LOOKUP_DISABLE, true )
                .register(
                    new JacksonJsonProvider(
                        new ObjectMapper()
                            .registerModule( new ParameterNamesModule() )
                            .registerModule( new Jdk8Module() )
                            .registerModule( new JavaTimeModule() )
                            .configure( READ_UNKNOWN_ENUM_VALUES_AS_NULL, true ) ) );
    }

    public Pubg( final String apiKey )
    {
        this( PubgConfig.builder().apiKey( apiKey ).build() );
    }

    private synchronized void waitForCallRateLimit()
    {
        if( myMillisBetweenCalls > 0 )
        {
            while( myLastApiCallTime.plusMillis( myMillisBetweenCalls ).isAfter( now() ) )
            {
                try
                {
                    Thread.sleep(
                        Duration.between( now(),
                                          myLastApiCallTime.plusMillis( myMillisBetweenCalls ) )
                            .toMillis() );
                }
                catch( final InterruptedException e )
                {
                    throw new RuntimeException( e );
                }
            }
        }
    }

    public synchronized Player getPlayer( final String playerName )
    {
        waitForCallRateLimit();
        try
        {
            return myClient
                .target( myBaseRestUrl )
                .path( "profile" )
                .path( "pc" )
                .path( playerName )
                .request()
                .header( "TRN-Api-Key", myApiKey )
                .get( Player.class );
        }
        finally
        {
            myLastApiCallTime = now();
        }
    }

    @Override
    public void close()
    {
        myClient.close();
    }
}
