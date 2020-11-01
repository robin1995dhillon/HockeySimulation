package dhl.LeagueModel;

import dhl.LeagueModel.conference.Conference;
import dhl.LeagueModel.division.Division;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConferenceTest2 {

    @Test
    void getConferenceName() {
        IConference conferenceTest = new Conference("Conference1");
        assertEquals("Conference1",conferenceTest.getConferenceName());
    }

    @Test
    void setConferenceName() {
        IConference conference = new Conference("Eastern");
        conference.setConferenceName("Western");
        assertEquals("Western", conference.getConferenceName());
    }

    @Test
    void getDivisions() {
        ArrayList<ITeam2> teamArray = new ArrayList<>();
        IDivision d = new Division("Metro", teamArray);
        d.setDivisionName("Atlantic");
        d.setTeams(new ArrayList<ITeam2>());
        ArrayList<IDivision> div_array = new ArrayList<>();
        div_array.add(d);
        IConference conference = new Conference("Eastern",div_array);
        conference.getDivisions();
        assertEquals(d,conference.getDivisions().get(0));
    }

    @Test
    void setDivisions() {
        ArrayList<ITeam2> teamArray = new ArrayList<>();
        IDivision d = new Division("Metro", teamArray);
        d.setDivisionName("Atlantic");
        d.setTeams(new ArrayList<ITeam2>());
        ArrayList<IDivision> div_array = new ArrayList<>();
        div_array.add(d);
        IConference conference = new Conference("Eastern",div_array);
        conference.getDivisions();
        IDivision d2 = new Division("Metro", teamArray);
        d2.setDivisionName("Metropolitan");
        ArrayList<IDivision> div_array_2 = new ArrayList<>();
        div_array_2.add(d2);
        conference.setDivisions(div_array_2);
        assertEquals(d2,conference.getDivisions().get(0));
    }
}