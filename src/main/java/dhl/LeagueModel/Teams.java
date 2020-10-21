package dhl.LeagueModel;

import java.util.ArrayList;

public class Teams implements ITeam2{

    public String teamName;
    public String generalManager;
    public IHeadCoach headCoach;
    ArrayList<IPlayers2> players;

    public Teams() {
    }

    public Teams(String teamName, String generalManager, IHeadCoach headCoach, ArrayList<IPlayers2> players) {
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
}
