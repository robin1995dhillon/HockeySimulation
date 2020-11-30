package dhl.leagueModel;

import dhl.mock.MockDivision;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConferenceTest {
    LeagueModelAbstractFactory leagueModelAbstractFactory;
    IConference conference;

    public ConferenceTest() {
        leagueModelAbstractFactory = LeagueModelAbstractFactory.instance();
        conference = leagueModelAbstractFactory.getConference();
    }

    @Test
    void getConferenceName() {
        IConference conferenceTest = new Conference("Conference1");
        assertEquals("Conference1", conferenceTest.getConferenceName());
    }

    @Test
    void setConferenceName() {
        IConference conference = new Conference("Eastern");
        conference.setConferenceName("Western");
        assertEquals("Western", conference.getConferenceName());
    }

    @Test
    void getDivisions() {
        IDivision division = MockDivision.createMock();
        ArrayList<IDivision> div_array = new ArrayList<>();
        div_array.add(division);
        IConference conference = new Conference("Eastern", div_array);
        assertEquals(division, conference.getDivisions().get(0));
    }

    @Test
    void setDivisions() {
        IDivision division = MockDivision.createMock();
        ArrayList<IDivision> div_array = new ArrayList<>();
        div_array.add(division);
        IConference conference = new Conference("Eastern", div_array);
        IDivision division2 = MockDivision.createMockTwo();
        div_array.add(division2);
        conference.setDivisions(div_array);
        assertEquals(division2, conference.getDivisions().get(1));

    }
}
