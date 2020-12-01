package dhl.leagueModel;

import dhl.leagueModel.gamePlayConfig.IGamePlayConfig;

import java.util.List;

public interface IPlayerTrainingCondition {
    public void receiveTraining(List<IPlayers> playerList, IHeadCoach headCoach, IGamePlayConfig gamePlayConfig);
}
