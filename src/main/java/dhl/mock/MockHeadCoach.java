package dhl.mock;

import dhl.leagueModel.HeadCoach;
import dhl.leagueModel.IHeadCoach;

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

    public static IHeadCoach createMockBestCoach() {
        IHeadCoach headCoach = new HeadCoach();
        headCoach.setName("Best Coach");
        headCoach.setChecking(1);
        headCoach.setSaving(1);
        headCoach.setShooting(1);
        headCoach.setSkating(1);
        return headCoach;
    }

    public static IHeadCoach createMockWorstCoach() {
        IHeadCoach headCoach = new HeadCoach();
        headCoach.setName("Worst Coach");
        headCoach.setChecking(0);
        headCoach.setSaving(0);
        headCoach.setShooting(0);
        headCoach.setSkating(0);
        return headCoach;
    }
}

