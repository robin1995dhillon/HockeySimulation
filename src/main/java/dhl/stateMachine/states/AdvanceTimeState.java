package dhl.stateMachine.states;

import dhl.presentation.inputOutput.IUserOutput;
import dhl.presentation.inputOutput.InputOutputAbstractFactory;
import dhl.leagueModel.IConference;
import dhl.leagueModel.IDivision;
import dhl.leagueModel.ILeague;
import dhl.leagueModel.ITeam;
import dhl.stateMachine.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.ParseException;

public class AdvanceTimeState implements IStateMachine {
    private static final Logger logger = LogManager.getLogger(AdvanceTimeState.class);

    StateMachine stateMachine;
    ITime leagueTimeConcept;
    IUserOutput output;
    InputOutputAbstractFactory inputOutputAbstractFactory;
    StateMachineAbstractFactory stateMachineAbstractFactory;

    public AdvanceTimeState(StateMachine stateMachine){
        stateMachineAbstractFactory = StateMachineAbstractFactory.instance();
        inputOutputAbstractFactory = InputOutputAbstractFactory.instance();
        this.stateMachine = stateMachine;
        leagueTimeConcept = stateMachineAbstractFactory.getLeagueTimeConcept();
        output = inputOutputAbstractFactory.createUserOutput();
    }

    public IStateMachine entry() throws ParseException {
        ILeague league = stateMachine.getLeague();
        String currentDate = league.getDate();
        league.setDate(leagueTimeConcept.nextDate(currentDate));
        return doTask();
    }

    public IStateMachine doTask() {
        ISchedulerSeason scheduler = StateMachineAbstractFactory.instance().getSchedulerSeason();
        ILeague league = stateMachine.getLeague();
        String currentDate = league.getDate();
        logger.info("Today is " + currentDate);
        String regularSeasonEndDate = league.getLastDateOfSeason();
        String playerDraftDate = league.getPlayerDraftDate();
        if(currentDate.equalsIgnoreCase(regularSeasonEndDate)){
            getLeagueAverages(league);
            String playOffDay = scheduler.getFirstDayOfStanleyPlayoffs();
            String day  = playOffDay.split("-")[0];
            String month  = playOffDay.split("-")[1];
            String year = String.valueOf(stateMachine.getPlayoffsYear());
            playOffDay = day + "-" + month + "-" + year;
            stateMachine.getLeague().setDate(playOffDay);
            logger.info("Regular season is over. Playoff season will start on " + playOffDay);
//            return stateMachine.getGeneratePlayoffSchedule();
            return stateMachine.getPlayerDraft();
        }
        else if(currentDate.equals(playerDraftDate)) {
            return stateMachine.getPlayerDraft();
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
        output.setOutput("Goals per game: " + goals / 32 / 82);
        output.sendOutput();
        output.setOutput("Penalties per game: " + penalties / 32 / 82);
        output.sendOutput();
        output.setOutput("Shots: " + shots / 32 / 82);
        output.sendOutput();
        output.setOutput("Saves: " + saves / 32 / 82);
        output.sendOutput();
        logger.info("League average statistics(Goals, Penalties, Shots, Saves): " + goals/32/82 + ", " + penalties/32/82 + ", " + shots/32/82 + ", " + saves/32/82);
    }
}
