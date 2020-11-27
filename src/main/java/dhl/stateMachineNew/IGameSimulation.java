package dhl.stateMachineNew;

import dhl.gameSimulationAlgorithm.IGameSimulationAlgorithm;
import dhl.gameSimulationAlgorithm.IShiftTime;
import dhl.leagueModel.league.ILeague;
import dhl.leagueModel.teams.ITeam;

public interface IGameSimulation {

    void simulateGame(ITeam offensiveTeam, ITeam defendingTeam, ILeague league, IGameSimulationAlgorithm algorithm, IShiftTime shiftTime);
    void teamWin(ITeam team, ITeamStanding teamStanding);
    void teamLost(ITeam team, ITeamStanding teamStanding);
    void teamDraw(ITeam team, ITeamStanding teamStanding);

}
