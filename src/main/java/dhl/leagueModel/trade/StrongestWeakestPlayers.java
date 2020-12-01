package dhl.leagueModel.trade;

import dhl.leagueModel.IPlayers;
import dhl.leagueModel.ITeam;
import dhl.leagueModel.LeagueModelAbstractFactory;
import dhl.leagueModel.gamePlayConfig.IGamePlayConfig;
import dhl.leagueModel.gamePlayConfig.ITrading;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StrongestWeakestPlayers implements IStrongestWeakestPlayers {

    ITrading trading;

    public StrongestWeakestPlayers() {
        trading = LeagueModelAbstractFactory.instance().getGamePlayConfig().getTrading();
    }

    @Override
    public List<IPlayers> checkStrongestPlayer(ITeam tradingTeam, String positionToTrade, int sizeOfList) {
        List<IPlayers> players;
        List<IPlayers> playersStrong = new ArrayList<>();
        players = tradingTeam.getPlayers();

        for (IPlayers weakPlayer : players) {
            if (weakPlayer.getPosition().equalsIgnoreCase(positionToTrade)) {
                playersStrong.add(weakPlayer);
            }
        }
        playersStrong.sort(Collections.reverseOrder((p1, p2) -> Double.compare(p1.calculateStrength(), p2.calculateStrength())));

        if (playersStrong.size() > sizeOfList) {
            return playersStrong.subList(0, sizeOfList);
        } else {
            return playersStrong.subList(0, playersStrong.size());
        }
    }

    @Override
    public double strongestPlayersStrength(List<IPlayers> selectedPLayers) {

        double strength = 0;
        for (IPlayers player : selectedPLayers) {
            strength += player.calculateStrength();
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
            double strength = weakPlayer.calculateStrength();
            weakPlayer.setStrength(strength);
        }
        players.sort((p1, p2) -> Double.compare(p1.calculateStrength(), p2.calculateStrength()));
        return players.subList(0, maxPlayersPerTrade);
    }
}
