package dhl.stateMachineNew;

import dhl.leagueModel.gamePlayConfig.ITrading;
import dhl.leagueModel.gamePlayConfig.Trading;
import dhl.trade.IPlayerTradingCondition;
import dhl.trade.PlayerTradingCondition;
import dhl.training.PlayerTrainingCondition;

public class ExecuteTradesState implements IStateMachine{

    StateMachine stateMachine;

    public ExecuteTradesState(StateMachine stateMachine){
        this.stateMachine = stateMachine;

    }
    public void entry() {

        IPlayerTradingCondition trading = new PlayerTradingCondition();
        trading.tradeCondition(stateMachine.getTotalTeamList());

    }

    public IStateMachine doTask() {

        return null;
    }

    public void exit() {

    }
}
