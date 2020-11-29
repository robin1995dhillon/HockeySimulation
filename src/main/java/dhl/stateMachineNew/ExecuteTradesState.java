package dhl.stateMachineNew;

import dhl.trade.IPlayerTradingCondition;
import dhl.trade.PlayerTradingCondition;

public class ExecuteTradesState implements IStateMachine{

    StateMachine stateMachine;

    public ExecuteTradesState(StateMachine stateMachine){
        this.stateMachine = stateMachine;

    }
    public IStateMachine entry() {
        System.out.println("We are in Execute Trades State");
        IPlayerTradingCondition trading = new PlayerTradingCondition();
        trading.tradeCondition(stateMachine.getTotalTeamList());


        return doTask();
    }

    public IStateMachine doTask() {

        return stateMachine.getAging();
    }

    public void exit() {

    }
}
