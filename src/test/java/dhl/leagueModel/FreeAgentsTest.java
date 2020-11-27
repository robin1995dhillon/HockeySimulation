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
        for(IFreeAgents freeAgents: freeAgentsList) {
//            freeAgents.retireFreeAgents()
        }
    }
}
