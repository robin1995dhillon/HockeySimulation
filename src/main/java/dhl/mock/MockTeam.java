package dhl.mock;

import dhl.leagueModel.headCoach.HeadCoach;
import dhl.leagueModel.headCoach.IHeadCoach;
import dhl.leagueModel.IPlayers;
import dhl.leagueModel.Players;
import dhl.leagueModel.teams.ITeam;
import dhl.leagueModel.teams.Teams;

import java.util.ArrayList;
import java.util.List;

public class MockTeam {

    public static ITeam MockTeam() {
        IHeadCoach headCoach = new HeadCoach();
        headCoach.setChecking(0.5);
        headCoach.setName("ABC");
        headCoach.setSaving(0.4);
        headCoach.setShooting(0.7);
        headCoach.setSkating(0.3);

//        ITeam team = new Teams("Random1", "Random2", headCoach);
        ITeam team = new Teams();
        team.setTeamName("Random1");
        team.setHeadCoach(headCoach);
        team.setTeamStrength(40);
        return team;
    }

    public static ITeam MockTeamTwo() {
        IHeadCoach headCoach2 = new HeadCoach();
        headCoach2.setChecking(0.5);
        headCoach2.setName("ABCD");
        headCoach2.setSaving(0.4);
        headCoach2.setShooting(0.7);
        headCoach2.setSkating(0.3);

//        ITeam team = new Teams("Team2", "GeneralManager2", headCoach2);
        ITeam team = new Teams();
        team.setTeamName("Team2");
        team.setHeadCoach(headCoach2);
        team.setTeamStrength(50);
        return team;
    }

    public static ITeam MockTeamThree() {
        ITeam team = new Teams();
        List<IPlayers> playersList = new ArrayList<>();
        IPlayers player = new Players();
        player.setGoals(1.0);
        player.setPenalties(0);
        player.setShots(5.0);
        player.setSaves(0);
        playersList.add(player);
        team.setPlayers(playersList);
        return team;
    }

    public static ITeam MockOffensiveTeam() {
        ITeam team = new Teams();
        team.setTeamName("Offensive Team");
        List<IPlayers> playersList = new ArrayList<>();
        IPlayers player1 = new Players();
        player1.setPlayerName("Zongming Page");
        player1.setPosition("forward");
        player1.setSkating(10);
        player1.setShooting(15);
        player1.setChecking(4);
        player1.setSaving(10);
        playersList.add(player1);
        IPlayers player2 = new Players();
        player2.setPlayerName("Prabhjot Smith");
        player2.setPosition("forward");
        player2.setSkating(18);
        player2.setShooting(10);
        player2.setChecking(6);
        player2.setSaving(17);
        playersList.add(player2);
        IPlayers player3 = new Players();
        player3.setPlayerName("Pat Chang");
        player3.setPosition("forward");
        player3.setSkating(14);
        player3.setShooting(8);
        player3.setChecking(12);
        player3.setSaving(6);
        playersList.add(player3);
        IPlayers player4 = new Players();
        player4.setPlayerName("Hardik Plant");
        player4.setPosition("forward");
        player4.setSkating(6);
        player4.setShooting(1);
        player4.setChecking(12);
        player4.setSaving(4);
        playersList.add(player4);
        IPlayers player5 = new Players();
        player5.setPlayerName("Hardik Morrison");
        player5.setPosition("forward");
        player5.setSkating(5);
        player5.setShooting(16);
        player5.setChecking(13);
        player5.setSaving(6);
        playersList.add(player5);
        IPlayers player6 = new Players();
        player6.setPlayerName("Prabhjot Page");
        player6.setPosition("forward");
        player6.setSkating(20);
        player6.setShooting(20);
        player6.setChecking(2);
        player6.setSaving(14);
        playersList.add(player6);
        IPlayers player7 = new Players();
        player7.setPlayerName("Nancy Burbchuk");
        player7.setPosition("forward");
        player7.setSkating(4);
        player7.setShooting(4);
        player7.setChecking(10);
        player7.setSaving(16);
        playersList.add(player7);
        IPlayers player8 = new Players();
        player8.setPlayerName("Fred Hendrix");
        player8.setPosition("forward");
        player8.setSkating(14);
        player8.setShooting(1);
        player8.setChecking(15);
        player8.setSaving(18);
        playersList.add(player8);
        IPlayers player9 = new Players();
        player9.setPlayerName("Tami Jones");
        player9.setPosition("forward");
        player9.setSkating(14);
        player9.setShooting(4);
        player9.setChecking(12);
        player9.setSaving(9);
        playersList.add(player9);
        IPlayers player10 = new Players();
        player10.setPlayerName("Roger Chang");
        player10.setPosition("forward");
        player10.setSkating(3);
        player10.setShooting(13);
        player10.setChecking(1);
        player10.setSaving(6);
        playersList.add(player10);
        IPlayers player11 = new Players();
        player11.setPlayerName("Abraham Singh");
        player11.setPosition("defense");
        player11.setSkating(20);
        player11.setShooting(8);
        player11.setChecking(3);
        player11.setSaving(11);
        playersList.add(player11);
        IPlayers player12 = new Players();
        player12.setPlayerName("Sai Burbchuk");
        player12.setPosition("defense");
        player12.setSkating(18);
        player12.setShooting(1);
        player12.setChecking(10);
        player12.setSaving(6);
        playersList.add(player12);
        IPlayers player13 = new Players();
        player13.setPlayerName("Rahul Liu");
        player13.setPosition("defense");
        player13.setSkating(20);
        player13.setShooting(2);
        player13.setChecking(1);
        player13.setSaving(19);
        playersList.add(player13);
        IPlayers player14 = new Players();
        player14.setPlayerName("Karan Marley");
        player14.setPosition("defense");
        player14.setSkating(4);
        player14.setShooting(19);
        player14.setChecking(1);
        player14.setSaving(15);
        playersList.add(player14);
        IPlayers player15 = new Players();
        player15.setPlayerName("Raghav Jones");
        player15.setPosition("defense");
        player15.setSkating(18);
        player15.setShooting(2);
        player15.setChecking(4);
        player15.setSaving(7);
        playersList.add(player15);
        IPlayers player16 = new Players();
        player16.setPlayerName("John Hendrix");
        player16.setPosition("defense");
        player16.setSkating(19);
        player16.setShooting(9);
        player16.setChecking(7);
        player16.setSaving(4);
        playersList.add(player16);
        IPlayers player17 = new Players();
        player17.setPlayerName("John Fei");
        player17.setPosition("defense");
        player17.setSkating(13);
        player17.setShooting(15);
        player17.setChecking(14);
        player17.setSaving(19);
        playersList.add(player17);
        IPlayers player18 = new Players();
        player18.setPlayerName("Jimmy Nelson");
        player18.setPosition("defense");
        player18.setSkating(2);
        player18.setShooting(5);
        player18.setChecking(10);
        player18.setSaving(13);
        playersList.add(player18);
        IPlayers player19 = new Players();
        player19.setPlayerName("Prashant Liu");
        player19.setPosition("goalie");
        player19.setSkating(5);
        player19.setShooting(4);
        player19.setChecking(20);
        player19.setSaving(20);
        playersList.add(player19);
        IPlayers player20 = new Players();
        player20.setPlayerName("Tina Halen");
        player20.setPosition("goalie");
        player20.setSkating(14);
        player20.setShooting(13);
        player20.setChecking(7);
        player20.setSaving(15);
        playersList.add(player20);
        team.setPlayers(playersList);
        return team;
    }

