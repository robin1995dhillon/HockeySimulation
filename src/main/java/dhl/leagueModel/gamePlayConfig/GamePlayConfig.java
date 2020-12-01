package dhl.leagueModel.gamePlayConfig;

import dhl.Configurables;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class GamePlayConfig implements IGamePlayConfig {

    private IAging aging;
    private IGameResolver gameResolver;
    private IInjuries injuries;
    private ITrading trading;
    private ITraining training;

    public GamePlayConfig() {
        aging = new Aging();
        gameResolver = new GameResolver();
        injuries = new Injuries();
        trading = new Trading();
        training = new Training();
    }

    public GamePlayConfig(IAging aging, IGameResolver gameResolver, IInjuries injuries, ITrading trading, ITraining training) {
        this.aging = aging;
        this.gameResolver = gameResolver;
        this.injuries = injuries;
        this.trading = trading;
        this.training = training;
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
        JSONObject gamePlayConfigObject = (JSONObject) Obj.get(Configurables.GAMEPLAYCONFIG.getAction());
        List<Boolean> results = new ArrayList<>();
        IAging aging = new Aging();
        IGameResolver gameResolver = new GameResolver();
        IInjuries injuries = new Injuries();
        ITraining training = new Training();
        ITrading trading = new Trading();
        results.add(aging.agingValidator(gamePlayConfigObject));
        results.add(injuries.injuriesValidator(gamePlayConfigObject));
        results.add(training.trainingValidator(gamePlayConfigObject));
        results.add(trading.tradingValidator(gamePlayConfigObject));
        if (results.contains(false)) {
            return false;
        } else {
            return true;
        }
    }
}


