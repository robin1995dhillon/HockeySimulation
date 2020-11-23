package dhl.stateMachineNew;

import java.text.ParseException;

public interface IStateMachine {

    void entry() throws ParseException;
    IStateMachine doTask() throws ParseException;
    void exit();
}
