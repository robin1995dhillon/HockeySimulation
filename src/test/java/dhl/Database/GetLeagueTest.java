package dhl.Database;

import dhl.LeagueModel.ILeague;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class GetLeagueTest {
    @Test
    public void CreateLeagueTest(){
        try{
            IGetStoredProcedure s = new GetLeague("DHL");
        }catch(Exception e){
            fail();
        }
    }

//    @Test
//    public void executeProcedureTest() throws SQLException, IOException {
//        IGetStoredProcedure s = new GetLeague("DHL");
//        s.executeProcedure();
//        ArrayList<ILeague> leagueList = s.getData();
//        for(ILeague league: leagueList){
//            System.out.println(league.getLeagueName());
//        }
//    }
}
