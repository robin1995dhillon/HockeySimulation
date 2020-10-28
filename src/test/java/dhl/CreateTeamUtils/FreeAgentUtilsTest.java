package dhl.CreateTeamUtils;

import dhl.LeagueModel.freeAgents.FreeAgents;
import dhl.LeagueModel.IFreeAgents;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class FreeAgentUtilsTest {
    @Test
    public void displayFreeAgentTest(){
        ArrayList<IFreeAgents> freeAgentList = new ArrayList();
        IFreeAgents freeAgent1 = new FreeAgents("Agent One", "forward");
        IFreeAgents freeAgent2 = new FreeAgents("Agent Two", "defense");
        freeAgent1.setAge(25);
        freeAgent1.setSkating(10);
        freeAgent1.setShooting(10);
        freeAgent1.setChecking(10);
        freeAgent1.setSaving(0);
        freeAgentList.add(freeAgent1);
        freeAgent2.setAge(25);
        freeAgent2.setSkating(10);
        freeAgent2.setShooting(10);
        freeAgent2.setChecking(10);
        freeAgent2.setSaving(0);
        freeAgentList.add(freeAgent2);
        IFreeAgentUtils freeAgentUtils = new FreeAgentUtils();
        freeAgentUtils.displayFreeAgent(freeAgentList);
    }

    @Test
    public void getFreeAgentFromListTest(){
        ArrayList<IFreeAgents> freeAgentList = new ArrayList();
        IFreeAgents freeAgent = new FreeAgents("Agent One", "forward");
        freeAgent.setAge(25);
        freeAgent.setSkating(10);
        freeAgent.setShooting(10);
        freeAgent.setChecking(10);
        freeAgent.setSaving(0);
        freeAgentList.add(freeAgent);
        IFreeAgentUtils freeAgentUtils = new FreeAgentUtils();
        assertEquals("Agent One", freeAgentUtils.getFreeAgentFromList(freeAgentList,"Agent One").getPlayerName());
        assertEquals("forward", freeAgentUtils.getFreeAgentFromList(freeAgentList,"Agent One").getPosition());
        assertEquals(25, freeAgentUtils.getFreeAgentFromList(freeAgentList,"Agent One").getAge());
        assertEquals(10, freeAgentUtils.getFreeAgentFromList(freeAgentList,"Agent One").getSkating());
        assertEquals(10, freeAgentUtils.getFreeAgentFromList(freeAgentList,"Agent One").getShooting());
        assertEquals(10, freeAgentUtils.getFreeAgentFromList(freeAgentList,"Agent One").getChecking());
        assertEquals(0, freeAgentUtils.getFreeAgentFromList(freeAgentList,"Agent One").getSaving());
    }

    @Test
    public void removeFreeAgentTest(){
        ArrayList<IFreeAgents> freeAgentList = new ArrayList();
        IFreeAgents freeAgent1 = new FreeAgents("Agent One", "forward");
        IFreeAgents freeAgent2 = new FreeAgents("Agent Two", "defense");
        freeAgent1.setAge(25);
        freeAgent1.setSkating(10);
        freeAgent1.setShooting(10);
        freeAgent1.setChecking(10);
        freeAgent1.setSaving(0);
        freeAgentList.add(freeAgent1);
        freeAgent2.setAge(25);
        freeAgent2.setSkating(10);
        freeAgent2.setShooting(10);
        freeAgent2.setChecking(10);
        freeAgent2.setSaving(0);
        freeAgentList.add(freeAgent2);
        IFreeAgentUtils freeAgentUtils = new FreeAgentUtils();
        System.out.println("Before remove:");
        freeAgentUtils.displayFreeAgent(freeAgentList);
        freeAgentUtils.removeFreeAgent(freeAgentList, "Agent One");
        System.out.println("\nAfter remove:");
        freeAgentUtils.displayFreeAgent(freeAgentList);
    }

    @Test
    public void checkPositionTest(){
        ArrayList<IFreeAgents> freeAgentList = new ArrayList();
        IFreeAgents freeAgent = new FreeAgents("Agent One", "forward");
        freeAgent.setAge(25);
        freeAgent.setSkating(10);
        freeAgent.setShooting(10);
        freeAgent.setChecking(10);
        freeAgent.setSaving(0);
        freeAgentList.add(freeAgent);
        IFreeAgentUtils freeAgentUtils = new FreeAgentUtils();
        assertTrue(freeAgentUtils.checkPosition(freeAgentList, "Agent One", "forward"));
        assertFalse(freeAgentUtils.checkPosition(freeAgentList, "Agent One", "goalie"));
    }
}
