package dhl.LeagueModel;

import java.util.ArrayList;

public class Division2 implements IDivision{

    String divisionName;
    ArrayList<ITeam2> teams;

    @Override
    public ArrayList<ITeam2> getTeams() {
        return teams;
    }

    @Override
    public void setTeams(ArrayList<ITeam2> teams) {
        this.teams = teams;

    }

    @Override
    public String getDivisionName() {
        return divisionName;
    }

    @Override
    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;

    }
}
