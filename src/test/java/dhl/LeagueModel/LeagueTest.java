package dhl.LeagueModel;

import dhl.Creator.LeagueCreator;
import dhl.LeagueModel.Conference;
import dhl.LeagueModel.League;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
class LeagueTest {

    @Test
    void isLeagueNamePresentTest() {
        League leagueTest = new League("DalhousieHockeyLeague");
        assertEquals(true, leagueTest.isLeagueNamePresent());

    }
    @Test
    void getLeagueNameTest() {
        League leagueTest = new League("Dalhousie Hockey League");
        assertEquals("Dalhousie Hockey League", leagueTest.getLeagueName());
    }

    @Test
    void setLeagueNameTest() {
        League leagueTest = new League("Dalhousie Hockey League");
        leagueTest.setLeagueName("DHL");
        assertEquals("DHL",leagueTest.getLeagueName());
    }
    @Test
    void getConferencesTest() {
        ArrayList<Conference> conf_array = new ArrayList<Conference>();
//        LeagueCreator lc = new LeagueCreator();
//        League league = lc.CreateLeague("src/Data.json");
//        for(Conference c : league.getConferences()) {
//            conf_array.add(c);
//        }
        League leagueTest = new League("Dalhousie Hockey League",conf_array);
        assertEquals(conf_array.getClass(),leagueTest.getConferences().getClass());
    }

}