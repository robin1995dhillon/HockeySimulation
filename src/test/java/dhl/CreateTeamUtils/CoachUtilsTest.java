package dhl.CreateTeamUtils;

import dhl.LeagueModel.HeadCoach;
import dhl.LeagueModel.IHeadCoach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CoachUtilsTest {
    @Test
    public void displayCoachTest(){
        ArrayList<IHeadCoach> coachList = new ArrayList();
        IHeadCoach coach1 = new HeadCoach();
        IHeadCoach coach2 = new HeadCoach();
        coach1.setName("Joe Smith");
        coach1.setSkating(0.5);
        coach1.setShooting(0.8);
        coach1.setChecking(0.3);
        coach1.setSaving(1.0);
        coachList.add(coach1);
        coach2.setName("Frank Smith");
        coach2.setSkating(0.5);
        coach2.setShooting(0.8);
        coach2.setChecking(0.3);
        coach2.setSaving(0.5);
        coachList.add(coach2);
        ICoachUtils coachUtils = new CoachUtils();
        coachUtils.displayCoach(coachList);
    }

    @Test
    public void removeCoachTest(){
        ArrayList<IHeadCoach> coachList = new ArrayList();
        IHeadCoach coach1 = new HeadCoach();
        IHeadCoach coach2 = new HeadCoach();
        coach1.setName("Joe Smith");
        coach1.setSkating(0.5);
        coach1.setShooting(0.8);
        coach1.setChecking(0.3);
        coach1.setSaving(1.0);
        coachList.add(coach1);
        coach2.setName("Frank Smith");
        coach2.setSkating(0.5);
        coach2.setShooting(0.8);
        coach2.setChecking(0.3);
        coach2.setSaving(0.5);
        coachList.add(coach2);
        ICoachUtils coachUtils = new CoachUtils();
        System.out.println("Before remove:");
        coachUtils.displayCoach(coachList);
        coachUtils.removeCoach(coachList, "Joe Smith");
        System.out.println("\nAfter remove:");
        coachUtils.displayCoach(coachList);
    }
}
