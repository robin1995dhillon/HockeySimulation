package dhl.leagueModel;

import dhl.leagueModel.conference.Conference;
import dhl.leagueModel.conference.IConference;
import dhl.leagueModel.division.Division;
import dhl.leagueModel.division.IDivision;
import dhl.leagueModel.gamePlayConfig.GamePlayConfig;
import dhl.leagueModel.gamePlayConfig.IGamePlayConfig;
import dhl.leagueModel.generalManager.GeneralManager;
import dhl.leagueModel.generalManager.IGeneralManager;
import dhl.leagueModel.headCoach.HeadCoach;
import dhl.leagueModel.headCoach.IHeadCoach;
import dhl.leagueModel.league.ILeague;
import dhl.leagueModel.league.League;
import dhl.leagueModel.teams.ITeam;
import dhl.leagueModel.teams.Teams;
import dhl.leagueModel.trade.*;

public class LeagueModelConcrete extends LeagueModelAbstractFactory {

    private ILeague league;
    private IConference conference;
    private IDivision division;
    private ITeam team;
    private IPlayers players;
    private IHeadCoach headCoach;
    private IGeneralManager generalManager;
    private IFreeAgents freeAgents;
    private IGamePlayConfig gamePlayConfig;
    private IPlayerTrainingCondition playerTrainingCondition;

    private IAddDropPlayers addDropPlayers;
    private IFreeAgentListAdd freeAgentListAdd;
    private IFreeAgentListDrop freeAgentListDrop;
    private IPlayerTradingCondition playerTradingCondition;
    private IStrongestWeakestPlayers strongestWeakestPlayers;


    public LeagueModelConcrete() {
    }

    @Override
    public ILeague getLeague() {
        if (league == null) {
            league = new League();
        }
        return league;
    }

    @Override
    public void setLeague(ILeague league) {
        this.league = league;
    }

    @Override
    public IConference getConference() {
        if (conference == null) {
            conference = new Conference();
        }
        return conference;
    }

    @Override
    public void setConference(IConference conference) {
        this.conference = conference;
    }

    @Override
    public IDivision getDivision() {
        if (division == null) {
            division = new Division();
        }
        return division;
    }

    @Override
    public void setDivision(IDivision division) {
        this.division = division;
    }

    @Override
    public ITeam getTeam() {
        if (team == null) {
            team = new Teams();
        }
        return team;
    }

    @Override
    public void setTeam(ITeam team) {
        this.team = team;
    }

    @Override
    public IPlayers getPlayers() {
        if (players == null) {
            players = new Players();
        }
        return players;
    }

    @Override
    public IPlayers getNewPlayers() {
        return new Players();
    }

    @Override
    public void setPlayers(IPlayers players) {
        this.players = players;
    }

    @Override
    public IHeadCoach getHeadCoach() {
        if (headCoach == null) {
            headCoach = new HeadCoach();
        }
        return headCoach;
    }

    @Override
    public void setHeadCoach(IHeadCoach headCoach) {
        this.headCoach = headCoach;
    }

    @Override
    public IGeneralManager getGeneralManager() {
        if (generalManager == null) {
            generalManager = new GeneralManager();
        }
        return generalManager;
    }

    @Override
    public void setGeneralManager(IGeneralManager generalManager) {
        this.generalManager = generalManager;
    }

    @Override
    public IFreeAgents getFreeAgents() {
        if (freeAgents == null) {
            freeAgents = new FreeAgents();
        }
        return freeAgents;
    }

    @Override
    public void setFreeAgents(IFreeAgents freeAgents) {
        this.freeAgents = freeAgents;
    }

    @Override
    public IGamePlayConfig getGamePlayConfig() {
        if (gamePlayConfig == null) {
            gamePlayConfig = new GamePlayConfig();
        }
        return gamePlayConfig;
    }

    @Override
    public void setGamePlayConfig(IGamePlayConfig gamePlayConfig) {
        this.gamePlayConfig = gamePlayConfig;
    }

    @Override
    public IPlayerTrainingCondition getPlayerTrainingCondition() {
        if (playerTrainingCondition == null) {
            playerTrainingCondition = new PlayerTrainingCondition();
        }
        return playerTrainingCondition;
    }

    @Override
    public void setPlayerTrainingCondition(IPlayerTrainingCondition playerTrainingCondition) {
        this.playerTrainingCondition = playerTrainingCondition;
    }

    public IAddDropPlayers getAddDropPlayers() {
        if (addDropPlayers == null) {
            addDropPlayers = new AddDropPlayers();
        }
        return addDropPlayers;
    }

    public IFreeAgentListAdd getFreeAgentList() {
        if (freeAgentListAdd == null) {
            freeAgentListAdd = new FreeAgentList();
        }
        return freeAgentListAdd;
    }

    public IFreeAgentListDrop getFreeAgentListDrop() {
        if (freeAgentListDrop == null) {
            freeAgentListDrop = new FreeAgentListDrop();
        }
        return freeAgentListDrop;
    }

    public IPlayerTradingCondition getPLayerTradingCondition() {
        if (playerTradingCondition == null) {
            playerTradingCondition = new PlayerTradingCondition();
        }
        return playerTradingCondition;
    }

    public IStrongestWeakestPlayers getStrongestWeakestPlayers() {
        if (strongestWeakestPlayers == null) {
            strongestWeakestPlayers = new StrongestWeakestPlayers();
        }
        return strongestWeakestPlayers;
    }

    public void setAddDropPlayers(IAddDropPlayers addDropPlayers) {
        this.addDropPlayers = addDropPlayers;

    }

    public void setFreeAgentList(IFreeAgentListAdd freeAgentListAdd) {

        this.freeAgentListAdd = freeAgentListAdd;
    }

    public void setFreeAgentListDrop(IFreeAgentListDrop freeAgentListDrop) {

        this.freeAgentListDrop = freeAgentListDrop;

    }

    public void setPLayerTradingCondition(IPlayerTradingCondition playerTradingCondition) {

        this.playerTradingCondition = playerTradingCondition;

    }

    public void setStrongestWeakestPlayers(IStrongestWeakestPlayers strongestWeakestPlayers) {

        this.strongestWeakestPlayers = strongestWeakestPlayers;

    }
}
