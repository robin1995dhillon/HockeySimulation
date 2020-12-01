package dhl.stateMachine.states;

import dhl.Configurables;
import dhl.leagueModel.IPlayers;
import dhl.leagueModel.ITeam;
import dhl.presentation.inputOutput.IUserOutput;
import dhl.presentation.inputOutput.InputOutputAbstractFactory;
import dhl.stateMachine.ISchedulerSeason;
import dhl.stateMachine.IStateMachine;
import dhl.stateMachine.StateMachine;

import java.util.List;

public class InjuryCheckState implements IStateMachine {

    StateMachine machine;
    List<ITeam> checkInjuryTeam;
    InputOutputAbstractFactory inputOutputAbstractFactory;
    IUserOutput userOutput;

    public InjuryCheckState(StateMachine machine) {
        inputOutputAbstractFactory = InputOutputAbstractFactory.instance();
        userOutput = inputOutputAbstractFactory.createUserOutput();
        this.machine = machine;
    }

    public IStateMachine entry() {
        this.checkInjuryTeam = this.machine.getTeamsForInjuryCheck();
        for (ITeam team : checkInjuryTeam) {
            userOutput.setOutput("Injury Check for " + team.getTeamName());
            userOutput.sendOutput();
            for (IPlayers player : team.getPlayers()) {
                player.checkForPlayerInjury(machine.getLeague().getGameplayConfig());
            }
        }
        return doTask();
    }

    public IStateMachine doTask() {
        for (ISchedulerSeason schedule : machine.getLeague().getGameSchedules()) {
            if (schedule.getStatus().equalsIgnoreCase(Configurables.SCHEDULED.getAction()) && machine.getLeague().getDate().equalsIgnoreCase(schedule.getDateOfMatch())) {
                return machine.getSimulate();
            }
        }
        return null;
    }

    public void exit() {

    }
}
