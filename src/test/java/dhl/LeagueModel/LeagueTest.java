//package dhl.LeagueModel;
//
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//
//import static org.junit.jupiter.api.Assertions.*;
//class LeagueTest {
//
//    @Test
//    void isLeagueNamePresentTest() {
//        ILeague ILeagueTest = new League("DalhousieHockeyLeague");
//        assertEquals(true, ILeagueTest.isLeagueNamePresent());
//
//    }
//    @Test
//    void getLeagueNameTest() {
//        ILeague ILeagueTest = new League("Dalhousie Hockey League");
//        assertEquals("Dalhousie Hockey League", ILeagueTest.getLeagueName());
//    }
//
//    @Test
//    void setLeagueNameTest() {
//        ILeague ILeagueTest = new League("Dalhousie Hockey League");
//        ILeagueTest.setLeagueName("DHL");
//        assertEquals("DHL", ILeagueTest.getLeagueName());
//    }
//    @Test
//    void getConferencesTest() {
//        ArrayList<IConference> conf_array = new ArrayList<IConference>();
////        LeagueCreator lc = new LeagueCreator();
////        League league = lc.CreateLeague("src/Data.json");
////        for(Conference c : league.getConferences()) {
////            conf_array.add(c);
////        }
//        ILeague ILeagueTest = new League("Dalhousie Hockey League",conf_array);
//        assertEquals(conf_array.getClass(), ILeagueTest.getConferences().getClass());
//    }
//
//}