package dhl.stateMachineNew;

import dhl.Configurables;
import dhl.leagueModel.IPlayers;
import dhl.leagueModel.teams.ITeam;

import java.util.List;

public class InjuryCheckState implements IStateMachine{

    StateMachine machine;
    List<ITeam> checkInjuryTeam;

    public InjuryCheckState(StateMachine machine, List<ITeam> checkInjury){
        this.machine = machine;
        this.checkInjuryTeam = checkInjury;
    }

    public void entry() {
        for(ITeam team : checkInjuryTeam){
            for(IPlayers player : team.getPlayers()){
                player.checkForPlayerInjury();
            }
        }
        doTask();

    }

    public IStateMachine doTask() {
        for(ISchedulerSeason schedule : machine.getLeague().getGameSchedules()){
            if(schedule.getStatus().equalsIgnoreCase(Configurables.SCHEDULED.getAction())){
                return machine.getSimulate();
            }
        }

        return null;
    }

    public void exit() {

    }
}
