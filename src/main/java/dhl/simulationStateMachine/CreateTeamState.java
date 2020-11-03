package dhl.simulationStateMachine;

import dhl.inputOutput.IUserInput;
import dhl.inputOutput.IUserOutput;
import dhl.leagueModel.league.ILeague;

public class CreateTeamState implements IState {
    private ILeague league;
    private StateContext context;
    private IUserInput input;
    private IUserOutput output;
    private String stateName;
    private String nextStateName;
    private String teamName;

    public CreateTeamState(ILeague league, StateContext context, IUserInput input, IUserOutput output, String teamName) {
        this.league = league;
        this.context = context;
        this.input = input;
        this.output = output;
        this.teamName = teamName;
        this.stateName = "CreateTeamState";
    }

    public void runState() {
        league.storeLeague();
    }

    public void forward(StateContext context) {
        this.nextStateName = "SimulateLeagueState";
        context.setState(new SimulateLeagueState(league, input, output, teamName));
    }

    public String getStateName() {
        return this.stateName;
    }

    public String getNextState() {
        return this.nextStateName;
    }
}
