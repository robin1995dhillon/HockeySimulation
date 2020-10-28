package dhl.LeagueModel;

import dhl.CreateTeamUtils.IManagerUtils;
import dhl.CreateTeamUtils.ManagerUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
class League2Test {

    @Test
    void isLeagueNamePresentTest() {
        ILeague leagueTest = new League("DalhousieHockeyLeague");
        assertTrue(leagueTest.isLeagueNamePresent());

    }
    @Test
    void getLeagueNameTest() {
        ILeague leagueTest = new League("Dalhousie Hockey League");
        assertEquals("Dalhousie Hockey League", leagueTest.getLeagueName());
    }

    @Test
    void setLeagueNameTest() {
        ILeague leagueTest = new League("Dalhousie Hockey League");
        leagueTest.setLeagueName("DHL");
        assertEquals("DHL",leagueTest.getLeagueName());
    }
    @Test
    void getConferencesTest() {
        ArrayList<IConference> conf_array = new ArrayList<>();
        ILeague leagueTest = new League("Dalhousie Hockey League",conf_array);
        assertEquals(conf_array.getClass(),leagueTest.getConferences().getClass());
    }

    @Test
    void removeManagerFromListTest(){
        ArrayList<String> managerList = new ArrayList();
        managerList.add("Karen Potam");
        managerList.add("Joseph Squidly");
        managerList.add("Tom Spaghetti");
        ILeague league = new League();
        league.removeManagerFromList(managerList,"Joseph Squidly");
        assertEquals(2,managerList.size());
    }

}