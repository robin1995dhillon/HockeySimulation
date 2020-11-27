package dhl.mock;

import dhl.leagueModel.conference.Conference;
import dhl.leagueModel.conference.IConference;
import dhl.leagueModel.division.Division;
import dhl.leagueModel.division.IDivision;
import dhl.leagueModel.freeAgents.FreeAgents;
import dhl.leagueModel.freeAgents.IFreeAgents;
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

import java.util.ArrayList;

public class MockLeague {

    public static ILeague createMock() {
        ILeague league = new League();
        IConference conference = new Conference();
        IPlayers player = new Players();
        ITeam team = new Teams();
        IDivision division = new Division("Metro");
        ArrayList<IPlayers> players = new ArrayList<>();
        player.setCaptain(true);
        player.setPosition("goalie");
        player.setPlayerName("Roger");
        players.add(player);
        team.setPlayers(players);
        IHeadCoach coach = new HeadCoach();
        coach.setName("Random1");
        coach.setChecking(5);
        coach.setSaving(5);
        coach.setShooting(5);
        coach.setSkating(5);
        ArrayList<ITeam> teams = new ArrayList<>();
        team.setHeadCoach(coach);
        team.setTeamName("HalifaxTigers");
        teams.add(team);
        division.setTeams(teams);
        ArrayList<IDivision> IDivision = new ArrayList<>();
        division.setDivisionName("American");
        IDivision.add(division);
        ArrayList<IConference> IConference = new ArrayList<>();
        conference.setConferenceName("Eastern Conference");
        conference.setDivisions(IDivision);
        IConference.add(conference);
        league.setLeagueName("Dalhousie League");
        league.setConferences(IConference);
        ArrayList<IFreeAgents> freeAgentsList = new ArrayList<>();
        IFreeAgents freeAgents = new FreeAgents();
        freeAgents.setPlayerName("Free1");
        freeAgents.setAge(20);
        freeAgents.setChecking(20);
        freeAgents.setSkating(20);
        freeAgents.setSaving(20);
        freeAgents.setShooting(20);
        freeAgents.setStrength(50);
        freeAgents.setPosition("forward");
        freeAgentsList.add(freeAgents);
        league.setFreeAgents(freeAgentsList);
        IHeadCoach headCoach = MockHeadCoach.createMock();
        ArrayList<IHeadCoach> headCoachArrayList = new ArrayList<>();
        headCoachArrayList.add(headCoach);
        league.setHeadCoach(headCoachArrayList);
        ArrayList<IGeneralManager> managerList = new ArrayList<>();
        IGeneralManager manager = new GeneralManager();
        manager.setName("Hey1");
        manager.setPersonality("gambler");
        managerList.add(manager);
        league.setGeneralManagers(managerList);
        IGamePlayConfig iGamePlayConfig = MockGamePlayConfig.createMock();
        league.setGameplayConfig(iGamePlayConfig);
        return league;
    }
}
