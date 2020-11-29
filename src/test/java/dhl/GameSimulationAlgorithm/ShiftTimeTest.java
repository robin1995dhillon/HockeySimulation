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
    IGameSimulationAlgorithm algorithm = new GameSimulationAlgorithm(0.04, 0.907, 0.433);
    IShiftTime shiftTime = new ShiftTime();

    @Test
    public void oneGameTest(){
        algorithm.setSaveCoefficientOne(0.001);
        algorithm.setSaveCoefficientTwo(0);
        algorithm.setShotCoefficientOne(0.001);
        algorithm.setShotCoefficientTwo(0);
        algorithm.setSaveCoefficientOne(0.001);
        algorithm.setSaveCoefficientTwo(0);
        algorithm.setShotCoefficientOne(0.06);
        algorithm.setShotCoefficientTwo(0.01);
        shiftTime.setAlgorithm(algorithm);
        ITeam teamOne = MockTeam.MockOffensiveTeam();
        ITeam teamTwo = MockTeam.MockDefendingTeam();
        shiftTime.oneGame(teamOne, teamTwo);
    }



}
