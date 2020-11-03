package dhl.simulationStateMachine;

import dhl.inputOutput.IUserInput;
import dhl.inputOutput.IUserOutput;
import dhl.persistence.database.CheckTeam;
import dhl.persistence.database.ICheckStoredProcedure;
import dhl.persistence.loading.ILoadLeague;
import dhl.persistence.loading.LoadLeague;

import java.io.IOException;
import java.sql.SQLException;

public class LoadTeamState implements IState {
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

    public void forward(StateContext context) {
        this.nextStateName = "SimulateLeagueState";
        context.setState(new SimulateLeagueState(null, input, output, teamName));
    }

    public void runState() {
        ICheckStoredProcedure SP = new CheckTeam(teamName);
        boolean is_exist = false;
        try {
            SP.executeProcedure();
            is_exist = SP.getExist();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        if (is_exist) {
            System.out.println("Found the team. Loading...");
            ILoadLeague load = new LoadLeague();
            try {
                load.loadLeague(teamName);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        } else {
            System.out.println(" No such team. Quitting simulation.");
            System.exit(0);
        }

    }

    public String getStateName() {
        return this.stateName;
    }

    public String getNextState() {
        return this.nextStateName;
    }
}
