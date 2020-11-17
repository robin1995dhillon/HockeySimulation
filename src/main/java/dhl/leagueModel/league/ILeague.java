package dhl.leagueModel.league;

import dhl.leagueModel.conference.IConference;
import dhl.leagueModel.freeAgents.IFreeAgents;
import dhl.leagueModel.gamePlayConfig.IGamePlayConfig;
import dhl.leagueModel.headCoach.IHeadCoach;

import java.util.ArrayList;
import java.util.List;

public interface ILeague {
    List<IConference> getConferences();

    void setConferences(List<IConference> conferences);

    String getLeagueName();

    void setLeagueName(String leagueName);

    List<IFreeAgents> getFreeAgents();

    List<String> getGeneralManagers();

    List<IHeadCoach> getCoaches();

    void removeManagerFromList(List<String> managerList, String managerName);

    void setFreeAgents(List<IFreeAgents> freeAgents);

    void setHeadCoach(List<IHeadCoach> coaches);

    void setGeneralManager(List<String> generalManagers);

    void saveManager(String name, int leagueID);

    IGamePlayConfig getGameplayConfig();

    void setGameplayConfig(IGamePlayConfig gameplayConfig);

    boolean isValid(ILeague league);

    boolean isLeagueNamePresent();

    void storeLeague();
}
