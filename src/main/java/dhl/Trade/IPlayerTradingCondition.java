package dhl.Trade;

import dhl.LeagueModel.IPlayers;
import dhl.LeagueModel.ITeam2;

import java.util.List;
import java.util.Map;

public interface IPlayerTradingCondition {
     void tradeCondition(List<ITeam2> tradeTeams);
     List<IPlayers> checkWeakestPlayer(ITeam2 tradingTeam , int weakestCount);
     void TradeAi(ITeam2 offeringTeam, ITeam2 consideringTeam); //delete if other works

   // public double strength(IPlayers player);
  //  public List<IPlayers> checkStrongestPlayer(ITeam2 tradingTeam , int weakestCount, String positionToTrade);
   void TradeUser(ITeam2 offeringTeam, ITeam2 consideringTeam);
    List<IPlayers> checkStrongestPlayer(ITeam2 tradingTeam ,String positionToTrade);
    List<IPlayers> getPositionTypesOffering(List<IPlayers> players);
   // ITeam2 getTradeTeamName(Map<ITeam2,Double> allTeams);
    double StrongestPlayersStrength(List<IPlayers> selectedPLayers);
}
