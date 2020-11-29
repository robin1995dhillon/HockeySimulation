package dhl.leagueModel.trade;

import dhl.leagueModel.IFreeAgents;
import dhl.leagueModel.IPlayers;
import dhl.leagueModel.league.ILeague;
import dhl.leagueModel.teams.ITeam;

import java.util.List;

public interface IFreeAgentListAdd {

    void addPlayer(List<IPlayers> player, int playersToBeAdded, int goalieCount);

    List<IFreeAgents> sortedAgentsList(int playersToBeAdded, int goalieCount);

    void addPlayerUser(List<IPlayers> player, int playersToBeAdded, int goalieCount);

    void aiAgentListAdd(ITeam team, int numberOfPlayers);

    void setAvailableLeague(ILeague league);

//    void addSkater(List<IPlayers> players, int playersToBeAdded);

//    void addGoalie(List<IPlayers> players, int goalieCount);

//    List<IFreeAgents> sortedAgentsGoalieList(int goaliesToBeAdded);

//    List<IFreeAgents> sortedAgentsSkaterList(int playersToBeAdded);

//    void addSkaterUser(List<IPlayers> player, int playersToBeAdded);

//    void addGoalieUser(List<IPlayers> player, int playersToBeAdded);

    List<IFreeAgents> strongestAgentsList(List<IFreeAgents> list);

    boolean checkPlayerInList(List<IPlayers> playerList, String agentName);
    List<IPlayers> strongestPlayersList(List<IPlayers> list);
}
