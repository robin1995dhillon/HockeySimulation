package dhl.stateMachineNew;

import dhl.leagueModel.gamePlayConfig.IGamePlayConfig;
import dhl.leagueModel.gamePlayConfig.ITraining;
import dhl.leagueModel.league.ILeague;
import dhl.leagueModel.teams.ITeam;
import dhl.training.IPlayerTrainingCondition;
import dhl.training.PlayerTrainingCondition;

public class TrainingState implements IStateMachine{

    StateMachine machine;
    IPlayerTrainingCondition trainingCondition;
    IGamePlayConfig config;
    ITraining training;


    public TrainingState(StateMachine machine){
        this.machine = machine;
    }
    public void entry() {
        trainingCondition = new PlayerTrainingCondition();
        ILeague league = machine.getLeague();
        config = league.getGameplayConfig();
        training = config.getTraining();
        training.setDaysTrained(training.getDaysTrained()+1);
        doTask();


    }

    public IStateMachine doTask() {

        int daysTrained = training.getDaysTrained();
        int daysUntilStatCheck = config.getTraining().getDaysUntilStatIncreaseCheck();
        if(daysTrained == daysUntilStatCheck){
            for(ITeam team : machine.getTotalTeamList()) {
                trainingCondition.receiveTraining(team.getPlayers(), team.getHeadCoach());
            }

        }

        return machine.getSimulate();
    }

    public void exit() {

    }
}
