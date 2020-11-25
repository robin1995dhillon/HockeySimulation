package dhl.GameSimulationAlgorithm;

import dhl.gameSimulationAlgorithm.GameSimulationAlgorithm;
import dhl.gameSimulationAlgorithm.IGameSimulationAlgorithm;
import dhl.leagueModel.players.IPlayers;
import dhl.leagueModel.teams.ITeam;
import dhl.mock.MockPlayer;
import dhl.mock.MockTeam;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

public class GameSimulationAlgorithmTest {
    IGameSimulationAlgorithm algorithm = new GameSimulationAlgorithm(0.05, 0.5, 0.5);


    @Test
    public void getPlayerForShiftTest(){
        ITeam offensiveTeam = MockTeam.MockOffensiveTeam();
        List<IPlayers> playersList = algorithm.getPlayerForShift(offensiveTeam);
        assertEquals("Zongming Page", playersList.get(0).getPlayerName());
        assertEquals("Abraham Singh", playersList.get(3).getPlayerName());
        assertEquals("Prashant Liu", playersList.get(5).getPlayerName());
    }

    @Test
    public void shotForwardTest(){
        List<IPlayers> playersList = MockPlayer.forwardListMock();
        IPlayers player = algorithm.shotForward(playersList);
        assertEquals("player1", player.getPlayerName());
    }

    @Test
    public void savesTest(){
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
        List<IPlayers> playersList = MockPlayer.forwardListMock().subList(0,2);
        algorithm.penaltyDefence(playersList);
        assertEquals(1.0, playersList.get(0).getPenalties());
    }

    @Test
    public void shotsTest(){

    }


}
