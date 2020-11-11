package dhl.leagueModel.gamePlayConfig;

import dhl.Configurables;
import org.json.simple.JSONObject;

public class Trading implements ITrading {
    private int lossPoint;
    private double randomTradeOfferChance;
    private int maxPlayersPerTrade;
    private double randomAcceptanceChance;

    @Override
    public int getLossPoint() {
        return lossPoint;
    }

    @Override
    public void setLossPoint(int lossPoint) {
        this.lossPoint = lossPoint;
    }

    @Override
    public double getRandomTradeOfferChance() {
        return randomTradeOfferChance;
    }

    @Override
    public void setRandomTradeOfferChance(double randomTradeOfferChance) {
        this.randomTradeOfferChance = randomTradeOfferChance;
    }

    @Override
    public int getMaxPlayersPerTrade() {
        return maxPlayersPerTrade;
    }

    @Override
    public void setMaxPlayersPerTrade(int maxPlayersPerTrade) {
        this.maxPlayersPerTrade = maxPlayersPerTrade;
    }

    @Override
    public double getRandomAcceptanceChance() {
        return randomAcceptanceChance;
    }

    @Override
    public void setRandomAcceptanceChance(double randomAcceptanceChance) {
        this.randomAcceptanceChance = randomAcceptanceChance;
    }

    @Override
    public boolean tradingValidator(JSONObject Obj) {
        JSONObject tradingObject = (JSONObject) Obj.get(Configurables.TRADING.getAction());
        double randomTradeOfferChance = (double) tradingObject.get(Configurables.RANDOMTRADEOFFERCHANCE.getAction());
        double randomAcceptanceChance = (double) tradingObject.get(Configurables.RANDOMACCEPTANCECHANCE.getAction());
        int lossPoint = ((Long) tradingObject.get(Configurables.LOSSPOINT.getAction())).intValue();
        int maxPlayersPerTrade = ((Long) tradingObject.get(Configurables.MAXPLAYERSPERTRADE.getAction())).intValue();
        int[] tradingAttributesInteger = {lossPoint, maxPlayersPerTrade};
        double[] tradingAttributesDouble = {randomTradeOfferChance, randomAcceptanceChance};
        boolean resultDouble = checkRangeDouble(tradingAttributesDouble);
        boolean resultInt = checkRangeInteger(tradingAttributesInteger);
        return (resultDouble && resultInt);
    }

    @Override
    public boolean checkRangeInteger(int[] tradingAttributes) {
        for (int attributeValue : tradingAttributes) {
            if (attributeValue >= 0 && attributeValue <= 365) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean checkRangeDouble(double[] tradingAttributes) {
        for (double attributeValue : tradingAttributes) {
            if (attributeValue >= 0 && attributeValue <= 1) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
