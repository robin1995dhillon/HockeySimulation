package dhl.Trade;

import dhl.LeagueModel.ITeam;

public interface IPlayerTrade {

    void TradeAi(ITeam offeringTeam, ITeam consideringTeam);
    void TradeUser(ITeam offeringTeam, ITeam consideringTeam);
    int countTeamPlayers(ITeam team);
}
