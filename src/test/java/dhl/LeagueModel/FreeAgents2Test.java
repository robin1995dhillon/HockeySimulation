package dhl.LeagueModel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FreeAgents2Test {

    @Test
    void getPlayerName() {
        IFreeAgents f = new FreeAgents2("Player1","");
        assertEquals("Player1", f.getPlayerName());
    }

    @Test
    void setPlayerName() {
        IFreeAgents f = new FreeAgents2("Player1","");
        f.setPlayerName("Player2");
        assertEquals("Player2", f.getPlayerName());
    }

    @Test
    void getPosition() {
        IFreeAgents f = new FreeAgents2("Player1","goalie");
        assertEquals("goalie", f.getPosition());
    }

    @Test
    void setPosition() {
        IFreeAgents f = new FreeAgents2("Player1","goalie");
        f.setPosition("forward");
        assertEquals("forward", f.getPosition());
    }



}