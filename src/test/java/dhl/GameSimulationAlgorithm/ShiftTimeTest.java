package dhl.GameSimulationAlgorithm;

import dhl.gameSimulationAlgorithm.GameSimulationAlgorithm;
import dhl.gameSimulationAlgorithm.IGameSimulationAlgorithm;
import dhl.gameSimulationAlgorithm.IShiftTime;
import dhl.gameSimulationAlgorithm.ShiftTime;
import dhl.leagueModel.teams.ITeam;
import dhl.mock.MockTeam;
import org.junit.jupiter.api.Test;

public class ShiftTimeTest {
    @Test
    public void oneGameTest(){
        IGameSimulationAlgorithm algorithm = new GameSimulationAlgorithm(0.05, 0.5, 0.5);
        algorithm.setSaveCoefficientOne(0.5);
        algorithm.setSaveCoefficientTwo(0.5);
        algorithm.setShotCoefficientOne(0.5);
        algorithm.setShotCoefficientTwo(0.5);
        IShiftTime shiftTime = new ShiftTime(algorithm);
        ITeam teamOne = MockTeam.MockTeam();
        ITeam teamTwo = MockTeam.MockTeamTwo();
        //shiftTime.oneGame(teamOne, teamTwo);
    }
}
