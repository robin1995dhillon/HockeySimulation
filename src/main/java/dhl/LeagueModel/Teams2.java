package dhl.LeagueModel;

import java.util.ArrayList;

public class Teams2 implements ITeam2{

    public String teamName;
    public String generalManager;
    public IHeadCoach headCoach;
    ArrayList<IPlayers2> players;
    String teamType;
    int lossPoints;

    public Teams2() {
    }

    public Teams2(String teamName, String generalManager, IHeadCoach headCoach, ArrayList<IPlayers2> players) {
        this.teamName = teamName;
        this.generalManager = generalManager;
        this.headCoach = headCoach;
        this.players = players;
    }

    public Teams2(String teamName, String generalManager, IHeadCoach headCoach) {
        this.teamName = teamName;
        this.generalManager = generalManager;
        this.headCoach = headCoach;
    }

    @Override
    public ArrayList<IPlayers2> getPlayers() {
        return players;
    }

    @Override
    public void setPlayers(ArrayList<IPlayers2> players) {
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
    public IHeadCoach getHeadCoach() {
        return headCoach;
    }

    @Override
    public void setHeadCoach(IHeadCoach headCoach) {
        this.headCoach = headCoach;

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
    public int getLossPoints() {
        return lossPoints;
    }

    @Override
    public void setLossPoints(int lossPoints) {
        this.lossPoints = lossPoints;

    }

}
