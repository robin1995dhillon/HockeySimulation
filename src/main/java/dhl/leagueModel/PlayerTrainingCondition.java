package dhl.leagueModel;

import dhl.leagueModel.gamePlayConfig.IGamePlayConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class PlayerTrainingCondition implements IPlayerTrainingCondition {
    private static final Logger logger = LogManager.getLogger(PlayerTrainingCondition.class);
    @Override
    public void receiveTraining(List<IPlayers> playerList, IHeadCoach headCoach, IGamePlayConfig gamePlayConfig) {
        for (IPlayers player : playerList) {
            logger.info("Before training, the stats of " + player.getPlayerName() + " is (skating, shooting, checking, saving): " + player.getSkating() + ", " + player.getShooting() + ", " + player.getChecking() + ", " + player.getSaving());
            if (Math.random() < headCoach.getSkating()) {
                player.setSkating(player.getSkating() + 1);
            } else {
                player.checkForPlayerInjury(gamePlayConfig);
            }
            if (Math.random() < headCoach.getShooting()) {
                player.setShooting(player.getShooting() + 1);
            } else {
                player.checkForPlayerInjury(gamePlayConfig);
            }
            if (Math.random() < headCoach.getChecking()) {
                player.setChecking(player.getChecking() + 1);
            } else {
                player.checkForPlayerInjury(gamePlayConfig);
            }
            if (Math.random() < headCoach.getSaving()) {
                player.setSaving(player.getSaving() + 1);
            } else {
                player.checkForPlayerInjury(gamePlayConfig);
            }
            logger.info("After training, the stats of " + player.getPlayerName() + " is (skating, shooting, checking, saving): " + player.getSkating() + ", " + player.getShooting() + ", " + player.getChecking() + ", " + player.getSaving());
        }
    }
}
