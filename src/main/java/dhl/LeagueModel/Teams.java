package dhl.LeagueModel;

import java.util.ArrayList;

public class Teams {
    public String TeamName = "";
    public String GeneralManager = "";
    public String HeadCoach = "";
    ArrayList<Players> Players = new ArrayList<>();

    public Teams(String teamName, String generalManager, String headCoach, ArrayList<dhl.LeagueModel.Players> players) {
        TeamName = teamName;
        GeneralManager = generalManager;
        HeadCoach = headCoach;
        Players = players;
    }

    public ArrayList<dhl.LeagueModel.Players> getPlayers() {
        return Players;
    }

    public void setPlayers(ArrayList<dhl.LeagueModel.Players> players) {
        Players = players;
    }

    public String getTeamName() {
        return TeamName;
    }

    public void setTeamName(String teamName) {
        TeamName = teamName;
    }

    public String getGeneralManager() {
        return GeneralManager;
    }

    public void setGeneralManager(String generalManager) {
        GeneralManager = generalManager;
    }

    public String getHeadCoach() {
        return HeadCoach;
    }

    public void setHeadCoach(String headCoach) {
        HeadCoach = headCoach;
    }
}
