package dhl.stateMachineNew;


public abstract class StateMachineAbstractFactory {

    private static StateMachineAbstractFactory instance = null;

    public static StateMachineAbstractFactory instance() {

        if (instance == null) {
            instance = new StateMachineConcrete();
        }
        return instance;
    }


}
