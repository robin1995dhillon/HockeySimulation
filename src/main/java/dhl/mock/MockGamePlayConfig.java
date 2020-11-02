package dhl.mock;

import dhl.leagueModel.gamePlayConfig.*;

public class MockGamePlayConfig {

    public static IGamePlayConfig createMock() {
        IGamePlayConfig gamePlayConfig = new GamePlayConfig();
        ITrading trading = new Trading();
        trading.setLossPoint(5);
        trading.setMaxPlayersPerTrade(5);
        trading.setRandomAcceptanceChance(5);
        trading.setRandomTradeOfferChance(5);
        gamePlayConfig.setTrading(trading);
        IAging aging = new Aging();
        aging.setAverageRetirementAge(35);
        aging.setMaximumAge(50);
        gamePlayConfig.setAging(aging);
        ITraining training = new Training();
        training.setDaysUntilStatIncreaseCheck(120);
        gamePlayConfig.setTraining(training);
        IGameResolver gameResolver = new GameResolver();
        gameResolver.setRandomWinChance(10);
        gamePlayConfig.setGameResolver(gameResolver);
        return gamePlayConfig;
    }
}
