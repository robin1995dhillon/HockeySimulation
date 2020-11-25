package dhl.stateMachineNew;

import dhl.leagueModel.league.ILeague;

import java.text.ParseException;

public class AdvanceTimeState implements IStateMachine{

    StateMachine stateMachine;
    ITime leagueTimeConcept;

    public AdvanceTimeState(StateMachine stateMachine){
        this.stateMachine = stateMachine;
        leagueTimeConcept = new LeagueTimeConcept();
    }

    public void entry() throws ParseException {

        ILeague league = stateMachine.getLeague();
        String currentDate = league.getDate();
        league.setDate(leagueTimeConcept.nextDate(currentDate));
        doTask();

    }

    public IStateMachine doTask() {

        ILeague league = stateMachine.getLeague();
        String currentDate = league.getDate();
        String regularSeasonEndDate = league.getLastDateOfSeason();
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
