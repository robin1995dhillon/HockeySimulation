package dhl.mock;

import dhl.leagueModel.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MockConference {

    LeagueModelAbstractFactory leagueModelAbstractFactory;
    IConference conference;
    IDivision division;
    MockDivision mockDivision;

    public MockConference() {
        leagueModelAbstractFactory = LeagueModelAbstractFactory.instance();
        conference = leagueModelAbstractFactory.getConference();
        division = leagueModelAbstractFactory.getDivision();
        mockDivision = new MockDivision();

    }

    public IConference createConferenceMock() {
        this.conference.setConferenceName("Conference1");
        division = mockDivision.createDivisionMockOne();
        this.conference.setDivisions(mockDivision.createDivisionMockList());
        return conference;
    }

    public static IConference mockConference() {
        IConference conference = new Conference();
        IPlayers player = new Players();
        ITeam team = new Teams();
        IDivision division = new Division("Metro");
        List<IPlayers> players = new ArrayList<>();
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
        List<ITeam> teams = new ArrayList<>();
        team.setHeadCoach(coach);
        team.setTeamName("HalifaxTigers");
        teams.add(team);
        division.setTeams(teams);
        List<IDivision> IDivision = new ArrayList<>();
        division.setDivisionName("American");
        IDivision.add(division);
        conference.setConferenceName("Eastern Conference");
        conference.setDivisions(IDivision);
        return conference;

    }

    public static IConference mockConferenceTwo() {
        IConference conference = new Conference();
        IPlayers player = new Players();
        ITeam team = new Teams();
        IDivision division = new Division("Metro");
        List<IPlayers> players = new ArrayList<>();
        player.setCaptain(true);
        player.setPosition("goalie");
        player.setPlayerName("RogerRabbit");
        players.add(player);
        team.setPlayers(players);
        IHeadCoach coach = new HeadCoach();
        coach.setName("Randoms");
        coach.setChecking(5);
        coach.setSaving(5);
        coach.setShooting(5);
        coach.setSkating(5);
        List<ITeam> teams = new ArrayList<>();
        team.setHeadCoach(coach);
        team.setTeamName("HalifaxPanthers");
        teams.add(team);
        division.setTeams(teams);
        List<IDivision> listDivision = new ArrayList<>();
        division.setDivisionName("Indian");
        listDivision.add(division);
        conference.setConferenceName("Western Conference");
        conference.setDivisions(listDivision);
        return conference;
    }

    public static Map<IConference, List<ITeam>> mockMapConference() {
        List<ITeam> teamList = new ArrayList<>();
        Map<IConference, List<ITeam>> conferenceMap = new HashMap<>();
        IConference conference = MockConference.mockConferenceTwo();
        for (IDivision division : conference.getDivisions()) {
            for (ITeam team : division.getTeams()) {
                teamList.add(team);
            }
        }
        conferenceMap.put(conference, teamList);
        return conferenceMap;
    }

    public static Map<IConference, List<IDivision>> mockMapDivisionInConference(){

        List<IDivision> divisionList = new ArrayList<>();
        Map<IConference, List<IDivision>> divisionMap = new HashMap<>();
        IConference conference = MockConference.mockConferenceTwo();
        for (IDivision division : conference.getDivisions()) {
            divisionList.add(division);
        }
        divisionMap.put(conference,divisionList);
        return divisionMap;
    }

    public static Map<IDivision, List<ITeam>> mockMapTeamsInDivision(){

        List<ITeam> teamList = new ArrayList<>();
        IConference conference = MockConference.mockConferenceTwo();
        Map<IDivision, List<ITeam>> teamMap = new HashMap<>();
//        IDivision division = conference.getDivisions().get(0);
        IDivision division = MockDivision.createMock();
        for (ITeam team : division.getTeams()) {
            teamList.add(team);
        }
        teamMap.put(division,teamList);
        return teamMap;
    }
}
