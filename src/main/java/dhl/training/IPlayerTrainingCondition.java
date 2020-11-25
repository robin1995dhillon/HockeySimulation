package dhl.training;

import dhl.leagueModel.headCoach.IHeadCoach;
import dhl.leagueModel.players.IPlayers;

import java.util.List;

public interface IPlayerTrainingCondition {
    public void receiveTraining(List<IPlayers> playerList, IHeadCoach headCoach);
}
