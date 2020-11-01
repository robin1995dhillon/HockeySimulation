package dhl.mock;

import dhl.leagueModel.*;
import dhl.leagueModel.conference.Conference;
import dhl.leagueModel.division.Division;
import dhl.leagueModel.headCoach.HeadCoach;
import dhl.leagueModel.league.League;
import dhl.leagueModel.players.Players;
import dhl.leagueModel.teams.Teams;

import java.util.ArrayList;

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
