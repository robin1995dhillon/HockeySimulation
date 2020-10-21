package dhl.Validator;

import dhl.LeagueModel.ILeague;
import dhl.MockLeague;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckerTest {

    @Test
    void conferenceChecker() {
        Checker c = new Checker();
        String MockStringName = "Eastern Conference";
        ILeague ILeague = MockLeague.createMock();
        assertEquals(true, c.ConferenceChecker(MockStringName, ILeague));
    }

    @Test
    void falseConferenceChecker() {
        Checker c = new Checker();
        String MockStringName = "Eastern ";
        ILeague ILeague = MockLeague.createMock();
        assertEquals(false, c.ConferenceChecker(MockStringName, ILeague));
    }

    @Test
    void divisionChecker() {
        Checker c = new Checker();
        String MockStringName = "American";
        ILeague ILeague = MockLeague.createMock();
        assertEquals(true, c.DivisionChecker(MockStringName, ILeague));
    }

    @Test
    void falseDivisionChecker() {
        Checker c = new Checker();
        String MockStringName = "India";
        ILeague ILeague = MockLeague.createMock();
        assertEquals(false, c.DivisionChecker(MockStringName, ILeague));
    }

    @Test
    void teamChecker() {
        Checker c = new Checker();
        String MockStringName = "halifax";
        ILeague ILeague = MockLeague.createMock();
        assertEquals(true, c.TeamChecker(MockStringName, ILeague));

    }
    void falseTeamChecker() {
        Checker c = new Checker();
        String MockStringName = "HalifaxTigers";
        ILeague ILeague = MockLeague.createMock();
        assertEquals(false, c.TeamChecker(MockStringName, ILeague));

    }
}