package dhl.leagueModel.trade;

import dhl.leagueModel.ITeam;
import dhl.leagueModel.gamePlayConfig.IGamePlayConfig;

public interface IPlayerTrade {

    void tradeAi(ITeam offeringTeam, ITeam consideringTeam, IGamePlayConfig gamePlayConfig);

    void tradeUser(ITeam offeringTeam, ITeam consideringTeam, IGamePlayConfig gamePlayConfig);

    int countTeamPlayers(ITeam team);
}
