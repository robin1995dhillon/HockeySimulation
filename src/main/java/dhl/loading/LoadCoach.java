package dhl.loading;

import dhl.database.GetCoach;
import dhl.database.GetFreeCoach;
import dhl.database.IGetStoredProcedure;
import dhl.leagueModel.headCoach.HeadCoach;
import dhl.leagueModel.headCoach.IHeadCoach;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoadCoach implements ILoadCoach{

    @Override
    public IHeadCoach loadHeadCoach(int teamId) throws IOException, SQLException {
        IGetStoredProcedure getCoach = new GetCoach(teamId);
        ResultSet rsCoach = getCoach.executeProcedure();
        IHeadCoach headCoach = new HeadCoach();
        while(rsCoach.next()){
            headCoach.setName(rsCoach.getString("name"));
            headCoach.setSkating(rsCoach.getDouble("skating"));
            headCoach.setShooting(rsCoach.getDouble("shooting"));
            headCoach.setChecking(rsCoach.getDouble("checking"));
            headCoach.setSaving(rsCoach.getDouble("saving"));
        }
        return headCoach;
    }

    @Override
    public ArrayList<IHeadCoach> loadFreeCoach(int leagueId) throws IOException, SQLException {
        IGetStoredProcedure getFreeCoach = new GetFreeCoach(leagueId);
        ResultSet rsFreeCoach = getFreeCoach.executeProcedure();
        ArrayList<IHeadCoach> freeCoachList = new ArrayList<>();
        while(rsFreeCoach.next()){
            IHeadCoach freeCoach = new HeadCoach();
            freeCoach.setName(rsFreeCoach.getString("name"));
            freeCoach.setSkating(rsFreeCoach.getDouble("skating"));
            freeCoach.setShooting(rsFreeCoach.getDouble("shooting"));
            freeCoach.setChecking(rsFreeCoach.getDouble("checking"));
            freeCoach.setSaving(rsFreeCoach.getDouble("saving"));
            freeCoachList.add(freeCoach);
        }
        return freeCoachList;
    }
}
