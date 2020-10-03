import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class LeagueTest {

    @Test
    void isLeagueNamePresent() {
        League leagueTest = new League("DalhousieHockeyLeague");
        assertEquals(true, leagueTest.isLeagueNamePresent());

    }
}