package dhl.CreateTeamUtils;

import dhl.LeagueModel.FreeAgents;
import dhl.LeagueModel.IFreeAgents;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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
    public void removeCoachTest(){
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
        freeAgentUtils.removeFreeAgent(freeAgentList, "Agent One");
        freeAgentUtils.displayFreeAgent(freeAgentList);
    }
}
