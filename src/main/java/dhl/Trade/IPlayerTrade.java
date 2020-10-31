package dhl.Trade;

import dhl.LeagueModel.ITeam2;

public interface IPlayerTrade {

    void TradeAi(ITeam2 offeringTeam, ITeam2 consideringTeam);
    void TradeUser(ITeam2 offeringTeam, ITeam2 consideringTeam);
    int countTeamPlayers(ITeam2 team);
}
