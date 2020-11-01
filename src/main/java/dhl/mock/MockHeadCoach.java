package dhl.mock;

import dhl.leagueModel.IHeadCoach;
import dhl.leagueModel.headCoach.HeadCoach;

public class MockHeadCoach {
    public static IHeadCoach createMock() {
        IHeadCoach headCoach = new HeadCoach();
        headCoach.setName("Head1");
        headCoach.setChecking(0.5);
        headCoach.setSaving(0.5);
        headCoach.setShooting(0.5);
        headCoach.setSkating(0.6);
        return headCoach;
    }
}

