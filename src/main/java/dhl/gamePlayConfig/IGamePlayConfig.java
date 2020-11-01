package dhl.gamePlayConfig;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.json.simple.JSONObject;

@JsonDeserialize(as= GamePlayConfig.class)
public interface IGamePlayConfig {
    IAging getAging();

    void setAging(IAging aging);

    IGameResolver getGameResolver();

    void setGameResolver(IGameResolver gameResolver);

    IInjuries getInjuries();

    void setInjuries(IInjuries injuries);

    ITrading getTrading();

    void setTrading(ITrading trading);

    ITraining getTraining();

    void setTraining(ITraining training);

    boolean gamePlayConfigValidator(JSONObject Obj);
}
