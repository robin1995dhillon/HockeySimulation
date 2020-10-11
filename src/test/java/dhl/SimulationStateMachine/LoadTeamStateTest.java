package dhl.SimulationStateMachine;

import dhl.Creator.LeagueCreator;
import dhl.Creator.TeamCreator;
import dhl.*;
import dhl.LeagueModel.League;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoadTeamStateTest {

    @Test
    void loadTeam() {
        LoadTeamState load = new LoadTeamState();
        assertTrue(load instanceof LoadTeamState);
    }
}