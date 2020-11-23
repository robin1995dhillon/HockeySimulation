package dhl.leagueModel.league;

import dhl.leagueModel.conference.IConference;
import dhl.leagueModel.freeAgents.IFreeAgents;
import dhl.leagueModel.gamePlayConfig.IGamePlayConfig;
import dhl.leagueModel.generalManager.IGeneralManager;
import dhl.leagueModel.headCoach.IHeadCoach;
import dhl.stateMachineNew.ISchedulerSeason;
import dhl.stateMachineNew.ITeamStanding;

import java.util.ArrayList;
import java.util.List;

public interface ILeague {
    List<IConference> getConferences();

    void setConferences(List<IConference> conferences);

    String getLeagueName();

    void setLeagueName(String leagueName);

    List<IFreeAgents> getFreeAgents();

    List<IGeneralManager> getGeneralManagers();

    List<IHeadCoach> getCoaches();

    void setFreeAgents(List<IFreeAgents> freeAgents);

    void setHeadCoach(List<IHeadCoach> coaches);

    void setGeneralManagers(List<IGeneralManager> generalManagers);

    void saveManager(String name, int leagueID);

    IGamePlayConfig getGameplayConfig();

    void setGameplayConfig(IGamePlayConfig gameplayConfig);

    boolean isValid(ILeague league);

    boolean isLeagueNamePresent();

    void setSchedules(List<ISchedulerSeason> gameSchedules);

    List<ISchedulerSeason> getGameSchedules();

    List<ITeamStanding> getTeamStandingList();

    void setTeamStandingList(List<ITeamStanding> teamStandingList);

//    void storeLeague();

    String getDate();

    void setDate(String startDateOfSeason);

    String getLastDateOfSeason();

    void setLastDateOfSeason(String lastDateOfSeason);

    int getSeason();

    void setSeason(int season);

    int getTotalSeasons();

    void setTotalSeasons(int numberOfSeasons);

}
