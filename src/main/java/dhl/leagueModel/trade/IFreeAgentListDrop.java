package dhl.leagueModel.trade;

import dhl.leagueModel.IPlayers;
import dhl.leagueModel.teams.ITeam;

import java.util.List;

public interface IFreeAgentListDrop {

    void agentListDrop(ITeam team, int playersToBeDropped);

//    void dropSkaterAi(List<IPlayers> players, int playersToBeDropped);

//    void dropGoalieAi(List<IPlayers> players, int goalieCount);

    void dropAi(List<IPlayers> players, int playersToBeDropped, int goalieCount);

    List<IPlayers> sortedPlayerList(List<IPlayers> players, int playersToBeDropped, int goaliesToBeDropped);

    void dropUser(List<IPlayers> player, int playersToBeDropped, int goalieCount);

//    List<IPlayers> sortedPlayerSkaterList(List<IPlayers> players, int playersToBeDropped);

//    List<IPlayers> sortedPlayerGoalieList(List<IPlayers> players, int goaliesToBeDropped);

//    void dropSkaterUser(List<IPlayers> players, int playersToBeDropped);

//    void dropGoalieUser(List<IPlayers> players, int playersToBeDropped);

}
