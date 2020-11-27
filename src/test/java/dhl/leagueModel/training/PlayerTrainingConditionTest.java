//package dhl.leagueModel.training;
//
//import dhl.leagueModel.headCoach.IHeadCoach;
//import dhl.leagueModel.IPlayers;
//import dhl.mock.MockHeadCoach;
//import dhl.mock.MockPlayer;
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class PlayerTrainingConditionTest {
//
//    @Test
//    public void receiveTrainingTest() {
//        int i = 0;
//        ArrayList<IPlayers> playerList = new ArrayList();
//        IPlayers player = MockPlayer.createMock();
//        playerList.add(player);
//        IHeadCoach bestCoach = MockHeadCoach.createMockBestCoach();
//        IHeadCoach worstCoach = MockHeadCoach.createMockWorstCoach();
//        IPlayerTrainingCondition t = new PlayerTrainingCondition();
//        t.receiveTraining(playerList, bestCoach);
//        assertEquals(16, player.getSkating());
//        assertEquals(16, player.getShooting());
//        assertEquals(16, player.getChecking());
//        assertEquals(16, player.getSaving());
//        //player.set(gamePlayConfig.injury)
//        while (player.isInjured() == false) {
//            t.receiveTraining(playerList, worstCoach);
//            i++;
//        }
//        System.out.println("Player get injured in the " + i + " turns.");
//        assertEquals(16, player.getSkating());
//        assertEquals(16, player.getShooting());
//        assertEquals(16, player.getChecking());
//        assertEquals(16, player.getSaving());
//    }
//}
