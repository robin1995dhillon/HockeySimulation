package dhl;

import dhl.LeagueModel.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MockLeague {

    public static League createMock() {
        League l = new League();
        Conference c = new Conference();
        Players p =new Players();
        Teams t = new Teams();
        Division d = new Division();
        ArrayList<Players> players = new ArrayList<>();
        p.setCaptain(true);
        p.setPosition("goalie");
        p.setPlayerName("Roger");
        players.add(p);
        t.setPlayers(players);
        ArrayList<Teams> teams = new ArrayList<>();
        t.setHeadCoach("Mat");
        t.setGeneralManager("John");
        t.setTeamName("HalifaxTigers");
        teams.add(t);
        d.setTeams(teams);
        ArrayList<Division> division = new ArrayList<>();
        d.setDivisionName("American");
        division.add(d);
        ArrayList<Conference> conference = new ArrayList<>();
        c.setConferenceName("Eastern Conference");
        c.setDivisions(division);
        conference.add(c);
        l.setLeagueName("Dalhousie League");
        l.setConferences(conference);

        return l;






    }
    public static League addTeamMock() {
        League l = new League();
        Conference c = new Conference();
        Players p =new Players();
        Teams t = new Teams();
        Teams t2 = new Teams();
        Division d = new Division();
        ArrayList<Players> players = new ArrayList<>();
        p.setCaptain(true);
        p.setPosition("goalie");
        p.setPlayerName("Roger");
        players.add(p);
        t.setPlayers(players);
        ArrayList<Teams> teams = new ArrayList<>();
        t.setHeadCoach("Mat");
        t.setGeneralManager("John");
        t.setTeamName("HalifaxTigers");
        t2.setHeadCoach("Dev1");
        t2.setTeamName("Hawks");
        t2.setGeneralManager("Rob");
        teams.add(t);
        teams.add(t2);
        d.setTeams(teams);
        ArrayList<Division> division = new ArrayList<>();
        d.setDivisionName("American");
        division.add(d);
        ArrayList<Conference> conference = new ArrayList<>();
        c.setConferenceName("Eastern Conference");
        c.setDivisions(division);
        conference.add(c);
        l.setLeagueName("Dalhousie League");
        l.setConferences(conference);

        return l;






    }
}
