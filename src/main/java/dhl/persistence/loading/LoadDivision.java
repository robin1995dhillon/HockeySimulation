package dhl.persistence.loading;

import dhl.persistence.database.GetAllDivisionInConference;
import dhl.persistence.database.IGetStoredProcedure;
import dhl.leagueModel.division.Division;
import dhl.leagueModel.division.IDivision;
import dhl.leagueModel.teams.ITeam;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoadDivision implements ILoadDivision {
    @Override
    public ArrayList<IDivision> loadDivision(int conferenceId) throws IOException, SQLException {
        ArrayList<IDivision> divisionList = new ArrayList<>();
        IGetStoredProcedure getDivision = new GetAllDivisionInConference(conferenceId);
        ResultSet rsDivision = getDivision.executeProcedure();
        while(rsDivision.next()){
            int divisionId = rsDivision.getInt("id");
            IDivision division = new Division();
            division.setDivisionName(rsDivision.getString("name"));
            ILoadTeam load = new LoadTeam();
            ArrayList<ITeam> teamList = load.loadTeam(divisionId);
            division.setTeams(teamList);
            divisionList.add(division);
        }
        return divisionList;
    }
}
