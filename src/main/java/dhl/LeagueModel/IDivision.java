package dhl.LeagueModel;

import java.util.ArrayList;

public interface IDivision {

    public ArrayList<ITeam2> getTeams();

    public void setTeams(ArrayList<ITeam2> teams);

    public String getDivisionName();

    public void setDivisionName(String divisionName);
}
