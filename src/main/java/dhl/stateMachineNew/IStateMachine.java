package dhl.stateMachineNew;

import java.text.ParseException;

public interface IStateMachine {

    IStateMachine entry() throws Exception;
    IStateMachine doTask() throws Exception;
    void exit();
}
