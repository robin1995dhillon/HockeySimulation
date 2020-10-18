package dhl.LeagueModel;

import java.util.ArrayList;

public class Division2 implements IDivision{


    String divisionName;
    ArrayList<ITeam2> teams;


    public Division2() {
    }

    public Division2(String divisionName, ArrayList<ITeam2> teams) {
        this.divisionName = divisionName;
        this.teams = teams;
    }

    public Division2(String divisionName) {
        this.divisionName = divisionName;
    }


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
    public void addTeam(ITeam2 team) {
        teams.add(team);
    }

}
