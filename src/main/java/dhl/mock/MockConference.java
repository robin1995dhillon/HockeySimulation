package dhl.mock;

import dhl.leagueModel.IConference;
import dhl.leagueModel.IDivision;
import dhl.leagueModel.LeagueModelAbstractFactory;

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
}
