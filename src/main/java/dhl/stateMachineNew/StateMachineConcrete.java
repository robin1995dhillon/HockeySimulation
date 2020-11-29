package dhl.stateMachineNew;

import dhl.leagueModel.league.League;

public class StateMachineConcrete extends StateMachineAbstractFactory{

    private IGameSimulation gameSimulation;
    private ISchedulerSeason schedulerSeason;
    private StateMachine stateMachine;
    private ITeamStanding teamStanding;
    private ITime time;

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
    public ITime getTime() {
        if (time == null) {
            time = new LeagueTimeConcept();
        }
        return time;
    }

    @Override
    public void setGameSimulation(IGameSimulation gameSimulation) {

    }

    @Override
    public void setSchedulerSeason(ISchedulerSeason schedulerSeason) {

    }

    @Override
    public void setStateMachine(IStateMachine stateMachine) {

    }

    @Override
    public void setTeamStanding(ITeamStanding teamStanding) {

    }

    @Override
    public void setTime(ITime time) {

    }
}
