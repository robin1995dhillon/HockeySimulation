package dhl.stateMachineNew;

import dhl.Configurables;
import dhl.inputOutput.IUserOutput;
import dhl.inputOutput.UserOutput;
import dhl.leagueModel.league.ILeague;
import dhl.leagueModel.teams.ITeam;

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

    public void entry() {

    }

    public IStateMachine doTask() throws ParseException {

        ILeague league = machine.getLeague();
        List<ITeam> teamsInjuryCheck = new ArrayList<>();
        IGameSimulation simulate = new GameSimulation();

        for (ISchedulerSeason scheduler : league.getGameSchedules()) {
            String currentDate = league.getDate();
            String dateOfMatch = scheduler.getDateOfMatch();
            if (currentDate.equalsIgnoreCase(dateOfMatch) && scheduler.getStatus().equals(Configurables.SCHEDULED.getAction())) {
                simulate.simulateGame(scheduler.getFirstTeam(), scheduler.getSecondTeam(), scheduler.getFirstTeam().getTeamStrength(),
                        scheduler.getSecondTeam().getTeamStrength(), league);
                scheduler.setStatus(Configurables.PLAYED.getAction());
                teamsInjuryCheck.add(scheduler.getFirstTeam());
                teamsInjuryCheck.add(scheduler.getSecondTeam());
                machine.setTeamsForInjuryCheck(teamsInjuryCheck);
            }
        }
        if (teamsInjuryCheck != null) {
            machine.setCurrentState(machine.getInjuryCheck());
            machine.getCurrentState().entry();
        } else {
            output.setOutput("injury check list is empty");
            output.sendOutput();
        }

        String currentDate = league.getDate();
        boolean isLastDayOfTrade = season.isLastDayOfTrade(currentDate);
        if (isLastDayOfTrade) {

            return machine.getExecuteTrades();
        } else {

            return machine.getAging();
        }

    }

    public void exit() {

    }
}