    public static ITeam MockDefendingTeam() {
        ITeam team = new Teams();
        team.setTeamName("Defending Team");
        team.setTeamType("ai");
        List<IPlayers> playersList = new ArrayList<>();
        IPlayers player1 = new Players();
        player1.setPlayerName("Shakuntala Liu");
        player1.setPosition("forward");
        player1.setSkating(18);
        player1.setShooting(19);
        player1.setChecking(17);
        player1.setSaving(18);
        playersList.add(player1);
        IPlayers player2 = new Players();
        player2.setPlayerName("Abraham Wu");
        player2.setPosition("forward");
        player2.setSkating(5);
        player2.setShooting(5);
        player2.setChecking(18);
        player2.setSaving(11);
        playersList.add(player2);
        IPlayers player3 = new Players();
        player3.setPlayerName("Jimmy Williamson");
        player3.setPosition("forward");
        player3.setSkating(9);
        player3.setShooting(10);
        player3.setChecking(13);
        player3.setSaving(20);
        playersList.add(player3);
        IPlayers player4 = new Players();
        player4.setPlayerName("Chris Hawkins");
        player4.setPosition("forward");
        player4.setSkating(20);
        player4.setShooting(6);
        player4.setChecking(5);
        player4.setSaving(2);
        playersList.add(player4);
        IPlayers player5 = new Players();
        player5.setPlayerName("Rashita Bishop");
        player5.setPosition("forward");
        player5.setSkating(2);
        player5.setShooting(3);
        player5.setChecking(18);
        player5.setSaving(20);
        playersList.add(player5);
        IPlayers player6 = new Players();
        player6.setPlayerName("Mozhgan Page");
        player6.setPosition("forward");
        player6.setSkating(15);
        player6.setShooting(13);
        player6.setChecking(13);
        player6.setSaving(3);
        playersList.add(player6);
        IPlayers player7 = new Players();
        player7.setPlayerName("Don Khatri");
        player7.setPosition("forward");
        player7.setSkating(7);
        player7.setShooting(15);
        player7.setChecking(14);
        player7.setSaving(6);
        playersList.add(player7);
        IPlayers player8 = new Players();
        player8.setPlayerName("Hardik Khatri");
        player8.setPosition("forward");
        player8.setSkating(9);
        player8.setShooting(15);
        player8.setChecking(3);
        player8.setSaving(2);
        playersList.add(player8);
        IPlayers player9 = new Players();
        player9.setPlayerName("Abraham Liu");
        player9.setPosition("forward");
        player9.setSkating(16);
        player9.setShooting(2);
        player9.setChecking(7);
        player9.setSaving(1);
        playersList.add(player9);
        IPlayers player10 = new Players();
        player10.setPlayerName("Jimmy Marley");
        player10.setPosition("forward");
        player10.setSkating(19);
        player10.setShooting(2);
        player10.setChecking(2);
        player10.setSaving(16);
        playersList.add(player10);
        IPlayers player11 = new Players();
        player11.setPlayerName("Tina Bonham");
        player11.setPosition("defense");
        player11.setSkating(19);
        player11.setShooting(16);
        player11.setChecking(8);
        player11.setSaving(14);
        playersList.add(player11);
        IPlayers player12 = new Players();
        player12.setPlayerName("Wen Jones");
        player12.setPosition("defense");
        player12.setSkating(13);
        player12.setShooting(10);
        player12.setChecking(2);
        player12.setSaving(16);
        playersList.add(player12);
        IPlayers player13 = new Players();
        player13.setPlayerName("Tami Bonham");
        player13.setPosition("defense");
        player13.setSkating(16);
        player13.setShooting(12);
        player13.setChecking(8);
        player13.setSaving(5);
        playersList.add(player13);
        IPlayers player14 = new Players();
        player14.setPlayerName("Fred Bishop");
        player14.setPosition("defense");
        player14.setSkating(10);
        player14.setShooting(20);
        player14.setChecking(2);
        player14.setSaving(6);
        playersList.add(player14);
        IPlayers player15 = new Players();
        player15.setPlayerName("Prabhjot Samson");
        player15.setPosition("defense");
        player15.setSkating(2);
        player15.setShooting(6);
        player15.setChecking(10);
        player15.setSaving(3);
        playersList.add(player15);
        IPlayers player16 = new Players();
        player16.setPlayerName("Mary Patel");
        player16.setPosition("defense");
        player16.setSkating(7);
        player16.setShooting(7);
        player16.setChecking(15);
        player16.setSaving(16);
        playersList.add(player16);
        IPlayers player17 = new Players();
        player17.setPlayerName("Tina Hawkins");
        player17.setPosition("defense");
        player17.setSkating(2);
        player17.setShooting(3);
        player17.setChecking(20);
        player17.setSaving(8);
        playersList.add(player17);
        IPlayers player18 = new Players();
        player18.setPlayerName("Jimmy Nelson");
        player18.setPosition("defense");
        player18.setSkating(18);
        player18.setShooting(5);
        player18.setChecking(6);
        player18.setSaving(12);
        playersList.add(player18);
        IPlayers player19 = new Players();
        player19.setPlayerName("Chris Hendrix");
        player19.setPosition("goalie");
        player19.setSkating(14);
        player19.setShooting(5);
        player19.setChecking(17);
        player19.setSaving(15);
        playersList.add(player19);
        IPlayers player20 = new Players();
        player20.setPlayerName("Nancy Marley");
        player20.setPosition("goalie");
        player20.setSkating(20);
        player20.setShooting(3);
        player20.setChecking(9);
        player20.setSaving(8);
        playersList.add(player20);
        team.setPlayers(playersList);
        return team;
    }

