package org.thatscloud.pubj.rest.model.constant;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum StatField
{
    @JsonProperty( "KillDeathRatio" )
    KILL_DEATH_RATIO,
    @JsonProperty( "WinRatio" )
    WIN_RATIO,
    @JsonProperty( "TimeSurvived" )
    TIME_SURVIVED,
    @JsonProperty( "RoundsPlayed" )
    ROUNDS_PLAYED,
    @JsonProperty( "Wins" )
    WINS,
    @JsonProperty( "WinTop10Ratio" )
    WIN_TOP_10_RATIO,
    @JsonProperty( "Top10s" )
    TOP_10S,
    @JsonProperty( "Top10Ratio" )
    TOP_10_RATIO,
    @JsonProperty( "Losses" )
    LOSSES,
    @JsonProperty( "Rating" )
    RATING,
    @JsonProperty( "BestRating" )
    BEST_RATING,
    @JsonProperty( "BestRank" )
    BEST_RANK,
    @JsonProperty( "DamagePg" )
    DAMAGE_PER_GAME,
    @JsonProperty( "HeadshotKillsPg" )
    HEADSHOT_KILLS_PER_GAME,
    @JsonProperty( "HealsPg" )
    HEALS_PER_GAME,
    @JsonProperty( "KillsPg" )
    KILLS_PER_GAME,
    @JsonProperty( "MoveDistancePg" )
    MOVE_DISTANCE_PER_GAME,
    @JsonProperty( "RevivesPg" )
    REVIVES_PER_GAME,
    @JsonProperty( "RoadKillsPg" )
    ROAD_KILLS_PER_GAME,
    @JsonProperty( "TeamKillsPg" )
    TEAM_KILLS_PER_GAME,
    @JsonProperty( "TimeSurvivedPg" )
    TIME_SURVIVED_PER_GAME,
    @JsonProperty( "Top10sPg" )
    TOP_10S_PER_GAME,
    @JsonProperty( "Kills" )
    KILLS,
    @JsonProperty( "Assists" )
    ASSISTS,
    @JsonProperty( "Suicides" )
    SUICIDES,
    @JsonProperty( "TeamKills" )
    TEAM_KILLS,
    @JsonProperty( "HeadshotKills" )
    HEADSHOT_KILLS,
    @JsonProperty( "HeadshotKillRatio" )
    HEADSHOT_KILL_RATIO,
    @JsonProperty( "VehicleDestroys" )
    VEHICLE_DESTROYS,
    @JsonProperty( "RoadKills" )
    ROAD_KILLS,
    @JsonProperty( "DailyKills" )
    DAILY_KILLS,
    @JsonProperty( "WeeklyKills" )
    WEEKLY_KILLS,
    @JsonProperty( "RoundMostKills" )
    ROUND_MOST_KILLS,
    @JsonProperty( "MaxKillStreaks" )
    MAX_KILL_STREAKS,
    @JsonProperty( "WeaponAcquired" )
    WEAPONS_ACQUIRED,
    @JsonProperty( "Days" )
    DAYS,
    @JsonProperty( "LongestTimeSurvived" )
    LONGEST_TIME_SURVIVED,
    @JsonProperty( "MostSurvivalTime" )
    MOST_SURVIVAL_TIME,
    @JsonProperty( "AvgSurvivalTime" )
    AVERAGE_SURVIVAL_TIME,
    @JsonProperty( "WinPoints" )
    WIN_POINTS,
    @JsonProperty( "WalkDistance" )
    WALK_DISTANCE,
    @JsonProperty( "RideDistance" )
    RIDE_DISTANCE,
    @JsonProperty( "MoveDistance" )
    MOVE_DISTANCE,
    @JsonProperty( "AvgWalkDistance" )
    AVERAGE_WALK_DISTANCE,
    @JsonProperty( "AvgRideDistance" )
    AVERAGE_RIDE_DISTANCE,
    @JsonProperty( "LongestKill" )
    LONGEST_KILL,
    @JsonProperty( "Heals" )
    HEALS,
    @JsonProperty( "Revives" )
    REVIVES,
    @JsonProperty( "Boosts" )
    BOOSTS,
    @JsonProperty( "DamageDealt" )
    DAMAGE_DEALT,
    @JsonProperty( "DBNOs" )
    KNOCK_OUTS

}
