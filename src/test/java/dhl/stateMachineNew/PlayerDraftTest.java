package dhl.stateMachineNew;

import dhl.leagueModel.IPlayers;
import dhl.leagueModel.ITeam;
import dhl.mock.MockStandingTeam;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayerDraftTest {
    MockStandingTeam mockStandingTeam;
    IPlayerDraft playerDraft;
    StateMachineAbstractFactory stateMachineAbstractFactory;

    public PlayerDraftTest() {
        stateMachineAbstractFactory = StateMachineAbstractFactory.instance();
        mockStandingTeam = new MockStandingTeam();
        playerDraft = new PlayerDraft();
    }

    @Test
    void generateRandomPlayers() {
        List<IPlayers> playerDraftList = new ArrayList<>();

        PlayerDraft playerDraft = new PlayerDraft();
        playerDraftList = playerDraft.generateRandomPlayers(5);
        assertEquals(35, playerDraftList.size());
    }


    @Test
    void selectionOrder() {
        List<ITeamStanding> teamStandingList = MockStandingTeam.createTeamStandingMock();
        assertEquals(2, teamStandingList.size());

    }
}
