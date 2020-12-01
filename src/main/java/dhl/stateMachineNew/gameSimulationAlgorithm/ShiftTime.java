package dhl.stateMachineNew.gameSimulationAlgorithm;


import dhl.inputOutput.IUserOutput;
import dhl.inputOutput.UserOutput;
import dhl.leagueModel.IPlayers;
import dhl.leagueModel.ITeam;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ShiftTime implements IShiftTime{
    private static final Logger logger = LogManager.getLogger(ShiftTime.class);
    private IGameSimulationAlgorithm algorithm;
    private IUserOutput output;

    public ShiftTime(){
        this.output = new UserOutput();
    }

    public void oneShot(List<IPlayers> playersListOne, List<IPlayers> playersListTwo){
        IPlayers forward = algorithm.shots(playersListOne, playersListTwo);
        IPlayers goalie = algorithm.getGoalie(playersListTwo);
//        System.out.println("Goalie Name is" + goalie.getPlayerName());
        if(forward == null){
            return;
        }
        algorithm.saves(goalie, forward);
    }

    public void oneShift(ITeam teamOne, ITeam teamTwo){
        List<IPlayers> playersListOne = algorithm.getPlayerForShift(teamOne);
        List<IPlayers> playersListTwo = algorithm.getPlayerForShift(teamTwo);
        for(int i = 0; i < 2; i++){
            oneShot(playersListOne, playersListTwo);
            oneShot(playersListTwo, playersListOne);
        }
        for(IPlayers player : playersListOne){
            player.setShifts(player.getShifts() + 1);
        }
        for(IPlayers player : playersListTwo){
            player.setShifts(player.getShifts() + 1);
        }
    }

    @Override
    public void oneGame(ITeam teamOne, ITeam teamTwo){
        for(int i = 0; i < 36; i++){
            oneShift(teamOne, teamTwo);
        }
//        output.setOutput(teamOne.getTeamName() + ": Goals: " + algorithm.getGoals(teamOne) + "\tPenalties: " + algorithm.getPenalties(teamOne) + "\tShots: " + algorithm.getShots(teamOne) + "\tSaves: " + algorithm.getSaves(teamOne));
//        output.sendOutput();
//        output.setOutput(teamTwo.getTeamName() + ": Goals: " + algorithm.getGoals(teamTwo) + "\tPenalties: " + algorithm.getPenalties(teamTwo) + "\tShots: " + algorithm.getShots(teamTwo) + "\tSaves: " + algorithm.getSaves(teamTwo));
//        output.sendOutput();
        logger.info(teamOne.getTeamName() + ": Goals: " + algorithm.getGoals(teamOne) + "\tPenalties: " + algorithm.getPenalties(teamOne) + "\tShots: " + algorithm.getShots(teamOne) + "\tSaves: " + algorithm.getSaves(teamOne));
        logger.info(teamTwo.getTeamName() + ": Goals: " + algorithm.getGoals(teamTwo) + "\tPenalties: " + algorithm.getPenalties(teamTwo) + "\tShots: " + algorithm.getShots(teamTwo) + "\tSaves: " + algorithm.getSaves(teamTwo));
        algorithm.getTeamStatistic(teamOne);
        algorithm.getTeamStatistic(teamTwo);
    }

    @Override
    public void setAlgorithm(IGameSimulationAlgorithm algorithm) {
        this.algorithm = algorithm;
    }
}
