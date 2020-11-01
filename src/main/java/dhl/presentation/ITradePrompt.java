package dhl.presentation;

import dhl.leagueModel.IPlayers;

import java.util.List;

public interface ITradePrompt {

    void userAcceptRejectTrade(List<IPlayers> players);
}
