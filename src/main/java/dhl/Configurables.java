package dhl;

public enum Configurables {
    FORWARD("forward"),
    DEFENSE("defense"),
    GOALIE("goalie"),
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
    PLAYOFF("Playoff");


    private String action;

    public String getAction() {
        return this.action;
    }

    Configurables(String action) {
        this.action = action;
    }
}

