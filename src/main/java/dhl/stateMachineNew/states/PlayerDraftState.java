package dhl.stateMachineNew.states;

import dhl.leagueModel.*;
import dhl.mock.MockStandingTeam;
import dhl.stateMachineNew.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.ParseException;
import java.util.List;

public class PlayerDraftState implements IStateMachine {
    private static final Logger logger = LogManager.getLogger(PlayerDraftState.class);
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
        int totalTeams = 0;
        league = stateMachine.getLeague();
        for(IConference conference : league.getConferences()){
            for(IDivision division : conference.getDivisions()){
                totalTeams += division.getTeams().size();
            }
        }
        //List<ITeam> allTeams = stateMachine.getTotalTeamList();
        //int totalTeams = allTeams.size();

        System.out.println("Total Number of Teams are: " + totalTeams);
        List<IPlayers> draftList =  playerDraft.generateRandomPlayers(totalTeams);
        for(IPlayers players:draftList){
            System.out.println(players.getPlayerName());
        }
        //List<ITeamStanding> teamStandingList = playerDraft.getTeamStandingList();
        List<ITeamStanding> teamStandingList = MockStandingTeam.createTeamStandingTwoMock();
        List<ITeamStanding> draftedTeamStanding = playerDraft.selectionOrder(teamStandingList);

        for(ITeamStanding teamStanding: draftedTeamStanding) {
            ITeam team = teamStanding.getTeam();
            team.dropTeamToThirty();
            System.out.println(team.getPlayers().size());
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
