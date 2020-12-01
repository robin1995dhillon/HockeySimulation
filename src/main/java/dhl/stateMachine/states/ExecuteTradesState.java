package dhl.stateMachine.states;

import dhl.leagueModel.LeagueModelAbstractFactory;
import dhl.leagueModel.trade.IPlayerTradingCondition;
import dhl.stateMachine.IStateMachine;
import dhl.stateMachine.StateMachine;

public class ExecuteTradesState implements IStateMachine {

    StateMachine stateMachine;

    public ExecuteTradesState(StateMachine stateMachine){
        this.stateMachine = stateMachine;

    }
    public IStateMachine entry() {
        IPlayerTradingCondition trading = LeagueModelAbstractFactory.instance().getPLayerTradingCondition();
//        trading.tradeCondition(stateMachine.getTotalTeamList(),stateMachine.getLeague().getGameplayConfig());
//        Commented because we dont have trading in milestone 3
        return doTask();
    }

    public IStateMachine doTask() {
        return stateMachine.getAging();
    }

    public void exit() {

    }
}
