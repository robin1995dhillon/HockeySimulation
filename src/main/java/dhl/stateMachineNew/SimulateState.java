package dhl.stateMachineNew;

import dhl.Configurables;
import dhl.gameSimulationAlgorithm.GameSimulationAlgorithm;
import dhl.gameSimulationAlgorithm.IGameSimulationAlgorithm;
import dhl.gameSimulationAlgorithm.IShiftTime;
import dhl.gameSimulationAlgorithm.ShiftTime;
import dhl.inputOutput.IUserOutput;
import dhl.inputOutput.UserOutput;
import dhl.leagueModel.league.ILeague;
import dhl.leagueModel.teams.ITeam;
import dhl.simulationStateMachine.IState;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class SimulateState implements IStateMachine {

    StateMachine machine;
    IUserOutput output;
    ISchedulerSeason season;

    public SimulateState(StateMachine stateMachine) {

        this.machine = stateMachine;
        output = new UserOutput();
        season = new SchedulerSeason();

    }

    public IStateMachine entry() throws ParseException {


        return doTask();
    }

    public IStateMachine doTask() throws ParseException {

        ILeague league = machine.getLeague();
        int count = 0; //remove it
        List<ITeam> teamsInjuryCheck = new ArrayList<>();
        IGameSimulation simulate = new GameSimulation();
        IGameSimulationAlgorithm algorithm = new GameSimulationAlgorithm();
        IShiftTime shiftTime = new ShiftTime();

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
        System.out.println("count of matches played = "+count);
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
            return machine.getExecuteTrades();

        } else {


            return machine.getAging();
        }
//interchange above states when final
    }

    public void exit() {

    }
}
