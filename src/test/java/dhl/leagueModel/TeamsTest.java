//package dhl.leagueModel;
//
//import dhl.mock.MockGamePlayConfig;
//import dhl.mock.MockTeam;
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//class TeamsTest {
//    ITeam team;
//    MockTeam mockTeam;
//    MockGamePlayConfig mockGamePlayConfig;
//    IGeneralManager generalManager;
//
//
//    public TeamsTest() {
//        mockTeam = new MockTeam();
//        mockGamePlayConfig = new MockGamePlayConfig();
//    }
//
//    @Test
//    void swapForPlayerInInactiveRoster() {
//
//    }
//
//    @Test
//    void getPlayers() {
//        team = mockTeam.createTeamMockOne();
//        List<IPlayers> playerList = mockTeam.createTeamMockOne().getPlayers();
//        assertEquals(playerList, team.getPlayers());
//    }
//
//    @Test
//    void setPlayers() {
//        team = mockTeam.createTeamMockOne();
//        List<IPlayers> playerList = mockTeam.createTeamMockTwo().getPlayers();
//        team.setPlayers(playerList);
//        assertEquals(playerList, team.getPlayers());
//    }
//
//    @Test
//    void getTeamName() {
//        team = mockTeam.createTeamMockOne();
//        assertEquals("Team1", team.getTeamName());
//    }
//
//    @Test
//    void setTeamName() {
//        team = mockTeam.createTeamMockOne();
//        team.setTeamName("Team2");
//        assertEquals("Team2", team.getTeamName());
//    }
//
//    @Test
//    void getGeneralManager() {
//        ITeam team = new Teams();
//        team.setGeneralManager("GeneralManager1");
//        assertEquals("GeneralManager1", team.getGeneralManager());
//    }
//
//    @Test
//    void setGeneralManager() {
//        ITeam team = new Teams();
//        team.setGeneralManager("GeneralManager1");
//        team.setGeneralManager("GeneralManager2");
//        assertEquals("GeneralManager2", team.getGeneralManager());
//    }
//
//    @Test
//    void getTeamType() {
//        ITeam team = new Teams();
//        team.setTeamType("ai");
//        assertEquals("ai", team.getTeamType());
//    }
//
//    @Test
//    void setTeamType() {
//        ITeam team = new Teams();
//        team.setTeamType("ai");
//        team.setTeamType("user");
//        assertEquals("user", team.getTeamType());
//    }
//
//    @Test
//    void getHeadCoach() {
//        ITeam team = new Teams();
//        IHeadCoach headCoach = MockHeadCoach.createMock();
//        team.setHeadCoach(headCoach);
//        assertEquals(headCoach, team.getHeadCoach());
//    }
//
//    @Test
//    void setHeadCoach() {
//        ITeam team = new Teams();
//        IHeadCoach headCoach = MockHeadCoach.createMock();
//        team.setHeadCoach(headCoach);
//        assertEquals(headCoach, team.getHeadCoach());
//    }
//
//    @Test
//    void getLossPoints() {
//        ITeam team = new Teams();
//        team.setLossPoints(10);
//        assertEquals(10, team.getLossPoints());
//    }
//
//    @Test
//    void setLossPoints() {
//        ITeam team = new Teams();
//        team.setLossPoints(10);
//        team.setLossPoints(11);
//        assertEquals(11, team.getLossPoints());
//    }
//
//    @Test
//    void getTeamStrength() {
//        ITeam team = new Teams();
//        team.setTeamStrength(10);
//        assertEquals(10, team.getTeamStrength());
//    }
//
//    @Test
//    void setTeamStrength() {
//        ITeam team = new Teams();
//        team.setTeamStrength(10);
//        team.setTeamStrength(20);
//        assertEquals(20, team.getTeamStrength());
//    }
//
//    @Test
//    void calculateTeamStrength() {
//        IHeadCoach headCoach = MockHeadCoach.createMock();
//        IPlayers players = MockPlayer.createMock();
//        IPlayers playerTwo = MockPlayer.createMockTwo();
//        ArrayList<IPlayers> playerArray = new ArrayList<>();
//        playerArray.add(players);
//        playerArray.add(playerTwo);
//        ITeam team = new Teams("Team1", "Manager1", headCoach, playerArray);
//        assertEquals(74, team.calculateTeamStrength(team));
//    }
//
//    @Test
//    void checkForInjury() {
//    }
//
//
//
//
//}
