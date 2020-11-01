package dhl.mock;

import dhl.leagueModel.IPlayers;
import dhl.leagueModel.players.Players;

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
}
