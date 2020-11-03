package dhl.leagueModel.division;

import dhl.Configurables;
import dhl.leagueModel.teams.ITeam;
import dhl.persistence.saving.DivisionPersistence;
import dhl.persistence.saving.IDivisionPersistence;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Division implements IDivision {

    private String divisionName;
    private ArrayList<ITeam> teams;

    public Division(String divisionName, ArrayList<ITeam> teams) {
        this.divisionName = divisionName;
        this.teams = teams;
    }

//    Need for Jackson to store JSON to memory
    public Division() {
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
        int divisionID = (int) resultObject.get(Configurables.ID.getAction());
        ID.add(2, divisionID);
        List<ITeam> teamArray = getTeams();
        for (ITeam t : teamArray) {
            t.saveTeams(ID);
        }
    }
}
