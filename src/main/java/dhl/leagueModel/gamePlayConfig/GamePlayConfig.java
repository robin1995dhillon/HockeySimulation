package dhl.leagueModel.gamePlayConfig;

import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class GamePlayConfig implements IGamePlayConfig {

    IAging aging;
    IGameResolver gameResolver;
    IInjuries injuries;
    ITrading trading;
    ITraining training;

    public GamePlayConfig() {
        aging = new Aging();
        gameResolver = new GameResolver();
        injuries = new Injuries();
        trading = new Trading();
        training = new Training();
    }

    @Override
    public IAging getAging() {
        return aging;
    }

    @Override
    public void setAging(IAging aging) {
        this.aging = aging;
    }

    @Override
    public IGameResolver getGameResolver() {
        return gameResolver;
    }

    @Override
    public void setGameResolver(IGameResolver gameResolver) {
        this.gameResolver = gameResolver;
    }

    @Override
    public IInjuries getInjuries() {
        return injuries;
    }

    @Override
    public void setInjuries(IInjuries injuries) {
        this.injuries = injuries;
    }

    @Override
    public ITrading getTrading() {
        return trading;
    }

    @Override
    public void setTrading(ITrading trading) {
        this.trading = trading;
    }

    @Override
    public ITraining getTraining() {
        return training;
    }

    @Override
    public void setTraining(ITraining training) {
        this.training = training;
    }

    @Override
    public boolean gamePlayConfigValidator(JSONObject Obj) {
        JSONObject gamePlayConfigObject = (JSONObject) Obj.get("gameplayConfig");
        List<Boolean> results = new ArrayList<>();
//        IAging aging = new Aging();
        IGameResolver gameResolver = new GameResolver();
        IInjuries injuries = new Injuries();
        ITraining training = new Training();
        ITrading trading = new Trading();
        results.add(aging.agingValidator(gamePlayConfigObject));
        results.add(gameResolver.gameResolverValidator(gamePlayConfigObject));
        results.add(injuries.injuriesValidator(gamePlayConfigObject));
        results.add(training.trainingValidator(gamePlayConfigObject));
        results.add(trading.tradingValidator(gamePlayConfigObject));

        if(results.contains(false)) {
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    public boolean saveGamePlayConfigToDB(int leagueID) {
        int maximumAge = this.aging.getMaximumAge();
        int averageRetirementAge = this.aging.getAverageRetirementAge();
        double randomWinChance = this.gameResolver.getRandomWinChance();
        int injuryDaysHigh = this.injuries.getInjuryDaysHigh();
        int injuryDaysLow = this.injuries.getInjuryDaysLow();
        double randomInjuryChance = this.injuries.getRandomInjuryChance();
        int lossPoint = this.trading.getLossPoint();
        int maxPlayersPerTrade =  this.trading.getMaxPlayersPerTrade();
        double randomAcceptanceChance = this.trading.getRandomAcceptanceChance();
        double randomTradeOfferChance = this.trading.getRandomTradeOfferChance();
        int daysUntilStatIncreaseCheck = this.training.getDaysUntilStatIncreaseCheck();

        int[] gamePlayAttributesInteger = {averageRetirementAge,maximumAge,injuryDaysLow,injuryDaysHigh,daysUntilStatIncreaseCheck,lossPoint,maxPlayersPerTrade,leagueID};
        double[] gamePlayAttributesDouble = {randomInjuryChance, randomWinChance,randomAcceptanceChance,randomTradeOfferChance};

        IGamePlayConfigPersistence gamePlayConfigPersistence = new GamePlayConfigPersistence();
        gamePlayConfigPersistence.saveConfigToDB(gamePlayAttributesInteger,gamePlayAttributesDouble);
        return true;
    }


}


