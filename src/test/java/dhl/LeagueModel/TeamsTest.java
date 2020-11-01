package dhl.LeagueModel;

import dhl.LeagueModel.headCoach.HeadCoach;
import dhl.LeagueModel.players.Players;
import dhl.LeagueModel.teams.Teams;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class TeamsTest {

//    @Test
//    void getPlayers() {
//        ArrayList<IPlayers> P = new ArrayList<>();
//        ITeam2 T = new Teams("Team1","","", P);
//        assertEquals(P, T.getPlayers());
//    }

//    @Test
//    void setPlayers() {
//        ArrayList<IPlayers> P = new ArrayList<>();
//        ArrayList<IPlayers> P_2 = new ArrayList<>();
//        ITeam2 T = new Teams("Team1","","", P);
//        T.setPlayers(P_2);
//        assertEquals(P_2, T.getPlayers());
//    }
//
//    @Test
//    void getTeamName() {
//        ITeam2 T = new Teams("Team1","","");
//        assertEquals("Team1", T.getTeamName());
//    }
//
//    @Test
//    void setTeamName() {
//        ITeam2 T = new Teams("Team1","","");
//        T.setTeamName("Team2");
//        assertEquals("Team2", T.getTeamName());
//    }
//
//    @Test
//    void getGeneralManager() {
//        ITeam2 T = new Teams("Team1","General1","");
//        assertEquals("General1", T.getGeneralManager());
//    }
//
//    @Test
//    void setGeneralManager() {
//        ITeam2 T = new Teams("Team1","General1","");
//        T.setGeneralManager("General2");
//        assertEquals("General2", T.getGeneralManager());
//    }
//
//    @Test
//    void getHeadCoach() {
//        ITeam2 T = new Teams("Team1","General1","Head1");
//        assertEquals("Head1", T.getHeadCoach());
//    }

    @Test
    void calculateTeamStrength() {
        IHeadCoach headCoach = new HeadCoach();
        ArrayList<IPlayers> players = new ArrayList<>();
        IPlayers play1 = new Players();
        play1.setPosition("forward");
        play1.setInjured(true);
        play1.setSaving(0);
        play1.setShooting(20);
        play1.setSkating(15);
        play1.setChecking(20);
        IPlayers play2 = new Players();
        play2.setPosition("defense");
        play2.setSaving(0);
        play2.setShooting(10);
        play2.setSkating(20);
        play2.setChecking(10);
        players.add(play1);
        players.add(play2);

        ITeam T = new Teams("Team1", "Manager1",headCoach, players);
        double strength = T.calculateTeamStrength(T);
        System.out.println(strength);
    }

//    @Test
//    void setHeadCoach() {
//        ITeam2 T = new Teams("Team1","General1","Head1");
//        T.setHeadCoach("Head2");
//        assertEquals("Head2", T.getHeadCoach());
//    }

}