package dhl.Training;

import dhl.LeagueModel.headCoach.HeadCoach;
import dhl.LeagueModel.IHeadCoach;
import dhl.LeagueModel.IPlayers;
import dhl.LeagueModel.players.Players;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class PlayerTrainingConditionTest {

    @Test
    public void receiveTrainingTest(){
        ArrayList<IPlayers> playerList = new ArrayList();
        IPlayers player = new Players("Zongyu", "goalie", false);
        player.setSkating(10);
        player.setShooting(10);
        player.setChecking(10);
        player.setSaving(10);
        player.setAge(50);
        playerList.add(player);
        IHeadCoach coach1 = new HeadCoach();
        coach1.setName("Joe Smith");
        coach1.setSkating(1.0);
        coach1.setShooting(1.0);
        coach1.setChecking(1.0);
        coach1.setSaving(1.0);
        IHeadCoach coach2 = new HeadCoach();
        coach2.setName("Joe Smith");
        coach2.setSkating(0);
        coach2.setShooting(0);
        coach2.setChecking(0);
        coach2.setSaving(1);
        IPlayerTrainingCondition t = new PlayerTrainingCondition();
        t.receiveTraining(playerList, coach1);
        assertEquals(11, player.getSkating());
        assertEquals(11, player.getShooting());
        assertEquals(11, player.getChecking());
        assertEquals(11, player.getSaving());
        t.receiveTraining(playerList, coach2);
        assertEquals(11, player.getSkating());
        assertEquals(11, player.getShooting());
        assertEquals(11, player.getChecking());
        assertEquals(12, player.getSaving());
    }


}
