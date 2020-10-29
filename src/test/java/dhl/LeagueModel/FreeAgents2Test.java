package dhl.LeagueModel;

import dhl.CreateTeamUtils.FreeAgentUtils;
import dhl.CreateTeamUtils.IFreeAgentUtils;
import dhl.LeagueModel.freeAgents.FreeAgents;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

class FreeAgents2Test {

    @Test
    void getPlayerName() {
        IFreeAgents f = new FreeAgents("Player1","");
        assertEquals("Player1", f.getPlayerName());
    }

    @Test
    void setPlayerName() {
        IFreeAgents f = new FreeAgents("Player1","");
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
    void getFreeAgentFromListTest(){
        ArrayList<IFreeAgents> freeAgentList = new ArrayList();
        IFreeAgents freeAgent = new FreeAgents("Agent One", "forward");
        freeAgent.setAge(25);
        freeAgent.setSkating(10);
        freeAgent.setShooting(10);
        freeAgent.setChecking(10);
        freeAgent.setSaving(0);
        freeAgentList.add(freeAgent);
        assertEquals("Agent One", freeAgent.getFreeAgentFromList(freeAgentList,"Agent One").getPlayerName());
        assertEquals("forward", freeAgent.getFreeAgentFromList(freeAgentList,"Agent One").getPosition());
        assertEquals(25, freeAgent.getFreeAgentFromList(freeAgentList,"Agent One").getAge());
        assertEquals(10, freeAgent.getFreeAgentFromList(freeAgentList,"Agent One").getSkating());
        assertEquals(10, freeAgent.getFreeAgentFromList(freeAgentList,"Agent One").getShooting());
        assertEquals(10, freeAgent.getFreeAgentFromList(freeAgentList,"Agent One").getChecking());
        assertEquals(0, freeAgent.getFreeAgentFromList(freeAgentList,"Agent One").getSaving());
    }

    @Test
    void checkPositionTest(){
        ArrayList<IFreeAgents> freeAgentList = new ArrayList();
        IFreeAgents freeAgent = new FreeAgents("Agent One", "forward");
        freeAgent.setAge(25);
        freeAgent.setSkating(10);
        freeAgent.setShooting(10);
        freeAgent.setChecking(10);
        freeAgent.setSaving(0);
        freeAgentList.add(freeAgent);
        assertTrue(freeAgent.checkPosition("forward"));
        assertFalse(freeAgent.checkPosition("goalie"));
    }

}