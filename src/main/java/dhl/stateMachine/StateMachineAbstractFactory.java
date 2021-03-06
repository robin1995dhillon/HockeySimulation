package dhl.stateMachine;

import dhl.stateMachine.gameSimulationAlgorithm.IGameSimulation;
import dhl.stateMachine.gameSimulationAlgorithm.IGameSimulationAlgorithm;
import dhl.stateMachine.gameSimulationAlgorithm.IShiftTime;

public abstract class StateMachineAbstractFactory {

    private static StateMachineAbstractFactory instance = null;

    public static StateMachineAbstractFactory instance() {

        if (instance == null) {
            instance = new StateMachineConcrete();
        }
        return instance;
    }

    public abstract ITime getLeagueTimeConcept();

    public abstract void setLeagueTimeConcept(ITime leagueTimeConcept);

    public abstract IGameSimulation getGameSimulation();

    public abstract ISchedulerSeason getSchedulerSeason();

    public abstract IPlayerDraft getPlayerDraft();

    public abstract void setPlayerDraft(IPlayerDraft playerDraft);

    public abstract StateMachine getStateMachine();

    public abstract ITeamStanding getTeamStanding();

    public abstract ITeamStanding getNewTeamStanding();

    public abstract ITime getTime();

    public abstract IJsonImport getJsonImport();

    public abstract IGameSimulationAlgorithm getGameSimulationAlgorithm();

    public abstract IShiftTime getShiftTime();

    public abstract void setGameSimulation(IGameSimulation gameSimulation);

    public abstract void setSchedulerSeason(ISchedulerSeason schedulerSeason);

    public abstract void setStateMachine(StateMachine stateMachine);

    public abstract void setTeamStanding(ITeamStanding teamStanding);

    public abstract void setTime(ITime time);

    public abstract void setJsonImport(IJsonImport jsonImport);

    public abstract void setGameSimulationAlgorithm(IGameSimulationAlgorithm gameSimulationAlgorithm);

    public abstract void getShiftTime(IShiftTime shiftTime);

}
