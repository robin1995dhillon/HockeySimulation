package dhl.Trade;

import dhl.LeagueModel.IPlayers;
import dhl.LeagueModel.ITeam2;

import java.util.List;

public interface IStrongestWeakestPlayers {

    List<IPlayers> checkStrongestPlayer(ITeam2 tradingTeam, String positionToTrade);
    double StrongestPlayersStrength(List<IPlayers> selectedPLayers);
    List<IPlayers> checkWeakestPlayer(ITeam2 tradingTeam);

}
