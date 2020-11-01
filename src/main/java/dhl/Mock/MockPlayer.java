package dhl.Mock;

import dhl.LeagueModel.IPlayers;
import dhl.LeagueModel.players.Players;

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
