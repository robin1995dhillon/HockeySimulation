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

    public static IFreeAgents createMockTwo() {
        IFreeAgents freeAgents = new FreeAgents();
        freeAgents.setPlayerName("FreeAgent2");
        freeAgents.setPosition("forward");
        freeAgents.setAge(18);
        freeAgents.setSkating(15);
        freeAgents.setShooting(15);
        freeAgents.setChecking(15);
        freeAgents.setSaving(10);
        return freeAgents;
    }

    public static IFreeAgents createMockThree() {
        IFreeAgents freeAgents = new FreeAgents();
        freeAgents.setPlayerName("FreeAgent3");
        freeAgents.setPosition("defense");
        freeAgents.setAge(18);
        freeAgents.setSkating(30);
        freeAgents.setShooting(25);
        freeAgents.setChecking(25);
        freeAgents.setSaving(20);
        return freeAgents;
    }
}
