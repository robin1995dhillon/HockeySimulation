package dhl.leagueModel;

import dhl.mock.MockConference;
import dhl.mock.MockDivision;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConferenceTest {
    LeagueModelAbstractFactory leagueModelAbstractFactory;
    IConference conference;
    MockConference mockConference;
    MockDivision mockDivision;

    public ConferenceTest() {
        leagueModelAbstractFactory = LeagueModelAbstractFactory.instance();
        mockConference = new MockConference();
        mockDivision = new MockDivision();
    }

    @Test
    void getConferenceName() {
        conference = mockConference.createConferenceMock();
        assertEquals("Conference1", conference.getConferenceName());
    }

    @Test
    void setConferenceName() {
        conference = mockConference.createConferenceMock();
        conference.setConferenceName("Conference2");
        assertEquals("Conference2", conference.getConferenceName());
    }

    @Test
    void getDivisions() {
        List<IDivision> divisionList = mockDivision.createDivisionMockList();
        conference = mockConference.createConferenceMock();
        assertEquals(divisionList, conference.getDivisions());
    }

    @Test
    void setDivisions() {
        List<IDivision> divisionList = mockDivision.createDivisionMockList();
        conference = mockConference.createConferenceMock();
        conference.setDivisions(divisionList);
        assertEquals(divisionList, conference.getDivisions());

    }
}
