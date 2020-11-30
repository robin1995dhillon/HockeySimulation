package dhl.mock;

import dhl.leagueModel.*;

import java.util.ArrayList;
import java.util.List;

public class MockDivision {

    LeagueModelAbstractFactory leagueModelAbstractFactory;
    IDivision division;
    MockTeam mockTeam;

    public MockDivision() {
        leagueModelAbstractFactory = LeagueModelAbstractFactory.instance();
        division = leagueModelAbstractFactory.getDivision();
        mockTeam = new MockTeam();
    }

    public static IDivision createMock() {
        ArrayList<ITeam> teamArray = new ArrayList<>();
        IDivision division = new Division("Metro");
        division.setDivisionName("Atlantic");
        ITeam team = new Teams();
        teamArray.add(team);
        division.setTeams(teamArray);
        return division;
    }

    public static IDivision createMockTwo() {
        ArrayList<ITeam> teamArray = new ArrayList<>();
        IDivision division = new Division("Metro");
        division.setDivisionName("Metro");
        ITeam team = new Teams();
        ITeam team2 = new Teams();
        teamArray.add(team);
        teamArray.add(team2);
        division.setTeams(teamArray);
        return division;
    }

    public IDivision createDivisionMock() {
        List<ITeam> teamList = mockTeam.createTeamMockList();
        division.setDivisionName("Division1");
        division.setTeams(teamList);
        return division;
    }

    public static IDivision divisionMock(){
        IDivision division = LeagueModelAbstractFactory.instance().getDivision();
        List<ITeam> teamList =new ArrayList<>();
        teamList.add(MockTeam.MockOffensiveTeam());
        teamList.add(MockTeam.MockTeam());
        division.setDivisionName("Metro");
        division.setTeams(teamList);
        return division;
    }
}
