package dhl.leagueModel.gamePlayConfig;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.json.simple.JSONObject;

@JsonDeserialize(as = Trading.class)
public interface ITrading {
    int getLossPoint();

    void setLossPoint(int lossPoint);

    double getRandomTradeOfferChance();

    void setRandomTradeOfferChance(double randomTradeOfferChance);

    int getMaxPlayersPerTrade();

    void setMaxPlayersPerTrade(int maxPlayersPerTrade);

    double getRandomAcceptanceChance();

    void setRandomAcceptanceChance(double randomAcceptanceChance);

    IGmTable getGmTable();

    void setGmTable(IGmTable gmTable);

    boolean tradingValidator(JSONObject Obj);

    boolean checkRangeInteger(int[] injuriesAttributes);

    boolean checkRangeDouble(double[] injuriesAttributes);
}
