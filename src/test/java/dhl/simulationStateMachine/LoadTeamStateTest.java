//package dhl.simulationStateMachine;
//
//
//import dhl.inputOutput.IUserInput;
//import dhl.inputOutput.IUserOutput;
//import dhl.inputOutput.UserInput;
//import dhl.inputOutput.UserOutput;
//import org.junit.Before;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//class LoadTeamStateTest {
//    IUserInput inp;
//    IUserOutput out;
//    String teamName;
//
//    @Before
//    public void config() {
//        inp = new UserInput();
//        out = new UserOutput();
//        teamName = "Rob's team";
//    }
//
//    @Test
//    void loadTeam() {
//        LoadTeamState load = new LoadTeamState(inp, out, teamName);
//        assertTrue(load instanceof LoadTeamState);
//    }
//}
