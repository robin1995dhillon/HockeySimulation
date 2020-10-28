package dhl.InternalStateMachine;


import dhl.InOut.IUserInput;
import dhl.InOut.IUserOutput;
import dhl.LeagueModel.ILeague;

public class NestedStartState implements INestedState {

    private IUserInput input;
    private IUserOutput output;
    private String teamName;
    private ILeague league;
    private NestedStateContext context;
    public int totalSeasons;
    private String stateName;
    private String nextStateName;

    public NestedStartState(ILeague league, NestedStateContext context, IUserInput input, IUserOutput output, String teamName) {
        this.league = league;
        this.context = context;
        this.input = input;
        this.output = output;
        this.teamName = teamName;
        this.stateName = "NestedStartState";
        this.totalSeasons = 0;
    }

    public void forward(NestedStateContext context) {
        this.nextStateName = "NestedSimulationState";
        context.setState(new NestedSimulationState(league, context, input, output, totalSeasons, teamName));
    }

    public void runState() {
        output.setOutput("How many seasons do you want to simulate?");
        output.sendOutput();
        input.setInput();
        this.totalSeasons = Integer.parseInt(input.getInput());
    }

    public String getStateName() {
        return this.stateName;
    }

    public String getNextState() {
        return this.nextStateName;
    }

}
