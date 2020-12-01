package dhl.stateMachine;

import dhl.presentation.inputOutput.IUserOutput;
import dhl.presentation.inputOutput.UserOutput;
import dhl.leagueModel.*;
import dhl.stateMachine.states.*;

import java.util.ArrayList;
import java.util.List;

public class StateMachine {
    private ILeague league;
    private LeagueModelAbstractFactory leagueModelAbstractFactory;
    private StateMachineAbstractFactory stateMachineAbstractFactory;
    private List<IPlayers> consideringTeamPlayers;
    private List<IPlayers> offeringTeamPositionPlayers;
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
    private IStateMachine playerDraft;


    private IStateMachine currentState;
    private IUserOutput output;
    private ITeam team;
    private int playoffsYear;
    private String filePath;
    private List<ITeam> totalTeamList;

    public StateMachine() {
        leagueModelAbstractFactory = LeagueModelAbstractFactory.instance();
        stateMachineAbstractFactory = StateMachineAbstractFactory.instance();
        totalTeamList = new ArrayList<>();
        league = leagueModelAbstractFactory.getLeague();
        team = leagueModelAbstractFactory.getTeam();
        jsonImport = new JsonImportState(this);
        createTeam = new CreateTeamState(this);
        loadTeam = new LoadTeamState(this);
        playerChoice = new PlayerChoiceState(this);
        simulate = new SimulateState(this);
        initializeSeason = new InitializeSeasonState(this);
        advanceTime = new AdvanceTimeState(this);
        generatePlayoffSchedule = new GeneratePlayoffScheduleState(this);
        training = new TrainingState(this);
        injuryCheck = new InjuryCheckState(this);
        executeTrades = new ExecuteTradesState(this);
        aging = new AgingState(this);
        advanceToNextSeason = new AdvanceToNextSeasonState(this, this.getTotalTeamList());
        output = new UserOutput();
        playerDraft = new PlayerDraftState(this);
        currentState = jsonImport;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public void startMachine() throws Exception {

        while (currentState != null) {
            IStateMachine nextState = currentState.entry();
            if (nextState == currentState) {
                continue;
            }
            else {
                goToNextState(nextState);
            }
        }

    }

    public void goToNextState(IStateMachine nextState) {
        if (nextState == null) {
            System.exit(0);
        } else {
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


    public IStateMachine getLoadTeam() {
        return loadTeam;
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

    public IStateMachine getGeneratePlayoffSchedule() {
        return generatePlayoffSchedule;
    }


    public IStateMachine getPlayerDraft() {
        return playerDraft;
    }

    public void setPlayerDraft(IStateMachine playerDraft) {
        this.playerDraft = playerDraft;
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


    public IStateMachine getExecuteTrades() {
        return executeTrades;
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

    public int getPlayoffsYear(){
        return playoffsYear;
    };

    public void setPlayoffsYear(int playoffsYear){
        this.playoffsYear = playoffsYear;
    };

    public List<IPlayers> getConsideringTeamPlayers() {
        return consideringTeamPlayers;
    }

    public void setConsideringTeamPlayers(List<IPlayers> consideringTeamPlayers) {
        this.consideringTeamPlayers = consideringTeamPlayers;
    }

    public List<IPlayers> getOfferingTeamPositionPlayers() {
        return offeringTeamPositionPlayers;
    }

    public void setOfferingTeamPositionPlayers(List<IPlayers> offeringTeamPositionPlayers) {
        this.offeringTeamPositionPlayers = offeringTeamPositionPlayers;
    }
}
