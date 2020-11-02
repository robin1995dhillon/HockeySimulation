package dhl.loading;

import dhl.database.GetFreeManager;
import dhl.database.IGetStoredProcedure;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoadFreeManager implements ILoadFreeManager{
    @Override
    public ArrayList<String> loadFreeManager(int leagueId) throws IOException, SQLException {
        IGetStoredProcedure getFreeManager = new GetFreeManager(leagueId);
        ResultSet rsFreeManager = getFreeManager.executeProcedure();
        ArrayList<String> freeManagerList = new ArrayList<>();
        while(rsFreeManager.next()){
            String freeManager = rsFreeManager.getString("name");
            freeManagerList.add(freeManager);
        }
        return freeManagerList;
    }
}
