package dhl.gamePlayConfig;

public class Trading implements ITrading {
    private int lossPoint;
    private int randomTradeOfferChance;
    private int maxPlayersPerTrade;
    private int randomAcceptanceChance;

    @Override
    public int getLossPoint() {
        return lossPoint;
    }

    @Override
    public void setLossPoint(int lossPoint) {
        this.lossPoint = lossPoint;
    }

    @Override
    public int getRandomTradeOfferChance() {
        return randomTradeOfferChance;
    }

    @Override
    public void setRandomTradeOfferChance(int randomTradeOfferChance) {
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
    public int getRandomAcceptanceChance() {
        return randomAcceptanceChance;
    }

    @Override
    public void setRandomAcceptanceChance(int randomAcceptanceChance) {
        this.randomAcceptanceChance = randomAcceptanceChance;
    }
}
