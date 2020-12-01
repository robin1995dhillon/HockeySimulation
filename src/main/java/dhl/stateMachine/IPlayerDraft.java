package dhl.stateMachine;

import dhl.leagueModel.IPlayers;

import java.util.List;

public interface IPlayerDraft {
    List<IPlayers> generateRandomPlayers(int numberOfTeams);

    List<ITeamStanding> getTeamStandingList();

    List<ITeamStanding> selectionOrder(List<ITeamStanding> teamStandingList);
}
