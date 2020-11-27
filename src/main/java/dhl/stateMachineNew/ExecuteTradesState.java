package dhl.stateMachineNew;

import dhl.trade.IPlayerTradingCondition;
import dhl.trade.PlayerTradingCondition;

public class ExecuteTradesState implements IStateMachine{

    StateMachine stateMachine;

    public ExecuteTradesState(StateMachine stateMachine){
        this.stateMachine = stateMachine;

    }
    public void entry() {

        IPlayerTradingCondition trading = new PlayerTradingCondition();
        trading.tradeCondition(stateMachine.getTotalTeamList());
        doTask();

    }

    public IStateMachine doTask() {

        return stateMachine.getAging();
    }

    public void exit() {

    }
}
