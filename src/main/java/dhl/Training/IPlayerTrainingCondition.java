package dhl.Training;

import dhl.LeagueModel.IHeadCoach;
import dhl.LeagueModel.IPlayers;

import java.util.ArrayList;

public interface IPlayerTrainingCondition {
    public void receiveTraining(ArrayList<IPlayers> playerList, IHeadCoach headCoach);
}
