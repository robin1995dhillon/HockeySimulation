package dhl.Validator;

import dhl.LeagueModel.IFreeAgents;
import dhl.LeagueModel.IHeadCoach;
import dhl.LeagueModel.ILeague;
import dhl.LeagueModel.freeAgents.FreeAgents;
import dhl.LeagueModel.headCoach.HeadCoach;
import dhl.Mock.MockLeague;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CheckerTest {

    @Test
    void conferenceChecker() {
        Checker c = new Checker();
        String MockStringName = "Eastern Conference";
        ILeague ILeague = MockLeague.createMock();
        assertEquals(true, c.ConferenceChecker(MockStringName, ILeague));
    }

    @Test
    void falseConferenceChecker() {
        Checker c = new Checker();
        String MockStringName = "Eastern ";
        ILeague ILeague = MockLeague.createMock();
        assertEquals(false, c.ConferenceChecker(MockStringName, ILeague));
    }

    @Test
    void divisionChecker() {
        Checker c = new Checker();
        String MockStringName = "American";
        ILeague ILeague = MockLeague.createMock();
        assertEquals(true, c.DivisionChecker(MockStringName, ILeague));
    }

    @Test
    void falseDivisionChecker() {
        Checker c = new Checker();
        String MockStringName = "India";
        ILeague ILeague = MockLeague.createMock();
        assertEquals(false, c.DivisionChecker(MockStringName, ILeague));
    }

    @Test
    void teamChecker() {
        Checker c = new Checker();
        String MockStringName = "halifax";
        ILeague ILeague = MockLeague.createMock();
        assertEquals(true, c.TeamChecker(MockStringName, ILeague));

    }
    void falseTeamChecker() {
        Checker c = new Checker();
        String MockStringName = "HalifaxTigers";
        ILeague ILeague = MockLeague.createMock();
        assertEquals(false, c.TeamChecker(MockStringName, ILeague));

    }

    @Test
    public void managerCheckerTest(){
        ArrayList<String> managerList = new ArrayList<>();
        managerList.add("abc");
        IChecker c = new Checker();
        assertTrue(c.managerChecker(managerList, "abc"));
        assertFalse(c.managerChecker(managerList, "def"));
    }

    @Test
    public void coachCheckerTest(){
        ArrayList<IHeadCoach> coachList = new ArrayList<>();
        IHeadCoach coach = new HeadCoach();
        coach.setName("Joe Smith");
        coach.setSkating(0.5);
        coach.setShooting(0.8);
        coach.setChecking(0.3);
        coach.setSaving(1.0);
        coachList.add(coach);
        IChecker c = new Checker();
        assertTrue(c.coachChecker(coachList, "Joe Smith"));
        assertFalse(c.coachChecker(coachList, "Frank Smith"));
    }

    @Test
    public void freeAgentCheckerTest(){
        ArrayList<IFreeAgents> freeAgentList = new ArrayList();
        IFreeAgents freeAgent = new FreeAgents("Agent One", "forward");
        freeAgent.setAge(25);
        freeAgent.setSkating(10);
        freeAgent.setShooting(10);
        freeAgent.setChecking(10);
        freeAgent.setSaving(0);
        freeAgentList.add(freeAgent);
        IChecker c = new Checker();
        assertTrue(c.freeAgentChecker(freeAgentList,"Agent One"));
        assertFalse(c.freeAgentChecker(freeAgentList, "Agent Two"));
    }
}