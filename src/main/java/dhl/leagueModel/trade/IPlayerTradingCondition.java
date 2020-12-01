package dhl.leagueModel.trade;

import dhl.leagueModel.IPlayers;
import dhl.leagueModel.ITeam;
import dhl.leagueModel.gamePlayConfig.IGamePlayConfig;

import java.util.List;

public interface IPlayerTradingCondition {

    void tradeCondition(List<ITeam> allTeams, IGamePlayConfig gameplayConfig);

    List<IPlayers> getPositionTypesOffering(List<IPlayers> players);

    List<IPlayers> offeringTeamPlayersList();

    List<IPlayers> offeringTeamPositionPlayersList();

    List<IPlayers> consideringTeamPlayersList();

//     List<IPlayers> getConsideringTeamPlayers();
//
//     void setConsideringTeamPlayers(List<IPlayers> consideringTeamPlayers);
//
//     List<IPlayers> getOfferingTeamPositionPlayers();
//
//     void setOfferingTeamPositionPlayers(List<IPlayers> offeringTeamPositionPlayers);
}
