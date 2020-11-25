package dhl.leagueModel.training;

import dhl.leagueModel.headCoach.IHeadCoach;
import dhl.leagueModel.players.IPlayers;

import java.util.List;

public class PlayerTrainingCondition implements IPlayerTrainingCondition {
    @Override
    public void receiveTraining(List<IPlayers> playerList, IHeadCoach headCoach) {
        for (IPlayers player : playerList) {
            if (Math.random() < headCoach.getSkating()) {
                player.setSkating(player.getSkating() + 1);
            } else {
                player.checkForPlayerInjury();
            }
            if (Math.random() < headCoach.getShooting()) {
                player.setShooting(player.getShooting() + 1);
            } else {
                player.checkForPlayerInjury();
            }
            if (Math.random() < headCoach.getChecking()) {
                player.setChecking(player.getChecking() + 1);
            } else {
                player.checkForPlayerInjury();
            }
            if (Math.random() < headCoach.getSaving()) {
                player.setSaving(player.getSaving() + 1);
            } else {
                player.checkForPlayerInjury();
            }
        }
    }
}
