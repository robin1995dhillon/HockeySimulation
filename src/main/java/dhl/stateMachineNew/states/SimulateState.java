package dhl.stateMachineNew.states;

import dhl.Configurables;
import dhl.stateMachineNew.gameSimulationAlgorithm.*;
import dhl.inputOutput.IUserOutput;
import dhl.inputOutput.UserOutput;
import dhl.leagueModel.league.ILeague;
import dhl.leagueModel.teams.ITeam;
import dhl.stateMachineNew.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class SimulateState implements IStateMachine {

    StateMachine machine;
    IUserOutput output;
    ISchedulerSeason season;
    StateMachineAbstractFactory abstractFactory;

    public SimulateState(StateMachine stateMachine) {

        this.machine = stateMachine;
        output = new UserOutput();
        season = new SchedulerSeason();
        abstractFactory = StateMachineAbstractFactory.instance();
    }

    public IStateMachine entry() throws ParseException {
        System.out.println("We are in Simulate State");

        return doTask();
    }

    public IStateMachine doTask() throws ParseException {

        ILeague league = machine.getLeague();
        int count = 0; //remove it
        List<ITeam> teamsInjuryCheck = new ArrayList<>();
        IGameSimulation simulate = abstractFactory.getGameSimulation();
        IGameSimulationAlgorithm algorithm = abstractFactory.getGameSimulationAlgorithm();
        IShiftTime shiftTime = abstractFactory.getShiftTime();

        for (ISchedulerSeason scheduler : league.getGameSchedules()) {
            String currentDate = league.getDate();
            String dateOfMatch = scheduler.getDateOfMatch();
            if (currentDate.equalsIgnoreCase(dateOfMatch) && scheduler.getStatus().equals(Configurables.SCHEDULED.getAction())) {
                simulate.simulateGame(scheduler.getFirstTeam(), scheduler.getSecondTeam(), league, algorithm, shiftTime);
                scheduler.setStatus(Configurables.PLAYED.getAction());
                teamsInjuryCheck.add(scheduler.getFirstTeam());
                teamsInjuryCheck.add(scheduler.getSecondTeam());
                count++;
              //  machine.setTeamsForInjuryCheck(teamsInjuryCheck);
            }
        }
        System.out.println(teamsInjuryCheck);
        System.out.println("count of matches played = " + count);
        machine.setTeamsForInjuryCheck(teamsInjuryCheck);
        System.out.println(teamsInjuryCheck.get(0).getTeamName() + "-----team injury check");
        if (teamsInjuryCheck == null) {
            output.setOutput("injury check list is empty");
            output.sendOutput();

        } else {
            int counter = 0;
            for (ISchedulerSeason scheduler : league.getGameSchedules()) {

                if(scheduler.getStatus().equalsIgnoreCase(Configurables.PLAYED.getAction())){
                    counter++;
                }
            }
            System.out.println("playedddddd "+counter);
            machine.setCurrentState(machine.getInjuryCheck());
            IStateMachine state = machine.getCurrentState().entry();
            if(state == machine.getSimulate()){
                machine.setCurrentState(machine.getSimulate());
                machine.getCurrentState().entry();
            }
        }

        String currentDate = league.getDate();
        boolean isLastDayOfTrade = season.isLastDayOfTrade(currentDate, machine.getPlayoffsYear());
        if (isLastDayOfTrade) {
            return machine.getAging();
        } else {
            return machine.getExecuteTrades();
        }

    }

    public void exit() {

    }
}
