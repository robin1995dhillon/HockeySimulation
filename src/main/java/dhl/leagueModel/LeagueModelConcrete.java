package dhl.leagueModel;

import dhl.leagueModel.conference.Conference;
import dhl.leagueModel.conference.IConference;
import dhl.leagueModel.division.Division;
import dhl.leagueModel.division.IDivision;
import dhl.leagueModel.freeAgents.FreeAgents;
import dhl.leagueModel.freeAgents.IFreeAgents;
import dhl.leagueModel.gamePlayConfig.GamePlayConfig;
import dhl.leagueModel.gamePlayConfig.IGamePlayConfig;
import dhl.leagueModel.generalManager.GeneralManager;
import dhl.leagueModel.generalManager.IGeneralManager;
import dhl.leagueModel.headCoach.HeadCoach;
import dhl.leagueModel.headCoach.IHeadCoach;
import dhl.leagueModel.league.ILeague;
import dhl.leagueModel.league.League;
import dhl.leagueModel.players.IPlayers;
import dhl.leagueModel.players.Players;
import dhl.leagueModel.teams.ITeam;
import dhl.leagueModel.teams.Teams;

public class LeagueModelConcrete extends LeagueModelAbstractFactory{

    private ILeague league;
    private IConference conference;
    private IDivision division;
    private ITeam team;
    private IPlayers players;
    private IHeadCoach headCoach;
    private IGeneralManager generalManager;
    private IFreeAgents freeAgents;
    private IGamePlayConfig gamePlayConfig;


    public LeagueModelConcrete() {
    }

    @Override
    public ILeague getLeague() {
        if(league == null) {
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
        if(conference == null) {
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
        if(division == null) {
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
        if(team == null) {
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
        if(players == null) {
            players = new Players();
        }
        return players;
    }

    @Override
    public void setPlayers(IPlayers players) {
        this.players = players;
    }

    @Override
    public IHeadCoach getHeadCoach() {
        if(headCoach == null) {
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
        if(generalManager == null) {
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
        if(freeAgents == null) {
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
        if(gamePlayConfig == null) {
            gamePlayConfig =  new GamePlayConfig();
        }
        return gamePlayConfig;
    }

    @Override
    public void setGamePlayConfig(IGamePlayConfig gamePlayConfig) {
        this.gamePlayConfig = gamePlayConfig;
    }
}
