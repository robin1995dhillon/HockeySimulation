package dhl.leagueModel;

import dhl.leagueModel.gamePlayConfig.GamePlayConfig;
import dhl.leagueModel.gamePlayConfig.IGamePlayConfig;
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
    private IPlayerTrade playerTrade;
    private IAllPlayers allPlayers;

    private IAddDropPlayers addDropPlayers;
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

    public IFreeAgents getNewFreeAgents() {
        return new FreeAgents();
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


    public void setPLayerTradingCondition(IPlayerTradingCondition playerTradingCondition) {

        this.playerTradingCondition = playerTradingCondition;

    }

    public void setStrongestWeakestPlayers(IStrongestWeakestPlayers strongestWeakestPlayers) {

        this.strongestWeakestPlayers = strongestWeakestPlayers;

    }

    @Override
    public void setPlayerTrade(IPlayerTrade playerTrade) {
        this.playerTrade = playerTrade;
    }

    @Override
    public IPlayerTrade getPlayerTrade() {

        if (playerTrade == null) {
            playerTrade = new PlayerTrade();
        }

        return this.playerTrade;
    }

    @Override
    public void setAllPlayers(IAllPlayers allPlayers) {
        this.allPlayers = allPlayers;
    }

    @Override
    public IAllPlayers getAllPlayers() {
        if (allPlayers == null) {
            allPlayers = new AllPlayers();
        }
        return allPlayers;
    }
}
