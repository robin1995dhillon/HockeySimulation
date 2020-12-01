package dhl.stateMachineNew;

import dhl.stateMachineNew.gameSimulationAlgorithm.*;

public class StateMachineConcrete extends StateMachineAbstractFactory{

    private IGameSimulation gameSimulation;
    private ISchedulerSeason schedulerSeason;
    private StateMachine stateMachine;
    private ITeamStanding teamStanding;
    private ITime time;
    private IJsonImport jsonImport;
    private IShiftTime shiftTime;
    private IGameSimulationAlgorithm gameSimulationAlgorithm;

    public StateMachineConcrete() {
    }


    @Override
    public IGameSimulation getGameSimulation() {
        if (gameSimulation == null) {
            gameSimulation = new GameSimulation();
        }
        return gameSimulation;
    }

    @Override
    public ISchedulerSeason getSchedulerSeason() {
        if (schedulerSeason == null) {
            schedulerSeason = new SchedulerSeason();
        }
        return schedulerSeason;
    }

    @Override
    public StateMachine getStateMachine() {
        if (stateMachine == null) {
            stateMachine = new StateMachine();
        }
        return stateMachine;
    }

    @Override
    public ITeamStanding getTeamStanding() {
        if (teamStanding == null) {
            teamStanding = new TeamStandings();
        }
        return teamStanding;
    }

    @Override
    public ITeamStanding getNewTeamStanding() {
        return new TeamStandings();
    }

    @Override
    public ITime getTime() {
        if (time == null) {
            time = new LeagueTimeConcept();
        }
        return time;
    }

    @Override
    public IJsonImport getJsonImport() {
        if (jsonImport == null) {
            jsonImport = new JsonImport();
        }
        return jsonImport;
    }

    @Override
    public IGameSimulationAlgorithm getGameSimulationAlgorithm() {
        if (gameSimulationAlgorithm == null) {
            gameSimulationAlgorithm = new GameSimulationAlgorithm();
        }
        return gameSimulationAlgorithm;
    }

    @Override
    public IShiftTime getShiftTime() {
        if (shiftTime == null) {
            shiftTime = new ShiftTime();
        }
        return shiftTime;
    }

    @Override
    public void setGameSimulation(IGameSimulation gameSimulation) {
        this.gameSimulation = gameSimulation;

    }

    @Override
    public void setSchedulerSeason(ISchedulerSeason schedulerSeason) {
        this.schedulerSeason = schedulerSeason;

    }

    @Override
    public void setStateMachine(StateMachine stateMachine) {
        this.stateMachine = stateMachine;

    }

    @Override
    public void setTeamStanding(ITeamStanding teamStanding) {
        this.teamStanding = teamStanding;

    }

    @Override
    public void setTime(ITime time) {
        this.time = time;

    }

    @Override
    public void setJsonImport(IJsonImport jsonImport) {
        this.jsonImport = jsonImport;

    }

    @Override
    public void setGameSimulationAlgorithm(IGameSimulationAlgorithm gameSimulationAlgorithm) {
        this.gameSimulationAlgorithm = gameSimulationAlgorithm;

    }

    @Override
    public void getShiftTime(IShiftTime shiftTime) {
        this.shiftTime = shiftTime;
    }
}
