package dhl;

import dhl.LeagueModel.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MockLeague2 {

    public static ILeague createMock() {
        League2 l = new League2();
        Conference2 c = new Conference2();
        Players2 p =new Players2();
        Teams2 t = new Teams2();
        Division2 d = new Division2();
        HeadCoach h = new HeadCoach();
        ArrayList<IPlayers2> players = new ArrayList<>();
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
        ArrayList<ITeam2> teams = new ArrayList<>();
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
        League2 l = new League2();
        Conference2 c = new Conference2();
        Players2 p =new Players2();
        Teams2 t = new Teams2();
        Teams2 t2 = new Teams2();
        Division2 d = new Division2();
        HeadCoach h = new HeadCoach();
        ArrayList<IPlayers2> players = new ArrayList<>();
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
        ArrayList<ITeam2> teams = new ArrayList<>();
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

