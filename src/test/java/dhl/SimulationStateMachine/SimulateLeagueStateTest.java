package dhl.SimulationStateMachine;

import dhl.InOut.IUserInput;
import dhl.InOut.IUserOutput;
import dhl.InOut.UserInput;
import dhl.InOut.UserOutput;
import dhl.LeagueModel.ILeague;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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