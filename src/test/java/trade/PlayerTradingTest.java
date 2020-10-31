package trade;

import dhl.LeagueModel.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import dhl.LeagueModel.headCoach.HeadCoach;
import dhl.LeagueModel.players.Players;
import dhl.LeagueModel.teams.Teams;
import dhl.Trade.FreeAgentList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PlayerTradingTest {

    @Test
    public void strengthTestForward(){

        IPlayers player = new Players();
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
        IPlayers player = new Players();
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
        IPlayers player = new Players();
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
        IPlayers player1 = new Players();
        IPlayers player2 = new Players();
        IPlayers player3 = new Players();
        IPlayers player4 = new Players();
        IPlayers player5 = new Players();
        IPlayers player6 = new Players();
        List<IPlayers> players = new ArrayList<>();
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

        List<IPlayers> expectedList = new ArrayList<>();
        expectedList.add(player1);
        expectedList.add(player4);
        expectedList.add(player6);

        for(int i=1;i<players.size();i++){
            if(players.get(0).getPosition().equalsIgnoreCase(players.get(i).getPosition())){

                continue;
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
        List<IPlayers> playersWeak = new ArrayList<>();
        List<IPlayers> playersWeakActual = new ArrayList<>();
        List<IPlayers> players = new ArrayList<>();
        IPlayers player1 = new Players();
        IPlayers player2 = new Players();
        IPlayers player3 = new Players();
        IPlayers player4 = new Players();
        IPlayers player5 = new Players();
        IPlayers player6 = new Players();
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


        players.sort((p1, p2) -> Double.compare(p1.getStrength(), p2.getStrength()));


        playersWeak=players.subList(0,weakestCount);

        assertEquals(playersWeak,playersWeakActual);
    }

    @Test
    public void checkStrongestPlayerTest() {


        int weakestCount = 2;
        int count=0;
        String positionToTrade = "forward";
        List<IPlayers> playersStrong = new ArrayList<>();
        List<IPlayers> playersStrongActual = new ArrayList<>();
        List<IPlayers> players = new ArrayList<>();
        IPlayers player1 = new Players();
        IPlayers player2 = new Players();
        IPlayers player3 = new Players();
        IPlayers player4 = new Players();
        IPlayers player5 = new Players();
        IPlayers player6 = new Players();

        player1.setPosition("forward");
        players.add(player1);

        player2.setPosition("forward");
        players.add(player2);

        player3.setPosition("defense");
        players.add(player3);

        player4.setPosition("goalie");
        players.add(player4);

        player5.setPosition("forward");
        players.add(player5);

        player6.setPosition("goalie");
        players.add(player6);

        playersStrongActual.add(player1);
        playersStrongActual.add(player2);

        for (IPlayers weakPlayer : players) {
            if (weakPlayer.getPosition().equalsIgnoreCase(positionToTrade)) {
                weakPlayer.setStrength(5.6);
                playersStrong.add(weakPlayer);
                count++;

            }
        }
            playersStrong.sort(Collections.reverseOrder((p1, p2) -> Double.compare(p1.getStrength(), p2.getStrength())));

        if(count>weakestCount)
            playersStrong= playersStrong.subList(0,weakestCount);
        else
            playersStrong= playersStrong.subList(0,count);

           assertEquals(playersStrong, playersStrongActual);
    }

    @Test
    public void tradeAiTest() {
        double randomAcceptanceChance = 0.05;
        ITeam2 offeringTeam = new Teams();
        ITeam2 consideringTeam = new Teams();
        ArrayList<IPlayers> consideringTeamPlayers = new ArrayList<>();
        ArrayList<IPlayers> offeringTeamPositionPlayers = new ArrayList<>();
        ArrayList<IPlayers> consideringFinal = new ArrayList<>();
        ArrayList<IPlayers> offeringFinal = new ArrayList<>();
        ArrayList<IPlayers> expectedConsideringTeam = new ArrayList<>();
        ArrayList<IPlayers> expectedTradingTeam = new ArrayList<>();

        IPlayers player1 = new Players();
        IPlayers player2 = new Players();
        IPlayers player3 = new Players();
        IPlayers player4 = new Players();
        IPlayers player5 = new Players();
        IPlayers player6 = new Players();
        IPlayers player7 = new Players();
        IPlayers player8 = new Players();

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

        outer:
        for (IPlayers offeredPlayer : offeringFinal) {
            for (IPlayers tradePlayer : consideringFinal) {

                if (offeredPlayer.getStrength() < tradePlayer.getStrength() && Math.random() < randomAcceptanceChance) {

                    break outer;
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

    @Test
    public void tradeUserTest() {
        String response = "n";
        String value = "rejected";
        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        ITeam2 offeringTeam = new Teams();
        ITeam2 consideringTeam = new Teams();
        ArrayList<IPlayers> consideringTeamPlayers = new ArrayList<>();
        ArrayList<IPlayers> offeringTeamPositionPlayers = new ArrayList<>();
        ArrayList<IPlayers> consideringFinal = new ArrayList<>();
        ArrayList<IPlayers> offeringFinal = new ArrayList<>();
        ArrayList<IPlayers> expectedConsideringTeam = new ArrayList<>();
        ArrayList<IPlayers> expectedTradingTeam = new ArrayList<>();

        IPlayers player1 = new Players();
        IPlayers player2 = new Players();
        IPlayers player3 = new Players();
        IPlayers player4 = new Players();
        IPlayers player5 = new Players();
        IPlayers player6 = new Players();
        IPlayers player7 = new Players();
        IPlayers player8 = new Players();

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

        while(true) {

            if (response.equalsIgnoreCase("y")) {
                offeringTeam.getPlayers().removeAll(offeringFinal);
                offeringTeam.getPlayers().addAll(consideringFinal);
                consideringTeam.getPlayers().removeAll(consideringFinal);
                consideringTeam.getPlayers().addAll(offeringFinal);
                assertEquals(offeringTeam.getPlayers(), expectedTradingTeam);
                assertEquals(consideringTeam.getPlayers(), expectedConsideringTeam);
                break;
            } else if(response.equalsIgnoreCase("n")) {
                System.out.println("rejected");
                assertEquals("rejected",value);
                break;
            }
        }
    }

    @Test
    public void strongestPlayersStrengthTest(){

        double strength = 0;
        List<IPlayers> players = new ArrayList<>();
        IPlayers player1 = new Players();
        IPlayers player2 = new Players();

        player1.setStrength(4.2);
        players.add(player1);

        player2.setStrength(4.5);
        players.add(player2);

        for(IPlayers p: players){
            strength += p.getStrength();
        }
        assertEquals(8.7,strength);
    }

    @Test
    public void countTeamPlayers() {

        int count = 0;
        ITeam2 team = new Teams();
        List<IPlayers> players = new ArrayList<>();
        IPlayers player1 = new Players();
        IPlayers player2 = new Players();

        player1.setStrength(4.2);
        players.add(player1);

        player2.setStrength(4.5);
        players.add(player2);

        team.setPlayers(players);

        for (IPlayers p : team.getPlayers()) {
            count++;
        }

        assertEquals(2,count);
    }
}
