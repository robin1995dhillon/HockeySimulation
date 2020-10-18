package dhl.LeagueModel;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeamDB implements ITeamDB{

    private String procedureName;
    private String sql;
    CallableStatement stmt = null;
    Connection conn = null;


    public TeamDB(String procedureName) {
        this.procedureName = procedureName;
    }

    public TeamDB(){

    }



    @Override
    public void loadTeamWithLoss(ITeam2 team) throws SQLException {

        for(IPlayers2 player: team.getPlayers()){

        }





    }
}
