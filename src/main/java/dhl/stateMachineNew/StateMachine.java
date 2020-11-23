package dhl.stateMachineNew;

import dhl.inputOutput.IUserOutput;
import dhl.inputOutput.UserOutput;
import dhl.leagueModel.league.ILeague;
import dhl.leagueModel.league.League;
import dhl.leagueModel.teams.ITeam;
import dhl.leagueModel.teams.Teams;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class StateMachine {
    private ILeague league;
    private List<ITeam> teamsForInjuryCheck;
    private IStateMachine jsonImport;
    private IStateMachine createTeam;
    private IStateMachine loadTeam;
    private IStateMachine playerChoice;
    private IStateMachine simulate;
    private IStateMachine initializeSeason;
    private IStateMachine advanceTime;
    private IStateMachine generatePlayoffSchedule;
    private IStateMachine training;
    private IStateMachine simulateGame;
    private IStateMachine injuryCheck;
    private IStateMachine executeTrades;
    private IStateMachine aging;
    private IStateMachine advanceToNextSeason;
    private IStateMachine persist;


    private IStateMachine currentState;
    private IUserOutput output;
    private ITeam team;
    private List<ITeam> totalTeamList;

    StateMachine(String filePath){

        totalTeamList = new ArrayList<>();
        league = new League();
        team = new Teams();
        jsonImport = new JsonImportState(this,filePath);
        createTeam = new CreateTeamState(this);
        loadTeam = new LoadTeamState(this);
        playerChoice = new PlayerChoiceState(this);
        simulate = new SimulateState(this);
        initializeSeason = new InitializeSeasonState(this);
        advanceTime = new AdvanceTimeState(this);
        generatePlayoffSchedule = new GeneratePlayoffScheduleState(this);
        training = new TrainingState();
        simulateGame = new SimulateGame();
        injuryCheck = new InjuryCheckState();
        executeTrades = new ExecuteTradesState(this);
        aging = new AgingState(this);
        advanceToNextSeason = new AdvanceToNextSeasonState(this);
        persist = new PersistState();
        output = new UserOutput();
        currentState = jsonImport;
    }


    public void startMachine() throws ParseException {

        while (currentState != null) {
            IStateMachine nextState = currentState.doTask();
            if (nextState != currentState) {
                goToNextState(nextState);
            }
        }

    }

    public void goToNextState(IStateMachine nextState){
        if(nextState == null){
            System.exit(0);
        }
        else {
            currentState.exit();
            currentState = nextState;
        }
    }

    public IStateMachine getJsonImport() {
        return jsonImport;
    }

    public void setJsonImport(IStateMachine jsonImport) {
        this.jsonImport = jsonImport;
    }

    public IStateMachine getCreateTeam() {
        return createTeam;
    }

    public void setCreateTeam(IStateMachine createTeam) {
        this.createTeam = createTeam;
    }

    public IStateMachine getLoadTeam() {
        return loadTeam;
    }

    public void setLoadTeam(IStateMachine loadTeam) {
        this.loadTeam = loadTeam;
    }

    public IStateMachine getPlayerChoice() {
        return playerChoice;
    }

    public void setPlayerChoice(IStateMachine playerChoice) {
        this.playerChoice = playerChoice;
    }

    public IStateMachine getSimulate() {
        return simulate;
    }

    public void setSimulate(IStateMachine simulate) {
        this.simulate = simulate;
    }

    public IStateMachine getInitializeSeason() {
        return initializeSeason;
    }

    public void setInitializeSeason(IStateMachine initializeSeason) {
        this.initializeSeason = initializeSeason;
    }

    public IStateMachine getAdvanceTime() {
        return advanceTime;
    }

    public void setAdvanceTime(IStateMachine advanceTime) {
        this.advanceTime = advanceTime;
    }

    public IStateMachine getGeneratePlayoffSchedule() {
        return generatePlayoffSchedule;
    }

    public void setGeneratePlayoffSchedule(IStateMachine generatePlayoffSchedule) {
        this.generatePlayoffSchedule = generatePlayoffSchedule;
    }

    public IStateMachine getTraining() {
        return training;
    }

    public void setTraining(IStateMachine training) {
        this.training = training;
    }

    public IStateMachine getSimulateGame() {
        return simulateGame;
    }

    public void setSimulateGame(IStateMachine simulateGame) {
        this.simulateGame = simulateGame;
    }

    public IStateMachine getInjuryCheck() {
        return injuryCheck;
    }

    public void setInjuryCheck(IStateMachine injuryCheck) {
        this.injuryCheck = injuryCheck;
    }

    public IStateMachine getExecuteTrades() {
        return executeTrades;
    }

    public void setExecuteTrades(IStateMachine executeTrades) {
        this.executeTrades = executeTrades;
    }

    public IStateMachine getAging() {
        return aging;
    }

    public void setAging(IStateMachine aging) {
        this.aging = aging;
    }

    public IStateMachine getAdvanceToNextSeason() {
        return advanceToNextSeason;
    }

    public void setAdvanceToNextSeason(IStateMachine advanceToNextSeason) {
        this.advanceToNextSeason = advanceToNextSeason;
    }

    public IStateMachine getPersist() {
        return persist;
    }

    public void setPersist(IStateMachine persist) {
        this.persist = persist;
    }

    public IStateMachine getCurrentState() {
        return currentState;
    }

    public void setCurrentState(IStateMachine currentState) {
        this.currentState = currentState;
    }

    public IUserOutput getOutput() {
        return output;
    }

    public void setOutput(IUserOutput output) {
        this.output = output;
    }

    public ILeague getLeague() {
        return league;
    }

    public void setLeague(ILeague league) {
        this.league = league;
    }


    public ITeam getTeam() {
        return team;
    }

    public void setTeam(ITeam team) {
        this.team = team;
    }

    public List<ITeam> getTotalTeamList() {
        return totalTeamList;
    }

    public void setTotalTeamList(List<ITeam> totalTeamList) {
        this.totalTeamList = totalTeamList;
    }

    public List<ITeam> getTeamsForInjuryCheck() {
        return teamsForInjuryCheck;
    }

    public void setTeamsForInjuryCheck(List<ITeam> teamsForInjuryCheck) {
        this.teamsForInjuryCheck = teamsForInjuryCheck;
    }
}