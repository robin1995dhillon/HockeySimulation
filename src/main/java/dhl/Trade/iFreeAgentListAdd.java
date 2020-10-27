package dhl.Trade;

import dhl.LeagueModel.IFreeAgents;
import dhl.LeagueModel.IPlayers;
import dhl.LeagueModel.ITeam2;

import java.util.List;

public interface iFreeAgentListAdd {

    void aiAgentListAdd(ITeam2 team, int numberOfPlayers);
    void addSkater(List<IPlayers> players, int playersToBeAdded);
    void addGoalie(List<IPlayers> players, int goalieCount);
    List<IFreeAgents> sortedAgentsGoalieList(int goaliesToBeAdded);
    List<IFreeAgents> sortedAgentsSkaterList(int playersToBeAdded);
}
