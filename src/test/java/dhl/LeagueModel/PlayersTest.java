package dhl.LeagueModel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayersTest {

    @Test
    void getPlayerName() {
        Players P = new Players("Player1","",true);
        assertEquals("Player1", P.getPlayerName());
    }

    @Test
    void setPlayerName() {
    }

    @Test
    void getPosition() {
    }

    @Test
    void setPosition() {
    }

    @Test
    void getCaptain() {
    }

    @Test
    void setCaptain() {
    }
}