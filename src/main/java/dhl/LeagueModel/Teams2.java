package dhl.LeagueModel;

import java.util.ArrayList;

public class Teams2 implements ITeam2{

    public String teamName;
    public String generalManager;
    public HeadCoach headCoach;
    ArrayList<IPlayers2> players;

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
    public HeadCoach getHeadCoach() {
        return headCoach;
    }

    @Override
    public void setHeadCoach(HeadCoach headCoach) {
        this.headCoach = headCoach;

    }
}
