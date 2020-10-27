package dhl.gamePlayConfig;

import org.json.simple.JSONObject;

public class Training implements ITraining {
    private int daysUntilStatIncreaseCheck;

    @Override
    public int getDaysUntilStatIncreaseCheck() {
        return daysUntilStatIncreaseCheck;
    }

    @Override
    public void setDaysUntilStatIncreaseCheck(int daysUntilStatIncreaseCheck) {
        this.daysUntilStatIncreaseCheck = daysUntilStatIncreaseCheck;
    }

    @Override
    public boolean trainingValidator(JSONObject Obj) {
        JSONObject trainingObject = (JSONObject) Obj.get("training");
        int daysUntilStatIncreaseCheck = ((Long) trainingObject.get("daysUntilStatIncreaseCheck")).intValue();
        int [] trainingAttribute = {daysUntilStatIncreaseCheck};
        boolean result = checkRange(trainingAttribute);
        return result;
    }

    @Override
    public boolean checkRange(int[] trainingAttribute) {
        for(int a: trainingAttribute) {
            if(a>=0 && a<=300) {
                continue;
            }
            else {
                return false;
            }
        }
        return true;
    }

}
