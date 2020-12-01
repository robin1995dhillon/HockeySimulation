package dhl.leagueModel.gamePlayConfig;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.json.simple.JSONObject;

@JsonDeserialize(as = Training.class)
public interface ITraining {
    int getDaysUntilStatIncreaseCheck();

    void setDaysUntilStatIncreaseCheck(int daysUntilStatIncreaseCheck);

    boolean trainingValidator(JSONObject Obj);

    boolean checkRange(int[] trainingAttribute);

    int getDaysTrained();

    void setDaysTrained(int daysTrained);


}
