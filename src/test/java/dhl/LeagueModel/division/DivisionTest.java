package dhl.LeagueModel.division;

import dhl.LeagueModel.IDivision;
import dhl.LeagueModel.IHeadCoach;
import dhl.LeagueModel.ITeam2;
import dhl.LeagueModel.headCoach.HeadCoach;
import dhl.LeagueModel.teams.Teams;
import dhl.Mock.MockTeam;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DivisionTest {

    @Test
    void getTeams() {
        ArrayList<ITeam2> team_array = new ArrayList<>();
        ITeam2 team = MockTeam.MockTeam();
        team_array.add(team);
        IDivision d = new Division("Atlantic", team_array);
        d.addTeam(team);
        assertEquals(team,d.getTeams().get(0));
    }

    @Test
    void setTeams() {
        ArrayList<ITeam2> team_array = new ArrayList<>();
        ITeam2 team = MockTeam.MockTeam();
        ITeam2 team2 = MockTeam.MockTeamTwo();
        team_array.add(team);
        IDivision d = new Division("Atlantic", team_array);
        team_array.add(team2);
        d.setTeams(team_array);
        assertEquals(team2,d.getTeams().get(1));
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
        ITeam2 team = MockTeam.MockTeam();
        ITeam2 team2 = MockTeam.MockTeamTwo();
        ArrayList<ITeam2> teamArray = new ArrayList<>();
        teamArray.add(team);
        IDivision division = new Division("Metro",teamArray);
        division.addTeam(team2);
        assertEquals(team2,division.getTeams().get(1));
    }

    @Test
    void saveDivision() {
    }
}