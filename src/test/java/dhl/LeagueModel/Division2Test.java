package dhl.LeagueModel;

import dhl.LeagueModel.division.Division;
import dhl.LeagueModel.headCoach.HeadCoach;
import dhl.LeagueModel.teams.Teams;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DivisionTest2 {

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
    void getTeams() {
        ArrayList<ITeam2> team_array = new ArrayList<>();
        IHeadCoach h = new HeadCoach();
        h.setChecking(0.5);
        h.setName("ABC");
        h.setSaving(0.4);
        h.setShooting(0.7);
        h.setSkating(0.3);

        ITeam2 t = new Teams("Random1", "Random2", h);
        IDivision d = new Division("Atlantic", team_array);
        d.addTeam(t);
        assertEquals(t,d.getTeams().get(0));
    }

    @Test
    void setTeams() {
        ArrayList<ITeam2> team_array = new ArrayList<>();
        ArrayList<ITeam2> team_array_2 = new ArrayList<>();
        IHeadCoach h = new HeadCoach();
        h.setChecking(0.5);
        h.setName("ABC");
        h.setSaving(0.4);
        h.setShooting(0.7);
        h.setSkating(0.3);
        ITeam2 t = new Teams("Random1", "Random2", h);
        IDivision d = new Division("Atlantic", team_array);
        d.addTeam(t);
        d.setTeams(team_array_2);
        assertEquals(team_array_2,d.getTeams());
    }

    @Test
    void addTeam() {
        ArrayList<ITeam2> team_array = new ArrayList<>();
        IHeadCoach headCoach = new HeadCoach();
        headCoach.setName("Head1");
        headCoach.setSkating(0.5);
        headCoach.setShooting(0.6);
        headCoach.setSaving(0.3);
        headCoach.setChecking(0.8);
        ITeam2 t = new Teams("Random1", "Random2", headCoach);
        IDivision d = new Division("Atlantic", team_array);
        d.addTeam(t);
        assertEquals(t,d.getTeams().get(0));
    }
}
