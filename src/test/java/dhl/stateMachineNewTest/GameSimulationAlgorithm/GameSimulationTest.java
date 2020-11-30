package dhl.stateMachineNewTest.GameSimulationAlgorithm;

import dhl.leagueModel.ITeam;
import dhl.mock.MockStandingTeam;
import dhl.mock.MockTeam;
import dhl.stateMachineNew.ITeamStanding;
import dhl.stateMachineNew.StateMachineAbstractFactory;
import dhl.stateMachineNew.gameSimulationAlgorithm.IGameSimulation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameSimulationTest {
    StateMachineAbstractFactory factory = StateMachineAbstractFactory.instance();
    ITeam team = MockTeam.MockOffensiveTeam();
    ITeamStanding standing = MockStandingTeam.createTeamStandingMock().get(0);
    IGameSimulation simulation = factory.getGameSimulation();

    @Test
    public void teamWinTest(){
        simulation.teamWin(team, standing);
        assertEquals(6, standing.getGamesPlayed());
        assertEquals(2, standing.getGamesWon());
        assertEquals(4, standing.getTotalPoints());
    }

    @Test
    public void teamLostTest(){
        simulation.teamLost(team, standing);
        assertEquals(6, standing.getGamesPlayed());
        assertEquals(1, standing.getGamesWon());
        assertEquals(2, standing.getTotalPoints());
    }

    @Test
    public void teamDrawTest(){
        simulation.teamDraw(team, standing);
        assertEquals(6, standing.getGamesPlayed());
        assertEquals(1, standing.getGamesWon());
        assertEquals(3, standing.getTotalPoints());
    }
}
