package dhl.leagueModel.trade;

import dhl.leagueModel.gamePlayConfig.IGamePlayConfig;
import dhl.leagueModel.IPlayers;
import dhl.leagueModel.ITeam;
import dhl.mock.MockGamePlayConfig;
import dhl.mock.MockTeam;
import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StrongestWeakestPlayersTest {
    IStrongestWeakestPlayers strongestWeakestPlayers = new StrongestWeakestPlayers();

    @Test
    public void checkWeakestPlayerTest() {

        IGamePlayConfig config = MockGamePlayConfig.createMock();
        config.getTrading().getMaxPlayersPerTrade();
        List<IPlayers> playersWeak;
        ITeam team = MockTeam.MockOffensiveTeam();
        playersWeak = strongestWeakestPlayers.checkWeakestPlayer(team, config);
        assertEquals(playersWeak.get(0).getStrength(), 13.0);
    }

//    @Test
//    public void checkStrongestPlayerTest() {
//
//        int count = 1;
//        String positionToTrade = "forward";
//        List<IPlayers> playersStrong;
//        ITeam team = MockTeam.MockOffensiveTeam();
//        playersStrong = strongestWeakestPlayers.checkStrongestPlayer(team, positionToTrade, gamePlayConfig);
//        playersStrong.subList(0,count);
//        assertEquals(playersStrong.get(0).getStrength(), 41.0);
//    }

    @Test
    public void strongestPlayersStrengthTest() {

        double strength = 0;
        ITeam team = MockTeam.MockOffensiveTeam();
        strength = strongestWeakestPlayers.strongestPlayersStrength(team.getPlayers());
        assertEquals(488.0, strength);
    }
}
