package dhl.stateMachineNew.gameSimulationAlgorithm;

import dhl.stateMachineNew.ITeamStanding;
import dhl.stateMachineNew.TeamStandings;
import dhl.leagueModel.ILeague;
import dhl.leagueModel.IPlayers;
import dhl.leagueModel.ITeam;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class GameSimulation implements IGameSimulation {
    private static final Logger logger = LogManager.getLogger(GameSimulation.class);

    @Override
    public void simulateGame(ITeam offensiveTeam, ITeam defendingTeam, ILeague league, IGameSimulationAlgorithm algorithm, IShiftTime shiftTime) {

        double offensiveGoals = 0;
        double defendingGoals = 0;
        algorithm.setPenaltyChance(0.025);
        algorithm.setSaveChance(0.907);
        algorithm.setShotChance(0.433);
        algorithm.setSaveCoefficientOne(0.001);
        algorithm.setSaveCoefficientTwo(0.001);
        algorithm.setShotCoefficientOne(0.001);
        algorithm.setShotCoefficientTwo(-0.00275);
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
            logger.info("Game between " + offensiveTeam.getTeamName() + " and " + defendingTeam.getTeamName() + " is over. " + offensiveTeam.getTeamName() + "won.");
        }
        else if(offensiveGoals < defendingGoals){
            teamWin(defendingTeam, offensiveTeamStanding);
            teamLost(offensiveTeam, defendingTeamStanding);
            logger.info("Game between " + offensiveTeam.getTeamName() + " and " + defendingTeam.getTeamName() + " is over. " + defendingTeam.getTeamName() + "won.");
        }
        else{
            teamDraw(offensiveTeam, offensiveTeamStanding);
            teamDraw(defendingTeam, defendingTeamStanding);
            logger.info("Game between " + offensiveTeam.getTeamName() + " and " + defendingTeam.getTeamName() + " is over. The two teams drew.");
        }
        algorithm.resetAlgorithm(0.04,0.907,0.433);
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
