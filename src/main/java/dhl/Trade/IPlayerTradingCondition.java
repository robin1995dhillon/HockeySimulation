package dhl.Trade;

import dhl.LeagueModel.IPlayers;
import dhl.LeagueModel.ITeam2;

import java.util.List;
import java.util.Map;

public interface IPlayerTradingCondition {

    void tradeCondition(List<ITeam2> allTeams);
    //List<IPlayers> checkWeakestPlayer(ITeam2 tradingTeam);
  //  void TradeAi(ITeam2 offeringTeam, ITeam2 consideringTeam);
   // void TradeUser(ITeam2 offeringTeam, ITeam2 consideringTeam);
   /// List<IPlayers> checkStrongestPlayer(ITeam2 tradingTeam ,String positionToTrade);
    List<IPlayers> getPositionTypesOffering(List<IPlayers> players);
   // double StrongestPlayersStrength(List<IPlayers> selectedPLayers);
   // int countTeamPlayers(ITeam2 team);
    List<IPlayers> offeringTeamPlayersList();
    List<IPlayers> offeringTeamPositionPlayersList();
    List<IPlayers> consideringTeamPlayersList();
   // void addDropPlayers(ITeam2 team, int totalPlayers);
}
