package Presentation;

import dhl.leagueModel.IHeadCoach;
import dhl.leagueModel.headCoach.HeadCoach;
import dhl.presentation.DisplayCoachList;
import dhl.presentation.IDisplayCoachList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class DisplayCoachListTest {
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
        IDisplayCoachList d = new DisplayCoachList();
        d.displayCoach(coachList);
    }
}
