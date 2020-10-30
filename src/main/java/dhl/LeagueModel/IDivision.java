package dhl.LeagueModel;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import dhl.LeagueModel.division.Division;

import java.util.ArrayList;
import java.util.List;

@JsonDeserialize(as= Division.class)
public interface IDivision {

    public ArrayList<ITeam2> getTeams();

    public void setTeams(ArrayList<ITeam2> teams);

    public String getDivisionName();

    public void setDivisionName(String divisionName);

    public void addTeam(ITeam2 team);

    void saveDivision(List<Integer> ID);
}
