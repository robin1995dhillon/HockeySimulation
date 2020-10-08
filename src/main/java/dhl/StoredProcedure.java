package dhl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class StoredProcedure {
//    static final String url = "jdbc:mysql://db-5308.cs.dal.ca:3306/CSCI5308_1_DEVINT?user=CSCI5308_1_DEVINT_USER&serverTimezone=UTC";
//    static final String user = "CSCI5308_1_DEVINT_USER";
//    static final String password = "B6D4tje9aC";
    private String procedureName;
    private int id;
    private String name;
    private String manager;
    private String coach;
    private String position;
    private boolean captain;
    private int teamId;
    private int leagueId;
    private int conferenceId;
    private int divisionId;
    private String sql;

    public StoredProcedure(String name){
        this.procedureName = name;
    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getManager(){
        return this.manager;
    }

    public String getCoach(){
        return this.coach;
    }

    public String getPosition(){
        return this.position;
    }

    public boolean getCaptain(){
        return this.captain;
    }

    public int getTeamId(){
        return this.teamId;
    }

    public int getLeagueId(){
        return this.leagueId;
    }

    public int getConferenceId(){
        return this.conferenceId;
    }

    public int getDivisionId(){
        return this.divisionId;
    }

    public void addParameter(int id, String name){
        this.id = id;
        this.name = name;
    }

    public void addParameter(int id, String name, String manager, String coach){
        this.id = id;
        this.name = name;
        this.manager = manager;
        this.coach = coach;
    }

    public void addParameter(int id, String name, String position, boolean captain, int teamId) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.captain = captain;
        this.teamId = teamId;
    }

    public void addParameter(int id, int leagueId, int conferenceId, int divisionId, int teamId){
        this.id = id;
        this.leagueId = leagueId;
        this.conferenceId = conferenceId;
        this.divisionId = divisionId;
        this.teamId = teamId;
    }

    public  void addParameter(int teamId){
        this.teamId = teamId;
    }

    public void executeProcedure() throws IOException {
        Connection conn = null;
        CallableStatement stmt = null;
        Properties database = new Properties();
        InputStream input = new FileInputStream("src/database.properties");
        database.load(input);
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(database.getProperty("dburl"), database.getProperty("dbuser"), database.getProperty("dbpass"));
            if(this.procedureName.equals("create_league") || this.procedureName.equals("create_conference") || this.procedureName.equals("create_division")){
                sql = "{CALL " + this.procedureName + "(?,?)}";
                stmt = conn.prepareCall(sql);
                stmt.setInt(1, this.id);
                stmt.setString(2, this.name);
            }else if(this.procedureName.equals("create_team")){
                sql = "{CALL " + this.procedureName + "(?,?,?,?)}";
                stmt = conn.prepareCall(sql);
                stmt.setInt(1, this.id);
                stmt.setString(2, this.name);
                stmt.setString(3, this.manager);
                stmt.setString(4, this.coach);
            }else if(this.procedureName.equals("create_player") || this.procedureName.equals("create_free_agent")){
                sql = "{CALL " + this.procedureName + "(?,?,?,?,?)}";
                stmt = conn.prepareCall(sql);
                stmt.setInt(1, this.id);
                stmt.setString(2, this.name);
                stmt.setString(3, this.position);
                stmt.setBoolean(4, this.captain);
                stmt.setInt(5, this.teamId);
            }else if(this.procedureName.equals("create_DHL_table")){
                sql = "{CALL " + this.procedureName + "(?,?,?,?,?)}";
                stmt = conn.prepareCall(sql);
                stmt.setInt(1, this.id);
                stmt.setInt(2, this.leagueId);
                stmt.setInt(3, this.conferenceId);
                stmt.setInt(4, this.divisionId);
                stmt.setInt(5, this.teamId);
            }else if(this.procedureName.equals("get_conference") || this.procedureName.equals("get_division")  || this.procedureName.equals("get_league") || this.procedureName.equals("get_team") || this.procedureName.equals("get_free_agent")){
                sql = "{CALL " + this.procedureName + "()}";
                stmt = conn.prepareCall(sql);
            }else if(this.procedureName.equals("get_team_player")){
                sql = "{CALL " + this.procedureName + "(?)}";
                stmt = conn.prepareCall(sql);
                stmt.setInt(1, this.teamId);
            }
            stmt.execute();
            stmt.close();
            conn.close();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
                if(stmt!=null) {
                    stmt.close();
                }
            }catch(SQLException se2){}
            try{
                if(conn!=null){
                    conn.close();
                }
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }
}



