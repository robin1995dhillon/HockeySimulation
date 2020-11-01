package dhl.Trade;

import dhl.LeagueModel.IPlayers;
import dhl.LeagueModel.ITeam;

import java.util.List;

public interface IStrongestWeakestPlayers {

    List<IPlayers> checkStrongestPlayer(ITeam tradingTeam, String positionToTrade);
    double StrongestPlayersStrength(List<IPlayers> selectedPLayers);
    List<IPlayers> checkWeakestPlayer(ITeam tradingTeam);

}
