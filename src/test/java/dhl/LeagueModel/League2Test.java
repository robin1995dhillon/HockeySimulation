package dhl.LeagueModel;

import dhl.Creator.LeagueCreator;
import dhl.LeagueModel.Conference;
import dhl.LeagueModel.League;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
class League2Test {

    @Test
    void isLeagueNamePresentTest() {
        ILeague leagueTest = new League2("DalhousieHockeyLeague");
        assertEquals(true, leagueTest.isLeagueNamePresent());

    }
    @Test
    void getLeagueNameTest() {
        ILeague leagueTest = new League2("Dalhousie Hockey League");
        assertEquals("Dalhousie Hockey League", leagueTest.getLeagueName());
    }

    @Test
    void setLeagueNameTest() {
        ILeague leagueTest = new League2("Dalhousie Hockey League");
        leagueTest.setLeagueName("DHL");
        assertEquals("DHL",leagueTest.getLeagueName());
    }
    @Test
    void getConferencesTest() {
        ArrayList<IConference> conf_array = new ArrayList<>();
        ILeague leagueTest = new League2("Dalhousie Hockey League",conf_array);
        assertEquals(conf_array.getClass(),leagueTest.getConferences().getClass());
    }

}