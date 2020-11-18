package dhl.mock;

import dhl.leagueModel.players.IPlayers;
import dhl.leagueModel.players.Players;
import dhl.leagueModel.teams.ITeam;
import dhl.leagueModel.teams.Teams;

import java.util.ArrayList;
import java.util.List;

public class MockPlayer {

    public static IPlayers createMock() {
        IPlayers players = new Players();
        players.setPlayerName("Player1");
        players.setPosition("forward");
        players.setSkating(15);
        players.setShooting(15);
        players.setChecking(15);
        players.setSaving(15);
        players.setAge(25);
        players.setCaptain(true);
        return players;
    }

    public static IPlayers createMockTwo() {
        IPlayers players = new Players();
        players.setPlayerName("Player2");
        players.setPosition("forward");
        players.setSkating(15);
        players.setShooting(15);
        players.setChecking(15);
        players.setSaving(15);
        players.setAge(25);
        return players;
    }

    public static IPlayers createMockWithDateOfBirth() {
        IPlayers players = new Players();
        players.setPlayerName("Player2");
        players.setPosition("forward");
        players.setSkating(15);
        players.setShooting(15);
        players.setChecking(15);
        players.setSaving(15);
        players.setBirthDay(28);
        players.setBirthYear(1997);
        players.setBirthMonth(6);

        return players;
    }

    public static List<IPlayers> createMockPlayerList() {

        List<IPlayers> players = new ArrayList<>();

        IPlayers player1 = new Players();
        IPlayers player2 = new Players();
        IPlayers player3 = new Players();
        IPlayers player4 = new Players();
        IPlayers player5 = new Players();
        IPlayers player6 = new Players();

        player1.setPosition("forward");
        player1.setPlayerName("ABC");
        player1.setStrength(4.2);
        players.add(player1);

        player2.setPosition("goalie");
        player2.setPlayerName("DEF");
        player2.setStrength(4.5);
        players.add(player2);

        player3.setPosition("defense");
        player3.setPlayerName("GHI");
        player3.setStrength(3.9);
        players.add(player3);

        player4.setPosition("forward");
        player4.setPlayerName("JKL");
        player4.setStrength(2.6);
        players.add(player4);

        player5.setPosition("goalie");
        player5.setPlayerName("MNO");
        player5.setStrength(8.3);
        players.add(player5);

        player6.setPosition("forward");
        player6.setPlayerName("PQR");
        player6.setStrength(5.8);
        players.add(player6);

        return players;

    }

    public static List<IPlayers> getPositionTypesOfferingExpectedList() {

        List<IPlayers> expectedList = new ArrayList<>();

        IPlayers player1 = new Players();
        IPlayers player2 = new Players();
        IPlayers player3 = new Players();

        player1.setPosition("forward");
        player2.setPosition("forward");
        player3.setPosition("forward");
        expectedList.add(player1);
        expectedList.add(player2);
        expectedList.add(player3);

        return expectedList;

    }

    public static ITeam tradeAiOfferingPlayersTestMock() {

        List<IPlayers> offeringTeamPositionPlayers = new ArrayList<>();
        ITeam offeringTeam = new Teams();

        IPlayers player1 = new Players();
        IPlayers player2 = new Players();
        IPlayers player3 = new Players();
        IPlayers player4 = new Players();


        player1.setStrength(2.5);
        player2.setStrength(3.9);
        player3.setStrength(4.2);
        player4.setStrength(4.5);


        offeringTeamPositionPlayers.add(player1);
        offeringTeamPositionPlayers.add(player2);
        offeringTeamPositionPlayers.add(player3);
        offeringTeamPositionPlayers.add(player4);

        offeringTeam.setPlayers(offeringTeamPositionPlayers);

        return offeringTeam;

    }

    public static ITeam tradeAiConsideringPlayersTestMock() {

        ITeam consideringTeam = new Teams();
        ArrayList<IPlayers> consideringTeamPlayers = new ArrayList<>();

        IPlayers player5 = new Players();
        IPlayers player6 = new Players();
        IPlayers player7 = new Players();
        IPlayers player8 = new Players();

        player5.setStrength(5.7);
        player6.setStrength(7.4);
        player7.setStrength(8.7);
        player8.setStrength(9.5);

        consideringTeamPlayers.add(player5);
        consideringTeamPlayers.add(player6);
        consideringTeamPlayers.add(player7);
        consideringTeamPlayers.add(player8);

        consideringTeam.setPlayers(consideringTeamPlayers);

        return consideringTeam;
    }

    public static List<IPlayers> tradeAiExpectedConsideringTeamTestMock() {

        List<IPlayers> expectedConsideringTeam = new ArrayList<>();

        IPlayers player5 = new Players();
        IPlayers player6 = new Players();
        IPlayers player1 = new Players();
        IPlayers player2 = new Players();

        player5.setStrength(5.7);
        player6.setStrength(7.4);
        player1.setStrength(2.5);
        player2.setStrength(3.9);

        expectedConsideringTeam.add(player5);
        expectedConsideringTeam.add(player6);
        expectedConsideringTeam.add(player1);
        expectedConsideringTeam.add(player2);

        return expectedConsideringTeam;

    }

    public static List<IPlayers> tradeAiExpectedTradingTeamTestMock() {

        List<IPlayers> expectedTradingTeam = new ArrayList<>();


        IPlayers player3 = new Players();
        IPlayers player4 = new Players();
        IPlayers player7 = new Players();
        IPlayers player8 = new Players();

        player3.setStrength(4.2);
        player4.setStrength(4.5);
        player7.setStrength(8.7);
        player8.setStrength(9.5);

        expectedTradingTeam.add(player3);
        expectedTradingTeam.add(player4);
        expectedTradingTeam.add(player7);
        expectedTradingTeam.add(player8);

        return expectedTradingTeam;

    }

    public static List<IPlayers> tradeAiOfferingFinalTeamTestMock() {

        List<IPlayers> offeringFinal = new ArrayList<>();

        IPlayers player1 = new Players();
        IPlayers player2 = new Players();
        player1.setStrength(2.5);
        player2.setStrength(3.9);

        offeringFinal.add(player1);
        offeringFinal.add(player2);

        return offeringFinal;
    }


    public static List<IPlayers> tradeAiConsideringFinalTeamTestMock() {

        List<IPlayers> consideringFinal = new ArrayList<>();
        IPlayers player7 = new Players();
        IPlayers player8 = new Players();

        player7.setStrength(8.7);
        player8.setStrength(9.5);

        consideringFinal.add(player7);
        consideringFinal.add(player8);

        return consideringFinal;
    }


}
