package dhl.LeagueModel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayersTest2 {

    @Test
    void getPlayerName() {
        IPlayers2 p = new Players2("Player1","",true);
        assertEquals("Player1", p.getPlayerName());
    }

    @Test
    void setPlayerName() {
        IPlayers2 p = new Players2("Player1","",true);
        p.setPlayerName("Player2");
        assertEquals("Player2", p.getPlayerName());
    }

    @Test
    void getPosition() {
        IPlayers2 p = new Players2("Player1","goalie",true);
        assertEquals("goalie", p.getPosition());
    }

    @Test
    void setPosition() {
        IPlayers2 p = new Players2("Player1","goalie",true);
        p.setPosition("forward");
        assertEquals("forward", p.getPosition());
    }

    @Test
    void getCaptain() {
        IPlayers2 p = new Players2("Player1","goalie",true);
        assertEquals(true, p.getCaptain());
    }

    @Test
    void setCaptain() {
        IPlayers2 p = new Players2("Player1","goalie",true);
        p.setCaptain(false);
        assertEquals(false, p.getCaptain());
    }
}