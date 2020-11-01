package dhl.LeagueModel.freeAgents;

import dhl.LeagueModel.IFreeAgents;
import dhl.Mock.MockFreeAgent;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FreeAgentsTest {

    @Test
    void getPlayerName() {
        IFreeAgents f = new FreeAgents("Player1","forward");
        assertEquals("Player1", f.getPlayerName());
    }

    @Test
    void setPlayerName() {
        IFreeAgents f = new FreeAgents("Player1","forward");
        f.setPlayerName("Player2");
        assertEquals("Player2", f.getPlayerName());
    }

    @Test
    void getPosition() {
        IFreeAgents f = new FreeAgents("Player1","goalie");
        assertEquals("goalie", f.getPosition());
    }

    @Test
    void setPosition() {
        IFreeAgents f = new FreeAgents("Player1","goalie");
        f.setPosition("forward");
        assertEquals("forward", f.getPosition());
    }

    @Test
    void getAge() {
        IFreeAgents freeAgents = new FreeAgents();
        freeAgents.setAge(15);
        assertEquals(15, freeAgents.getAge());
    }

    @Test
    void setAge() {
        IFreeAgents freeAgents = new FreeAgents();
        freeAgents.setAge(15);
        freeAgents.setAge(20);
        assertEquals(20, freeAgents.getAge());
    }

    @Test
    void getSkating() {
        IFreeAgents freeAgents = new FreeAgents();
        freeAgents.setSkating(15);
        assertEquals(15, freeAgents.getSkating());
    }

    @Test
    void setSkating() {
        IFreeAgents freeAgents = new FreeAgents();
        freeAgents.setSkating(15);
        freeAgents.setSkating(20);
        assertEquals(20, freeAgents.getSkating());
    }

    @Test
    void getShooting() {
        IFreeAgents freeAgents = new FreeAgents();
        freeAgents.setShooting(15);
        assertEquals(15, freeAgents.getShooting());
    }

    @Test
    void setShooting() {
        IFreeAgents freeAgents = new FreeAgents();
        freeAgents.setShooting(15);
        freeAgents.setShooting(20);
        assertEquals(20, freeAgents.getShooting());
    }

    @Test
    void getChecking() {
        IFreeAgents freeAgents = new FreeAgents();
        freeAgents.setChecking(15);
        assertEquals(15, freeAgents.getChecking());
    }

    @Test
    void setChecking() {
        IFreeAgents freeAgents = new FreeAgents();
        freeAgents.setChecking(15);
        freeAgents.setChecking(20);
        assertEquals(20, freeAgents.getChecking());
    }

    @Test
    void getSaving() {
        IFreeAgents freeAgents = new FreeAgents();
        freeAgents.setSaving(15);
        assertEquals(15, freeAgents.getSaving());
    }

    @Test
    void setSaving() {
        IFreeAgents freeAgents = new FreeAgents();
        freeAgents.setSaving(15);
        freeAgents.setSaving(20);
        assertEquals(20, freeAgents.getSaving());
    }

    @Test
    void getStrength() {
        IFreeAgents freeAgents = new FreeAgents();
        freeAgents.setStrength(15);
        assertEquals(15, freeAgents.getStrength());
    }

    @Test
    void setStrength() {
        IFreeAgents freeAgents = new FreeAgents();
        freeAgents.setStrength(15);
        freeAgents.setStrength(25);
        assertEquals(25, freeAgents.getStrength());
    }

    @Test
    void calculateStrength() {
        IFreeAgents freeAgents = MockFreeAgent.createMock();
        double strength = freeAgents.calculateStrength();
        assertEquals(50,strength);

    }

    @Test
    void strengthAdder() {
        int [] StrengthArray = {20,15,10};
        IFreeAgents freeAgents = new FreeAgents();
        double strength = freeAgents.strengthAdder(StrengthArray);
        assertEquals(45, strength);
    }

    @Test
    void getFreeAgentFromList() {

    }

    @Test
    void checkPosition() {
        IFreeAgents freeAgents = MockFreeAgent.createMock();
        assertTrue(freeAgents.checkPosition("forward"));
    }

    @Test
    void checkPositionFalse() {
        IFreeAgents freeAgents = MockFreeAgent.createMock();
        assertFalse(freeAgents.checkPosition("goalie"));
    }

    @Test
    void saveFreeAgent() {
    }
}