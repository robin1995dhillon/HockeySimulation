package dhl.stateMachineNew;

import dhl.leagueModel.gamePlayConfig.IGamePlayConfig;
import dhl.leagueModel.league.ILeague;
import dhl.leagueModel.teams.ITeam;
import dhl.mock.MockGamePlayConfig;


public class GameSimulation implements IGameSimulation {


    @Override
    public boolean simulateGame(ITeam firstTeam, ITeam opponentTeam, double firstTeamStrength, double opponentTeamStrength, ILeague league) {

        IGamePlayConfig config = MockGamePlayConfig.createMock();
        double randomWinChance = config.getGameResolver().getRandomWinChance(); //league.getGameplayConfig().getGameResolver().getRandomWinChance()[pass league from stateMachine, it will have all the values];
        boolean decisionReversed = false;
        if (Math.random() > randomWinChance) {
            decisionReversed = true;
        }

        for (ITeamStanding teamStanding : league.getTeamStandingList()) {

            if (teamStanding.getTeam().getTeamName().equalsIgnoreCase(firstTeam.getTeamName()) && firstTeamStrength > opponentTeamStrength) {

                if (decisionReversed) {

                    firstTeamLose(firstTeam, teamStanding);
                }
                else {

                    opponentTeamLose(opponentTeam, teamStanding);
                }

            }
            else if (teamStanding.getTeam().getTeamName().equalsIgnoreCase(firstTeam.getTeamName()) && firstTeamStrength < opponentTeamStrength) {
                if (decisionReversed) {

                    opponentTeamLose(opponentTeam, teamStanding);

                }
                else {

                    firstTeamLose(firstTeam, teamStanding);
                }
            }
            else if (teamStanding.getTeam().getTeamName().equalsIgnoreCase(opponentTeam.getTeamName()) && opponentTeamStrength > firstTeamStrength) {
                if (decisionReversed) {

                    opponentTeamLoseReverse(opponentTeam, teamStanding);
                }
                else {

                    firstTeamLoseReverse(firstTeam, teamStanding);
                }

            }
            else if (teamStanding.getTeam().getTeamName().equalsIgnoreCase(opponentTeam.getTeamName()) && opponentTeamStrength < firstTeamStrength) {
                if (decisionReversed) {

                    firstTeamLoseReverse(firstTeam, teamStanding);
                }
                else {

                    opponentTeamLoseReverse(opponentTeam, teamStanding);
                }
            }

        }
        return true;
    }

    public void opponentTeamLose(ITeam opponentTeam, ITeamStanding teamStanding) {
//        opponentTeam.setLossPoints(opponentTeam.getLossPoints() + 1);
        teamStanding.setGamesPlayed(teamStanding.getGamesPlayed() + 1);
        teamStanding.setGamesWon(teamStanding.getGamesWon() + 1);
        teamStanding.setTotalPoints(teamStanding.getTotalPoints() + 2);
    }

    public void firstTeamLose(ITeam firstTeam, ITeamStanding teamStanding) {
        firstTeam.setLossPoints(firstTeam.getLossPoints() + 1);
        teamStanding.setGamesPlayed(teamStanding.getGamesPlayed() + 1);
        teamStanding.setGamesLost(teamStanding.getGamesLost() + 1);
    }

    public void opponentTeamLoseReverse(ITeam opponentTeam, ITeamStanding teamStanding) {
        opponentTeam.setLossPoints(opponentTeam.getLossPoints() + 1);
        teamStanding.setGamesPlayed(teamStanding.getGamesPlayed() + 1);
        teamStanding.setGamesLost(teamStanding.getGamesLost() + 1);
    }

    public void firstTeamLoseReverse(ITeam firstTeam, ITeamStanding teamStanding) {
//        firstTeam.setLossPoints(firstTeam.getLossPoints() + 1);
        teamStanding.setGamesPlayed(teamStanding.getGamesPlayed() + 1);
        teamStanding.setGamesWon(teamStanding.getGamesWon() + 1);
        teamStanding.setTotalPoints(teamStanding.getTotalPoints() + 2);
    }


}
