package dhl.SimulationStateMachine;


import dhl.InOut.IUserInput;
import dhl.InOut.IUserOutput;
import dhl.InOut.UserInput;
import dhl.InOut.UserOutput;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class LoadTeamStateTest {
    IUserInput inp;
    IUserOutput out;
    String teamName;

    @Before
    public void config() {
        inp = new UserInput();
        out = new UserOutput();
        teamName = "Rob's team";
    }
    @Test
    void loadTeam() {
        LoadTeamState load = new LoadTeamState(inp, out, teamName);
        assertTrue(load instanceof LoadTeamState);
    }
}