package dhl.gameSimulationAlgorithm;

import dhl.leagueModel.IPlayers;
import dhl.leagueModel.teams.ITeam;

import java.util.List;

public interface IShiftTime {
    void oneShot(List<IPlayers> playersListOne, List<IPlayers> playersListTwo);
    void oneGame(ITeam teamOne, ITeam teamTwo);
    void setAlgorithm(IGameSimulationAlgorithm algorithm);
}
