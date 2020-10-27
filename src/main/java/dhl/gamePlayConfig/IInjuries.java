package dhl.gamePlayConfig;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import dhl.LeagueModel.Division;
import org.json.simple.JSONObject;

@JsonDeserialize(as= Injuries.class)
public interface IInjuries {
    double getRandomInjuryChance();

    void setRandomInjuryChance(double randomInjuryChance);

    int getInjuryDaysLow();

    void setInjuryDaysLow(int injuryDaysLow);

    int getInjuryDaysHigh();

    void setInjuryDaysHigh(int injuryDaysHigh);

    boolean injuriesValidator(JSONObject Obj);

    boolean checkRangeInteger(int[] injuriesAttributes);

    boolean checkRangeDouble(double[] injuriesAttributes);
}
