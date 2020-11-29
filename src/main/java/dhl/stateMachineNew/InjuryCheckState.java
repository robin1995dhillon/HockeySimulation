package dhl.stateMachineNew;

import dhl.Configurables;
import dhl.leagueModel.IPlayers;
import dhl.leagueModel.gamePlayConfig.IGamePlayConfig;
import dhl.leagueModel.teams.ITeam;

import java.util.List;

public class InjuryCheckState implements IStateMachine {

    StateMachine machine;
    List<ITeam> checkInjuryTeam;

    //    public InjuryCheckState(StateMachine machine, List<ITeam> checkInjury){
    public InjuryCheckState(StateMachine machine) {
        this.machine = machine;
        //this.checkInjuryTeam = this.machine.getTeamsForInjuryCheck();
    }

    public IStateMachine entry() {
        System.out.println("We are in Injury Check State");
        this.checkInjuryTeam = this.machine.getTeamsForInjuryCheck();
        System.out.println("in injury state "+machine.getLeague().getLeagueName());
        System.out.println("teams for injury check "+this.machine.getTeamsForInjuryCheck());
        System.out.println("teams for injury checksssss "+this.checkInjuryTeam);
        System.out.println("bla bla bla "+this.checkInjuryTeam.get(0).getTeamName());
        for (ITeam team : checkInjuryTeam) {
            for (IPlayers player : team.getPlayers()) {
                player.checkForPlayerInjury(machine.getLeague().getGameplayConfig());
            }
        }


        return doTask();
    }

    public IStateMachine doTask() {
        int count = 0;
        for (ISchedulerSeason schedule : machine.getLeague().getGameSchedules()) {
            if (schedule.getStatus().equalsIgnoreCase(Configurables.SCHEDULED.getAction()) && machine.getLeague().getDate().equalsIgnoreCase(schedule.getDateOfMatch())) {
                System.out.println(schedule.getFirstTeam().getTeamName());
                System.out.println(schedule.getSecondTeam().getTeamName());
                //return machine.getSimulate();
                count++;
            }
        }
        System.out.println("count is : "+count);
        return null;
    }

    public void exit() {

    }
}
