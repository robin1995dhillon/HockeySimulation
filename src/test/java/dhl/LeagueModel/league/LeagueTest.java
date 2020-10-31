package dhl.LeagueModel.league;

import dhl.LeagueModel.IConference;
import dhl.LeagueModel.ILeague;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LeagueTest {

    @Test
    void getConferences() {
        ArrayList<IConference> conf_array = new ArrayList<>();
        ILeague leagueTest = new League("Dalhousie Hockey League",conf_array);
        assertEquals(conf_array.getClass(),leagueTest.getConferences().getClass());
    }

    @Test
    void setConferences() {
    }

    @Test
    void getLeagueName() {
        ILeague leagueTest = new League("Dalhousie Hockey League");
        assertEquals("Dalhousie Hockey League", leagueTest.getLeagueName());
    }

    @Test
    void setLeagueName() {
        ILeague leagueTest = new League("Dalhousie Hockey League");
        leagueTest.setLeagueName("DHL");
        assertEquals("DHL",leagueTest.getLeagueName());
    }

    @Test
    void getFreeAgents() {
    }

    @Test
    void getGeneralManagers() {
    }

    @Test
    void getCoaches() {
    }

    @Test
    void removeManagerFromList() {
        ArrayList<String> managerList = new ArrayList();
        managerList.add("Karen Potam");
        managerList.add("Joseph Squidly");
        managerList.add("Tom Spaghetti");
        ILeague league = new League();
        league.setGeneralManager(managerList);
        league.removeManagerFromList(managerList,"Joseph Squidly");
        assertEquals(2,managerList.size());
    }

    @Test
    void setFreeAgents() {
    }

    @Test
    void setHeadCoach() {
    }

    @Test
    void setGeneralManager() {
    }

    @Test
    void getGameplayConfig() {
    }

    @Test
    void setGameplayConfig() {
    }

    @Test
    void isValid() {
    }

    @Test
    void isLeagueNamePresent() {
    }

    @Test
    void storeLeague() {

    }
}