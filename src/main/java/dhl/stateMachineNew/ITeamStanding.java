package dhl.stateMachineNew;

import dhl.leagueModel.teams.ITeam;

public interface ITeamStanding {

    ITeam getTeam();

    void setTeam(ITeam teamName);

    String getDivision();

    void setDivision(String divisionName);

    String getConference();

    void setConference(String conferenceName);

    int getGamesPlayed();

    void setGamesPlayed(int gamesPlayed);

    int getGamesWon();

    void setGamesWon(int gamesWon);

    int getGamesLost();

    void setGamesLost(int gamesLost);

    int getTotalPoints();

    void setTotalPoints(int totalPoints);

}
