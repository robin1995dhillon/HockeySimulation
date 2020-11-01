package dhl.trade;

import dhl.leagueModel.IPlayers;
import dhl.leagueModel.ITeam;

import java.util.List;

public interface IPlayerTradingCondition {

    void tradeCondition(List<ITeam> allTeams);
    List<IPlayers> getPositionTypesOffering(List<IPlayers> players);
    List<IPlayers> offeringTeamPlayersList();
    List<IPlayers> offeringTeamPositionPlayersList();
    List<IPlayers> consideringTeamPlayersList();
}
