package dhl.persistence.database2;

import dhl.leagueModel.division.Division;
import dhl.leagueModel.division.IDivision;
import dhl.leagueModel.teams.ITeam;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DivisionDB implements IDivisionDB{

    @Override
    public int createDivision(String divisionName) throws IOException, SQLException {
        IStoredProcedure storedProcedure = new StoredProcedure("create_division(?)");
        storedProcedure.addParameter(1, divisionName);
        ResultSet rs = storedProcedure.getResult();
        int divisionId = 0;
        while(rs.next()){
            divisionId = rs.getInt(1);
        }
        storedProcedure.closeConnection();
        return divisionId;
    }

    @Override
    public List<IDivision> getAllDivisionInConference(int conferenceId) throws IOException, SQLException {
        IStoredProcedure storedProcedure = new StoredProcedure("get_all_division_in_conference(?)");
        storedProcedure.addParameter(1, conferenceId);
        ResultSet rs = storedProcedure.getResult();
        if(rs == null){
            System.out.println("This conference does not have divisions");
        }
        List<IDivision> divisionList = new ArrayList<>();
        while(rs.next()){
            int divisionId = rs.getInt(1);
            IDivision division = new Division();
            division.setDivisionName(rs.getString(2));
            ITeamDB teamDB = new TeamDB();
            List<ITeam> teamList = teamDB.getAllTeamInDivision(divisionId);
            division.setTeams(teamList);
            divisionList.add(division);
        }
        storedProcedure.closeConnection();
        return divisionList;
    }

    @Override
    public void updateDivision() {

    }
}
