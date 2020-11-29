package dhl.leagueModel;

import dhl.leagueModel.IPlayerTrainingCondition;
import dhl.leagueModel.LeagueModelAbstractFactory;
import dhl.leagueModel.PlayerTrainingCondition;
import dhl.leagueModel.gamePlayConfig.IGamePlayConfig;
import dhl.leagueModel.headCoach.IHeadCoach;
import dhl.mock.MockGamePlayConfig;
import dhl.mock.MockHeadCoach;
import dhl.mock.MockPlayer;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTrainingConditionTest {
    LeagueModelAbstractFactory abstractFactory = LeagueModelAbstractFactory.instance();

    @Test
    public void receiveTrainingTest() {
        ArrayList<IPlayers> playerList = new ArrayList();
        IPlayers player = MockPlayer.createMock();
        playerList.add(player);
        IHeadCoach bestCoach = MockHeadCoach.createMockBestCoach();
        IHeadCoach worstCoach = MockHeadCoach.createMockWorstCoach();
        IGamePlayConfig config = MockGamePlayConfig.createMock();
        IPlayerTrainingCondition t = abstractFactory.getPlayerTrainingCondition();
        t.receiveTraining(playerList, bestCoach, config);
        assertEquals(16, player.getSkating());
        assertEquals(16, player.getShooting());
        assertEquals(16, player.getChecking());
        assertEquals(16, player.getSaving());
        while (player.isInjured() == false) {
            t.receiveTraining(playerList, worstCoach, config);
        }
        assertEquals(16, player.getSkating());
        assertEquals(16, player.getShooting());
        assertEquals(16, player.getChecking());
        assertEquals(16, player.getSaving());
    }
}
