package dhl.stateMachineNew;

import dhl.leagueModel.league.ILeague;
import dhl.leagueModel.teams.ITeam;

public interface IGameSimulation {

    public boolean simulateGame(ITeam firstTeam, ITeam opponentTeam, double firstTeamStrength, double opponentTeamTeamStrength, ILeague league);
}
