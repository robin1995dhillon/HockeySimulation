package dhl.gameSimulationAlgorithm;


import dhl.leagueModel.players.IPlayers;
import dhl.leagueModel.teams.ITeam;

import java.util.List;

public class ShiftTime implements IShiftTime{
    private IGameSimulationAlgorithm algorithm;

    public ShiftTime(IGameSimulationAlgorithm algorithm){
        this.algorithm = algorithm;
    }

    public void oneShot(List<IPlayers> playersListOne, List<IPlayers> playersListTwo){
        IPlayers forward = algorithm.shots(playersListOne, playersListTwo);
        IPlayers goalie = algorithm.getGoalie(playersListTwo);
        algorithm.saves(goalie, forward);
    }

    public void oneShift(ITeam teamOne, ITeam teamTwo){
        List<IPlayers> playersListOne = algorithm.getPlayerForShift(teamOne);
        List<IPlayers> playersListTwo = algorithm.getPlayerForShift(teamTwo);
        for(int i = 0; i < 2; i++){
            oneShot(playersListOne, playersListTwo);
            oneShot(playersListTwo, playersListOne);
        }
    }

    @Override
    public void oneGame(ITeam teamOne, ITeam teamTwo){
        for(int i = 0; i < 36; i++){
            oneShift(teamOne, teamTwo);
        }
        System.out.print(teamOne.getTeamName() + ": Goals: " + algorithm.getGoals(teamOne) + "\tPenalties: " + algorithm.getPenalties(teamOne));
        System.out.println("\tShots: " + algorithm.getShots(teamOne) + "\tSaves: " + algorithm.getSaves(teamOne));
        System.out.print(teamTwo.getTeamName() + ": Goals: " + algorithm.getGoals(teamTwo) + "\tPenalties: " + algorithm.getPenalties(teamTwo));
        System.out.println("\tShots: " + algorithm.getShots(teamTwo) + "\tSaves: " + algorithm.getSaves(teamTwo));
    }
}
