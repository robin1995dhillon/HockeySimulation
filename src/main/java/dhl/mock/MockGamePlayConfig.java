package dhl.mock;

import dhl.leagueModel.LeagueModelAbstractFactory;
import dhl.leagueModel.gamePlayConfig.*;

public class MockGamePlayConfig {
    LeagueModelAbstractFactory leagueModelAbstractFactory;
    IGamePlayConfig gamePlayConfig;

    public MockGamePlayConfig() {
        leagueModelAbstractFactory = LeagueModelAbstractFactory.instance();
        gamePlayConfig = leagueModelAbstractFactory.getGamePlayConfig();
    }

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

    public IGamePlayConfig createGamePlayConfig() {
        gamePlayConfig.getAging().setAverageRetirementAge(35);
        gamePlayConfig.getAging().setMaximumAge(55);
        gamePlayConfig.getAging().setStatDecayChance(0.02);
        gamePlayConfig.getInjuries().setInjuryDaysLow(2);
        gamePlayConfig.getInjuries().setInjuryDaysHigh(132);
        gamePlayConfig.getInjuries().setRandomInjuryChance(0.85);
        gamePlayConfig.getTraining().setDaysUntilStatIncreaseCheck(363);
        gamePlayConfig.getTrading().setLossPoint(4);
        gamePlayConfig.getTrading().setRandomTradeOfferChance(0.06);
        gamePlayConfig.getTrading().setMaxPlayersPerTrade(4);
        gamePlayConfig.getTrading().setRandomAcceptanceChance(0.27);
//        gamePlayConfig.getTrading().getGmTable().setGambler(-0.1);
//        gamePlayConfig.getTrading().getGmTable().setNormal(0.0);
//        gamePlayConfig.getTrading().getGmTable().setGambler(0.1);
        return gamePlayConfig;
    }
}
