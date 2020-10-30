package Presentation;

import dhl.LeagueModel.IFreeAgents;
import dhl.LeagueModel.freeAgents.FreeAgents;
import dhl.Presentation.DisplayFreeAgentList;
import dhl.Presentation.IDisplayFreeAgentList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class DisplayFreeAgentTest {
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
        IDisplayFreeAgentList d = new DisplayFreeAgentList();
        d.displayFreeAgent(freeAgentList);
    }
}
