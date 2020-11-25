package dhl.stateMachineNew;

import dhl.leagueModel.league.ILeague;
import dhl.leagueModel.teams.ITeam;

public interface IGameSimulation {

    void simulateGame(ITeam firstTeam, ITeam opponentTeam, double firstTeamStrength, double opponentTeamTeamStrength, ILeague league);

    void opponentTeamLose(ITeam opponentTeam, ITeamStanding teamStanding);

    void firstTeamLose(ITeam firstTeam, ITeamStanding teamStanding);

    void opponentTeamLoseReverse(ITeam opponentTeam, ITeamStanding teamStanding);

    void firstTeamLoseReverse(ITeam firstTeam, ITeamStanding teamStanding);
}
