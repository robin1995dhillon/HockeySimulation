package dhl.simulationStateMachine;

import dhl.inputOutput.IUserInput;
import dhl.inputOutput.IUserOutput;
import dhl.inputOutput.UserInput;
import dhl.inputOutput.UserOutput;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class CreateTeamStateTest {
    IUserInput inp;
    IUserOutput out;
    String teamName;
    StateContext context;
    CreateTeamState state;

    @Before
    public void config() {
        inp = new UserInput();
        out = new UserOutput();
        teamName = "Rob's team";
    }
    @Test
    void runState() {
    }

    @Test
    void saveLeague() {
    }

    @Test
    void saveConference() {
    }

    @Test
    void saveDivision() {
    }

    @Test
    void saveTeam() {
    }

    @Test
    void savePlayer() {
    }

    @Test
    void saveDHL() {
    }

    @Test
    void forward() {
    }

    @org.junit.Test
    public void getStateNameTest() {
        assertEquals("Create Team", state.getStateName());
    }

    @org.junit.Test
    public void getNextStateTest() {
        context.forward();
        assertEquals("Simulate", state.getNextState());
        context.setState(state);
    }
}