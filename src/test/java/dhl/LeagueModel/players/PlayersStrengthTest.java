package dhl.LeagueModel.players;

import dhl.LeagueModel.IPlayers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayersStrengthTest {

    @Test
    void calculateForwardStrength() {
        IPlayers player = new Players();
        player.setPosition("forward");
        player.setChecking(15);
        player.setSkating(18);
        player.setShooting(20);
        player.setSaving(0);

        PlayersStrength strength = new PlayersStrength();
        double playerStrength = strength.calculateStrength(player);
        assertEquals(45.0, playerStrength);
    }
    @Test
    void calculateDefenseStrength() {
        IPlayers player = new Players();
        player.setPosition("defense");
        player.setChecking(15);
        player.setSkating(18);
        player.setShooting(20);
        player.setSaving(0);

        PlayersStrength strength = new PlayersStrength();
        double playerStrength = strength.calculateStrength(player);
        assertEquals(43, playerStrength);
    }
    @Test
    void calculateGoalieStrength() {
        IPlayers player = new Players();
        player.setPosition("goalie");
        player.setChecking(15);
        player.setSkating(18);
        player.setShooting(20);
        player.setSaving(0);

        PlayersStrength strength = new PlayersStrength();
        double playerStrength = strength.calculateStrength(player);
        assertEquals(18.0, playerStrength);
    }
}