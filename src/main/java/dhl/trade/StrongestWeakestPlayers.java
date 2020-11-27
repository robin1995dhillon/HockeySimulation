package dhl.trade;

import dhl.leagueModel.gamePlayConfig.GamePlayConfig;
import dhl.leagueModel.gamePlayConfig.IGamePlayConfig;
import dhl.leagueModel.gamePlayConfig.ITrading;
import dhl.leagueModel.gamePlayConfig.Trading;
import dhl.leagueModel.players.IPlayers;
import dhl.leagueModel.players.Players;
import dhl.leagueModel.teams.ITeam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StrongestWeakestPlayers implements IStrongestWeakestPlayers {

    IPlayers playerStrength;
    IGamePlayConfig gamePlayConfig;
    ITrading trading;

    StrongestWeakestPlayers() {
        playerStrength = new Players();
        trading = new Trading();
    }

    @Override
    public List<IPlayers> checkStrongestPlayer(ITeam tradingTeam, String positionToTrade) {
        List<IPlayers> players;
        List<IPlayers> playersStrong = new ArrayList<>();
        players = tradingTeam.getPlayers();

        for (IPlayers weakPlayer : players) {
            if (weakPlayer.getPosition().equalsIgnoreCase(positionToTrade)) {
                playersStrong.add(weakPlayer);
            }
        }
        playersStrong.sort(Collections.reverseOrder((p1, p2) -> Double.compare(playerStrength.calculateStrength(p1), playerStrength.calculateStrength(p2))));

        return playersStrong;

    }

    @Override
    public double strongestPlayersStrength(List<IPlayers> selectedPLayers) {

        double strength = 0;
        for (IPlayers player : selectedPLayers) {
            //strength += player.getStrength();
            strength += player.calculateStrength(player);
        }
        return strength;

    }

    @Override
    public List<IPlayers> checkWeakestPlayer(ITeam tradingTeam, IGamePlayConfig gamePlayConfig) {
        trading = gamePlayConfig.getTrading();
        int maxPlayersPerTrade = trading.getMaxPlayersPerTrade();
        List<IPlayers> players;
        players = tradingTeam.getPlayers();

        for (IPlayers weakPlayer : players) {
            double strength = playerStrength.calculateStrength(weakPlayer);
            weakPlayer.setStrength(strength);
        }
        players.sort((p1, p2) -> Double.compare(playerStrength.calculateStrength(p1), playerStrength.calculateStrength(p2)));
        return players.subList(0, maxPlayersPerTrade);
    }
}
