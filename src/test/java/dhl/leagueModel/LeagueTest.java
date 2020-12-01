package dhl.leagueModel;

import dhl.leagueModel.gamePlayConfig.IGamePlayConfig;
import dhl.mock.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LeagueTest {

    MockLeague mockLeague;
    MockHeadCoach mockHeadCoach;
    MockGeneralManager mockGeneralManager;
    ILeague league;


    public LeagueTest() {
        mockLeague = new MockLeague();
        mockHeadCoach = new MockHeadCoach();
        mockGeneralManager = new MockGeneralManager();
    }

    @Test
    void getConferences() {
        List<IConference> conferenceList;
        league = mockLeague.createLeagueMock();
        conferenceList = league.getConferences();
        assertEquals(conferenceList,league.getConferences());
    }

    @Test
    void setConferences() {
        List<IConference> conferenceListTwo = new ArrayList<>();
        league = mockLeague.createLeagueMock();
        league.setConferences(conferenceListTwo);
        assertEquals(conferenceListTwo,league.getConferences());
    }

    @Test
    void getLeagueName() {
        league = mockLeague.createLeagueMock();
        assertEquals("League1", league.getLeagueName());
    }

    @Test
    void setLeagueName() {
        league = mockLeague.createLeagueMock();
        league.setLeagueName("League2");
        assertEquals("League2", league.getLeagueName());
    }

    @Test
    void getFreeAgents() {
        league = mockLeague.createLeagueMock();
        List<IFreeAgents> freeAgentsList = league.getFreeAgents();
        league.setFreeAgents(freeAgentsList);
        assertEquals(freeAgentsList, league.getFreeAgents());
    }

    @Test
    void getGeneralManagers() {
        List<IGeneralManager> generalManagerArray = new ArrayList<>();
        IGeneralManager generalManager = mockGeneralManager.createGeneralManager();
        generalManagerArray.add(generalManager);
        league = mockLeague.createLeagueMock();
        league.setGeneralManagers(generalManagerArray);
        assertEquals(generalManager, league.getGeneralManagers().get(0));
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

//    @Test
//    void removeManagerFromList() {
//        ArrayList<String> managerList = MockManager.createMock();
//        ILeague league = new League();
//        league.setGeneralManager(managerList);
//        league.removeManagerFromList(managerList, "Manager1");
//        assertEquals(2, managerList.size());
//
//    }

    @Test
    void setFreeAgents() {
        league = mockLeague.createLeagueMock();
        ArrayList<IFreeAgents> freeAgentsList2 = new ArrayList<>();
        league.setFreeAgents(freeAgentsList2);
        assertEquals(freeAgentsList2, league.getFreeAgents());
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
        league = mockLeague.createLeagueMock();
        IGeneralManager generalManager = mockGeneralManager.createGeneralManager();
        ArrayList<IGeneralManager> generalManagerArrayList = new ArrayList<>();
        generalManagerArrayList.add(generalManager);
        league.setGeneralManagers(generalManagerArrayList);
        assertEquals(generalManagerArrayList, league.getGeneralManagers());
    }

    @Test
    void getGameplayConfig() {
        league = mockLeague.createLeagueMock();
        IGamePlayConfig gamePlayConfig = league.getGameplayConfig();
        assertEquals(gamePlayConfig, league.getGameplayConfig());
    }

    @Test
    void setGameplayConfig() {
        league = mockLeague.createLeagueMock();
        IGamePlayConfig gamePlayConfig = league.getGameplayConfig();
        assertEquals(gamePlayConfig, league.getGameplayConfig());
    }

    @Test
    void isValid() {
        league = mockLeague.createLeagueMock();
        boolean result = league.isValid(league);
        assertEquals(true, result);
    }

    @Test
    void isLeagueNamePresent() {
        league = mockLeague.createLeagueMock();
        boolean result = league.isLeagueNamePresent();
        assertEquals(true, result);
    }


}
