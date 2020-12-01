package dhl;

import dhl.stateMachine.StateMachine;
import dhl.stateMachine.StateMachineAbstractFactory;

public class MainSimulation {

    public static void main(String[] args) throws Exception {

        GlobalHandler handler = new GlobalHandler();
        Thread.setDefaultUncaughtExceptionHandler(handler);

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
