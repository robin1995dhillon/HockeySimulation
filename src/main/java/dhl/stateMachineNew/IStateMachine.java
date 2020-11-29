package dhl.stateMachineNew;

import java.text.ParseException;

public interface IStateMachine {

    IStateMachine entry() throws ParseException;
    IStateMachine doTask() throws ParseException;
    void exit();
}
