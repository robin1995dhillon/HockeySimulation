package dhl.LeagueModel;

import java.util.ArrayList;

public class Division {

    String DivisionName = "";
    ArrayList<Teams> Teams= new ArrayList<>();

    public Division(String divisionName, ArrayList<dhl.LeagueModel.Teams> teams) {
        DivisionName = divisionName;
        Teams = teams;
    }

    public ArrayList<dhl.LeagueModel.Teams> getTeams() {
        return Teams;
    }

    public void setTeams(ArrayList<dhl.LeagueModel.Teams> teams) {
        Teams = teams;
    }

    public String getDivisionName() {
        return DivisionName;
    }

    public void setDivisionName(String divisionName) {
        DivisionName = divisionName;
    }


}
