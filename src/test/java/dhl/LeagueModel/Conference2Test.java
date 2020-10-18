package dhl.LeagueModel;

import dhl.LeagueModel.Conference;
import dhl.LeagueModel.League;
import dhl.MockLeague;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConferenceTest2 {

    @Test
    void getConferenceName() {
        IConference conferenceTest = new Conference2("Conference1");
        assertEquals("Conference1",conferenceTest.getConferenceName());
    }

    @Test
    void setConferenceName() {
        IConference conference = new Conference2("Eastern");
        conference.setConferenceName("Western");
        assertEquals("Western", conference.getConferenceName());
    }

    @Test
    void getDivisions() {
        IDivision d = new Division2();
        d.setDivisionName("Atlantic");
        d.setTeams(new ArrayList<ITeam2>());
        ArrayList<IDivision> div_array = new ArrayList<>();
        div_array.add(d);
        IConference conference = new Conference2("Eastern",div_array);
        conference.getDivisions();
        assertEquals(d,conference.getDivisions().get(0));
    }

    @Test
    void setDivisions() {
        IDivision d = new Division2();
        d.setDivisionName("Atlantic");
        d.setTeams(new ArrayList<ITeam2>());
        ArrayList<IDivision> div_array = new ArrayList<>();
        div_array.add(d);
        IConference conference = new Conference2("Eastern",div_array);
        conference.getDivisions();
        IDivision d2 = new Division2();
        d2.setDivisionName("Metropolitian");
        ArrayList<IDivision> div_array_2 = new ArrayList<>();
        div_array_2.add(d2);
        conference.setDivisions(div_array_2);
        assertEquals(d2,conference.getDivisions().get(0));
    }
}