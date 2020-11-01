package dhl.mock;

import dhl.leagueModel.IFreeAgents;
import dhl.leagueModel.freeAgents.FreeAgents;

public class MockFreeAgent {

    public static IFreeAgents createMock() {
        IFreeAgents freeAgents = new FreeAgents();
        freeAgents.setPlayerName("FreeAgent1");
        freeAgents.setPosition("forward");
        freeAgents.setAge(18);
        freeAgents.setSkating(20);
        freeAgents.setShooting(20);
        freeAgents.setChecking(20);
        freeAgents.setSaving(0);
        freeAgents.setStrength(40);
        return freeAgents;
    }
}
