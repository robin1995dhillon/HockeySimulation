package dhl.trade;

import dhl.leagueModel.gamePlayConfig.IGamePlayConfig;
import dhl.leagueModel.IPlayers;
import dhl.leagueModel.teams.ITeam;

import java.util.List;

public interface IStrongestWeakestPlayers {

    List<IPlayers> checkStrongestPlayer(ITeam tradingTeam, String positionToTrade);

    double strongestPlayersStrength(List<IPlayers> selectedPLayers);

    List<IPlayers> checkWeakestPlayer(ITeam tradingTeam, IGamePlayConfig gamePlayConfig);

}
