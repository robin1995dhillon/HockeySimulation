package dhl.leagueModel.trade;

import dhl.leagueModel.IPlayers;
import dhl.leagueModel.gamePlayConfig.IGamePlayConfig;
import dhl.leagueModel.teams.ITeam;

import java.util.List;

public interface IPlayerTrade {

    void tradeAi(ITeam offeringTeam, ITeam consideringTeam, IGamePlayConfig gamePlayConfig);

    void tradeUser(ITeam offeringTeam, ITeam consideringTeam, IGamePlayConfig gamePlayConfig);

    int countTeamPlayers(ITeam team);
}
