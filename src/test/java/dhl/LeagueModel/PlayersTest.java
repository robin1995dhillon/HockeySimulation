//package dhl.LeagueModel;
//
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class PlayersTest {
//
//    @Test
//    void getPlayerName() {
//        IPlayers2 P = new Players("Player1","",true);
//        assertEquals("Player1", P.getPlayerName());
//    }
//
//    @Test
//    void setPlayerName() {
//        IPlayers2 P = new Players("Player1","",true);
//        P.setPlayerName("Player2");
//        assertEquals("Player2", P.getPlayerName());
//    }
//
//    @Test
//    void getPosition() {
//        IPlayers2 P = new Players("Player1","goalie",true);
//        assertEquals("goalie", P.getPosition());
//    }
//
//    @Test
//    void setPosition() {
//        IPlayers2 P = new Players("Player1","goalie",true);
//        P.setPosition("forward");
//        assertEquals("forward", P.getPosition());
//    }
//
//    @Test
//    void getCaptain() {
//        IPlayers2 P = new Players("Player1","goalie",true);
//        assertEquals(true, P.getCaptain());
//    }
//
//    @Test
//    void setCaptain() {
//        IPlayers2 P = new Players("Player1","goalie",true);
//        P.setCaptain(false);
//        assertEquals(false, P.getCaptain());
//    }
//}