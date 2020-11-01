package Presentation;

import dhl.leagueModel.IFreeAgents;
import dhl.leagueModel.freeAgents.FreeAgents;
import dhl.mock.MockFreeAgent;
import dhl.presentation.DisplayFreeAgentList;
import dhl.presentation.IDisplayFreeAgentList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class DisplayFreeAgentTest {
    @Test
    public void displayFreeAgentTest(){
        ArrayList<IFreeAgents> freeAgentList = new ArrayList();
        IFreeAgents freeAgent1 = MockFreeAgent.createMock();
        freeAgentList.add(freeAgent1);
        IDisplayFreeAgentList d = new DisplayFreeAgentList();
        d.displayFreeAgent(freeAgentList);
    }
}
