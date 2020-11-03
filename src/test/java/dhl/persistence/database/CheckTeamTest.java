package dhl.persistence.database;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckTeamTest {
    @Test
    public void CreateLeagueTest() {
        try {
            ICheckStoredProcedure s = new CheckTeam("abc");
        } catch (Exception e) {
            assertTrue(false);
        }
    }

//    @Test
//    public void executeProcedureTest() throws SQLException, IOException {
//        ICheckStoredProcedure s = new CheckTeam("abc");
//        s.executeProcedure();
//        assertTrue(s.getExist());
//        ICheckStoredProcedure s1 = new CheckTeam("asdfghjkl");
//        s1.executeProcedure();
//        assertFalse(s1.getExist());
//    }
}
