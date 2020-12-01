package dhl.mock;

import dhl.leagueModel.HeadCoach;
import dhl.leagueModel.IHeadCoach;
import dhl.leagueModel.League;
import dhl.leagueModel.LeagueModelAbstractFactory;

public class MockHeadCoach {

    LeagueModelAbstractFactory leagueModelAbstractFactory;
    IHeadCoach headCoach;

    public MockHeadCoach() {
        leagueModelAbstractFactory = LeagueModelAbstractFactory.instance();
        headCoach = leagueModelAbstractFactory.getHeadCoach();
    }

    public IHeadCoach createHeadCoachMock() {
        headCoach.setName("Head1");
        headCoach.setSaving(14);
        headCoach.setShooting(15);
        headCoach.setChecking(16);
        headCoach.setSkating(17);
        return headCoach;

    }

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

