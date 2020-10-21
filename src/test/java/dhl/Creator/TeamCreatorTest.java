//package dhl.Creator;
//
//import dhl.LeagueModel.ILeague;
//import dhl.MockLeague;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class TeamCreatorTest {
//
//    @Test
//    void createTeam() {
//        ILeague ILeague = MockLeague.createMock();
//        ILeague addTeamILeague = MockLeague.addTeamMock();
//        TeamCreator teamCreator = new TeamCreator();
//        ILeague new_I_league = teamCreator.createTeam("Rob", "Dev1", ILeague,"Eastern Conference","American","Hawks");
//        assertEquals(addTeamILeague.getClass(), new_I_league.getClass());
//    }
//}