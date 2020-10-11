package dhl.Creator;

import dhl.LeagueModel.League;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeagueCreatorTest {

    @Test
    void createLeague() {
        LeagueCreator leagueCreator = new LeagueCreator();
        League league = leagueCreator.CreateLeague("src/Data.json");
        assertTrue(league instanceof League);
    }
}