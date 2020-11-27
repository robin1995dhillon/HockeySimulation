package dhl.GameSimulationAlgorithm;

import dhl.gameSimulationAlgorithm.GameSimulationAlgorithm;
import dhl.gameSimulationAlgorithm.IGameSimulationAlgorithm;
import dhl.gameSimulationAlgorithm.IShiftTime;
import dhl.gameSimulationAlgorithm.ShiftTime;
import dhl.leagueModel.teams.ITeam;
import dhl.mock.MockTeam;
import org.junit.jupiter.api.Test;



public class ShiftTimeTest {
    IGameSimulationAlgorithm algorithm = new GameSimulationAlgorithm(0.05, 0.5, 0.5);
    IShiftTime shiftTime = new ShiftTime();

    @Test
    public void oneGameTest(){
        algorithm.setSaveCoefficientOne(0);
        algorithm.setSaveCoefficientTwo(0.015);
        algorithm.setShotCoefficientOne(0.1);
        algorithm.setShotCoefficientTwo(-0.001);
        shiftTime.setAlgorithm(algorithm);
        ITeam teamOne = MockTeam.MockOffensiveTeam();
        ITeam teamTwo = MockTeam.MockDefendingTeam();
        shiftTime.oneGame(teamOne, teamTwo);
    }

}
