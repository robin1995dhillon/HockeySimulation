//package dhl.validator;
//
//import dhl.leagueModel.IFreeAgents;
//import dhl.leagueModel.headCoach.IHeadCoach;
//import dhl.leagueModel.league.ILeague;
//import dhl.mock.MockFreeAgent;
//import dhl.mock.MockHeadCoach;
//import dhl.mock.MockLeague;
//import dhl.mock.MockManager;
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//class CheckerTest {
//
//    @Test
//    void conferenceChecker() {
//        Checker c = new Checker();
//        String MockStringName = "Eastern Conference";
//        ILeague ILeague = MockLeague.createMock();
//        assertTrue(c.conferenceChecker(MockStringName, ILeague));
//    }
//
//    @Test
//    void falseConferenceChecker() {
//        Checker c = new Checker();
//        String MockStringName = "Eastern ";
//        ILeague ILeague = MockLeague.createMock();
//        assertFalse(c.conferenceChecker(MockStringName, ILeague));
//    }
//
//    @Test
//    void divisionChecker() {
//        Checker c = new Checker();
//        String MockStringName = "American";
//        ILeague ILeague = MockLeague.createMock();
//        assertTrue(c.divisionChecker(MockStringName, ILeague));
//    }
//
//    @Test
//    void falseDivisionChecker() {
//        Checker c = new Checker();
//        String MockStringName = "India";
//        ILeague ILeague = MockLeague.createMock();
//        assertFalse(c.divisionChecker(MockStringName, ILeague));
//    }
//
//    @Test
//    void teamChecker() {
//        Checker c = new Checker();
//        String MockStringName = "halifax";
//        ILeague ILeague = MockLeague.createMock();
//        assertTrue(c.teamChecker(MockStringName, ILeague));
//
//    }
//
//    void falseTeamChecker() {
//        Checker c = new Checker();
//        String MockStringName = "HalifaxTigers";
//        ILeague ILeague = MockLeague.createMock();
//        assertFalse(c.teamChecker(MockStringName, ILeague));
//
//    }
//
//    @Test
//    public void managerCheckerTest() {
//        ArrayList<String> managerList = MockManager.createMock();
//        IChecker c = new Checker();
//        assertTrue(c.managerChecker(managerList, "Manager1"));
//        assertFalse(c.managerChecker(managerList, "def"));
//    }
//
//    @Test
//    public void coachCheckerTest() {
//        ArrayList<IHeadCoach> coachList = new ArrayList<>();
//        IHeadCoach coach = MockHeadCoach.createMock();
//        coachList.add(coach);
//        IChecker c = new Checker();
//        assertTrue(c.coachChecker(coachList, "Head1"));
//        assertFalse(c.coachChecker(coachList, "Frank Smith"));
//    }
//
//    @Test
//    public void freeAgentCheckerTest() {
//        ArrayList<IFreeAgents> freeAgentList = new ArrayList();
//        IFreeAgents freeAgent = MockFreeAgent.createMock();
//        freeAgentList.add(freeAgent);
//        IChecker c = new Checker();
//        assertTrue(c.freeAgentChecker(freeAgentList, "FreeAgent1"));
//        assertFalse(c.freeAgentChecker(freeAgentList, "Agent Two"));
//    }
//}
