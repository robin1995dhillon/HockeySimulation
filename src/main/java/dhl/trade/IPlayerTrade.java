package dhl.trade;

import dhl.leagueModel.teams.ITeam;

public interface IPlayerTrade {

    void tradeAi(ITeam offeringTeam, ITeam consideringTeam);

    void tradeUser(ITeam offeringTeam, ITeam consideringTeam);

    int countTeamPlayers(ITeam team);
}
