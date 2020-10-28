package dhl.SimulationStateMachine;

import dhl.InOut.IUserInput;
import dhl.InOut.IUserOutput;
import dhl.StoredProcedure;

import java.io.IOException;

public class LoadTeamState implements IState{
    private IUserInput input;
    private IUserOutput output;
    private String teamName;
    private String stateName;
    private String nextStateName;

    public LoadTeamState(IUserInput input, IUserOutput output, String teamName) {
        this.input = input;
        this.output = output;
        this.teamName = teamName;
        this.stateName = "LoadTeamState";
    }
    public void forward(StateContext context){
        this.nextStateName = "SimulateLeagueState";
        context.setState(new SimulateLeagueState(null, input, output, teamName));
    }
    public void runState() {
        StoredProcedure SP = new StoredProcedure("check_team");
        SP.addParameter(teamName);
        boolean is_exist = false;
        try {
            SP.executeProcedure();
            is_exist = SP.getExist();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (is_exist) {
            System.out.println("Found the team. Loading...");
        } else {
            System.out.println(" No such team. Quitting simulation.");
            System.exit(0);
        }
    }
    public String getStateName(){
        return this.stateName;
    }

    public String getNextState(){
        return this.nextStateName;
    }
}
