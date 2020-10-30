package dhl.LeagueModel.teams;

import dhl.LeagueModel.IHeadCoach;
import dhl.LeagueModel.IPlayers;
import dhl.LeagueModel.ITeam2;
import dhl.LeagueModel.players.PlayersStrength;

import java.util.ArrayList;
import java.util.List;

public class Teams implements ITeam2 {

    public String teamName;
    public String generalManager;
    public IHeadCoach headCoach;
    List<IPlayers> players;
    String teamType;
    int lossPoints;
    double teamStrength;

    public Teams() {
    }

    public Teams(String teamName, String generalManager, IHeadCoach headCoach, List<IPlayers> players) {
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
    public List<IPlayers> getPlayers() {
        return players;
    }

    @Override
    public void setPlayers(List<IPlayers> players) {
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

    @Override
    public double getTeamStrength() {
        return teamStrength;
    }

    @Override
    public void setTeamStrength(double teamStrength) {
        this.teamStrength = teamStrength;
    }

    @Override
    public double calculateTeamStrength(ITeam2 team) {
        List<IPlayers> players;
        players = team.getPlayers();
        System.out.println(players);
        double teamStrength = 0;

        for (IPlayers player: players) {
            PlayersStrength strength = new PlayersStrength();
            double playerStrength = strength.calculateStrength(player);
            teamStrength += playerStrength;
        }
        System.out.println(teamStrength);
        team.setTeamStrength(teamStrength);
        return teamStrength;
    }

    public void checkForInjury(ITeam2 team) {
        List<IPlayers> players;
        players = team.getPlayers();
        for(IPlayers player: players) {
            player.checkForPlayerInjury(player);
        }
    }

}
