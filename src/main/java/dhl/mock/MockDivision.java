package dhl.mock;

import dhl.leagueModel.division.Division;
import dhl.leagueModel.division.IDivision;
import dhl.leagueModel.teams.ITeam;
import dhl.leagueModel.teams.Teams;

import java.util.ArrayList;

public class MockDivision {

    public static IDivision createMock() {
        ArrayList<ITeam> teamArray = new ArrayList<>();
        IDivision division = new Division("Metro");
        division.setDivisionName("Atlantic");
        ITeam team = new Teams();
        teamArray.add(team);
        division.setTeams(teamArray);
        return division;
    }

    public static IDivision createMockTwo() {
        ArrayList<ITeam> teamArray = new ArrayList<>();
        IDivision division = new Division("Metro");
        division.setDivisionName("Metro");
        ITeam team = new Teams();
        ITeam team2 = new Teams();
        teamArray.add(team);
        teamArray.add(team2);
        division.setTeams(teamArray);
        return division;
    }
}
