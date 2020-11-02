package dhl.training;

import dhl.leagueModel.headCoach.IHeadCoach;
import dhl.leagueModel.players.IPlayers;

import java.util.ArrayList;

public interface IPlayerTrainingCondition {
    public void receiveTraining(ArrayList<IPlayers> playerList, IHeadCoach headCoach);
}
