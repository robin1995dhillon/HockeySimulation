package dhl.stateMachineNew;

import dhl.leagueModel.teams.ITeam;

import java.text.ParseException;

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

    void playoffSchedule(StateMachine machine) throws ParseException;

    String getLastDayOfSeason();

    String getLastDayOfStanleyPlayoffs();

    void generateSchedule(StateMachine machine) throws ParseException;

    boolean isLastDayOfTrade(String currentDate);

    String getStartDayOfSeason();


}
