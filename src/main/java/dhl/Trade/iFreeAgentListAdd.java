package dhl.Trade;

import dhl.LeagueModel.IFreeAgents;
import dhl.LeagueModel.IPlayers;
import dhl.LeagueModel.ITeam;

import java.util.List;

public interface iFreeAgentListAdd {

    void aiAgentListAdd(ITeam team, int numberOfPlayers);
    void addSkater(List<IPlayers> players, int playersToBeAdded);
    void addGoalie(List<IPlayers> players, int goalieCount);
    List<IFreeAgents> sortedAgentsGoalieList(int goaliesToBeAdded);
    List<IFreeAgents> sortedAgentsSkaterList(int playersToBeAdded);
    void addSkaterUser(List<IPlayers> player, int playersToBeAdded);
    void addGoalieUser(List<IPlayers> player, int playersToBeAdded);
    List<IFreeAgents> strongestAgentsList(List<IFreeAgents> list);
    boolean checkPlayerInList(List<IPlayers> playerList,String agentName);
}
