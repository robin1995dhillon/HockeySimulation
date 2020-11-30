package dhl.stateMachineNew.states;

import dhl.leagueModel.LeagueModelAbstractFactory;
import dhl.leagueModel.trade.IPlayerTradingCondition;
import dhl.leagueModel.trade.PlayerTradingCondition;
import dhl.stateMachineNew.IStateMachine;
import dhl.stateMachineNew.StateMachine;

public class ExecuteTradesState implements IStateMachine {

    StateMachine stateMachine;

    public ExecuteTradesState(StateMachine stateMachine){
        this.stateMachine = stateMachine;

    }
    public IStateMachine entry() {
        System.out.println("We are in Execute Trades State");
//        IPlayerTradingCondition trading = LeagueModelAbstractFactory.instance().getPLayerTradingCondition();
//        System.out.println("league is : "+stateMachine.getLeague().getLeagueName());
//        System.out.println("total team list is : "+stateMachine.getTotalTeamList());
//        trading.tradeCondition(stateMachine.getTotalTeamList(),stateMachine.getLeague().getGameplayConfig());

        return doTask();
    }

    public IStateMachine doTask() {

        return stateMachine.getAging();
    }

    public void exit() {

    }
}
