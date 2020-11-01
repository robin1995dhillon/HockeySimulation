package dhl.Trade;

import dhl.LeagueModel.IPlayers;
import dhl.LeagueModel.ITeam;

import java.util.List;

public interface iFreeAgentListDrop {

    void agentListDrop(ITeam team, int playersToBeDropped);
    void dropSkaterAi(List<IPlayers> players, int playersToBeDropped);
    void dropGoalieAi(List<IPlayers> players, int goalieCount);
    List<IPlayers> sortedPLayerSkaterList(List<IPlayers> players, int playersToBeDropped);
    List<IPlayers> sortedPLayerGoalieList(List<IPlayers> players,int goaliesToBeDropped);
    void dropSkaterUser(List<IPlayers> players, int playersToBeDropped);
    void dropGoalieUser(List<IPlayers> players, int playersToBeDropped);

}
