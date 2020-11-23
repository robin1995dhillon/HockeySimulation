package dhl.stateMachineNew;

import dhl.leagueModel.league.ILeague;

import java.text.ParseException;

public class AdvanceTimeState implements IStateMachine{

    StateMachine stateMachine;
    ITime leagueTimeConcept;
    ISchedulerSeason season;

    public AdvanceTimeState(StateMachine stateMachine){
        this.stateMachine = stateMachine;
        leagueTimeConcept = new LeagueTimeConcept();
        season = new SchedulerSeason();
    }

    public void entry() throws ParseException {

        ILeague league = stateMachine.getLeague();
        String currentDate = league.getDate();
        league.setDate(leagueTimeConcept.nextDate(currentDate));

    }

    public IStateMachine doTask() {

        ILeague league = stateMachine.getLeague();
        String currentDate = league.getDate();
        String regularSeasonEndDate = season.getLastDayOfSeason();
        if(currentDate.equalsIgnoreCase(regularSeasonEndDate)){

            return stateMachine.getGeneratePlayoffSchedule();
        }
        else{
            return stateMachine.getTraining();
        }
    }

    public void exit() {

    }
}
