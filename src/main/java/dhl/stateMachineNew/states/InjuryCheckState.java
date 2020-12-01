package dhl.stateMachineNew.states;

import dhl.Configurables;
import dhl.leagueModel.IPlayers;
import dhl.leagueModel.ITeam;
import dhl.stateMachineNew.ISchedulerSeason;
import dhl.stateMachineNew.IStateMachine;
import dhl.stateMachineNew.StateMachine;

import java.util.List;

public class InjuryCheckState implements IStateMachine {

    StateMachine machine;
    List<ITeam> checkInjuryTeam;

    public InjuryCheckState(StateMachine machine) {
        this.machine = machine;

    }

    public IStateMachine entry() {
        System.out.println("We are in Injury Check State");
        this.checkInjuryTeam = this.machine.getTeamsForInjuryCheck();
        for (ITeam team : checkInjuryTeam) {
            System.out.println("Injury Check for " + team.getTeamName());
            for (IPlayers player : team.getPlayers()) {
                player.checkForPlayerInjury(machine.getLeague().getGameplayConfig());
            }
        }

        return doTask();
    }

    public IStateMachine doTask() {
        for (ISchedulerSeason schedule : machine.getLeague().getGameSchedules()) {
            if (schedule.getStatus().equalsIgnoreCase(Configurables.SCHEDULED.getAction()) && machine.getLeague().getDate().equalsIgnoreCase(schedule.getDateOfMatch())) {
                System.out.println(schedule.getFirstTeam().getTeamName());
                System.out.println(schedule.getSecondTeam().getTeamName());
                return machine.getSimulate();
            }
        }
        return null;
    }

    public void exit() {

    }
}
