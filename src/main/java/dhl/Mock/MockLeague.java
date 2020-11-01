package dhl.Mock;

import dhl.LeagueModel.*;
import dhl.LeagueModel.conference.Conference;
import dhl.LeagueModel.division.Division;
import dhl.LeagueModel.headCoach.HeadCoach;
import dhl.LeagueModel.league.League;
import dhl.LeagueModel.players.Players;
import dhl.LeagueModel.teams.Teams;

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
