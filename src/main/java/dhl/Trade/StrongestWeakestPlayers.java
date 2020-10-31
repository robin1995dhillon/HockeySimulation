package dhl.Trade;

import dhl.LeagueModel.IPlayers;
import dhl.LeagueModel.ITeam2;
import dhl.LeagueModel.players.PlayersStrength;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StrongestWeakestPlayers implements IStrongestWeakestPlayers{

    PlayersStrength playerStrength;
    private int maxPlayersPerTrade = 2;

    StrongestWeakestPlayers(){
        playerStrength = new PlayersStrength();
    }

    @Override
    public List<IPlayers> checkStrongestPlayer(ITeam2 tradingTeam, String positionToTrade) {
        List<IPlayers> players = new ArrayList<>();
        List<IPlayers> playersStrong = new ArrayList<>();
        players = tradingTeam.getPlayers();
        int count=0;

        for(IPlayers weakPlayer: players){
            if(weakPlayer.getPosition().equalsIgnoreCase(positionToTrade)) {
                playersStrong.add(weakPlayer);
                count++;
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
    public List<IPlayers> checkWeakestPlayer(ITeam2 tradingTeam) {

        List<IPlayers> players = new ArrayList<>();
        players = tradingTeam.getPlayers();

        for(IPlayers weakPlayer: players){
            double strength = playerStrength.calculateStrength(weakPlayer);
            weakPlayer.setStrength(strength);

        }
        players.sort((p1, p2) -> Double.compare(playerStrength.calculateStrength(p1), playerStrength.calculateStrength(p2)));


        return players.subList(0,maxPlayersPerTrade);


    }
}
