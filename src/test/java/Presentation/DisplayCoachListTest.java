package Presentation;

import dhl.leagueModel.IHeadCoach;
import dhl.leagueModel.headCoach.HeadCoach;
import dhl.mock.MockHeadCoach;
import dhl.presentation.DisplayCoachList;
import dhl.presentation.IDisplayCoachList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class DisplayCoachListTest {
    @Test
    public void displayCoachTest(){
        ArrayList<IHeadCoach> coachList = new ArrayList();
        IHeadCoach coach1 = MockHeadCoach.createMockBestCoach();
        IHeadCoach coach2 = MockHeadCoach.createMockWorstCoach();
        coachList.add(coach1);
        coachList.add(coach2);
        IDisplayCoachList d = new DisplayCoachList();
        d.displayCoach(coachList);
    }
}
