package dhl.Validator;

import dhl.LeagueModel.League;
import dhl.MockLeague;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckerTest {

    @Test
    void conferenceChecker() {
        Checker c = new Checker();
        String MockStringName = "Eastern Conference";
        League league = MockLeague.createMock();
        assertEquals(true, c.ConferenceChecker(MockStringName, league));
    }

    @Test
    void falseConferenceChecker() {
        Checker c = new Checker();
        String MockStringName = "Eastern ";
        League league = MockLeague.createMock();
        assertEquals(false, c.ConferenceChecker(MockStringName, league));
    }

    @Test
    void divisionChecker() {
        Checker c = new Checker();
        String MockStringName = "American";
        League league = MockLeague.createMock();
        assertEquals(true, c.DivisionChecker(MockStringName, league));
    }

    @Test
    void falseDivisionChecker() {
        Checker c = new Checker();
        String MockStringName = "India";
        League league = MockLeague.createMock();
        assertEquals(false, c.DivisionChecker(MockStringName, league));
    }

    @Test
    void teamChecker() {
        Checker c = new Checker();
        String MockStringName = "halifax";
        League league = MockLeague.createMock();
        assertEquals(true, c.TeamChecker(MockStringName, league));

    }
    void falseTeamChecker() {
        Checker c = new Checker();
        String MockStringName = "HalifaxTigers";
        League league = MockLeague.createMock();
        assertEquals(false, c.TeamChecker(MockStringName, league));

    }
}