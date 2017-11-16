package org.thatscloud.pubj;

public class PubgConfig
{
    private final long myDelayBetweenApiCallsInMilliseconds;
    private final String myBaseRestUrl;
    private final String myApiKey;

    public static PubgConfigBuilder builder()
    {
        return new PubgConfigBuilder();
    }

    private PubgConfig( final PubgConfigBuilder pubgConfigBuilder )
    {
        myDelayBetweenApiCallsInMilliseconds =
            pubgConfigBuilder.myDelayBetweenApiCallsInMilliseconds;
        myBaseRestUrl = pubgConfigBuilder.myBaseRestUrl;
        myApiKey = pubgConfigBuilder.myApiKey;
    }

    public long getDelayBetweenApiCallsInMilliseconds()
    {
        return myDelayBetweenApiCallsInMilliseconds;
    }

    public String getBaseRestUrl()
    {
        return myBaseRestUrl;
    }

    public String getApiKey()
    {
        return myApiKey;
    }

    public static class PubgConfigBuilder
    {
        private long myDelayBetweenApiCallsInMilliseconds;
        private String myBaseRestUrl;
        private String myApiKey;


        private PubgConfigBuilder()
        {
            myDelayBetweenApiCallsInMilliseconds = 2200L;
            myBaseRestUrl = "https://api.pubgtracker.com/v2";
        }

        public PubgConfigBuilder delayBetweenApiCallsInMilliseconds(
            final long delayBetweenApiCallsInMilliseconds )
        {
            myDelayBetweenApiCallsInMilliseconds = delayBetweenApiCallsInMilliseconds;
            return this;
        }

        public PubgConfigBuilder baseRestUrl( final String baseRestUrl )
        {
            myBaseRestUrl = baseRestUrl;
            return this;
        }

        public PubgConfigBuilder apiKey( final String apiKey )
        {
            myApiKey = apiKey;
            return this;
        }

        public PubgConfig build()
        {
            return new PubgConfig( this );
        }
    }
}
