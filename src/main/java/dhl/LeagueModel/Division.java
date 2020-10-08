package dhl.LeagueModel;

import java.util.ArrayList;

public class Division {

    String divisionName;
    ArrayList<Teams> Teams;

    public Division(String divisionName, ArrayList<dhl.LeagueModel.Teams> teams) {
        this.divisionName = divisionName;
        Teams = teams;
    }

    public Division() {

    }

    public ArrayList<dhl.LeagueModel.Teams> getTeams() {
        return Teams;
    }

    public void setTeams(ArrayList<dhl.LeagueModel.Teams> teams) {
        Teams = teams;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public void addTeam(Teams team) {
        Teams.add(team);
    }

}
