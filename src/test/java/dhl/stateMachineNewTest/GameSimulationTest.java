package dhl.stateMachineNewTest;

import dhl.leagueModel.teams.ITeam;
import dhl.mock.MockStandingTeam;
import dhl.mock.MockTeam;
import dhl.stateMachineNew.ITeamStanding;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GameSimulationTest {

    @Test
    public void simulateGame() {

        double randomWinChance = 0.66;
        List<ITeamStanding> listStanding;
        listStanding = MockStandingTeam.createTeamStandingMock();
        ITeam first = listStanding.get(1).getTeam();
        ITeam  second = listStanding.get(0).getTeam();

        ITeam firstTeam = MockTeam.MockTeam();
        ITeam opponentTeam = MockTeam.MockTeamTwo();

//        System.out.println(first.getTeamName());
//        System.out.println(firstTeam.getTeamName());
//        System.out.println(second.getTeamName());
//        System.out.println(opponentTeam.getTeamName());
//        System.out.println("**********************************************");


        double random = 0.76;
        System.out.println(random);
        System.out.println(firstTeam.getTeamName());
        System.out.println(opponentTeam.getTeamName());
        System.out.println(opponentTeam.getTeamStrength());
        System.out.println(firstTeam.getTeamStrength());


        double firstTeamStrength = firstTeam.getTeamStrength();
        double opponentTeamStrength = opponentTeam.getTeamStrength();
        boolean decisionReversed = false;

        if(random > randomWinChance){
            decisionReversed = true;
        }

        for(ITeamStanding teamStanding : listStanding){

            if(teamStanding.getTeam().getTeamName().equalsIgnoreCase(firstTeam.getTeamName()) && firstTeamStrength > opponentTeamStrength){
                if(decisionReversed){
                    firstTeam.setLossPoints(firstTeam.getLossPoints()+1);
                    teamStanding.setGamesPlayed(teamStanding.getGamesPlayed()+1);
                    teamStanding.setGamesLost(teamStanding.getGamesLost()+1);
                   // firstTeamLose(firstTeam, teamStanding);
                }
                else{
               //     opponentTeam.setLossPoints(opponentTeam.getLossPoints()+1); //testing lyi chaddeya
                    teamStanding.setGamesPlayed(teamStanding.getGamesPlayed()+1);
                    teamStanding.setGamesWon(teamStanding.getGamesWon()+1);
                    teamStanding.setTotalPoints(teamStanding.getTotalPoints()+2);
                   // opponentTeamLose(opponentTeam,teamStanding);
                }

            }
            else if(teamStanding.getTeam().getTeamName().equalsIgnoreCase(firstTeam.getTeamName()) && firstTeamStrength < opponentTeamStrength) {
                if (decisionReversed) {
                 ///   opponentTeam.setLossPoints(opponentTeam.getLossPoints()+1);  //testing lyi chaddeya
                    teamStanding.setGamesPlayed(teamStanding.getGamesPlayed()+1);
                    teamStanding.setGamesWon(teamStanding.getGamesWon()+1);
                    teamStanding.setTotalPoints(teamStanding.getTotalPoints()+2);
//                    opponentTeamLose(opponentTeam,teamStanding);

                } else {
                    firstTeam.setLossPoints(firstTeam.getLossPoints() + 1);
                    teamStanding.setGamesPlayed(teamStanding.getGamesPlayed() + 1);
                    teamStanding.setGamesLost(teamStanding.getGamesLost() + 1);
//                    firstTeamLose(firstTeam, teamStanding);
                }
            }
            else if(teamStanding.getTeam().getTeamName().equalsIgnoreCase(opponentTeam.getTeamName()) && opponentTeamStrength > firstTeamStrength){
                if(decisionReversed){
                    opponentTeam.setLossPoints(opponentTeam.getLossPoints()+1);
                    teamStanding.setGamesPlayed(teamStanding.getGamesPlayed()+1);
                    teamStanding.setGamesLost(teamStanding.getGamesLost()+1);
//                    opponentTeamLoseReverse(opponentTeam,teamStanding);
                }
                else{
                //    firstTeam.setLossPoints(firstTeam.getLossPoints()+1); // hatake dekh
                    teamStanding.setGamesPlayed(teamStanding.getGamesPlayed()+1);
                    teamStanding.setGamesWon(teamStanding.getGamesWon()+1);
                    teamStanding.setTotalPoints(teamStanding.getTotalPoints()+2);
//                    firstTeamLoseReverse(firstTeam, teamStanding);
                }

            }
            else if(teamStanding.getTeam().getTeamName().equalsIgnoreCase(opponentTeam.getTeamName()) && opponentTeamStrength < firstTeamStrength){
                if(decisionReversed){
                //    firstTeam.setLossPoints(firstTeam.getLossPoints()+1);
                    teamStanding.setGamesPlayed(teamStanding.getGamesPlayed()+1);
                    teamStanding.setGamesWon(teamStanding.getGamesWon()+1);
                    teamStanding.setTotalPoints(teamStanding.getTotalPoints()+2);
//                    firstTeamLoseReverse(firstTeam, teamStanding);
                }
                else{
                    opponentTeam.setLossPoints(opponentTeam.getLossPoints()+1);
                    teamStanding.setGamesPlayed(teamStanding.getGamesPlayed()+1);
                    teamStanding.setGamesLost(teamStanding.getGamesLost()+1);
                    //  opponentTeamLoseReverse(opponentTeam,teamStanding);
                }
            }

            System.out.println(teamStanding.getTeam().getTeamName()+" "+teamStanding.getTotalPoints()+" "+teamStanding.getGamesPlayed()
            +" "+teamStanding.getGamesWon()+" "+teamStanding.getGamesLost()+" "+teamStanding.getTeam().getLossPoints());


        }
        System.out.println("randomm loss points : "+firstTeam.getLossPoints());
        System.out.println("team2 loss points : "+opponentTeam.getLossPoints());
        System.out.println(listStanding.get(0).getTeam().getTeamName()+" "+listStanding.get(0).getGamesLost());
        System.out.println(listStanding.get(1).getTeam().getTeamName()+" "+listStanding.get(1).getGamesLost());

    }

    public void opponentTeamLose(ITeam opponentTeam, ITeamStanding teamStanding){
//        opponentTeam.setLossPoints(opponentTeam.getLossPoints()+1);
        teamStanding.setGamesPlayed(teamStanding.getGamesPlayed()+1);
        teamStanding.setGamesWon(teamStanding.getGamesWon()+1);
        teamStanding.setTotalPoints(teamStanding.getTotalPoints()+2);
    }

    public void firstTeamLose(ITeam firstTeam, ITeamStanding teamStanding){
        firstTeam.setLossPoints(firstTeam.getLossPoints() + 1);
        teamStanding.setGamesPlayed(teamStanding.getGamesPlayed() + 1);
        teamStanding.setGamesLost(teamStanding.getGamesLost() + 1);
    }

    public void opponentTeamLoseReverse(ITeam opponentTeam, ITeamStanding teamStanding){
        opponentTeam.setLossPoints(opponentTeam.getLossPoints()+1);
        teamStanding.setGamesPlayed(teamStanding.getGamesPlayed()+1);
        teamStanding.setGamesLost(teamStanding.getGamesLost()+1);
    }

    public void firstTeamLoseReverse(ITeam firstTeam, ITeamStanding teamStanding){
//        firstTeam.setLossPoints(firstTeam.getLossPoints()+1);
        teamStanding.setGamesPlayed(teamStanding.getGamesPlayed()+1);
        teamStanding.setGamesWon(teamStanding.getGamesWon()+1);
        teamStanding.setTotalPoints(teamStanding.getTotalPoints()+2);
    }

}
