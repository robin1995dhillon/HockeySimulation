package dhl.leagueModel.division;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import dhl.leagueModel.division.Division;
import dhl.leagueModel.teams.ITeam;

import java.util.ArrayList;
import java.util.List;

@JsonDeserialize(as= Division.class)
public interface IDivision {

    public ArrayList<ITeam> getTeams();

    public void setTeams(ArrayList<ITeam> teams);

    public String getDivisionName();

    public void setDivisionName(String divisionName);

    public void addTeam(ITeam team);

    void saveDivision(List<Integer> ID);
}
