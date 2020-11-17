package dhl.stateMachineNew;

import dhl.leagueModel.teams.ITeam;

public interface ISchedulerSeason {

    ITeam getFirstTeam();

    ITeam getSecondTeam();

    String getDateOfMatch();

    String getGameType();

    String getStatus();

    void setFirstTeam(ITeam teamFirst);

    void setSecondTeam(ITeam teamSecond);

    void setDateOfMatch(String date);

    void setGameType(String gameType);

    void setStatus(String status);



}
