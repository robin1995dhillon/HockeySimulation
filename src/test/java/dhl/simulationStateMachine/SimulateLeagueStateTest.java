package dhl.simulationStateMachine;

import dhl.inputOutput.IUserInput;
import dhl.inputOutput.IUserOutput;
import dhl.inputOutput.UserInput;
import dhl.inputOutput.UserOutput;
import dhl.leagueModel.ILeague;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SimulateLeagueStateTest {
    IUserInput inp;
    IUserOutput out;
    String teamName;
    ILeague league;


    @Before
    public void config() {
        inp = new UserInput();
        out = new UserOutput();
        teamName = "Rob's team";
    }

    @Test
    void simulateLeague() {
        SimulateLeagueState sim = new SimulateLeagueState(league, inp, out, teamName);
        assertTrue(sim instanceof SimulateLeagueState);

    }

}
