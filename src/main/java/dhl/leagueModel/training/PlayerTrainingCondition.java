package dhl.leagueModel.training;

import dhl.leagueModel.gamePlayConfig.IGamePlayConfig;
import dhl.leagueModel.headCoach.IHeadCoach;
import dhl.leagueModel.IPlayers;
import dhl.stateMachineNew.AdvanceToNextSeasonState;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class PlayerTrainingCondition implements IPlayerTrainingCondition {
    private static final Logger logger = LogManager.getLogger(PlayerTrainingCondition.class);

    @Override
    public void receiveTraining(List<IPlayers> playerList, IHeadCoach headCoach, IGamePlayConfig gamePlayConfig) {
        for (IPlayers player : playerList) {
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
        }
        logger.info("Complete the training.");
    }
}
