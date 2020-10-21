package dhl.Trade;

import dhl.LeagueModel.IPlayers;
import dhl.LeagueModel.ITeam2;

import java.util.List;

public interface IPlayerTradingCondition {
    public void tradeCondition(List<ITeam2> tradeTeams);
    public List<IPlayers> checkWeakestPlayer(ITeam2 tradingTeam , int weakestCount);
    public void TradeAi(ITeam2 offeringTeam, ITeam2 consideringTeam);
    public double strength(IPlayers player);
    public List<IPlayers> checkStrongestPlayer(ITeam2 tradingTeam , int weakestCount, String positionToTrade);
    public List<IPlayers> getPositionTypesOffering(List<IPlayers> players);
}
