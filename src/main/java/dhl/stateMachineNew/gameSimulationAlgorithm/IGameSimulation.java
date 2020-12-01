package dhl.stateMachineNew.gameSimulationAlgorithm;

import dhl.leagueModel.ILeague;
import dhl.leagueModel.ITeam;
import dhl.stateMachineNew.ITeamStanding;

public interface IGameSimulation {

    void simulateGame(ITeam offensiveTeam, ITeam defendingTeam, ILeague league, IGameSimulationAlgorithm algorithm, IShiftTime shiftTime);
    void teamWin(ITeam team, ITeamStanding teamStanding);
    void teamLost(ITeam team, ITeamStanding teamStanding);
    void teamDraw(ITeam team, ITeamStanding teamStanding);

}
