package dhl.training;

import dhl.leagueModel.headCoach.IHeadCoach;
import dhl.leagueModel.players.IPlayers;

import java.util.ArrayList;

public class PlayerTrainingCondition implements IPlayerTrainingCondition {
    @Override
    public void receiveTraining(ArrayList<IPlayers> playerList, IHeadCoach headCoach) {
        for (IPlayers player : playerList) {
            if (Math.random() < headCoach.getSkating()) {
                player.setSkating(player.getSkating() + 1);
            } else {
                if (player.isInjured() == false) {
                    player.checkForPlayerInjury();
                }
            }
            if (Math.random() < headCoach.getShooting()) {
                player.setShooting(player.getShooting() + 1);
            } else {
                if (player.isInjured() == false) {
                    player.checkForPlayerInjury();
                }
            }
            if (Math.random() < headCoach.getChecking()) {
                player.setChecking(player.getChecking() + 1);
            } else {
                if (player.isInjured() == false) {
                    player.checkForPlayerInjury();
                }
            }
            if (Math.random() < headCoach.getSaving()) {
                player.setSaving(player.getSaving() + 1);
            } else {
                if (player.isInjured() == false) {
                    player.checkForPlayerInjury();
                }
            }
        }
    }
}
