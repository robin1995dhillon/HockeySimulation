package dhl.leagueModel.teams;

import dhl.leagueModel.headCoach.IHeadCoach;
import dhl.leagueModel.players.IPlayers;
import dhl.leagueModel.players.PlayersStrength;
import dhl.persistence.saving.DHLPersistence;
import dhl.persistence.saving.IDHLPersistence;
import dhl.persistence.saving.ITeamPersistence;
import dhl.persistence.saving.TeamPersistence;
import org.json.simple.JSONObject;

import java.util.List;

public class Teams implements ITeam {

    public String teamName;
    public String generalManager;
    public IHeadCoach headCoach;
    List<IPlayers> players;
    String teamType = "ai";
    int lossPoints;
    double teamStrength;
    private boolean isUser = false;

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
    public double calculateTeamStrength(ITeam team) {
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

    @Override
    public boolean getIsUser() {
        return this.isUser;
    }

    @Override
    public void setIsUser(boolean isUser) {
        this.isUser = isUser;
    }

    public void checkForInjury(ITeam team) {
        List<IPlayers> players;
        players = team.getPlayers();
        for(IPlayers player: players) {
            player.checkForPlayerInjury();
        }
    }

    @Override
    public void saveTeams(List<Integer> id) {
        ITeamPersistence teamPersistence = new TeamPersistence();
        String headCoach = this.headCoach.getName();
        JSONObject resultObject = teamPersistence.saveTeamToDB(this.teamName, this.generalManager, headCoach, this.isUser);
        int teamID = (int) resultObject.get("id");
        System.out.println(teamID);
        id.add(3,teamID);

        IDHLPersistence idhlPersistence = new DHLPersistence();
        idhlPersistence.saveDHLTable(id.get(0), id.get(1), id.get(2), id.get(3));
        List<IPlayers> playersArray = getPlayers();
        IHeadCoach iHeadCoach = getHeadCoach();
        iHeadCoach.saveHeadCoach(teamID);

        for(IPlayers player: playersArray) {
            player.savePlayer(teamID);
        }
    }

}