    public static ITeam MockUserTeam() {
        ITeam team = new Teams();
        team.setTeamName("User Team");
        team.setTeamType("user");
        List<IPlayers> playersList = new ArrayList<>();
        IPlayers player1 = new Players();
        player1.setPlayerName("Xiaong Page");
        player1.setPosition("forward");
        player1.setSkating(10);
        player1.setShooting(15);
        player1.setChecking(4);
        player1.setSaving(10);
        playersList.add(player1);
        IPlayers player2 = new Players();
        player2.setPlayerName("Prabhjot Johnson");
        player2.setPosition("forward");
        player2.setSkating(18);
        player2.setShooting(10);
        player2.setChecking(6);
        player2.setSaving(17);
        playersList.add(player2);
        IPlayers player3 = new Players();
        player3.setPlayerName("walter Chang");
        player3.setPosition("forward");
        player3.setSkating(14);
        player3.setShooting(8);
        player3.setChecking(12);
        player3.setSaving(6);
        playersList.add(player3);
        IPlayers player4 = new Players();
        player4.setPlayerName("ken adams");
        player4.setPosition("forward");
        player4.setSkating(6);
        player4.setShooting(1);
        player4.setChecking(12);
        player4.setSaving(4);
        playersList.add(player4);
        IPlayers player5 = new Players();
        player5.setPlayerName("Hardik Jackson");
        player5.setPosition("forward");
        player5.setSkating(5);
        player5.setShooting(16);
        player5.setChecking(13);
        player5.setSaving(6);
        playersList.add(player5);
        IPlayers player6 = new Players();
        player6.setPlayerName("Prabhjot Page");
        player6.setPosition("forward");
        player6.setSkating(20);
        player6.setShooting(20);
        player6.setChecking(2);
        player6.setSaving(14);
        playersList.add(player6);
        IPlayers player7 = new Players();
        player7.setPlayerName("Nancy Burbchuk");
        player7.setPosition("forward");
        player7.setSkating(4);
        player7.setShooting(4);
        player7.setChecking(10);
        player7.setSaving(16);
        playersList.add(player7);
        IPlayers player8 = new Players();
        player8.setPlayerName("Fred Hendrix");
        player8.setPosition("forward");
        player8.setSkating(14);
        player8.setShooting(1);
        player8.setChecking(15);
        player8.setSaving(18);
        playersList.add(player8);
        IPlayers player9 = new Players();
        player9.setPlayerName("Tami Jones");
        player9.setPosition("forward");
        player9.setSkating(14);
        player9.setShooting(4);
        player9.setChecking(12);
        player9.setSaving(9);
        playersList.add(player9);
        IPlayers player10 = new Players();
        player10.setPlayerName("Roger Chang");
        player10.setPosition("forward");
        player10.setSkating(3);
        player10.setShooting(13);
        player10.setChecking(1);
        player10.setSaving(6);
        playersList.add(player10);
        IPlayers player11 = new Players();
        player11.setPlayerName("Abraham Singh");
        player11.setPosition("defense");
        player11.setSkating(20);
        player11.setShooting(8);
        player11.setChecking(3);
        player11.setSaving(11);
        playersList.add(player11);
        IPlayers player12 = new Players();
        player12.setPlayerName("Sai Burbchuk");
        player12.setPosition("defense");
        player12.setSkating(18);
        player12.setShooting(1);
        player12.setChecking(10);
        player12.setSaving(6);
        playersList.add(player12);
        IPlayers player13 = new Players();
        player13.setPlayerName("Rahul Liu");
        player13.setPosition("defense");
        player13.setSkating(20);
        player13.setShooting(2);
        player13.setChecking(1);
        player13.setSaving(19);
        playersList.add(player13);
        IPlayers player14 = new Players();
        player14.setPlayerName("Karan Marley");
        player14.setPosition("defense");
        player14.setSkating(4);
        player14.setShooting(19);
        player14.setChecking(1);
        player14.setSaving(15);
        playersList.add(player14);
        IPlayers player15 = new Players();
        player15.setPlayerName("Raghav Jones");
        player15.setPosition("defense");
        player15.setSkating(18);
        player15.setShooting(2);
        player15.setChecking(4);
        player15.setSaving(7);
        playersList.add(player15);
        IPlayers player16 = new Players();
        player16.setPlayerName("John Hendrix");
        player16.setPosition("defense");
        player16.setSkating(19);
        player16.setShooting(9);
        player16.setChecking(7);
        player16.setSaving(4);
        playersList.add(player16);
        IPlayers player17 = new Players();
        player17.setPlayerName("John Fei");
        player17.setPosition("defense");
        player17.setSkating(13);
        player17.setShooting(15);
        player17.setChecking(14);
        player17.setSaving(19);
        playersList.add(player17);
        IPlayers player18 = new Players();
        player18.setPlayerName("Jimmy Nelson");
        player18.setPosition("defense");
        player18.setSkating(2);
        player18.setShooting(5);
        player18.setChecking(10);
        player18.setSaving(13);
        playersList.add(player18);
        IPlayers player19 = new Players();
        player19.setPlayerName("Prashant Liu");
        player19.setPosition("goalie");
        player19.setSkating(5);
        player19.setShooting(4);
        player19.setChecking(20);
        player19.setSaving(20);
        playersList.add(player19);
        IPlayers player20 = new Players();
        player20.setPlayerName("Tina Halen");
        player20.setPosition("goalie");
        player20.setSkating(14);
        player20.setShooting(13);
        player20.setChecking(7);
        player20.setSaving(15);
        playersList.add(player20);
        IPlayers player21 = new Players();
        player21.setPlayerName("Brown Marley");
        player21.setPosition("goalie");
        player21.setSkating(15);
        player21.setShooting(3);
        player21.setChecking(7);
        player21.setSaving(8);
        playersList.add(player21);
        team.setPlayers(playersList);
        return team;

    }


}
