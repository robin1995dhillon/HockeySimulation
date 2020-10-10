package dhl.LeagueModel;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TeamsTest {

    @Test
    void getPlayers() {
        ArrayList<Players> P = new ArrayList<>();
        Teams T = new Teams("Team1","","", P);
        assertEquals(P, T.getPlayers());
    }

    @Test
    void setPlayers() {
        ArrayList<Players> P = new ArrayList<>();
        ArrayList<Players> P_2 = new ArrayList<>();
        Teams T = new Teams("Team1","","", P);
        T.setPlayers(P_2);
        assertEquals(P_2, T.getPlayers());
    }

    @Test
    void getTeamName() {
        Teams T = new Teams("Team1","","");
        assertEquals("Team1", T.getTeamName());
    }

    @Test
    void setTeamName() {
        Teams T = new Teams("Team1","","");
        T.setTeamName("Team2");
        assertEquals("Team2", T.getTeamName());
    }

    @Test
    void getGeneralManager() {
        Teams T = new Teams("Team1","General1","");
        assertEquals("General1", T.getGeneralManager());
    }

    @Test
    void setGeneralManager() {
        Teams T = new Teams("Team1","General1","");
        T.setGeneralManager("General2");
        assertEquals("General2", T.getGeneralManager());
    }

    @Test
    void getHeadCoach() {
        Teams T = new Teams("Team1","General1","Head1");
        assertEquals("Head1", T.getHeadCoach());
    }

    @Test
    void setHeadCoach() {
        Teams T = new Teams("Team1","General1","Head1");
        T.setHeadCoach("Head2");
        assertEquals("Head2", T.getHeadCoach());
    }
}