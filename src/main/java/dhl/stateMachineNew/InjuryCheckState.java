package dhl.stateMachineNew;

import dhl.leagueModel.players.IPlayers;
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

    }

    public IStateMachine doTask() {

        return null;
    }

    public void exit() {

    }
}
