package dhl.gamePlayConfig;

import org.json.simple.JSONObject;

public class Aging implements IAging {
    private int averageRetirementAge;
    private int maximumAge;

    @Override
    public int getAverageRetirementAge() {
        return averageRetirementAge;
    }

    @Override
    public void setAverageRetirementAge(int averageRetirementAge) {
        this.averageRetirementAge = averageRetirementAge;
    }

    @Override
    public int getMaximumAge() {
        return maximumAge;
    }

    @Override
    public void setMaximumAge(int maximumAge) {
        this.maximumAge = maximumAge;
    }

    public boolean agingValidator(JSONObject Obj) {
        JSONObject ageObject = (JSONObject) Obj.get("aging");
        


        return true;
    }


}
