package dhl.gamePlayConfig;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.json.simple.JSONObject;

@JsonDeserialize(as= Trading.class)
public interface ITrading {
    int getLossPoint();

    void setLossPoint(int lossPoint);

    int getRandomTradeOfferChance();

    void setRandomTradeOfferChance(int randomTradeOfferChance);

    int getMaxPlayersPerTrade();

    void setMaxPlayersPerTrade(int maxPlayersPerTrade);

    int getRandomAcceptanceChance();

    void setRandomAcceptanceChance(int randomAcceptanceChance);

    boolean tradingValidator(JSONObject Obj);

    boolean checkRangeInteger(int[] injuriesAttributes);

    boolean checkRangeDouble(double[] injuriesAttributes);
}
