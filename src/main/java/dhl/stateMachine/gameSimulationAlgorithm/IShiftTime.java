package dhl.stateMachine.gameSimulationAlgorithm;

import dhl.leagueModel.IPlayers;
import dhl.leagueModel.ITeam;

import java.util.List;

public interface IShiftTime {
    void oneShot(List<IPlayers> playersListOne, List<IPlayers> playersListTwo);
    void oneGame(ITeam teamOne, ITeam teamTwo);
    void setAlgorithm(IGameSimulationAlgorithm algorithm);
}
