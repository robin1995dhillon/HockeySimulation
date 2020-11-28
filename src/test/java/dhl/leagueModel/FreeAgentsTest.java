package dhl.leagueModel;

import dhl.mock.MockFreeAgent;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FreeAgentsTest {

    @Test
    void retireFreeAgents() {
        List<IFreeAgents> freeAgentsList= MockFreeAgent.retireFreeAgentMockList();
//        List<IFreeAgents> newFreeAgentList = new ArrayList<>();

        for(int i=0;i<freeAgentsList.size();i++) {
            if(freeAgentsList.get(i).isRetired()) {
                freeAgentsList.remove(freeAgentsList.get(i));
            }
        }

//        for(IFreeAgents freeAgents1: freeAgentsList) {
//            if(freeAgents1.isRetired()) {
//                newFreeAgentList.remove(freeAgents1);
//            }
//        }
        assertEquals(2, freeAgentsList.size());
    }
}
