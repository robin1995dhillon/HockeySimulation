package dhl.leagueModel.headCoach;

import dhl.leagueModel.IFreeAgents;
import dhl.leagueModel.IHeadCoach;
import dhl.leagueModel.IPlayers;
import dhl.mock.MockFreeAgent;
import dhl.mock.MockHeadCoach;
import dhl.mock.MockPlayer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeadCoachTest {

    @Test
    void getName() {
        IHeadCoach headCoach = MockHeadCoach.createMock();
        assertEquals("Head1", headCoach.getName());
    }

    @Test
    void setName() {
        IHeadCoach headCoach = MockHeadCoach.createMock();
        headCoach.setName("Head2");
        assertEquals("Head2", headCoach.getName());
    }

    @Test
    void getSkating() {
        IHeadCoach headCoach = MockHeadCoach.createMock();
        assertEquals(0.6, headCoach.getSkating());
    }

    @Test
    void setSkating() {
        IHeadCoach headCoach = MockHeadCoach.createMock();
        headCoach.setSkating(0.6);
        assertEquals(0.6, headCoach.getSkating());
    }

    @Test
    void getShooting() {
        IHeadCoach headCoach = MockHeadCoach.createMock();
        assertEquals(0.5, headCoach.getShooting());
    }

    @Test
    void setShooting() {
        IHeadCoach headCoach = MockHeadCoach.createMock();
        headCoach.setShooting(0.6);
        assertEquals(0.6, headCoach.getShooting());
    }

    @Test
    void getChecking() {
        IHeadCoach headCoach = MockHeadCoach.createMock();
        assertEquals(0.5, headCoach.getChecking());
    }

    @Test
    void setChecking() {
        IHeadCoach headCoach = MockHeadCoach.createMock();
        headCoach.setChecking(0.6);
        assertEquals(0.6, headCoach.getChecking());
    }

    @Test
    void getSaving() {
        IHeadCoach headCoach = MockHeadCoach.createMock();
        assertEquals(0.5, headCoach.getSaving());
    }

    @Test
    void setSaving() {
        IHeadCoach headCoach = MockHeadCoach.createMock();
        headCoach.setSaving(0.6);
        assertEquals(0.6, headCoach.getSaving());
    }

    @Test
    void getCoachFromList() {
    }

    @Test
    void saveHeadCoach() {
    }

    @Test
    public void convertFreeAgentToPlayerTest(){
        IPlayers players = MockPlayer.createMock();
        IFreeAgents agent = MockFreeAgent.createMock();
        IPlayers player = players.convertFreeAgentToPlayer(agent);
        assertEquals(agent.getPlayerName(), player.getPlayerName());


    }
}