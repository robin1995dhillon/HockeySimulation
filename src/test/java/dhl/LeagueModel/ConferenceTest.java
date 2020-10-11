package dhl.LeagueModel;

import dhl.LeagueModel.Conference;
import dhl.LeagueModel.League;
import dhl.MockLeague;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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

    @Test
    void getDivisions() {
        Division d = new Division();
        d.setDivisionName("Atlantic");
        d.setTeams(new ArrayList<Teams>());
        ArrayList<Division> div_array = new ArrayList<>();
        div_array.add(d);
        Conference conference = new Conference("Eastern",div_array);
        conference.getDivisions();
        assertEquals(d,conference.getDivisions().get(0));
    }

    @Test
    void setDivisions() {
        Division d = new Division();
        d.setDivisionName("Atlantic");
        d.setTeams(new ArrayList<Teams>());
        ArrayList<Division> div_array = new ArrayList<>();
        div_array.add(d);
        Conference conference = new Conference("Eastern",div_array);
        conference.getDivisions();
        Division d2 = new Division();
        d2.setDivisionName("Metropolitian");
        ArrayList<Division> div_array_2 = new ArrayList<>();
        div_array_2.add(d2);
        conference.setDivisions(div_array_2);
        assertEquals(d2,conference.getDivisions().get(0));
    }
}