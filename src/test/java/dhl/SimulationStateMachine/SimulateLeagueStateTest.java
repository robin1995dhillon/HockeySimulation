package dhl.SimulationStateMachine;

import dhl.InOut.IUserInput;
import dhl.InOut.IUserOutput;
import dhl.InOut.UserInput;
import dhl.InOut.UserOutput;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimulateLeagueStateTest {
    IUserInput inp;
    IUserOutput out;
    String teamName;
    Object ob=null;

    @Before
    public void config() {
        inp = new UserInput();
        out = new UserOutput();
        teamName = "Rob's team";
    }

    @Test
    void simulateLeague() {
        SimulateLeagueState sim = new SimulateLeagueState(inp, out, teamName);
        assertTrue(sim instanceof SimulateLeagueState);

    }
}