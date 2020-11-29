package dhl.GameSimulationAlgorithm;

import dhl.gameSimulationAlgorithm.GameSimulationAlgorithm;
import dhl.gameSimulationAlgorithm.IGameSimulationAlgorithm;
import dhl.gameSimulationAlgorithm.IShiftTime;
import dhl.gameSimulationAlgorithm.ShiftTime;
import dhl.leagueModel.IPlayers;
import dhl.leagueModel.teams.ITeam;
import dhl.mock.MockTeam;
import org.junit.jupiter.api.Test;



public class ShiftTimeTest {
    IGameSimulationAlgorithm algorithm = new GameSimulationAlgorithm(0.05, 0.2, 0.5);
    IShiftTime shiftTime = new ShiftTime();

    @Test
    public void oneGameTest(){
        algorithm.setSaveCoefficientOne(0.05);
        algorithm.setSaveCoefficientTwo(0.05);
        algorithm.setShotCoefficientOne(0.3);
        algorithm.setShotCoefficientTwo(0.05);
        shiftTime.setAlgorithm(algorithm);
        ITeam teamOne = MockTeam.MockOffensiveTeam();
        ITeam teamTwo = MockTeam.MockDefendingTeam();
        shiftTime.oneGame(teamOne, teamTwo);
        algorithm.reset(teamOne);
        algorithm.reset(teamTwo);
        algorithm.resetAlgorithm(0.05,0.2,0.5);
        shiftTime.oneGame(teamTwo, teamOne);
    }



}
