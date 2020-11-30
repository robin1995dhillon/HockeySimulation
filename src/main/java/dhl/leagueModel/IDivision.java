package dhl.leagueModel;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

@JsonDeserialize(as = Division.class)
public interface IDivision {

    public List<ITeam> getTeams();

    public void setTeams(List<ITeam> teams);

    public String getDivisionName();

    public void setDivisionName(String divisionName);

    public void addTeam(ITeam team);

//    void saveDivision(List<Integer> ID);
}
