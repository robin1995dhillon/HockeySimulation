package dhl.stateMachineNew;

import dhl.leagueModel.LeagueModelAbstractFactory;
import dhl.leagueModel.LeagueModelConcrete;

public abstract class StateMachineAbstractFactory {

        private static StateMachineAbstractFactory instance = null;

        public static StateMachineAbstractFactory instance() {

            if (instance == null) {
                instance = new StateMachineConcrete();
            }
            return instance;
        }

    public abstract IGameSimulation getGameSimulation();
    public abstract ISchedulerSeason getSchedulerSeason();
    public abstract StateMachine getStateMachine();
    public abstract ITeamStanding getTeamStanding();
    public abstract ITime getTime();

    public abstract void setGameSimulation(IGameSimulation gameSimulation);
    public abstract void setSchedulerSeason(ISchedulerSeason schedulerSeason);
    public abstract void setStateMachine(IStateMachine stateMachine);
    public abstract void setTeamStanding(ITeamStanding teamStanding);
    public abstract void setTime(ITime time);
}
