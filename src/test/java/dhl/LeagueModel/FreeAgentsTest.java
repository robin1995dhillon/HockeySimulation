//package dhl.LeagueModel;
//
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class FreeAgentsTest {
//
//    @Test
//    void getPlayerName() {
//        IFreeAgents F = new FreeAgents("Player1","",true);
//        assertEquals("Player1", F.getPlayerName());
//    }
//
//    @Test
//    void setPlayerName() {
//        IFreeAgents F = new FreeAgents("Player1","",true);
//        F.setPlayerName("Player2");
//        assertEquals("Player2", F.getPlayerName());
//    }
//
//    @Test
//    void getPosition() {
//        IFreeAgents F = new FreeAgents("Player1","goalie",true);
//        assertEquals("goalie", F.getPosition());
//    }
//
//    @Test
//    void setPosition() {
//        IFreeAgents F = new FreeAgents("Player1","goalie",true);
//        F.setPosition("forward");
//        assertEquals("forward", F.getPosition());
//    }
//
//    @Test
//    void getCaptain() {
//        IFreeAgents F = new FreeAgents("Player1","goalie",true);
//        assertEquals(true, F.getCaptain());
//    }
//
//    @Test
//    void setCaptain() {
//        IFreeAgents F = new FreeAgents("Player1","goalie",true);
//        F.setCaptain(false);
//        assertEquals(false, F.getCaptain());
//    }
//}