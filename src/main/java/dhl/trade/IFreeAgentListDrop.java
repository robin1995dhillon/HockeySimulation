package dhl.trade;

import dhl.leagueModel.players.IPlayers;
import dhl.leagueModel.teams.ITeam;

import java.util.List;

public interface IFreeAgentListDrop {

    void agentListDrop(ITeam team, int playersToBeDropped);

    void dropSkaterAi(List<IPlayers> players, int playersToBeDropped);

    void dropGoalieAi(List<IPlayers> players, int goalieCount);

    List<IPlayers> sortedPLayerSkaterList(List<IPlayers> players, int playersToBeDropped);

    List<IPlayers> sortedPLayerGoalieList(List<IPlayers> players, int goaliesToBeDropped);

    void dropSkaterUser(List<IPlayers> players, int playersToBeDropped);

    void dropGoalieUser(List<IPlayers> players, int playersToBeDropped);

}
