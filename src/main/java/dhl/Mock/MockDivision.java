package dhl.Mock;

import dhl.LeagueModel.IDivision;
import dhl.LeagueModel.ITeam;
import dhl.LeagueModel.division.Division;
import dhl.LeagueModel.teams.Teams;

import java.util.ArrayList;

public class MockDivision {

    public static IDivision getOneTeamDivision() {
        ArrayList<ITeam> teamArray = new ArrayList<>();
        IDivision division = new Division("Metro");
        division.setDivisionName("Atlantic");
        ITeam team = new Teams();
        teamArray.add(team);
        division.setTeams(teamArray);
        return division;
    }

    public static IDivision getTwoTeamDivision() {
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
