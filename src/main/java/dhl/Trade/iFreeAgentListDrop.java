package dhl.Trade;

import dhl.LeagueModel.IPlayers;
import dhl.LeagueModel.ITeam2;

import java.util.List;

public interface iFreeAgentListDrop {

    void agentListDrop(ITeam2 team, int playersToBeDropped);
    void dropSkater(List<IPlayers> players, int playersToBeDropped);
    void dropGoalie(List<IPlayers> players, int goalieCount);

}
