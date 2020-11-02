package dhl.presentation;

import dhl.leagueModel.players.IPlayers;

import java.util.List;

public interface ITradePrompt {

    void userAcceptRejectTrade(List<IPlayers> players);
}
