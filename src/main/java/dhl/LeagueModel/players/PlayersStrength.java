package dhl.LeagueModel.players;

import dhl.LeagueModel.IPlayers;

import java.util.stream.IntStream;

public class PlayersStrength extends Players {



    public PlayersStrength() {
    }

    public PlayersStrength(String playerName, String position, boolean captain) {
        super(playerName, position, captain);
    }

    private double strengthCalculator(int[] forwardValues) {
        double playerStrength = 0;
        playerStrength = IntStream.of(forwardValues).sum();
        System.out.println(playerStrength);
        return playerStrength;
    }

    public double calculateStrength(IPlayers player) {
        String position = player.getPosition();
        int skating = player.getSkating();
        int shooting = player.getShooting();
        int checking = player.getChecking();
        int saving = player.getSaving();
        double strength;

        if(position.equals("forward")) {
            int[] forwardValues = {skating, shooting, checking/2};
            strength = strengthCalculator(forwardValues);
            player.setStrength(strength);
        }
        else if(position.equals("defense")) {
            int[] defenseValues = {skating, shooting/2, checking};
            strength = strengthCalculator(defenseValues);
            player.setStrength(strength);
        }
        else {
            int [] goalieValues = {skating, saving};
            strength = strengthCalculator(goalieValues);
            player.setStrength(strength);
        }

        return strength;
    }


}
