package dhl.stateMachine;

import dhl.leagueModel.ITeam;

public class TeamStandings implements ITeamStanding{

    private ITeam teamName;
    private String conference;
    private String division;
    private int gamesPlayed = 0;
    private int gamesWon = 0;
    private int gamesLost = 0;
    private int points = 0;


    public ITeam getTeam() {
        return teamName;
    }

    public void setTeam(ITeam teamName) {
        this.teamName = teamName;

    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String divisionName) {
        this.division = divisionName;

    }

    public String getConference() {
        return conference;
    }

    public void setConference(String conferenceName) {
        this.conference = conferenceName;

    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;

    }

    public int getGamesWon() {
        return gamesWon;
    }

    public void setGamesWon(int gamesWon) {
        this.gamesWon = gamesWon;

    }

    public int getGamesLost() {
        return gamesLost;
    }

    public void setGamesLost(int gamesLost) {
        this.gamesLost = gamesLost;

    }

    public int getTotalPoints() {
        return points;
    }

    public void setTotalPoints(int totalPoints) {
        this.points = totalPoints;

    }
}
