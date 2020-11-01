package dhl.trade;

import dhl.leagueModel.IPlayers;
import dhl.leagueModel.ITeam;

import java.util.List;

public interface IStrongestWeakestPlayers {

    List<IPlayers> checkStrongestPlayer(ITeam tradingTeam, String positionToTrade);
    double StrongestPlayersStrength(List<IPlayers> selectedPLayers);
    List<IPlayers> checkWeakestPlayer(ITeam tradingTeam);

}
