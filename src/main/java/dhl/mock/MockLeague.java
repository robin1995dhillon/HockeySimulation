package dhl.mock;

import dhl.leagueModel.conference.Conference;
import dhl.leagueModel.conference.IConference;
import dhl.leagueModel.division.Division;
import dhl.leagueModel.division.IDivision;
import dhl.leagueModel.freeAgents.FreeAgents;
import dhl.leagueModel.freeAgents.IFreeAgents;
import dhl.leagueModel.gamePlayConfig.IGamePlayConfig;
import dhl.leagueModel.headCoach.HeadCoach;
import dhl.leagueModel.headCoach.IHeadCoach;
import dhl.leagueModel.league.ILeague;
import dhl.leagueModel.league.League;
import dhl.leagueModel.players.IPlayers;
import dhl.leagueModel.players.Players;
import dhl.leagueModel.teams.ITeam;
import dhl.leagueModel.teams.Teams;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MockLeague {

    public static ILeague createMock() {
        ILeague l = new League();
        IConference c = new Conference();
        IPlayers p =new Players();
        ITeam t = new Teams();
        IDivision d = new Division("Metro");
        ArrayList<IPlayers> players = new ArrayList<>();
        p.setCaptain(true);
        p.setPosition("goalie");
        p.setPlayerName("Roger");
        players.add(p);
        t.setPlayers(players);
        IHeadCoach coach = new HeadCoach();
        coach.setName("Random1");
        coach.setChecking(5);
        coach.setSaving(5);
        coach.setShooting(5);
        coach.setSkating(5);
        ArrayList<ITeam> teams = new ArrayList<>();
        t.setHeadCoach(coach);
        t.setGeneralManager("John");
        t.setTeamName("HalifaxTigers");
        teams.add(t);
        d.setTeams(teams);
        ArrayList<IDivision> IDivision = new ArrayList<>();
        d.setDivisionName("American");
        IDivision.add(d);
        ArrayList<IConference> IConference = new ArrayList<>();
        c.setConferenceName("Eastern Conference");
        c.setDivisions(IDivision);
        IConference.add(c);
        l.setLeagueName("Dalhousie League");
        l.setConferences(IConference);
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
        l.setFreeAgents(freeAgentsList);
        IHeadCoach headCoach = MockHeadCoach.createMock();
        ArrayList<IHeadCoach> headCoachArrayList = new ArrayList<>();
        headCoachArrayList.add(headCoach);
        l.setHeadCoach(headCoachArrayList);
        ArrayList<String> managerList = new ArrayList<>();
        managerList.add("Hey1");
        managerList.add("Hey2");
        l.setGeneralManager(managerList);
        IGamePlayConfig iGamePlayConfig = MockGamePlayConfig.createMock();
        l.setGameplayConfig(iGamePlayConfig);


        return l;






    }
    public static ILeague addTeamMock() {
        ILeague l = new League();
        IConference c = new Conference();
        IPlayers p =new Players();
        ITeam t = new Teams();
        ITeam t2 = new Teams();
        IDivision d = new Division("Metro");
        ArrayList<IPlayers> players = new ArrayList<>();
        p.setCaptain(true);
        p.setPosition("goalie");
        p.setPlayerName("Roger");
        players.add(p);
        t.setPlayers(players);
        ArrayList<ITeam> teams = new ArrayList<>();
//        t.setHeadCoach("Mat");
        t.setGeneralManager("John");
        t.setTeamName("HalifaxTigers");
//        t2.setHeadCoach("Dev1");
        t2.setTeamName("Hawks");
        t2.setGeneralManager("Rob");
        teams.add(t);
        teams.add(t2);
        d.setTeams(teams);
        ArrayList<IDivision> IDivision = new ArrayList<>();
        d.setDivisionName("American");
        IDivision.add(d);
        ArrayList<IConference> IConference = new ArrayList<>();
        c.setConferenceName("Eastern Conference");
        c.setDivisions(IDivision);
        IConference.add(c);
        l.setLeagueName("Dalhousie League");
        l.setConferences(IConference);

        return l;






    }
}
