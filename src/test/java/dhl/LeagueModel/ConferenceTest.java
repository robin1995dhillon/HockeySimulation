package dhl.LeagueModel;

import dhl.LeagueModel.Conference;
import dhl.LeagueModel.League;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConferenceTest {

    @Test
    void getConferenceName() {
        Conference conferenceTest = new Conference("Conference1");
        assertEquals("Conference1",conferenceTest.getConferenceName());
    }

    @Test
    void setConferenceName() {
        Conference conference = new Conference("Eastern");
        conference.setConferenceName("Western");
        assertEquals("Western", conference.getConferenceName());
    }
}