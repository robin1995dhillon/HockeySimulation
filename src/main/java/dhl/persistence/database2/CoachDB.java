package dhl.persistence.database2;

import dhl.leagueModel.headCoach.HeadCoach;
import dhl.leagueModel.headCoach.IHeadCoach;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CoachDB implements ICoachDB{

    @Override
    public void createHeadCoach(IHeadCoach headCoach, int teamId) throws IOException, SQLException {
        IStoredProcedure storedProcedure = new StoredProcedure("create_coach(?,?,?,?,?,?)");
        storedProcedure.addParameter(1, headCoach.getName());
        storedProcedure.addParameter(2, headCoach.getSkating());
        storedProcedure.addParameter(3, headCoach.getShooting());
        storedProcedure.addParameter(4, headCoach.getChecking());
        storedProcedure.addParameter(5, headCoach.getSaving());
        storedProcedure.addParameter(6, teamId);
        storedProcedure.execute();
        storedProcedure.closeConnection();
    }

    @Override
    public void createFreeCoach(IHeadCoach freeCoach, int leagueId) throws IOException, SQLException {
        IStoredProcedure storedProcedure = new StoredProcedure("create_free_coach(?,?,?,?,?,?)");
        storedProcedure.addParameter(1, freeCoach.getName());
        storedProcedure.addParameter(2, freeCoach.getSkating());
        storedProcedure.addParameter(3, freeCoach.getShooting());
        storedProcedure.addParameter(4, freeCoach.getChecking());
        storedProcedure.addParameter(5, freeCoach.getSaving());
        storedProcedure.addParameter(6, leagueId);
        storedProcedure.execute();
        storedProcedure.closeConnection();
    }

    @Override
    public IHeadCoach getHeadCoach(int teamId) throws IOException, SQLException {
        IStoredProcedure storedProcedure = new StoredProcedure("get_coach(?)");
        storedProcedure.addParameter(1, teamId);
        ResultSet rs = storedProcedure.getResult();
        if(rs == null){
            System.out.println("This team does not have head coach.");
        }
        IHeadCoach headCoach = new HeadCoach();
        while(rs.next()) {
            headCoach.setName(rs.getString(2));
            headCoach.setSkating(rs.getDouble(3));
            headCoach.setShooting(rs.getDouble(4));
            headCoach.setChecking(rs.getDouble(5));
            headCoach.setSaving(rs.getDouble(6));
        }
        storedProcedure.closeConnection();
        return headCoach;
    }

    @Override
    public List<IHeadCoach> getFreeCoach(int leagueId) throws IOException, SQLException {
        IStoredProcedure storedProcedure = new StoredProcedure("get_free_coach(?)");
        storedProcedure.addParameter(1, leagueId);
        ResultSet rs = storedProcedure.getResult();
        if(rs == null){
            System.out.println("This league does not have free coaches.");
        }
        List<IHeadCoach> coachList = new ArrayList<>();
        while(rs.next()){
            IHeadCoach freeCoach = new HeadCoach();
            freeCoach.setName(rs.getString(2));
            freeCoach.setSkating(rs.getDouble(3));
            freeCoach.setShooting(rs.getDouble(4));
            freeCoach.setChecking(rs.getDouble(5));
            freeCoach.setSaving(rs.getDouble(6));
            coachList.add(freeCoach);

        }
        storedProcedure.closeConnection();
        return coachList;
    }

    @Override
    public void updateHeadCoach() {

    }

    @Override
    public void updateFreeCoach() {

    }
}
