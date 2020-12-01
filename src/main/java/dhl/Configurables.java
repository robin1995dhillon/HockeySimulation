package dhl;

public enum Configurables {
    FORWARD("forward"),
    DEFENSE("defense"),
    GOALIE("goalie"),
    SKATER("skater"),
    LEAGUENAME("leagueName"),
    CONFERENCES("conferences"),
    CONFERENCENAME("conferenceName"),
    DIVISIONS("divisions"),
    DIVISIONNAME("divisionName"),
    TEAMS("teams"),
    TEAMNAME("teamName"),
    PLAYERS("players"),
    PLAYERNAME("playerName"),
    FREEAGENTS("freeAgents"),
    GENERALMANAGER("generalManager"),
    GENERALMANAGERS("generalManagers"),
    ID("id"),
    AGING("aging"),
    AGE("age"),
    AVERAGERETIREMENTAGE("averageRetirementAge"),
    MAXIMUMAGE("maximumAge"),
    GAMEPLAYCONFIG("gameplayConfig"),
    GAMERESOLVER("gameResolver"),
    RANDOMWINCHANCE("randomWinChance"),
    INJURIES("injuries"),
    RANDOMINJURYCHANCE("randomInjuryChance"),
    INJURYDAYSLOW("injuryDaysLow"),
    INJURYDAYSHIGH("injuryDaysHigh"),
    TRADING("trading"),
    RANDOMTRADEOFFERCHANCE("randomTradeOfferChance"),
    RANDOMACCEPTANCECHANCE("randomAcceptanceChance"),
    LOSSPOINT("lossPoint"),
    MAXPLAYERSPERTRADE("maxPlayersPerTrade"),
    TRAINING("training"),
    DAYSUNTILSTATINCREASECHECK("daysUntilStatIncreaseCheck"),
    YES("y"),
    NO("n"),
    CAPTAIN("captain"),
    COACHES("coaches"),
    HEADCOACH("headCoach"),
    SKATING("skating"),
    SHOOTING("shooting"),
    CHECKING("checking"),
    SAVING("saving"),
    NAME("name"),
    POSITION("position"),
    AI("ai"),
    USER("user"),
    BIRTHDAY("birthDay"),
    BIRTHYEAR("birthYear"),
    BIRTHMONTH("birthMonth"),
    PERSONALITY("personality"),
    STATDECAYCHANCE("statDecayChance"),
    ISVALID("isValid"),
    TRUE("True"),
    REGULAR("Regular"),
    SCHEDULED("Scheduled"),
    PLAYED("played"),
    START_DAY_OF_SEASON("30-09-"),
    FIRST_DAY_OF_SEASON( "01-10-"),
    TOTAL_PLAYERS("30"),
    LAST_DAY_OF_SEASON_MONTH("-04-"),
    LAST_DAY_OF_STANLEY_PLAYOFFS("01-06-"),
    TOTAL_GOALIES("4"),
    TOTAL_DEFENSE("10"),
    TOTAL_FORWARD("16"),
    PLAYER_DRAFT_DATE("15-07-"),
    MONTH_OF_TRADE("-02-"),
    PLAYOFF("Playoff");

    private String action;

    public String getAction() {
        return this.action;
    }

    Configurables(String action) {
        this.action = action;
    }
}

