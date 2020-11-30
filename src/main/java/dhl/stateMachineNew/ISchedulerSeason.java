package dhl.stateMachineNew;

import dhl.leagueModel.IConference;
import dhl.leagueModel.IDivision;
import dhl.leagueModel.ILeague;
import dhl.leagueModel.ITeam;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

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

    String getLastDayOfSeason() throws ParseException;

    String getLastDayOfStanleyPlayoffs();

    void generateSchedule(StateMachine machine) throws ParseException;

    boolean isLastDayOfTrade(String currentDate,int playoffsYear) throws ParseException;

    String getStartDayOfSeason();

    String schedule(List<ITeam> teamsInFormat, ITeam teamName, String currentDate) throws ParseException;

    void initialize(ILeague league);

    void setCurrentYear(String currentYear);

    String getFirstDayOfSeason();

    void setPlayoffsYear(int playoffsYear);

    String getFirstDayOfStanleyPlayoffs();

    String enterIntoPlayerDraft();

    String getLastDayOfTrade();

    boolean isLastDayOfSeason(String currentDate, String lastDate);

    void setLastDayOfSeason(String lastDay);

    void setScheduleList(List<ISchedulerSeason> list);

    void addSchedule(ITeam team, ITeam opponentTeam, String currentDay, String gameType);

    List<ISchedulerSeason> getScheduleList();

    String scheduleInterConfGames(IConference conferenceName, ITeam teamName, String currentDate) throws ParseException;

    Map<IConference, List<ITeam>> getTeamsInConference();

    void setTeamsInConference(Map<IConference, List<ITeam>> teamsInConference);

    String scheduleInterDivGames(IConference conferenceName, IDivision divisionName, ITeam teamName, String currentDate) throws ParseException;

    Map<IConference, List<IDivision>> getDivisionsInConference();

    void setDivisionsInConference(Map<IConference, List<IDivision>> divisionsInConference);

    Map<IDivision, List<ITeam>> getTeamsInDivision();

    void setTeamsInDivision(Map<IDivision, List<ITeam>> teamsInDivision);

    String scheduleIntraDivGames(IDivision divisionName, ITeam teamName, String currentDate) throws ParseException;

}
