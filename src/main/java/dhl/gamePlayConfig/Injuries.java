package dhl.gamePlayConfig;

import org.json.simple.JSONObject;

public class Injuries implements IInjuries {
    double randomInjuryChance = 0.05;
    int injuryDaysLow = 1;
    int injuryDaysHigh = 260;

    @Override
    public double getRandomInjuryChance() {
        return randomInjuryChance;
    }

    @Override
    public void setRandomInjuryChance(double randomInjuryChance) {
        this.randomInjuryChance = randomInjuryChance;
    }

    @Override
    public int getInjuryDaysLow() {
        return injuryDaysLow;
    }

    @Override
    public void setInjuryDaysLow(int injuryDaysLow) {
        this.injuryDaysLow = injuryDaysLow;
    }

    @Override
    public int getInjuryDaysHigh() {
        return injuryDaysHigh;
    }

    @Override
    public void setInjuryDaysHigh(int injuryDaysHigh) {
        this.injuryDaysHigh = injuryDaysHigh;
    }

    @Override
    public boolean injuriesValidator(JSONObject Obj) {
        JSONObject injuriesObject = (JSONObject) Obj.get("injuries");
        double randomInjuryChance = (double) injuriesObject.get("randomInjuryChance");
        int injuryDaysLow = ((Long) injuriesObject.get("injuryDaysLow")).intValue();
        int injuryDaysHigh = ((Long) injuriesObject.get("injuryDaysHigh")).intValue();
        int[] injuriesAttributesInt = {injuryDaysLow,injuryDaysHigh};
        double[] injuriesAttributesDouble = {randomInjuryChance};
        boolean resultDouble = checkRangeDouble(injuriesAttributesDouble);
        boolean resultInt = checkRangeInteger(injuriesAttributesInt);
        return (resultDouble && resultInt);
    }

    @Override
    public boolean checkRangeInteger(int[] injuriesAttributes) {
        for(int a: injuriesAttributes) {
            if(a>=0 && a<=365) {
                continue;
            }
            else {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean checkRangeDouble(double[] injuriesAttributes) {
        for(double a: injuriesAttributes) {
            if(a>=0 && a<=1) {
                continue;
            }
            else {
                return false;
            }
        }
        return true;
    }
}
