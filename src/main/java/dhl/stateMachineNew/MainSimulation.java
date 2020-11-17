package dhl.stateMachineNew;

public class MainSimulation {

    public static void main(String[] args) {

        String filePath = null;
        try {
            filePath = args[0];
        } catch (ArrayIndexOutOfBoundsException ae) {
            filePath = null;
        }

        StateMachine stateMachine = new StateMachine(filePath);
        stateMachine.startMachine();

    }


}
