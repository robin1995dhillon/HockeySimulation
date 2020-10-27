package dhl.gamePlayConfig;

import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class GamePlayConfig implements IGamePlayConfig {

    Aging aging;
    GameResolver gameResolver;
    Injuries injuries;
    Trading trading;
    Training training;

    public GamePlayConfig() {
        aging = new Aging();
        gameResolver = new GameResolver();
        injuries = new Injuries();
        trading = new Trading();
        training = new Training();
    }

    @Override
    public Aging getAging() {
        return aging;
    }

    @Override
    public void setAging(Aging aging) {
        this.aging = aging;
    }

    @Override
    public GameResolver getGameResolver() {
        return gameResolver;
    }

    @Override
    public void setGameResolver(GameResolver gameResolver) {
        this.gameResolver = gameResolver;
    }

    @Override
    public Injuries getInjuries() {
        return injuries;
    }

    @Override
    public void setInjuries(Injuries injuries) {
        this.injuries = injuries;
    }

    @Override
    public Trading getTrading() {
        return trading;
    }

    @Override
    public void setTrading(Trading trading) {
        this.trading = trading;
    }

    @Override
    public Training getTraining() {
        return training;
    }

    @Override
    public void setTraining(Training training) {
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
}


