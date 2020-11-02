package dhl.training;

import dhl.leagueModel.headCoach.IHeadCoach;
import dhl.leagueModel.players.IPlayers;

import static org.junit.jupiter.api.Assertions.*;

import dhl.mock.MockHeadCoach;
import dhl.mock.MockPlayer;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class PlayerTrainingConditionTest {

    @Test
    public void receiveTrainingTest(){
        ArrayList<IPlayers> playerList = new ArrayList();
        IPlayers player = MockPlayer.createMock();
        playerList.add(player);
        IHeadCoach bestCoach = MockHeadCoach.createMockBestCoach();
        IHeadCoach worstCoach = MockHeadCoach.createMockWorstCoach();
        IPlayerTrainingCondition t = new PlayerTrainingCondition();
        t.receiveTraining(playerList, bestCoach);
        assertEquals(16, player.getSkating());
        assertEquals(16, player.getShooting());
        assertEquals(16, player.getChecking());
        assertEquals(16, player.getSaving());
        t.receiveTraining(playerList, worstCoach);
        assertEquals(16, player.getSkating());
        assertEquals(16, player.getShooting());
        assertEquals(16, player.getChecking());
        assertEquals(16, player.getSaving());


    }


}
