package dhl.stateMachineNew;

import dhl.stateMachineNew.gameSimulationAlgorithm.IGameSimulation;
import dhl.stateMachineNew.gameSimulationAlgorithm.IGameSimulationAlgorithm;
import dhl.stateMachineNew.gameSimulationAlgorithm.IShiftTime;

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
