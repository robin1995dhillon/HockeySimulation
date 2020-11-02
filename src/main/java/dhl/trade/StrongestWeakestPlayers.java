package dhl.trade;

import dhl.leagueModel.players.IPlayers;
import dhl.leagueModel.teams.ITeam;
import dhl.leagueModel.players.PlayersStrength;
import dhl.leagueModel.gamePlayConfig.GamePlayConfig;
import dhl.leagueModel.gamePlayConfig.IGamePlayConfig;
import dhl.leagueModel.gamePlayConfig.ITrading;
import dhl.leagueModel.gamePlayConfig.Trading;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StrongestWeakestPlayers implements IStrongestWeakestPlayers{

    PlayersStrength playerStrength;
    IGamePlayConfig gamePlayConfig;
    ITrading trading;

    StrongestWeakestPlayers(){
        playerStrength = new PlayersStrength();
        gamePlayConfig = new GamePlayConfig();
        trading = new Trading();
    }

    @Override
    public List<IPlayers> checkStrongestPlayer(ITeam tradingTeam, String positionToTrade) {
        List<IPlayers> players;
        List<IPlayers> playersStrong = new ArrayList<>();
        players = tradingTeam.getPlayers();

        for(IPlayers weakPlayer: players){
            if(weakPlayer.getPosition().equalsIgnoreCase(positionToTrade)) {
                playersStrong.add(weakPlayer);
            }
        }
        playersStrong.sort(Collections.reverseOrder((p1, p2) -> Double.compare(playerStrength.calculateStrength(p1), playerStrength.calculateStrength(p2))));

        return playersStrong;

    }

    @Override
    public double StrongestPlayersStrength(List<IPlayers> selectedPLayers) {

        double strength = 0;
        for(IPlayers p: selectedPLayers){
            strength += p.getStrength();
        }
        return strength;

    }

    @Override
    public List<IPlayers> checkWeakestPlayer(ITeam tradingTeam) {
        trading = gamePlayConfig.getTrading();
        int maxPlayersPerTrade = trading.getMaxPlayersPerTrade();

        List<IPlayers> players;
        players = tradingTeam.getPlayers();

        for(IPlayers weakPlayer: players){
            double strength = playerStrength.calculateStrength(weakPlayer);
            weakPlayer.setStrength(strength);

        }
        players.sort((p1, p2) -> Double.compare(playerStrength.calculateStrength(p1), playerStrength.calculateStrength(p2)));


        return players.subList(0,maxPlayersPerTrade);


    }
}
