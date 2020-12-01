package dhl.leagueModel.trade;

import dhl.leagueModel.IPlayers;
import dhl.leagueModel.gamePlayConfig.IGamePlayConfig;
import dhl.leagueModel.ITeam;

import java.util.List;

public interface IPlayerTradingCondition {

    void tradeCondition(List<ITeam> allTeams, IGamePlayConfig gameplayConfig);

    List<IPlayers> getPositionTypesOffering(List<IPlayers> players);

}
