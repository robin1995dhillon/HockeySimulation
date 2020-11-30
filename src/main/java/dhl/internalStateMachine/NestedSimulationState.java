package dhl.internalStateMachine;


import dhl.inputOutput.IUserInput;
import dhl.inputOutput.IUserOutput;
import dhl.leagueModel.ILeague;

public class NestedSimulationState implements INestedState {

    private int season;
    private int totalSeasons;
    private int currentSeason;
    private String teamName;
    private String stateName;
    private String nextStateName;

    private IUserInput input;
    private IUserOutput output;
    private ILeague league;

    private NestedStateContext context;


    public NestedSimulationState(ILeague league, NestedStateContext context, IUserInput input, IUserOutput output, int totalSeasons, String teamName) {
        this.league = league;
        this.context = context;
        this.input = input;
        this.output = output;
        this.totalSeasons = totalSeasons;
        this.currentSeason = 0;
        this.teamName = teamName;
        this.stateName = "NestedSimulationState";
    }

    public void forward(NestedStateContext context) {
        this.nextStateName = "NestedEndState";
        context.setState(new NestedEndState(input, output));
    }

    public void runState() {
        for (int i = 0; i < totalSeasons; i++) {
            this.currentSeason = i;
            boolean seasonIncomplete = true;
            output.setOutput("Simulating season " + (i + 1) + " for " + teamName + " ...");
            output.sendOutput();
        }

    }


    public String getStateName() {
        return this.stateName;
    }

    public String getNextState() {
        return this.nextStateName;
    }

}
