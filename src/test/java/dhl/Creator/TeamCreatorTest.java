package dhl.Creator;

import dhl.LeagueModel.League;
import dhl.MockLeague;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeamCreatorTest {

    @Test
    void createTeam() {
        League league = MockLeague.createMock();
        League addTeamLeague = MockLeague.addTeamMock();
        TeamCreator teamCreator = new TeamCreator();
        League new_league = teamCreator.createTeam("Rob", "Dev1",league,"Eastern Conference","American","Hawks");
        assertEquals(addTeamLeague.getClass(),new_league.getClass());
    }
}