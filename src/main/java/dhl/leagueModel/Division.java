package dhl.leagueModel;

import java.util.List;

public class Division implements IDivision {

    private String divisionName;
    private List<ITeam> teams;

    public Division(String divisionName, List<ITeam> teams) {
        this.divisionName = divisionName;
        this.teams = teams;
    }

    public Division() {
    }

    public Division(String divisionName) {
        this.divisionName = divisionName;
    }

    @Override
    public List<ITeam> getTeams() {
        return teams;
    }

    @Override
    public void setTeams(List<ITeam> teams) {
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


}
