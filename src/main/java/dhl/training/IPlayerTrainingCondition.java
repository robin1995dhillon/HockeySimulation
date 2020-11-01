package dhl.training;

import dhl.leagueModel.IHeadCoach;
import dhl.leagueModel.IPlayers;

import java.util.ArrayList;

public interface IPlayerTrainingCondition {
    public void receiveTraining(ArrayList<IPlayers> playerList, IHeadCoach headCoach);
}
