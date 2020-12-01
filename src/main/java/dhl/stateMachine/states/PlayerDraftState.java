package dhl.stateMachine.states;

import dhl.leagueModel.*;
import dhl.mock.MockStandingTeam;
import dhl.presentation.inputOutput.IUserOutput;
import dhl.presentation.inputOutput.InputOutputAbstractFactory;
import dhl.stateMachine.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.ParseException;
import java.util.List;

public class PlayerDraftState implements IStateMachine {
    private static final Logger logger = LogManager.getLogger(PlayerDraftState.class);

    StateMachine stateMachine;
    ILeague league;
    IPlayerDraft playerDraft;
    StateMachineAbstractFactory stateMachineAbstractFactory;
    InputOutputAbstractFactory inputOutputAbstractFactory;
    IUserOutput userOutput;

    public PlayerDraftState(StateMachine stateMachine) {
        stateMachineAbstractFactory = StateMachineAbstractFactory.instance();
        this.stateMachine = stateMachine;
        playerDraft = stateMachineAbstractFactory.getPlayerDraft();
        inputOutputAbstractFactory = InputOutputAbstractFactory.instance();
        userOutput = inputOutputAbstractFactory.createUserOutput();
    }

    public IStateMachine entry() throws ParseException {
        return doTask();
    }

    public IStateMachine doTask() throws ParseException {
        int totalTeams = 0;
        league = stateMachine.getLeague();
        for(IConference conference : league.getConferences()){
            for(IDivision division : conference.getDivisions()){
                totalTeams += division.getTeams().size();
            }
        }

        List<IPlayers> draftList =  playerDraft.generateRandomPlayers(totalTeams);

        userOutput.setOutput("Player Draft Begins: ");
        userOutput.sendOutput();
        for(IPlayers players:draftList){
            userOutput.setOutput("Player Draft Player is: " + players.getPlayerName());
            userOutput.sendOutput();
        }

        List<ITeamStanding> teamStandingList = MockStandingTeam.createTeamStandingTwoMock();
        List<ITeamStanding> draftedTeamStanding = playerDraft.selectionOrder(teamStandingList);

        for(ITeamStanding teamStanding: draftedTeamStanding) {
            ITeam team = teamStanding.getTeam();
            team.dropTeamToThirty();
        }

        if(league.getDate().equals(league.getLastDateOfSeason())) {
            return stateMachine.getGeneratePlayoffSchedule();
        }
        else {
            return stateMachine.getTraining();
        }

    }

    public void exit() {

    }
}
