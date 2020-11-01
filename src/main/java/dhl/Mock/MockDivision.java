package dhl.Mock;

import dhl.LeagueModel.IDivision;
import dhl.LeagueModel.ITeam2;
import dhl.LeagueModel.division.Division;
import dhl.LeagueModel.teams.Teams;

import java.util.ArrayList;

public class MockDivision {

    public static IDivision getOneTeamDivision() {
        ArrayList<ITeam2> teamArray = new ArrayList<>();
        IDivision division = new Division("Metro");
        division.setDivisionName("Atlantic");
        ITeam2 team = new Teams();
        teamArray.add(team);
        division.setTeams(teamArray);
        return division;
    }

    public static IDivision getTwoTeamDivision() {
        ArrayList<ITeam2> teamArray = new ArrayList<>();
        IDivision division = new Division("Metro");
        division.setDivisionName("Metro");
        ITeam2 team = new Teams();
        ITeam2 team2 = new Teams();
        teamArray.add(team);
        teamArray.add(team2);
        division.setTeams(teamArray);
        return division;
    }
}
