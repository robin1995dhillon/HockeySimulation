package dhl.Database;

import com.mysql.cj.protocol.Resultset;
import dhl.LeagueModel.ILeague;
import dhl.LeagueModel.League;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetLeague implements IGetStoredProcedure{
    private String procedureName;
    private String name;
    private ArrayList<ILeague> leagueList;

    public GetLeague(String name){
        this.procedureName = "get_league";
        this.name = name;
        this.leagueList = new ArrayList<>();
    }

    @Override
    public void executeProcedure() throws SQLException, IOException {
        IConnect conn = new Connect();
        conn.getConnection();
        ResultSet rs = conn.gerResultSet();
        String sql = "{CALL " + this.procedureName + "(?)}";
        CallableStatement stmt = conn.getStatement(sql);
        stmt.setString(1, this.name);
        boolean hasResultSet = stmt.execute();
        if(hasResultSet){
            rs = stmt.getResultSet();
            while(rs.next()){
                ILeague league = new League();
                league.setLeagueName(rs.getString("name"));
                leagueList.add(league);
                int id  = rs.getInt("id");
                String name = rs.getString("name");
                System.out.print("ID: " + id);
                System.out.println(", Name: " + name);
            }
        }
        conn.closeConnection();
    }

    @Override
    public ArrayList getData() {
        return this.leagueList;
    }
}
