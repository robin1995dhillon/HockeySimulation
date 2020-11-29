package dhl.leagueModel;

import dhl.leagueModel.headCoach.IHeadCoach;
import dhl.leagueModel.IPlayers;

import java.util.List;

public interface IPlayerTrainingCondition {
    public void receiveTraining(List<IPlayers> playerList, IHeadCoach headCoach);
}
