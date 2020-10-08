package dhl.LeagueModel;

import java.util.ArrayList;

public class Teams {
    public String teamName;
    public String generalManager;
    public String headCoach;
    ArrayList<Players> Players;

    public Teams(String teamName, String generalManager, String headCoach, ArrayList<dhl.LeagueModel.Players> players) {
        this.teamName = teamName;
        this.generalManager = generalManager;
        this.headCoach = headCoach;
        Players = players;
    }

    public Teams() {

    }

    public ArrayList<dhl.LeagueModel.Players> getPlayers() {
        return Players;
    }

    public void setPlayers(ArrayList<dhl.LeagueModel.Players> players) {
        Players = players;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getGeneralManager() {
        return generalManager;
    }

    public void setGeneralManager(String generalManager) {
        this.generalManager = generalManager;
    }

    public String getHeadCoach() {
        return headCoach;
    }

    public void setHeadCoach(String headCoach) {
        this.headCoach = headCoach;
    }

}
