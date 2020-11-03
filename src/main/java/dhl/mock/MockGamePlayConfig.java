package dhl.mock;

import dhl.leagueModel.gamePlayConfig.*;

public class MockGamePlayConfig {

    public static IGamePlayConfig createMock() {
        IGamePlayConfig gamePlayConfig = new GamePlayConfig();
        ITrading trading = new Trading();
        trading.setLossPoint(6);
        trading.setMaxPlayersPerTrade(3);
        trading.setRandomAcceptanceChance(0.27);
        trading.setRandomTradeOfferChance(0.13);
        gamePlayConfig.setTrading(trading);
        IAging aging = new Aging();
        aging.setAverageRetirementAge(37);
        aging.setMaximumAge(49);
        gamePlayConfig.setAging(aging);
        ITraining training = new Training();
        training.setDaysUntilStatIncreaseCheck(40);
        gamePlayConfig.setTraining(training);
        IGameResolver gameResolver = new GameResolver();
        gameResolver.setRandomWinChance(0.66);
        gamePlayConfig.setGameResolver(gameResolver);
        IInjuries injuries = new Injuries();
        injuries.setInjuryDaysHigh(5);
        injuries.setInjuryDaysLow(94);
        injuries.setRandomInjuryChance(0.9);
        return gamePlayConfig;
    }
}
