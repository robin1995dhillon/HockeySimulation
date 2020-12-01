package dhl.leagueModel.gamePlayConfig;

import dhl.Configurables;
import org.json.simple.JSONObject;

public class Injuries implements IInjuries {

    private double randomInjuryChance;
    private int injuryDaysLow;
    int injuryDaysHigh;

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
        JSONObject injuriesObject = (JSONObject) Obj.get(Configurables.INJURIES.getAction());
        double randomInjuryChance = (double) injuriesObject.get(Configurables.RANDOMINJURYCHANCE.getAction());
        int injuryDaysLow = ((Long) injuriesObject.get(Configurables.INJURYDAYSLOW.getAction())).intValue();
        int injuryDaysHigh = ((Long) injuriesObject.get(Configurables.INJURYDAYSHIGH.getAction())).intValue();
        int[] injuriesAttributesInt = {injuryDaysLow, injuryDaysHigh};
        double[] injuriesAttributesDouble = {randomInjuryChance};
        boolean resultDouble = checkRangeDouble(injuriesAttributesDouble);
        boolean resultInt = checkRangeInteger(injuriesAttributesInt);
        return (resultDouble && resultInt);
    }

    @Override
    public boolean checkRangeInteger(int[] injuriesAttributes) {
        for (int attributeValue : injuriesAttributes) {
            if (attributeValue >= 0 && attributeValue <= 365) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean checkRangeDouble(double[] injuriesAttributes) {
        for (double attributeValue : injuriesAttributes) {
            if (attributeValue >= 0 && attributeValue <= 1) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
