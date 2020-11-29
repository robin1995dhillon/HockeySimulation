package dhl.trade;

import dhl.leagueModel.gamePlayConfig.IGamePlayConfig;
import dhl.leagueModel.teams.ITeam;

public interface IPlayerTrade {

    void tradeAi(ITeam offeringTeam, ITeam consideringTeam, IGamePlayConfig gamePlayConfig);

    void tradeUser(ITeam offeringTeam, ITeam consideringTeam, IGamePlayConfig gamePlayConfig);

    int countTeamPlayers(ITeam team);
}
