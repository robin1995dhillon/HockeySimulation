package dhl.mock;

import dhl.leagueModel.*;
import dhl.leagueModel.conference.Conference;
import dhl.leagueModel.division.Division;
import dhl.leagueModel.headCoach.HeadCoach;
import dhl.leagueModel.league.League;
import dhl.leagueModel.players.Players;
import dhl.leagueModel.teams.Teams;

import java.util.ArrayList;

public class MockLeague2 {

    public static ILeague createMock() {
        ILeague l = new League();
        IConference c = new Conference();
        IPlayers p =new Players();
        ITeam t = new Teams();
        IDivision d = new Division("Metro");
        HeadCoach h = new HeadCoach();
        ArrayList<IPlayers> players = new ArrayList<>();
        h.setName("Mary Smith");
        h.setSkating(0.5);
        h.setShooting(0.8);
        h.setChecking(0.3);
        h.setSaving(0.5);
        p.setCaptain(true);
        p.setPosition("goalie");
        p.setPlayerName("Roger");
        p.setAge(33);
        p.setSkating(10);
        p.setShooting(4);
        p.setChecking(9);
        p.setChecking(18);
        players.add(p);
        t.setPlayers(players);
        ArrayList<ITeam> teams = new ArrayList<>();
        t.setHeadCoach(h);
        t.setGeneralManager("John");
        t.setTeamName("HalifaxTigers");
        teams.add(t);
        d.setTeams(teams);
        ArrayList<IDivision> division = new ArrayList<>();
        d.setDivisionName("American");
        division.add(d);
        ArrayList<IConference> conference = new ArrayList<>();
        c.setConferenceName("Eastern Conference");
        c.setDivisions(division);
        conference.add(c);
        l.setLeagueName("Dalhousie League");
        l.setConferences(conference);

        return l;






    }
    public static ILeague addTeamMock() {
        ILeague l = new League();
        IConference c = new Conference();
        IPlayers p =new Players();
        ITeam t = new Teams();
        ITeam t2 = new Teams();
        IDivision d = new Division("Metro");
        HeadCoach h = new HeadCoach();
        ArrayList<IPlayers> players = new ArrayList<>();
        h.setName("Mary Smith");
        h.setSkating(0.5);
        h.setShooting(0.8);
        h.setChecking(0.3);
        h.setSaving(0.5);
        p.setCaptain(true);
        p.setPosition("goalie");
        p.setPlayerName("Roger");
        players.add(p);
        t.setPlayers(players);
        ArrayList<ITeam> teams = new ArrayList<>();
        t.setHeadCoach(h);
        t.setGeneralManager("John");
        t.setTeamName("HalifaxTigers");
        t2.setHeadCoach(h);
        t2.setTeamName("Hawks");
        t2.setGeneralManager("Rob");
        teams.add(t);
        teams.add(t2);
        d.setTeams(teams);
        ArrayList<IDivision> division = new ArrayList<>();
        d.setDivisionName("American");
        division.add(d);
        ArrayList<IConference> conference = new ArrayList<>();
        c.setConferenceName("Eastern Conference");
        c.setDivisions(division);
        conference.add(c);
        l.setLeagueName("Dalhousie League");
        l.setConferences(conference);

        return l;






    }
}

