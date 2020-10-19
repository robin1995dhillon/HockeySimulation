package dhl.SimulationStateMachine;

import dhl.InOut.IUserInput;
import dhl.InOut.IUserOutput;
import dhl.StoredProcedure;

import java.io.IOException;

public class LoadTeamState implements IState{
    private static IUserInput input;
    private static IUserOutput output;
    private static String teamName;
    private static String stateName;
    private static String nextStateName;

    public LoadTeamState(IUserInput input, IUserOutput output, String teamName) {
        LoadTeamState.input = input;
        LoadTeamState.output = output;
        this.teamName = teamName;
        LoadTeamState.stateName = "Load Team";
    }
    public void forward(StateContext context){
        LoadTeamState.nextStateName = "Simulate";
        context.setState(new SimulateLeagueState(input, output, teamName));
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
        return LoadTeamState.stateName;
    }

    public String getNextState(){
        return LoadTeamState.nextStateName;
    }
}
