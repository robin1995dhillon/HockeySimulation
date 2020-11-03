package dhl.leagueModel.gamePlayConfig;

import dhl.Configurables;
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
        JSONObject ageObject = (JSONObject) Obj.get(Configurables.AGING.getAction());
        int averageRetirementAge = ((Long) ageObject.get(Configurables.AVERAGERETIREMENTAGE.getAction())).intValue();
        int maximumAge = ((Long) ageObject.get(Configurables.MAXIMUMAGE.getAction())).intValue();
        int[] ageAttribute = {averageRetirementAge, maximumAge};
        boolean result = checkRange(ageAttribute);
        return result;
    }

    @Override
    public boolean checkRange(int[] ageAttribute) {
        for (int ageValue : ageAttribute) {
            if (ageValue >= 10 && ageValue <= 70) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }


}
