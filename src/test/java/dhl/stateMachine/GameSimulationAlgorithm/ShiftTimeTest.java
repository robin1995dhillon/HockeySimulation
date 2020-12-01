package dhl.stateMachine.GameSimulationAlgorithm;

import dhl.leagueModel.IPlayers;
import dhl.mock.MockPlayer;
import dhl.stateMachine.StateMachineAbstractFactory;
import dhl.stateMachine.gameSimulationAlgorithm.IGameSimulationAlgorithm;
import dhl.stateMachine.gameSimulationAlgorithm.IShiftTime;
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
}
