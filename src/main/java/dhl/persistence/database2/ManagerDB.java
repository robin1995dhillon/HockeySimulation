package dhl.persistence.database2;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManagerDB implements IManagerDB{

    @Override
    public void createFreeManager(String managerName, int leagueId) throws IOException, SQLException {
        IStoredProcedure storedProcedure = new StoredProcedure("create_free_manager(?,?)");
        storedProcedure.addParameter(1, managerName);
        storedProcedure.addParameter(2, leagueId);
        storedProcedure.execute();
        storedProcedure.closeConnection();
    }

    @Override
    public List<String> getFreeManager(int leagueId) throws IOException, SQLException {
        IStoredProcedure storedProcedure = new StoredProcedure("get_free_manager(?)");
        storedProcedure.addParameter(1, leagueId);
        ResultSet rs = storedProcedure.getResult();
        if(rs == null){
            System.out.println("This league does not have free managers");
        }
        List<String> freeManagerList = new ArrayList<>();
        while(rs.next()){
            String freeManager = rs.getString(2);
            freeManagerList.add(freeManager);
        }
        storedProcedure.closeConnection();
        return freeManagerList;
    }

    @Override
    public void updateFreeManager() {

    }
}
