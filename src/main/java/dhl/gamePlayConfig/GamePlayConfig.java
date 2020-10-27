package dhl.gamePlayConfig;

public class GamePlayConfig implements IGamePlayConfig {

    Aging aging;
    GameResolver gameResolver;
    Injuries injuries;
    Trading trading;
    Training training;

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
}
