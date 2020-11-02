package dhl.simulationStateMachine;

import dhl.inputOutput.IUserInput;
import dhl.inputOutput.IUserOutput;
import dhl.internalStateMachine.NestedStartState;
import dhl.internalStateMachine.NestedStateContext;
import dhl.leagueModel.league.ILeague;

public class SimulateLeagueState implements IState{
    private ILeague league;
    private IUserInput input;
    private IUserOutput output;
    private String teamName;
    private String stateName;
    private String nextStateName;


    public SimulateLeagueState(ILeague league, IUserInput input, IUserOutput output, String teamName) {
        this.league = league;
        this.input = input;
        this.output = output;
        this.teamName = teamName;
        this.stateName = "SimulateLeagueState";
    }

    public void forward(StateContext context){
        this.nextStateName = "";
    }
    public void runState() {
        NestedStateContext stateContext = new NestedStateContext(input, output);
        stateContext.setState(new NestedStartState(league, stateContext, input, output, teamName)); //Nested state machine start state
        stateContext.runState(); // Run the logic in the nested state
        stateContext.forward(); // Move forward to the next state i.e. Nested Sim State
        stateContext.runState(); // Run the logic in the nested state
        stateContext.forward(); // Move to the next state i.e. End State
        stateContext.runState(); // End state
    }
    public String getStateName(){
        return this.stateName;
    }

    public String getNextState(){
        return this.nextStateName;
    }

}
