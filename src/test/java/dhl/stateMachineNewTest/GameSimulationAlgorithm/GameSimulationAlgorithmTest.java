package dhl.stateMachineNewTest.GameSimulationAlgorithm;

import dhl.stateMachineNew.StateMachineAbstractFactory;
import dhl.stateMachineNew.gameSimulationAlgorithm.IGameSimulationAlgorithm;
import dhl.leagueModel.IPlayers;
import dhl.leagueModel.teams.ITeam;
import dhl.mock.MockPlayer;
import dhl.mock.MockTeam;
import org.junit.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

public class GameSimulationAlgorithmTest {
    IGameSimulationAlgorithm algorithm = StateMachineAbstractFactory.instance().getGameSimulationAlgorithm();


    @Test
    public void getPlayerForShiftTest(){
        ITeam offensiveTeam = MockTeam.MockOffensiveTeam();
        algorithm.resetAlgorithm(1,0.5,0.5);
        List<IPlayers> playersList = algorithm.getPlayerForShift(offensiveTeam);
        assertEquals("Zongming Page", playersList.get(0).getPlayerName());
        assertEquals("Abraham Singh", playersList.get(3).getPlayerName());
        assertEquals("Prashant Liu", playersList.get(5).getPlayerName());
    }

    @Test
    public void shotForwardTest(){
        algorithm.resetAlgorithm(1,0.5,0.5);
        List<IPlayers> playersList = MockPlayer.forwardListMock();
        IPlayers player = algorithm.shotForward(playersList);
        assertEquals("player1", player.getPlayerName());
    }

    @Test
    public void savesTest(){
        algorithm.resetAlgorithm(1,0.5,0.5);
        IPlayers forward = MockPlayer.worstForwardMock();
        IPlayers goalie = MockPlayer.bestGoalieMock();
        algorithm.setSaveCoefficientOne(0);
        algorithm.setSaveCoefficientTwo(-0.5);
        algorithm.saves(goalie, forward);
        assertEquals(0.0, goalie.getSaves());
        assertEquals(1.0, forward.getGoals());
    }

    @Test
    public void penaltyDefenseTest(){
        algorithm.resetAlgorithm(1,0.5,0.5);
        List<IPlayers> playersList = MockPlayer.forwardListMock().subList(0,2);
        algorithm.penaltyDefence(playersList);
        assertEquals(1.0, playersList.get(0).getPenalties());
    }

    @Test
    public void shotsOneTest(){
        algorithm.resetAlgorithm(1,0.5,0.5);
        List<IPlayers> playersList = MockPlayer.offensivePlayerListMock();
        algorithm.setShotCoefficientOne(1);
        algorithm.setShotCoefficientTwo(0.5);
        IPlayers players = algorithm.shots(playersList, playersList);
        assertEquals("player1", players.getPlayerName());
    }

    @Test
    public void shotsTwoTest(){
        algorithm.resetAlgorithm(1,0.5,0.5);
        List<IPlayers> playersList = MockPlayer.offensivePlayerListMock();
        algorithm.setShotCoefficientOne(1);
        algorithm.setShotCoefficientTwo(-0.5);
        IPlayers players = algorithm.shots(playersList, playersList);
        assertEquals(null, players);
        assertEquals(1.0, playersList.get(3).getPenalties());
    }

    @Test
    public void getGoalieTest(){
        algorithm.resetAlgorithm(1,0.5,0.5);
        List<IPlayers> playersList = MockPlayer.offensivePlayerListMock();
        IPlayers player = algorithm.getGoalie(playersList);
        assertEquals("player6", player.getPlayerName());
    }

    @Test
    public void getTeamStatisticTest(){
        algorithm.resetAlgorithm(1,0.5,0.5);
        ITeam team = MockTeam.MockTeamThree();
        algorithm.getTeamStatistic(team);
        assertEquals(1.0, team.getGoals());
        assertEquals(0.0, team.getPenalties());
        assertEquals(5.0, team.getShots());
        assertEquals(0.0, team.getSaves());
    }

    @Test
    public void getPlayerWithLeastShiftTest(){
        algorithm.resetAlgorithm(1,0.5,0.5);
        List<IPlayers> playersList = MockPlayer.forwardListMock();
        IPlayers player = algorithm.getPlayerWithLeastShift(playersList);
        assertEquals("player2", player.getPlayerName());
    }

}
