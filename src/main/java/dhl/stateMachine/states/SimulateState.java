package dhl.stateMachine.states;

import dhl.Configurables;
import dhl.presentation.inputOutput.IUserOutput;
import dhl.presentation.inputOutput.InputOutputAbstractFactory;
import dhl.leagueModel.ILeague;
import dhl.leagueModel.ITeam;
import dhl.stateMachine.*;
import dhl.stateMachine.gameSimulationAlgorithm.IGameSimulation;
import dhl.stateMachine.gameSimulationAlgorithm.IGameSimulationAlgorithm;
import dhl.stateMachine.gameSimulationAlgorithm.IShiftTime;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class SimulateState implements IStateMachine {
    private static final Logger logger = LogManager.getLogger(SimulateState.class);

    StateMachine machine;
    IUserOutput output;
    ISchedulerSeason season;
    StateMachineAbstractFactory abstractFactory;
    InputOutputAbstractFactory inputOutputAbstractFactory;

    public SimulateState(StateMachine stateMachine) {
        inputOutputAbstractFactory = InputOutputAbstractFactory.instance();
        this.machine = stateMachine;
        output = inputOutputAbstractFactory.createUserOutput();
        abstractFactory = StateMachineAbstractFactory.instance();
        season = abstractFactory.getSchedulerSeason();
    }

    public IStateMachine entry() throws Exception {

        return doTask();
    }

    public IStateMachine doTask() throws Exception {

        ILeague league = machine.getLeague();
        int count = 0;
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
            }
        }
        machine.setTeamsForInjuryCheck(teamsInjuryCheck);
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
