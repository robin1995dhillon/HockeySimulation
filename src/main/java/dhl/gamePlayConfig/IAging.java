package dhl.gamePlayConfig;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.json.simple.JSONObject;

@JsonDeserialize(as= Aging.class)
public interface IAging {
    int getAverageRetirementAge();

    void setAverageRetirementAge(int averageRetirementAge);

    int getMaximumAge();

    void setMaximumAge(int maximumAge);

    boolean agingValidator(JSONObject Obj);

    boolean checkRange(int[] ageAttribute);
}
