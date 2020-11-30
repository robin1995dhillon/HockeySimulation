package dhl.mock;

import dhl.leagueModel.*;

import java.util.ArrayList;
import java.util.List;

public class MockDivision {

    LeagueModelAbstractFactory leagueModelAbstractFactory;
    IDivision division;
    IDivision division2;
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

    public IDivision createDivisionMockOne() {
        List<ITeam> teamList = mockTeam.createTeamMockList();
        division.setDivisionName("Division1");
        division.setTeams(teamList);
        return division;
    }

    public IDivision createDivisionMockTwo() {
        List<ITeam> teamList = mockTeam.createTeamMockList();
        division.setDivisionName("Division2");
        division.setTeams(teamList);
        return division;
    }

    public List<IDivision> createDivisionMockList() {
        division = createDivisionMockOne();
        division2 = createDivisionMockTwo();
        List<IDivision> divisionList = new ArrayList<>();
        divisionList.add(division);
        divisionList.add(division2);
        return divisionList;
    }
}
