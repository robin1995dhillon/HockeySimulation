package dhl.leagueModel.trade;

import dhl.leagueModel.gamePlayConfig.IGamePlayConfig;
import dhl.leagueModel.IPlayers;
import dhl.leagueModel.ITeam;

import java.util.List;

public interface IStrongestWeakestPlayers {

    List<IPlayers> checkStrongestPlayer(ITeam tradingTeam, String positionToTrade, int gamePlayConfig);

    double strongestPlayersStrength(List<IPlayers> selectedPLayers);

    List<IPlayers> checkWeakestPlayer(ITeam tradingTeam, IGamePlayConfig gamePlayConfig);

}
