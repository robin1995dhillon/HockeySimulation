package dhl.stateMachineNew;

import dhl.gameSimulationAlgorithm.IGameSimulationAlgorithm;
import dhl.gameSimulationAlgorithm.IShiftTime;
import dhl.leagueModel.league.ILeague;
import dhl.leagueModel.IPlayers;
import dhl.leagueModel.teams.ITeam;


public class GameSimulation implements IGameSimulation {


    @Override
    public void simulateGame(ITeam offensiveTeam, ITeam defendingTeam, ILeague league, IGameSimulationAlgorithm algorithm, IShiftTime shiftTime) {

        double offensiveGoals = 0;
        double defendingGoals = 0;
        algorithm.setPenaltyChance(0.05);
        algorithm.setShotChance(0.3);
        algorithm.setSaveChance(0.5);
        algorithm.setSaveCoefficientOne(0.05);
        algorithm.setSaveCoefficientTwo(0.05);
        algorithm.setShotCoefficientOne(0.3);
        algorithm.setShotCoefficientTwo(0.05);
        shiftTime.setAlgorithm(algorithm);
        ITeamStanding offensiveTeamStanding = new TeamStandings();
        ITeamStanding defendingTeamStanding = new TeamStandings();

        for(ITeamStanding teamStanding : league.getTeamStandingList()){
            if(teamStanding.getTeam().getTeamName().equals(offensiveTeam.getTeamName())){
                offensiveTeamStanding = teamStanding;
            }
            if(teamStanding.getTeam().getTeamName().equals(defendingTeam.getTeamName())){
                defendingTeamStanding = teamStanding;
            }
        }

        shiftTime.oneGame(offensiveTeam, defendingTeam);
        for(IPlayers player : offensiveTeam.getPlayers()){
            offensiveGoals += player.getGoals();
        }
        for(IPlayers player : defendingTeam.getPlayers()){
            defendingGoals += player.getGoals();
        }
        if(offensiveGoals > defendingGoals){
            teamWin(offensiveTeam, offensiveTeamStanding);
            teamLost(defendingTeam, defendingTeamStanding);
        }
        else if(offensiveGoals < defendingGoals){
            teamWin(defendingTeam, offensiveTeamStanding);
            teamLost(offensiveTeam, defendingTeamStanding);
        }
        else{
            teamDraw(offensiveTeam, offensiveTeamStanding);
            teamDraw(defendingTeam, defendingTeamStanding);
        }
        algorithm.resetAlgorithm(0.05,0.2,0.5);
        algorithm.reset(offensiveTeam);
        algorithm.reset(defendingTeam);
    }

    public void teamWin(ITeam team, ITeamStanding teamStanding){
        teamStanding.setGamesPlayed(teamStanding.getGamesPlayed() + 1);
        teamStanding.setGamesWon(teamStanding.getGamesWon() + 1);
        teamStanding.setTotalPoints(teamStanding.getTotalPoints() + 2);
    }

    public void teamLost(ITeam team, ITeamStanding teamStanding){
        teamStanding.setGamesPlayed(teamStanding.getGamesPlayed() + 1);
        team.setLossPoints(team.getLossPoints() + 1);
    }

    public void teamDraw(ITeam team, ITeamStanding teamStanding){
        teamStanding.setGamesPlayed(teamStanding.getGamesPlayed() + 1);
        teamStanding.setTotalPoints(teamStanding.getTotalPoints() + 1);
    }
}
