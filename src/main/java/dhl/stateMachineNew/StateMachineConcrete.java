package dhl.stateMachineNew;

public class StateMachineConcrete extends StateMachineAbstractFactory {

    private IStateMachine advanceTimeState;
    private IStateMachine advanceToNextSeasonState;
    private IStateMachine stateMachine

    public IStateMachine getAdvanceTimeState() {
        return new AdvanceTimeState(stateMachine);
    }

    public void setAdvanceTimeState(IStateMachine advanceTimeState) {
        this.advanceTimeState = advanceTimeState;
    }

    public IStateMachine getAdvanceToNextSeasonState() {
        return advanceToNextSeasonState;
    }

    public void setAdvanceToNextSeasonState(IStateMachine advanceToNextSeasonState) {
        this.advanceToNextSeasonState = advanceToNextSeasonState;
    }

}
