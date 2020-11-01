package dhl.leagueModel;

import dhl.gamePlayConfig.IGamePlayConfig;

import java.util.ArrayList;
import java.util.List;

public interface ILeague {
    ArrayList<IConference> getConferences();

    void setConferences(ArrayList<IConference> conferences);

    String getLeagueName();

    void setLeagueName(String leagueName);
    ArrayList<IFreeAgents> getFreeAgents();
    ArrayList<String> getGeneralManagers();
    ArrayList<IHeadCoach> getCoaches();
    void removeManagerFromList(List<String> managerList, String managerName);

    void setFreeAgents(ArrayList<IFreeAgents> freeAgents);
    void setHeadCoach(ArrayList<IHeadCoach> coaches);
    void setGeneralManager(ArrayList<String> generalManagers);

    IGamePlayConfig getGameplayConfig();

    void setGameplayConfig(IGamePlayConfig gameplayConfig);

    boolean isValid(ILeague league);
    boolean isLeagueNamePresent();

    void storeLeague();
}