package dhl.Trade;

import dhl.LeagueModel.IPlayers;
import dhl.LeagueModel.ITeam2;

import java.util.List;
import java.util.Map;

public interface IPlayerTradingCondition {

    void tradeCondition(List<ITeam2> allTeams);
    List<IPlayers> getPositionTypesOffering(List<IPlayers> players);
    List<IPlayers> offeringTeamPlayersList();
    List<IPlayers> offeringTeamPositionPlayersList();
    List<IPlayers> consideringTeamPlayersList();
}
