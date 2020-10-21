package dhl.Trade;

import dhl.LeagueModel.IPlayers2;
import dhl.LeagueModel.ITeam2;

import java.util.ArrayList;
import java.util.List;

public interface IPlayerTradingCondition {
    public void tradeCondition(List<ITeam2> tradeTeams);
    public List<IPlayers2> checkWeakestPlayer(ITeam2 tradingTeam , int weakestCount);
    public void TradeAi(ITeam2 offeringTeam, ITeam2 consideringTeam);
    public double strength(IPlayers2 player);
    public List<IPlayers2> checkStrongestPlayer(ITeam2 tradingTeam , int weakestCount,String positionToTrade);
    public List<IPlayers2> getPositionTypesOffering(List<IPlayers2> players);
}
