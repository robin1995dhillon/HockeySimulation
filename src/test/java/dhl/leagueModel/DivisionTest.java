package dhl.leagueModel;

import dhl.mock.MockTeam;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DivisionTest {

    IDivision division;


    public DivisionTest() {
    }

    @Test
    void getTeams() {
        ArrayList<ITeam> team_array = new ArrayList<>();
        ITeam team = MockTeam.MockTeam();
        team_array.add(team);
        IDivision d = new Division("Atlantic", team_array);
        d.addTeam(team);
        assertEquals(team, d.getTeams().get(0));
    }

    @Test
    void setTeams() {
        ArrayList<ITeam> team_array = new ArrayList<>();
        ITeam team = MockTeam.MockTeam();
        ITeam team2 = MockTeam.MockTeamTwo();
        team_array.add(team);
        IDivision d = new Division("Atlantic", team_array);
        team_array.add(team2);
        d.setTeams(team_array);
        assertEquals(team2, d.getTeams().get(1));
    }

    @Test
    void getDivisionName() {
        IDivision d = new Division("Atlantic");
        assertEquals("Atlantic", d.getDivisionName());
    }

    @Test
    void setDivisionName() {
        IDivision d = new Division("Atlantic");
        d.setDivisionName("Halifax Lions");
        assertEquals("Halifax Lions", d.getDivisionName());
    }

    @Test
    void addTeam() {

    }

}
