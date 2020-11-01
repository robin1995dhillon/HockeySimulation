package dhl.leagueModel.division;

import dhl.leagueModel.IDivision;
import dhl.leagueModel.ITeam;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Division implements IDivision {


    String divisionName;
    ArrayList<ITeam> teams;


    public Division(String divisionName, ArrayList<ITeam> teams) {
        this.divisionName = divisionName;
        this.teams = teams;
    }

    public Division(String divisionName) {
        this.divisionName = divisionName;
    }


    @Override
    public ArrayList<ITeam> getTeams() {
        return teams;
    }

    @Override
    public void setTeams(ArrayList<ITeam> teams) {
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
    public void addTeam(ITeam team) {
        teams.add(team);
    }

    @Override
    public void saveDivision(List<Integer> ID) {
        IDivisionPersistence divisionPersistence = new DivisionPersistence();
        JSONObject resultObject = divisionPersistence.saveDivisionToDB(this.getDivisionName());
        int divisionID = (int) resultObject.get("id");
        ID.add(2,divisionID);
        List<ITeam> teamArray = getTeams();
        for(ITeam t: teamArray) {
            t.saveTeams(ID);
        }
    }

}
