package dhl.LeagueModel.division;

import dhl.LeagueModel.IDivision;
import dhl.LeagueModel.ITeam2;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Division implements IDivision {


    String divisionName;
    ArrayList<ITeam2> teams;


    public Division(String divisionName, ArrayList<ITeam2> teams) {
        this.divisionName = divisionName;
        this.teams = teams;
    }

    public Division(String divisionName) {
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

    @Override
    public void saveDivision(List<Integer> ID) {
        IDivisionPersistence divisionPersistence = new DivisionPersistence();
        JSONObject resultObject = divisionPersistence.saveDivisionToDB(this.getDivisionName());
        int divisionID = (int) resultObject.get("id");
        ID.add(2,divisionID);
        List<ITeam2> teamArray = getTeams();
        for(ITeam2 t: teamArray) {
            t.saveTeams(ID);
        }
    }

}
