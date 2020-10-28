package dhl.LeagueModel;

import dhl.CreateTeamUtils.CoachUtils;
import dhl.CreateTeamUtils.ICoachUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HeadCoachTest {

    @Test
    public void setNameTest(){
        IHeadCoach coach = new HeadCoach();
        coach.setName("Adams");
        assertEquals(coach.getName(),"Adams");
    }

    @Test
    public void setShootingTest(){
        IHeadCoach coach = new HeadCoach();
        coach.setShooting(0.4);
        assertEquals(coach.getShooting(),0.4);
    }

    @Test
    public void setCheckingTest(){
        IHeadCoach coach = new HeadCoach();
        coach.setChecking(0.5);
        assertEquals(coach.getChecking(),0.5);
    }

    @Test
    public void setSavingTest(){
        IHeadCoach coach = new HeadCoach();
        coach.setSaving(0.6);
        assertEquals(coach.getSaving(),0.6);
    }

    @Test
    public void setSkatingTest(){
        IHeadCoach coach = new HeadCoach();
        coach.setSkating(0.7);
        assertEquals(coach.getSkating(),0.7);
    }

    @Test
    public void getCoachFromListTest(){
        ArrayList<IHeadCoach> coachList = new ArrayList();
        IHeadCoach coach = new HeadCoach();
        coach.setName("Frank Smith");
        coach.setSkating(0.5);
        coach.setShooting(0.8);
        coach.setChecking(0.3);
        coach.setSaving(0.5);
        coachList.add(coach);
        IHeadCoach headCoach = new HeadCoach();
        headCoach.getCoachFromList(coachList,"Frank Smith");
        assertEquals("Frank Smith", headCoach.getCoachFromList(coachList,"Frank Smith").getName());
        assertEquals(0.5, headCoach.getCoachFromList(coachList,"Frank Smith").getSkating());
        assertEquals(0.8, headCoach.getCoachFromList(coachList,"Frank Smith").getShooting());
        assertEquals(0.3, headCoach.getCoachFromList(coachList,"Frank Smith").getChecking());
        assertEquals(0.5, headCoach.getCoachFromList(coachList,"Frank Smith").getSaving());
    }


}
