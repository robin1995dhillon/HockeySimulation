package dhl.mock;

import dhl.leagueModel.headCoach.HeadCoach;
import dhl.leagueModel.headCoach.IHeadCoach;
import dhl.leagueModel.players.IPlayers;
import dhl.leagueModel.players.Players;
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
        team.setTeamStrength(50);
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

}
