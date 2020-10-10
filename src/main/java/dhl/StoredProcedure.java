package dhl;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Properties;
public class StoredProcedure {
    //    static final String url = "jdbc:mysql://db-5308.cs.dal.ca:3306/CSCI5308_1_DEVINT?user=CSCI5308_1_DEVINT_USER&serverTimezone=UTC";
//    static final String user = "CSCI5308_1_DEVINT_USER";
//    static final String password = "B6D4tje9aC";
    private String procedureName;
    private String name;
    private String manager;
    private String coach;
    private String position;
    private boolean captain;
    private int insertedId;
    private int teamId;
    private int leagueId;
    private int conferenceId;
    private int divisionId;
    private String sql;
    private boolean exist = true;
    public StoredProcedure(String name){
        this.procedureName = name;
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
    public int getInsertedId(){
        return this.insertedId;
    }
    public int getLeagueId(){
        return this.leagueId;
    }
    public int getConferenceId(){
        return this.conferenceId;
    }
    public boolean getExist(){
        return this.exist;
    }
    public int getDivisionId(){
        return this.divisionId;
    }
    public void addParameter(String name){
        this.name = name;
    }
    public void addParameter(String name, String manager, String coach){
        this.name = name;
        this.manager = manager;
        this.coach = coach;
    }
    public void addParameter(String name, String position, boolean captain, int teamId) {
        this.name = name;
        this.position = position;
        this.captain = captain;
        this.teamId = teamId;
    }
    public void addParameter(int leagueId, int conferenceId, int divisionId, int teamId){
        this.leagueId = leagueId;
        this.conferenceId = conferenceId;
        this.divisionId = divisionId;
        this.teamId = teamId;
    }
    public  void addParameter(int id){
        this.teamId = id;
    }

    public void executeProcedure() throws IOException {
        InputStream input = null;
        Connection conn = null;
        Properties database = null;
        CallableStatement stmt = null;
        String file = "application.properties";
        try {
            Path currentRelativePath = Paths.get("");
            String str = currentRelativePath.toAbsolutePath().toString();

            str = str.substring(0, str.lastIndexOf("target") + 1);
             database = new Properties();
            input = new FileInputStream(str+file);
            if (input != null) {
                database.load(input);
            } else {
                throw new FileNotFoundException("no file present");
            }
        }
        catch(FileNotFoundException files){
            input = new FileInputStream("src/"+file);
            database.load(input);
        }

       try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(database.getProperty("dburl"), database.getProperty("dbuser"), database.getProperty("dbpass"));
            if(this.procedureName.equals("create_league") || this.procedureName.equals("create_conference") || this.procedureName.equals("create_division")){
                sql = "{CALL " + this.procedureName + "(?)}";
                stmt = conn.prepareCall(sql);
                stmt.setString(1, this.name);
                boolean hasResultSet = stmt.execute();
                if(hasResultSet){
                    ResultSet rs = stmt.getResultSet();
                    while(rs.next()){
                        this.insertedId  = rs.getInt("id");
//                        System.out.print("LAST INSERTED ID = " + this.insertedId);
//                        System.out.print("\n");
                    }
                    rs.close();
                }
            } else if(this.procedureName.equals("create_team")){
                sql = "{CALL " + this.procedureName + "(?,?,?)}";
                stmt = conn.prepareCall(sql);
                stmt.setString(1, this.name);
                stmt.setString(2, this.manager);
                stmt.setString(3, this.coach);
                boolean hasResultSet = stmt.execute();
                if(hasResultSet){
                    ResultSet rs = stmt.getResultSet();
                    while(rs.next()){
                        this.insertedId  = rs.getInt("id");
//                        System.out.print("LAST INSERTED ID = " + this.insertedId);
//                        System.out.print("\n");
                    }
                    rs.close();
                }
            }else if(this.procedureName.equals("create_player") || this.procedureName.equals("create_free_agent")){
                sql = "{CALL " + this.procedureName + "(?,?,?,?)}";
                stmt = conn.prepareCall(sql);
                stmt.setString(1, this.name);
                stmt.setString(2, this.position);
                stmt.setBoolean(3, this.captain);
                stmt.setInt(4, this.teamId);
                stmt.execute();
//                if(hasResultSet){
//                    ResultSet rs = stmt.getResultSet();
//                    while(rs.next()){
//                        int id  = rs.getInt("id");
//                        System.out.print("LAST INSERTED ID = " + id);
//                        System.out.print("\n");
//                    }
//                    rs.close();
//                }
            }else if(this.procedureName.equals("create_DHL_table")){
                sql = "{CALL " + this.procedureName + "(?,?,?,?)}";
                stmt = conn.prepareCall(sql);
                stmt.setInt(1, this.leagueId);
                stmt.setInt(2, this.conferenceId);
                stmt.setInt(3, this.divisionId);
                stmt.setInt(4, this.teamId);
                stmt.execute();
            }else if(this.procedureName.equals("get_conference")){ //this.procedureName.equals("get_free_agent")){
                sql = "{CALL " + this.procedureName + "(?)}";
                stmt = conn.prepareCall(sql);
                stmt.setInt(1, this.teamId);
                boolean hasResultSet = stmt.execute();
                if(hasResultSet){
                    ResultSet rs = stmt.getResultSet();
                    while(rs.next()){
                        int id  = rs.getInt("id");
                        String name = rs.getString("name");
                        String league = rs.getString("league");
//                        System.out.print("ID: " + id);
//                        System.out.print(", Name: " + name);
//                        System.out.print(", League: " + league);
//                        System.out.print("\n");
                    }
                    rs.close();
                }
            }else if(this.procedureName.equals("get_division")){
                sql = "{CALL " + this.procedureName + "(?)}";
                stmt = conn.prepareCall(sql);
                stmt.setInt(1, this.teamId);
                boolean hasResultSet = stmt.execute();
                if(hasResultSet){
                    ResultSet rs = stmt.getResultSet();
                    while(rs.next()){
                        int id  = rs.getInt("id");
                        String name = rs.getString("name");
                        String conference = rs.getString("conference");
                        String league = rs.getString("league");
//                        System.out.print("ID: " + id);
//                        System.out.print(", Name: " + name);
//                        System.out.print(", Conference: " + conference);
//                        System.out.print(", League: " + league);
//                        System.out.print("\n");
                    }
                    rs.close();
                }
            }else if(this.procedureName.equals("get_league")){
                sql = "{CALL " + this.procedureName + "(?)}";
                stmt = conn.prepareCall(sql);
                stmt.setString(1, this.name);
                boolean hasResultSet = stmt.execute();
                if(hasResultSet){
                    ResultSet rs = stmt.getResultSet();
                    while(rs.next()){
                        int id  = rs.getInt("id");
                        String name = rs.getString("name");
//                        System.out.print("ID: " + id);
//                        System.out.print(", Name: " + name);
//                        System.out.print("\n");
                    }
                    rs.close();
                }
            }else if(this.procedureName.equals("get_team")){
                sql = "{CALL " + this.procedureName + "(?)}";
                stmt = conn.prepareCall(sql);
                stmt.setInt(1, this.teamId);
                boolean hasResultSet = stmt.execute();
                if(hasResultSet){
                    ResultSet rs = stmt.getResultSet();
                    while(rs.next()){
                        int id  = rs.getInt("id");
                        String name = rs.getString("name");
                        String division = rs.getString("division");
                        String conference = rs.getString("conference");
                        String league = rs.getString("league");
                        String gm = rs.getString("general_manager");
                        String hc = rs.getString("head_coach");
//                        System.out.print("ID: " + id);
//                        System.out.print(", Name: " + name);
//                        System.out.print(", Division: " + division);
//                        System.out.print(", Conference: " + conference);
//                        System.out.print(", League: " + league);
//                        System.out.print(", General Manager: " + gm);
//                        System.out.print(", Head Coach: " + hc);
//                        System.out.print("\n");
                    }
                    rs.close();
                }
            }else if(this.procedureName.equals("get_free_agent")){
                sql = "{CALL " + this.procedureName + "()}";
                stmt = conn.prepareCall(sql);
                boolean hasResultSet = stmt.execute();
                if(hasResultSet){
                    ResultSet rs = stmt.getResultSet();
                    while(rs.next()){
                        int id  = rs.getInt("id");
                        String name = rs.getString("name");
                        String position = rs.getString("position");
                        boolean captain = rs.getBoolean("captain");
//                        System.out.print("ID: " + id);
//                        System.out.print(", Name: " + name);
//                        System.out.print(", Position: " + position);
//                        System.out.print(", Captain: " + captain);
//                        System.out.print("\n");
                    }
                    rs.close();
                }
            } else if(this.procedureName.equals("get_team_player")){
                sql = "{CALL " + this.procedureName + "(?)}";
                stmt = conn.prepareCall(sql);
                stmt.setInt(1, this.teamId);
                boolean hasResultSet = stmt.execute();
                if(hasResultSet){
                    ResultSet rs = stmt.getResultSet();
                    while(rs.next()){
                        int id  = rs.getInt("id");
                        String name = rs.getString("name");
                        String position = rs.getString("position");
                        boolean captain = rs.getBoolean("captain");
//                        System.out.print("ID: " + id);
//                        System.out.print(", Name: " + name);
//                        System.out.print(", Position: " + position);
//                        System.out.print(", Captain: " + captain);
//                        System.out.print("\n");
                    }
                    rs.close();
                }
            }else if(this.procedureName.equals("check_league")){
                sql = "{CALL " + this.procedureName + "(?)}";
                stmt = conn.prepareCall(sql);
                stmt.setString(1, this.name);
                boolean hasResultSet = stmt.execute();
                if(hasResultSet){
                    ResultSet rs = stmt.getResultSet();
                    if(!rs.next()){
                        System.out.print("League does not exist!");
                        this.exist = false;
                    }
                    rs.close();
                }
            }
            else if(this.procedureName.equals("check_team")){
                sql = "{CALL " + this.procedureName + "(?)}";
                stmt = conn.prepareCall(sql);
                stmt.setString(1, this.name);
                boolean hasResultSet = stmt.execute();
                if(hasResultSet){
                    ResultSet rs = stmt.getResultSet();
                    if(!rs.next()){
                        System.out.print("Team does not exist...");
                        this.exist = false;
                    }
                    rs.close();
                }
            }
            stmt.close();
            conn.close();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }

        finally {
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