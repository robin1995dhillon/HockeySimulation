package dhl.stateMachineNew.states;

import dhl.inputOutput.IUserOutput;
import dhl.inputOutput.UserOutput;
import dhl.leagueModel.conference.IConference;
import dhl.leagueModel.division.IDivision;
import dhl.leagueModel.league.ILeague;
import dhl.leagueModel.teams.ITeam;
import dhl.stateMachineNew.IStateMachine;
import dhl.stateMachineNew.ITime;
import dhl.stateMachineNew.LeagueTimeConcept;
import dhl.stateMachineNew.StateMachine;

import java.text.ParseException;

public class AdvanceTimeState implements IStateMachine {

    StateMachine stateMachine;
    ITime leagueTimeConcept;
    IUserOutput output;

    public AdvanceTimeState(StateMachine stateMachine){
        this.stateMachine = stateMachine;
        leagueTimeConcept = new LeagueTimeConcept();
        output = new UserOutput();
    }

    public IStateMachine entry() throws ParseException {
        System.out.println("We are in Advance Time State");
        ILeague league = stateMachine.getLeague();
        String currentDate = league.getDate();
        league.setDate(leagueTimeConcept.nextDate(currentDate));
        return doTask();
    }

    public IStateMachine doTask() {

        ILeague league = stateMachine.getLeague();
        String currentDate = league.getDate();
        String regularSeasonEndDate = league.getLastDateOfSeason();
        if(currentDate.equalsIgnoreCase(regularSeasonEndDate)){
            getLeagueAverages(league);
            return stateMachine.getGeneratePlayoffSchedule();
        }
        else{
            return stateMachine.getTraining();
        }
    }

    public void exit() {

    }

    public void getLeagueAverages(ILeague league){
        double goals = 0;
        double penalties = 0;
        double shots = 0;
        double saves = 0;
        for(IConference conference: league.getConferences()){
            for(IDivision division: conference.getDivisions()){
                for(ITeam team: division.getTeams()){
                    goals += team.getGoals();
                    penalties += team.getPenalties();
                    shots += team.getShots();
                    saves += team.getSaves();
                    team.setGoals(0);
                    team.setPenalties(0);
                    team.setShots(0);
                    team.setSaves(0);
                }
            }
        }
        output.setOutput("Goals per game: " + goals);
        output.sendOutput();
        output.setOutput("Penalties per game: " + penalties);
        output.sendOutput();
        output.setOutput("Shots: " + shots);
        output.sendOutput();
        output.setOutput("Saves: " + saves);
        output.sendOutput();
    }
}
