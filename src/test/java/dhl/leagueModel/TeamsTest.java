package dhl.leagueModel;

import dhl.mock.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TeamsTest {
    ITeam team;
    MockTeam mockTeam;
    MockGamePlayConfig mockGamePlayConfig;
    IGeneralManager generalManager;
    MockGeneralManager mockGeneralManager;
    IHeadCoach headCoach;
    MockHeadCoach mockHeadCoach;
    MockPlayer mockPlayer;
    IPlayers players;
    IPlayers players2;

    public TeamsTest() {
        mockTeam = new MockTeam();
        mockGamePlayConfig = new MockGamePlayConfig();
        mockGeneralManager = new MockGeneralManager();
        mockHeadCoach = new MockHeadCoach();
        mockPlayer = new MockPlayer();
    }

    @Test
    void swapForPlayerInInactiveRoster() {

    }

    @Test
    void getPlayers() {
        team = mockTeam.createTeamMockOne();
        List<IPlayers> playerList = mockTeam.createTeamMockOne().getPlayers();
        assertEquals(playerList, team.getPlayers());
    }

    @Test
    void setPlayers() {
        team = mockTeam.createTeamMockOne();
        List<IPlayers> playerList = mockTeam.createTeamMockTwo().getPlayers();
        team.setPlayers(playerList);
        assertEquals(playerList, team.getPlayers());
    }

    @Test
    void getTeamName() {
        team = mockTeam.createTeamMockOne();
        assertEquals("Team1", team.getTeamName());
    }

    @Test
    void setTeamName() {
        team = mockTeam.createTeamMockOne();
        team.setTeamName("Team2");
        assertEquals("Team2", team.getTeamName());
    }

    @Test
    void getGeneralManager() {
        team = mockTeam.createTeamMockOne();
        generalManager = mockGeneralManager.createGeneralManager();
        team.setGeneralManager(generalManager);
        assertEquals(generalManager, team.getGeneralManager());
    }

    @Test
    void setGeneralManager() {
        team = mockTeam.createTeamMockOne();
        generalManager = mockGeneralManager.createGeneralManager();
        team.setGeneralManager(generalManager);
        assertEquals(generalManager, team.getGeneralManager());
    }

    @Test
    void getTeamType() {
        team = mockTeam.createTeamMockOne();
        team.setTeamType("ai");
        assertEquals("ai", team.getTeamType());
    }

    @Test
    void setTeamType() {
        team = mockTeam.createTeamMockOne();
        team.setTeamType("ai");
        team.setTeamType("user");
        assertEquals("user", team.getTeamType());
    }

    @Test
    void getHeadCoach() {
        team = mockTeam.createTeamMockOne();
        headCoach = mockHeadCoach.createHeadCoachMock();
        team.setHeadCoach(headCoach);
        assertEquals(headCoach, team.getHeadCoach());
    }

    @Test
    void setHeadCoach() {
        headCoach = mockHeadCoach.createHeadCoachMock();
        team = mockTeam.createTeamMockOne();
        team.setHeadCoach(headCoach);
        assertEquals(headCoach, team.getHeadCoach());
    }

    @Test
    void getLossPoints() {
        team = mockTeam.createTeamMockOne();
        team.setLossPoints(10);
        assertEquals(10, team.getLossPoints());
    }

    @Test
    void setLossPoints() {
        team = mockTeam.createTeamMockOne();
        team.setLossPoints(10);
        assertEquals(10, team.getLossPoints());
    }

    @Test
    void getTeamStrength() {
        team = mockTeam.createTeamMockOne();
        team.setTeamStrength(10);
        assertEquals(10, team.getTeamStrength());
    }

    @Test
    void setTeamStrength() {
        team = mockTeam.createTeamMockOne();
        team.setTeamStrength(10);
        assertEquals(10, team.getTeamStrength());
    }

    @Test
    void calculateTeamStrength() {
        headCoach = mockHeadCoach.createHeadCoachMock();
        players = mockPlayer.createPlayerMockOne();
        players2 = mockPlayer.createPlayerMockTwo();
        ArrayList<IPlayers> playerArray = new ArrayList<>();
        playerArray.add(players);
        playerArray.add(players2);
        team = mockTeam.createTeamMockOne();
        team.setPlayers(playerArray);
        assertEquals(96, team.calculateTeamStrength(team));
    }

//    @Test
//    void checkForInjury() {
//
//    }




}
