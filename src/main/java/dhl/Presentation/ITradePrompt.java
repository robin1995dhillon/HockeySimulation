package dhl.Presentation;

import dhl.LeagueModel.IPlayers;

import java.util.List;

public interface ITradePrompt {

    void userAcceptRejectTrade(List<IPlayers> players);
}
