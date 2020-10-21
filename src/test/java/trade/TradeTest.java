package trade;

import dhl.LeagueModel.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class TradeTest {

    @Test
    public void strengthTestForward(){

        IPlayers2 player = new Players2();
        player.setPosition("forward");
        player.setSkating(15);
        player.setShooting(18);
        player.setChecking(12);
        player.setSaving(0);
        double strength = player.getShooting() + player.getSkating() + player.getChecking() / 2.0;
        assertEquals(player.getShooting() + player.getSkating() + player.getChecking() / 2.0,strength);
    }

    @Test
    public void strengthTestDefense(){
        IPlayers2 player = new Players2();
        player.setPosition("defense");
        player.setSkating(10);
        player.setShooting(10);
        player.setChecking(10);
        player.setSaving(0);
        double strength = player.getSkating() + player.getChecking() + player.getShooting() / 2.0;
        assertEquals(player.getSkating() + player.getChecking() + player.getShooting() / 2.0,strength);

    }

    @Test
    public void strengthTestGoalie(){
        IPlayers2 player = new Players2();
        player.setPosition("goalie");
        player.setSkating(10);
        player.setShooting(4);
        player.setChecking(9);
        player.setSaving(18);
        double strength = player.getSkating() + player.getSaving();
        assertEquals(player.getSkating() + player.getSaving(),strength);
    }

    @Test
    public void getPositionTypesOfferingTest(){
        IPlayers2 player1 = new Players2();
        IPlayers2 player2 = new Players2();
        IPlayers2 player3 = new Players2();
        IPlayers2 player4 = new Players2();
        IPlayers2 player5 = new Players2();
        IPlayers2 player6 = new Players2();
        List<IPlayers2> players = new ArrayList<>();
        player1.setPosition("forward");
        players.add(player1);
        player2.setPosition("goalie");
        players.add(player2);
        player3.setPosition("defense");
        players.add(player3);
        player4.setPosition("forward");
        players.add(player4);
        player5.setPosition("goalie");
        players.add(player5);
        player6.setPosition("forward");
        players.add(player6);
        for(IPlayers2 p: players)
            System.out.println("Original list includes : "+p.getPosition());

        List<IPlayers2> expectedPlayers = new ArrayList<>();


        List<IPlayers2> expectedList = new ArrayList<>();
        expectedList.add(player1);
        expectedList.add(player4);
        expectedList.add(player6);

        for(int i=1;i<players.size();i++){
            if(players.get(0).getPosition().equalsIgnoreCase(players.get(i).getPosition())){

            }
            else{
                players.remove(i);
                i-=1;
            }
        }
        assertEquals(players,expectedList);
    }

    @Test
    public void checkWeakestPlayerTest() {


        int weakestCount =2;
        List<IPlayers2> playersWeak = new ArrayList<>();
        List<IPlayers2> playersWeakActual = new ArrayList<>();
        List<IPlayers2> players = new ArrayList<>();
        IPlayers2 player1 = new Players2();
        IPlayers2 player2 = new Players2();
        IPlayers2 player3 = new Players2();
        IPlayers2 player4 = new Players2();
        IPlayers2 player5 = new Players2();
        IPlayers2 player6 = new Players2();
        player1.setStrength(4.2);
        players.add(player1);
        player2.setStrength(4.5);
        players.add(player2);
        player3.setStrength(3.9);
        players.add(player3);
        player4.setStrength(2.6);
        players.add(player4);
        player5.setStrength(8.3);
        players.add(player5);
        player6.setStrength(5.8);
        players.add(player6);
        playersWeakActual.add(player4);
        playersWeakActual.add(player3);


        Collections.sort(players, (p1, p2) -> Double.compare(p1.getStrength(),p2.getStrength()));


        playersWeak=players.subList(0,weakestCount);

        assertEquals(playersWeak,playersWeakActual);
    }

    @Test
    public void checkStrongestPlayerTest() {


        int weakestCount = 2;
        int count=0;
        String positionToTrade = "forward";
        List<IPlayers2> playersStrong = new ArrayList<>();
        List<IPlayers2> playersStrongActual = new ArrayList<>();
        List<IPlayers2> players = new ArrayList<>();
        IPlayers2 player1 = new Players2();
        IPlayers2 player2 = new Players2();
        IPlayers2 player3 = new Players2();
        IPlayers2 player4 = new Players2();
        IPlayers2 player5 = new Players2();
        IPlayers2 player6 = new Players2();
 //       player1.setStrength(4.2);
        player1.setPosition("forward");
        players.add(player1);
 //       player2.setStrength(4.5);
        player2.setPosition("forward");
        players.add(player2);
//        player3.setStrength(3.9);
        player3.setPosition("defense");
        players.add(player3);
 //       player4.setStrength(2.6);
        player4.setPosition("goalie");
        players.add(player4);
//        player5.setStrength(8.3);
        player5.setPosition("forward");
        players.add(player5);
//         player6.setStrength(5.8);
        player6.setPosition("goalie");
        players.add(player6);
        playersStrongActual.add(player1);
        playersStrongActual.add(player2);

        for (IPlayers2 weakPlayer : players) {
            if (weakPlayer.getPosition().equalsIgnoreCase(positionToTrade)) {
                weakPlayer.setStrength(5.6);
                playersStrong.add(weakPlayer);
                // weakPlayer.setStrength(5.6);
                count++;

            } else {
                continue;
            }
        }
            Collections.sort(playersStrong, Collections.reverseOrder((p1, p2) -> Double.compare(p1.getStrength(), p2.getStrength())));

        if(count>weakestCount)
            playersStrong= playersStrong.subList(0,weakestCount);
        else
            playersStrong= playersStrong.subList(0,count);


            for (IPlayers2 p : playersStrong) {
                System.out.println("Player Strong :"+p.getPosition()+" "+p.getStrength());
            }

            for (IPlayers2 p : playersStrongActual) {
                System.out.println("Player Strong Actual:"+p.getPosition()+" "+p.getStrength());
            }
           assertEquals(playersStrong, playersStrongActual);

    }

    @Test
    public void TradeAiTest() {
        double randomAcceptanceChance = 0.05;
        int maxPlayersPerTrade=2;
        int count =0;
        ITeam2 offeringTeam = new Teams2();
        ITeam2 consideringTeam = new Teams2();
        List<IPlayers2> consideringTeamPlayers = new ArrayList<>();
        List<IPlayers2> offeringTeamPositionPlayers = new ArrayList<>();
        List<IPlayers2> consideringFinal = new ArrayList<>();
        List<IPlayers2> offeringFinal = new ArrayList<>();
        List<IPlayers2> expectedConsideringTeam = new ArrayList<>();
        List<IPlayers2> expectedTradingTeam = new ArrayList<>();

        IPlayers2 player1 = new Players2();
        IPlayers2 player2 = new Players2();
        IPlayers2 player3 = new Players2();
        IPlayers2 player4 = new Players2();
        IPlayers2 player5 = new Players2();
        IPlayers2 player6 = new Players2();
        IPlayers2 player7 = new Players2();
        IPlayers2 player8 = new Players2();

        player1.setStrength(2.5);
        player2.setStrength(3.9);
        player3.setStrength(4.2);
        player4.setStrength(4.5);
        player5.setStrength(5.7);
        player6.setStrength(7.4);
        player7.setStrength(8.7);
        player8.setStrength(9.5);

        offeringTeamPositionPlayers.add(player1);
        offeringTeamPositionPlayers.add(player2);
        offeringTeamPositionPlayers.add(player3);
        offeringTeamPositionPlayers.add(player4);

        offeringTeam.setPlayers(offeringTeamPositionPlayers);

        consideringTeamPlayers.add(player5);
        consideringTeamPlayers.add(player6);
        consideringTeamPlayers.add(player7);
        consideringTeamPlayers.add(player8);

        consideringTeam.setPlayers(consideringTeamPlayers);

        offeringFinal.add(player1);
        offeringFinal.add(player2);
        consideringFinal.add(player7);
        consideringFinal.add(player8);

        expectedConsideringTeam.add(player5);
        expectedConsideringTeam.add(player6);
        expectedConsideringTeam.add(player1);
        expectedConsideringTeam.add(player2);

        expectedTradingTeam.add(player3);
        expectedTradingTeam.add(player4);
        expectedTradingTeam.add(player7);
        expectedTradingTeam.add(player8);



        for(IPlayers2 t:offeringTeam.getPlayers()) {
            System.out.println("team before offering: "+t.getStrength());
        }

        for(IPlayers2 t:consideringTeam.getPlayers()) {
            System.out.println("team before trade considered: "+t.getStrength());
        }


        outer:
        for (IPlayers2 offeredPlayer : offeringFinal) {
            for (IPlayers2 tradePlayer : consideringFinal) {

                if (offeredPlayer.getStrength() < tradePlayer.getStrength() && Math.random() < randomAcceptanceChance) {
                    System.out.println("Rejected");
                    break outer;
                } else {
                    System.out.println("player eligible for trade");

                }
            }
        }

            offeringTeam.getPlayers().removeAll(offeringFinal);
            offeringTeam.getPlayers().addAll(consideringFinal);
            consideringTeam.getPlayers().removeAll(consideringFinal);
            consideringTeam.getPlayers().addAll(offeringFinal);


        assertEquals(offeringTeam.getPlayers(),expectedTradingTeam);
        assertEquals(consideringTeam.getPlayers(),expectedConsideringTeam);
    }


//    @Test
//    public void tradeConditionTest(){
//
//        ArrayList<ITeam2> team_array = new ArrayList<>();
//        IHeadCoach h = new HeadCoach();
//        h.setChecking(0.5);
//        h.setName("ABC");
//        h.setSaving(0.4);
//        h.setShooting(0.7);
//        h.setSkating(0.3);
//        ITeam2 t = new Teams2("Random1", "Random2", h);
//        t.setTeamType("ai");
//        t.setLossPoints(8);
//
//
//    }
}
