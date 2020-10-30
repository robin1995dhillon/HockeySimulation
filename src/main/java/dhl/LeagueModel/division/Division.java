package dhl.LeagueModel.division;

import dhl.LeagueModel.IDivision;
import dhl.LeagueModel.ITeam2;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class Division implements IDivision {


    String divisionName;
    ArrayList<ITeam2> teams;


    public Division() {
    }

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
    public void saveDivision(int[] ID) {
        IDivisionPersistence divisionPersistence = new DivisionPersistence();
        JSONObject resultObject = divisionPersistence.saveDivisionToDB(this.getDivisionName());
        ArrayList<ITeam2> teamArray = getTeams();
        
        for(ITeam2 t: teamArray) {

        }
    }

}
