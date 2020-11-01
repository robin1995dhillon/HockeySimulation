//package dhl.LeagueModel;
//
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class TeamsTest2 {
//
//
//    @Test
//    void getPlayers() {
//        IHeadCoach h = new HeadCoach();
//        h.setChecking(0.5);
//        h.setName("ABC");
//        h.setSaving(0.4);
//        h.setShooting(0.7);
//        h.setSkating(0.3);
//        ArrayList<IPlayers2> p = new ArrayList<>();
//        ITeam2 t = new Teams("Team1","",h, p);
//        assertEquals(p, t.getPlayers());
//    }
//
//    @Test
//    void setPlayers() {
//        IHeadCoach h = new HeadCoach();
//        h.setChecking(0.5);
//        h.setName("ABC");
//        h.setSaving(0.4);
//        h.setShooting(0.7);
//        h.setSkating(0.3);
//        ArrayList<IPlayers2> p = new ArrayList<>();
//        ArrayList<IPlayers2> p_2 = new ArrayList<>();
//        ITeam2 t = new Teams("Team1","",h, p);
//        t.setPlayers(p_2);
//        assertEquals(p_2, t.getPlayers());
//    }
//
//    @Test
//    void getTeamName() {
//        IHeadCoach h = new HeadCoach();
//        h.setChecking(0.5);
//        h.setName("ABC");
//        h.setSaving(0.4);
//        h.setShooting(0.7);
//        h.setSkating(0.3);
//        ITeam2 t = new Teams("Team1","",h);
//        assertEquals("Team1", t.getTeamName());
//    }
//
//    @Test
//    void setTeamName() {
//        IHeadCoach h = new HeadCoach();
//        h.setChecking(0.5);
//        h.setName("ABC");
//        h.setSaving(0.4);
//        h.setShooting(0.7);
//        h.setSkating(0.3);
//        ITeam2 t = new Teams("Team1","",h);
//        t.setTeamName("Team2");
//        assertEquals("Team2", t.getTeamName());
//    }
//
//    @Test
//    void getGeneralManager() {
//        IHeadCoach h = new HeadCoach();
//        h.setChecking(0.5);
//        h.setName("ABC");
//        h.setSaving(0.4);
//        h.setShooting(0.7);
//        h.setSkating(0.3);
//        ITeam2 t = new Teams("Team1","General1",h);
//        assertEquals("General1", t.getGeneralManager());
//    }
//
//    @Test
//    void setGeneralManager() {
//        IHeadCoach h = new HeadCoach();
//        h.setChecking(0.5);
//        h.setName("ABC");
//        h.setSaving(0.4);
//        h.setShooting(0.7);
//        h.setSkating(0.3);
//        ITeam2 t = new Teams("Team1","General1",h);
//        t.setGeneralManager("General2");
//        assertEquals("General2", t.getGeneralManager());
//    }
//
//    @Test
//    void getHeadCoach() {
//        IHeadCoach h = new HeadCoach();
//        h.setChecking(0.5);
//        h.setName("ABC");
//        h.setSaving(0.4);
//        h.setShooting(0.7);
//        h.setSkating(0.3);
//        ITeam2 t = new Teams("Team1","General1",h);
//        assertEquals(h, t.getHeadCoach());
//    }
//
//    @Test
//    void setHeadCoach() {
//        IHeadCoach h = new HeadCoach();
//        h.setChecking(0.5);
//        h.setName("ABC");
//        h.setSaving(0.4);
//        h.setShooting(0.7);
//        h.setSkating(0.3);
//
//        IHeadCoach h2 = new HeadCoach();
//        h2.setChecking(0.6);
//        h2.setName("DEF");
//        h2.setSaving(0.2);
//        h2.setShooting(0.4);
//        h2.setSkating(0.5);
//        ITeam2 t = new Teams("Team1","General1",h);
//        t.setHeadCoach(h2);
//        assertEquals(h2, t.getHeadCoach());
//    }
//}