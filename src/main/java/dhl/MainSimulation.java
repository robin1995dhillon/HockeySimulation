package dhl;

import dhl.stateMachineNew.StateMachine;
import dhl.stateMachineNew.StateMachineAbstractFactory;

import java.text.ParseException;

public class MainSimulation {

    public static void main(String[] args) throws ParseException {

        String filePath = null;
        try {
            filePath = args[0];
        } catch (ArrayIndexOutOfBoundsException ae) {
            filePath = null;
        }


        StateMachine stateMachine = StateMachineAbstractFactory.instance().getStateMachine();
        stateMachine.setFilePath(filePath);
        stateMachine.startMachine();

    }


}
