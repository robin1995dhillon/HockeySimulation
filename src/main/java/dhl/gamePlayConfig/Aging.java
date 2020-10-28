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

    @Override
    public boolean agingValidator(JSONObject Obj) {
        JSONObject ageObject = (JSONObject) Obj.get("aging");
        int averageRetirementAge = ((Long) ageObject.get("averageRetirementAge")).intValue();
        int maximumAge = ((Long) ageObject.get("maximumAge")).intValue();
        int [] ageAttribute = {averageRetirementAge, maximumAge};
        boolean result = checkRange(ageAttribute);
        return result;
    }

    @Override
    public boolean checkRange(int[] ageAttribute) {
        for(int a: ageAttribute) {
            if(a>=10 && a<=70) {
                continue;
            }
            else {
                return false;
            }
        }
        return true;
    }


}
