package dhl.LeagueModel;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DivisionTest {

    @Test
    void getDivisionName() {
        Division D = new Division("Atlantic");
        assertEquals("Atlantic", D.getDivisionName());
    }

    @Test
    void setDivisionName() {
        Division D = new Division("Atlantic");
        D.setDivisionName("Halifax Lions");
        assertEquals("Halifax Lions", D.getDivisionName());
    }

    @Test
    void getTeams() {
        ArrayList<Teams> team_array = new ArrayList<>();
        Teams T = new Teams("Random1", "Random2", "Random3");
        Division D = new Division("Atlantic", team_array);
        D.addTeam(T);
        assertEquals(T,D.getTeams().get(0));
    }

    @Test
    void setTeams() {
        ArrayList<Teams> team_array = new ArrayList<>();
        ArrayList<Teams> team_array_2 = new ArrayList<>();
        Teams T = new Teams("Random1", "Random2", "Random3");
        Division D = new Division("Atlantic", team_array);
        D.addTeam(T);
        D.setTeams(team_array_2);
        assertEquals(team_array_2,D.getTeams());
    }

    @Test
    void addTeam() {
        ArrayList<Teams> team_array = new ArrayList<>();
        Teams T = new Teams("Random1", "Random2", "Random3");
        Division D = new Division("Atlantic", team_array);
        D.addTeam(T);
        assertEquals(T,D.getTeams().get(0));
    }
}