package dhl.stateMachineNew.states;

import dhl.leagueModel.gamePlayConfig.IGamePlayConfig;
import dhl.leagueModel.gamePlayConfig.ITraining;
import dhl.leagueModel.ILeague;
import dhl.leagueModel.ITeam;
import dhl.leagueModel.IPlayerTrainingCondition;
import dhl.leagueModel.PlayerTrainingCondition;
import dhl.stateMachineNew.IStateMachine;
import dhl.stateMachineNew.StateMachine;

public class TrainingState implements IStateMachine {

    StateMachine machine;
    IPlayerTrainingCondition trainingCondition;
    IGamePlayConfig config;
    ITraining training;


    public TrainingState(StateMachine machine){
        this.machine = machine;
    }
    public IStateMachine entry() {
        System.out.println("We are in Training State");
        trainingCondition = new PlayerTrainingCondition();
        ILeague league = machine.getLeague();
        config = league.getGameplayConfig();
        training = config.getTraining();
        training.setDaysTrained(training.getDaysTrained()+1);
        return doTask();



    }

    public IStateMachine doTask() {

        int daysTrained = training.getDaysTrained();
        int daysUntilStatCheck = config.getTraining().getDaysUntilStatIncreaseCheck();
        if(daysTrained == daysUntilStatCheck){
            for(ITeam team : machine.getTotalTeamList()) {
                trainingCondition.receiveTraining(team.getPlayers(), team.getHeadCoach(), machine.getLeague().getGameplayConfig());
            }

        }

        return machine.getSimulate();
    }

    public void exit() {

    }
}
