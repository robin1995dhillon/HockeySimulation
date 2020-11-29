package dhl.stateMachineNewTest.GameSimulationAlgorithm;

import dhl.leagueModel.IPlayers;
import dhl.mock.MockPlayer;
import dhl.stateMachineNew.StateMachineAbstractFactory;
import dhl.stateMachineNew.gameSimulationAlgorithm.IGameSimulationAlgorithm;
import dhl.stateMachineNew.gameSimulationAlgorithm.IShiftTime;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShiftTimeTest {
    StateMachineAbstractFactory factory = StateMachineAbstractFactory.instance();
    IGameSimulationAlgorithm algorithm = factory.getGameSimulationAlgorithm();
    IShiftTime shiftTime = factory.getShiftTime();

    @Test
    public void oneShotFirstTest(){
        List<IPlayers> playersListOne = MockPlayer.offensivePlayerListMock();
        List<IPlayers> playersListTwo = MockPlayer.offensivePlayerListMock();
        algorithm.setPenaltyChance(1);
        algorithm.setSaveChance(0.5);
        algorithm.setShotChance(0.5);
        algorithm.setShotCoefficientOne(1);
        algorithm.setShotCoefficientTwo(-0.5);
        algorithm.setSaveCoefficientOne(0);
        algorithm.setSaveCoefficientTwo(0.5);
        shiftTime.setAlgorithm(algorithm);
        shiftTime.oneShot(playersListOne, playersListTwo);
        assertEquals(1.0, playersListTwo.get(3).getPenalties());
    }

    @Test
    public void oneShotSecondTest(){
        List<IPlayers> playersListOne = MockPlayer.offensivePlayerListMock();
        List<IPlayers> playersListTwo = MockPlayer.offensivePlayerListMock();
        algorithm.setPenaltyChance(1);
        algorithm.setSaveChance(0.5);
        algorithm.setShotChance(0.5);
        algorithm.setShotCoefficientOne(1);
        algorithm.setShotCoefficientTwo(0.5);
        algorithm.setSaveCoefficientOne(0);
        algorithm.setSaveCoefficientTwo(0.5);
        shiftTime.setAlgorithm(algorithm);
        shiftTime.oneShot(playersListOne, playersListTwo);
        assertEquals(1.0, playersListOne.get(0).getShots());
        assertEquals(1.0, playersListOne.get(0).getGoals());
        assertEquals(0.0, playersListTwo.get(5).getSaves());
    }


//    @Test
//    public void oneGameTest(){
//        algorithm.setPenaltyChance(0.04);
//        algorithm.setSaveChance(0.907);
//        algorithm.setShotChance(0.433);
//        algorithm.setSaveCoefficientOne(0.001);
//        algorithm.setSaveCoefficientTwo(0);
//        algorithm.setShotCoefficientOne(0.001);
//        algorithm.setShotCoefficientTwo(0);
//        algorithm.setSaveCoefficientOne(0.001);
//        algorithm.setSaveCoefficientTwo(0);
//        algorithm.setShotCoefficientOne(0.06);
//        algorithm.setShotCoefficientTwo(0.01);
//        shiftTime.setAlgorithm(algorithm);
//        ITeam teamOne = MockTeam.MockOffensiveTeam();
//        ITeam teamTwo = MockTeam.MockDefendingTeam();
//        shiftTime.oneGame(teamOne, teamTwo);
//    }



}
