package dhl.leagueModel.league;

import dhl.leagueModel.conference.Conference;
import dhl.leagueModel.conference.IConference;
import dhl.leagueModel.freeAgents.IFreeAgents;
import dhl.leagueModel.gamePlayConfig.IGamePlayConfig;
import dhl.leagueModel.headCoach.IHeadCoach;
import dhl.mock.MockFreeAgent;
import dhl.mock.MockGamePlayConfig;
import dhl.mock.MockHeadCoach;
import dhl.mock.MockManager;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LeagueTest {

    @Test
    void getConferences() {
        ArrayList<IConference> conf_array = new ArrayList<>();
        ILeague leagueTest = new League("Dalhousie Hockey League", conf_array);
        assertEquals(conf_array.getClass(), leagueTest.getConferences().getClass());
    }

    @Test
    void setConferences() {
        ArrayList<IConference> conf_array = new ArrayList<>();
        IConference conference = new Conference("Eastern");
        conf_array.add(conference);
        ILeague league = new League("Dalhousie Hockey League", conf_array);
        league.setConferences(conf_array);
        assertEquals(conference, league.getConferences().get(0));
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
        assertEquals("DHL", leagueTest.getLeagueName());
    }

    @Test
    void getFreeAgents() {
        IFreeAgents freeAgents = MockFreeAgent.createMock();
        ArrayList<IFreeAgents> freeAgentsArray = new ArrayList<>();
        freeAgentsArray.add(freeAgents);
        ILeague league = new League("DHL");
        league.setFreeAgents(freeAgentsArray);
        assertEquals(freeAgentsArray, league.getFreeAgents());
    }

    @Test
    void getGeneralManagers() {
        ArrayList<String> generalManagerArray = MockManager.createMock();
        ILeague league = new League("DHL");
        league.setGeneralManager(generalManagerArray);
        assertEquals(generalManagerArray, league.getGeneralManagers());
    }

    @Test
    void getCoaches() {
        IHeadCoach headCoach = MockHeadCoach.createMock();
        ArrayList<IHeadCoach> headCoachArray = new ArrayList<>();
        ILeague league = new League("DHL");
        headCoachArray.add(headCoach);
        league.setHeadCoach(headCoachArray);
        assertEquals(headCoachArray, league.getCoaches());
    }

    @Test
    void removeManagerFromList() {
        ArrayList<String> managerList = MockManager.createMock();
        ILeague league = new League();
        league.setGeneralManager(managerList);
        league.removeManagerFromList(managerList, "Manager1");
        assertEquals(2, managerList.size());

    }

    @Test
    void setFreeAgents() {
        ArrayList<IFreeAgents> freeAgentsList = new ArrayList<>();
        IFreeAgents freeAgents = MockFreeAgent.createMock();
        ILeague league = new League("DHL");
        freeAgentsList.add(freeAgents);
        league.setFreeAgents(freeAgentsList);
        assertEquals(freeAgentsList, league.getFreeAgents());
    }

    @Test
    void setHeadCoach() {
        ArrayList<IHeadCoach> headCoachList = new ArrayList<>();
        IHeadCoach headCoach = MockHeadCoach.createMock();
        ILeague league = new League("DHL");
        headCoachList.add(headCoach);
        league.setHeadCoach(headCoachList);
        assertEquals(headCoachList, league.getCoaches());
    }

    @Test
    void setGeneralManager() {
        ArrayList<String> generalManagerArray = MockManager.createMock();
        ILeague league = new League("DHL");
        league.setGeneralManager(generalManagerArray);
        assertEquals(generalManagerArray, league.getGeneralManagers());
    }

    @Test
    void getGameplayConfig() {
        IGamePlayConfig gamePlayConfig = MockGamePlayConfig.createMock();
        ILeague league = new League("DHL");
        league.setGameplayConfig(gamePlayConfig);
        assertEquals(gamePlayConfig, league.getGameplayConfig());
    }

    @Test
    void setGameplayConfig() {
        IGamePlayConfig gamePlayConfig = MockGamePlayConfig.createMock();
        ILeague league = new League("DHL");
        league.setGameplayConfig(gamePlayConfig);
        assertEquals(gamePlayConfig, league.getGameplayConfig());
    }

    @Test
    void isValid() {
        ILeague league = new League("DHL");
        boolean result = league.isValid(league);
        assertEquals(true, result);
    }

    @Test
    void isLeagueNamePresent() {
        ILeague league = new League("DHL");
        boolean result = league.isLeagueNamePresent();
        assertEquals(true, result);
    }

    @Test
    void storeLeague() {

    }
}
