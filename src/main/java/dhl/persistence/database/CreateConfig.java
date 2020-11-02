package dhl.persistence.database;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateConfig implements ICreateStoredProcedure{
    private String procedureName;
    private int averageRetirementAge;
    private int maximumAge;
    private double randomWinChance;
    private double randomInjuryChance;
    private int injuryDaysLow;
    private int injuryDaysHigh;
    private int daysUntilStatIncreaseCheck;
    private int lossPoint;
    private double randomTradeOfferChance;
    private int maxPlayersPerTrade;
    private double randomAcceptanceChance;
    private int leagueId;
    private int insertedId;

    public CreateConfig(int averageRetirementAge,int maximumAge, double randomWinChance, double randomInjuryChance, int injuryDaysLow, int injuryDaysHigh, int daysUntilStatIncreaseCheck, int lossPoint, double randomTradeOfferChance, int maxPlayersPerTrade, double randomAcceptanceChance, int leagueId){
        this.procedureName = "create_config";
        this.averageRetirementAge = averageRetirementAge;
        this.maximumAge = maximumAge;
        this.randomWinChance = randomWinChance;
        this.randomInjuryChance= randomInjuryChance;
        this.injuryDaysLow = injuryDaysLow;
        this.injuryDaysHigh = injuryDaysHigh;
        this.daysUntilStatIncreaseCheck = daysUntilStatIncreaseCheck;
        this.lossPoint = lossPoint;
        this.randomTradeOfferChance = randomTradeOfferChance;
        this.maxPlayersPerTrade = maxPlayersPerTrade;
        this.randomAcceptanceChance = randomAcceptanceChance;
        this.leagueId = leagueId;
    }

    @Override
    public int getInsertedId() {
        return this.insertedId;
    }

    @Override
    public void executeProcedure() throws SQLException, IOException {
        IConnect conn = new Connect();
        conn.getConnection();
        String sql = "{CALL " + this.procedureName + "(?,?,?,?,?,?,?,?,?,?,?,?)}";
        CallableStatement stmt = conn.getStatement(sql);
        stmt.setInt(1, this.averageRetirementAge);
        stmt.setInt(2,this.maximumAge);
        stmt.setDouble(3, this.randomWinChance);
        stmt.setDouble(4,this.randomInjuryChance);
        stmt.setInt(5, this.injuryDaysLow);
        stmt.setInt(6, this.injuryDaysHigh);
        stmt.setInt(7, this.daysUntilStatIncreaseCheck);
        stmt.setInt(8, this.lossPoint);
        stmt.setDouble(9, this.randomTradeOfferChance);
        stmt.setInt(10, this.maxPlayersPerTrade);
        stmt.setDouble(11, this.randomAcceptanceChance);
        stmt.setInt(12, this.leagueId);
        boolean hasResultSet = stmt.execute();
        if(hasResultSet){
            ResultSet rs = stmt.getResultSet();
            while(rs.next()){
                this.insertedId  = rs.getInt("id");
            }
        }
        conn.closeConnection();
    }
}
