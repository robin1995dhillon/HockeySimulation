package dhl.stateMachineNew.states;

import dhl.leagueModel.ILeague;
import dhl.leagueModel.ITeam;
import dhl.stateMachineNew.*;

import java.text.ParseException;
import java.util.List;

public class PlayerDraftState implements IStateMachine {
    StateMachine stateMachine;
    ILeague league;
    IPlayerDraft playerDraft;

    public PlayerDraftState(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
        playerDraft = new PlayerDraft();
    }

    public IStateMachine entry() throws ParseException {
        return doTask();
    }

    public IStateMachine doTask() throws ParseException {
        league = stateMachine.getLeague();
        List<ITeam> allTeams = stateMachine.getTotalTeamList();
        int totalTeams = allTeams.size();
        List<ITeamStanding> teamStandingList = playerDraft.getTeamStandingList();
        System.out.println("Total Number of Teams are: " + totalTeams);
        playerDraft.generateRandomPlayers(totalTeams);
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
