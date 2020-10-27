package dhl.gamePlayConfig;

public interface ITrading {
    int getLossPoint();

    void setLossPoint(int lossPoint);

    int getRandomTradeOfferChance();

    void setRandomTradeOfferChance(int randomTradeOfferChance);

    int getMaxPlayersPerTrade();

    void setMaxPlayersPerTrade(int maxPlayersPerTrade);

    int getRandomAcceptanceChance();

    void setRandomAcceptanceChance(int randomAcceptanceChance);
}
