package dhl.LeagueModel.Teams;

import dhl.LeagueModel.IHeadCoach;
import dhl.LeagueModel.IPlayers;
import dhl.LeagueModel.ITeam2;

import java.util.ArrayList;

public class Teams implements ITeam2 {

    public String teamName;
    public String generalManager;
    public IHeadCoach headCoach;
    ArrayList<IPlayers> players;
    String teamType;
    int lossPoints;

    public Teams() {
    }

    public Teams(String teamName, String generalManager, IHeadCoach headCoach, ArrayList<IPlayers> players) {
        this.teamName = teamName;
        this.generalManager = generalManager;
        this.headCoach = headCoach;
        this.players = players;
    }

    public Teams(String teamName, String generalManager, IHeadCoach headCoach) {
        this.teamName = teamName;
        this.generalManager = generalManager;
        this.headCoach = headCoach;
    }

    @Override
    public ArrayList<IPlayers> getPlayers() {
        return players;
    }

    @Override
    public void setPlayers(ArrayList<IPlayers> players) {
        this.players = players;

    }

    @Override
    public String getTeamName() {
        return teamName;
    }

    @Override
    public void setTeamName(String teamName) {
        this.teamName = teamName;

    }

    @Override
    public String getGeneralManager() {
        return generalManager;
    }

    @Override
    public void setGeneralManager(String generalManager) {
        this.generalManager = generalManager;

    }

    @Override
    public String getTeamType() {
        return teamType;
    }

    @Override
    public void setTeamType(String teamType) {
        this.teamType = teamType;
    }

    @Override
    public IHeadCoach getHeadCoach() {
        return headCoach;
    }

    @Override
    public void setHeadCoach(IHeadCoach headCoach) {
        this.headCoach = headCoach;

    }
    @Override
    public int getLossPoints() {
        return lossPoints;
    }

    @Override
    public void setLossPoints(int lossPoints) {
        this.lossPoints = lossPoints;

    }
}
