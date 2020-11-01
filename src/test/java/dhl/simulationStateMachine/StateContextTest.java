package dhl.simulationStateMachine;

import dhl.inputOutput.IUserInput;
import dhl.inputOutput.IUserOutput;
import dhl.inputOutput.UserInput;
import dhl.inputOutput.UserOutput;
import dhl.leagueModel.ILeague;
import dhl.mock.MockLeague;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class StateContextTest {
    private static IState state;
    private static IUserInput input;
    private static IUserOutput output;
    private static StateContext context;
    private static ILeague league1;
    private static MockLeague league;

    @Before
    public void config() {
        input = new UserInput();
        output = new UserOutput();
        league = new MockLeague();
        state = new CreateTeamState(league1, context, input, output, "Hawks");
        context = new StateContext(input, output);
        context.setState(state);
    }

    @Test
    public void forward() {
        context.setState(new LoadTeamState(input, output, "Hawks"));
        context.forward();
        assertEquals("SimulateLeagueState", context.currentStateName);
        context.setState(state);
    }

    @Test
    public void setState() {
        context.setState(state);
        assertEquals("CreateTeamState", context.currentStateName);
    }

    @Test
    public void runState() {
        context.setState(state);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        context.runState();
        String expected = "";
        String gotOutput = out.toString().replaceAll("\n", "");
        gotOutput = gotOutput.replaceAll("\r", "");
        assertEquals(expected, gotOutput);
    }
}