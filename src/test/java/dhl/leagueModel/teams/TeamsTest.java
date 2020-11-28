package dhl.leagueModel.teams;

import dhl.leagueModel.headCoach.IHeadCoach;
import dhl.leagueModel.IPlayers;
import dhl.mock.MockHeadCoach;
import dhl.mock.MockPlayer;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TeamsTest {
    @Test
    void swapForPlayerInInactiveRoster() {

    }

//    @Test
//    void getPlayers() {
//        IPlayers players = MockPlayer.createMock();
//        ArrayList<IPlayers> playerArray = new ArrayList<>();
//        ITeam team2 = new Teams();
//        playerArray.add(players);
//        team2.setPlayers(playerArray);
//        assertEquals(playerArray, team2.getPlayers());
//    }
//
//    @Test
//    void setPlayers() {
//        IPlayers players = MockPlayer.createMock();
//        ArrayList<IPlayers> playerArray = new ArrayList<>();
//        ITeam team2 = new Teams();
//        playerArray.add(players);
//        team2.setPlayers(playerArray);
//        assertEquals(playerArray, team2.getPlayers());
//    }
//
//    @Test
//    void getTeamName() {
//        ITeam team = new Teams();
//        team.setTeamName("Team1");
//        assertEquals("Team1", team.getTeamName());
//    }
//
//    @Test
//    void setTeamName() {
//        ITeam team = new Teams();
//        team.setTeamName("Team1");
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

//    @Test
//    void checkForInjury() {
//    }
//
//    @Test
//    void saveTeams() {
//    }



}
