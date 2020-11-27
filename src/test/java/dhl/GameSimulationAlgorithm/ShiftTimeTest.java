package dhl.GameSimulationAlgorithm;

import dhl.gameSimulationAlgorithm.GameSimulationAlgorithm;
import dhl.gameSimulationAlgorithm.IGameSimulationAlgorithm;
import dhl.gameSimulationAlgorithm.IShiftTime;
import dhl.gameSimulationAlgorithm.ShiftTime;
import dhl.leagueModel.players.IPlayers;
import dhl.leagueModel.teams.ITeam;
import dhl.mock.MockPlayer;
import dhl.mock.MockTeam;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShiftTimeTest {
    IGameSimulationAlgorithm algorithm = new GameSimulationAlgorithm(0.05, 0.5, 0.5);
    IShiftTime shiftTime = new ShiftTime();

    @Test
    public void oneGameTest(){
        algorithm.setSaveCoefficientOne(0);
        algorithm.setSaveCoefficientTwo(0.015);
        algorithm.setShotCoefficientOne(0.1);
        algorithm.setShotCoefficientTwo(-0.001);
        shiftTime.setAlgorithm(algorithm);
        ITeam teamOne = MockTeam.MockOffensiveTeam();
        ITeam teamTwo = MockTeam.MockDefendingTeam();
        shiftTime.oneGame(teamOne, teamTwo);

//        System.out.print(teamOne.getTeamName() + ": Goals: " + teamOne.getGoals() + "\tPenalties: " + teamOne.getPenalties());
//        System.out.println("\tShots: " + teamOne.getShots() + "\tSaves: " + teamOne.getSaves());
//        System.out.print(teamTwo.getTeamName() + ": Goals: " + teamTwo.getGoals() + "\tPenalties: " + teamTwo.getPenalties());
//        System.out.println("\tShots: " + teamTwo.getShots() + "\tSaves: " + teamTwo.getSaves());

    }

}
