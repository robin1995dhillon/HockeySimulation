package dhl.gamePlayConfig;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.json.simple.JSONObject;

@JsonDeserialize(as= GamePlayConfig.class)
public interface IGamePlayConfig {
    Aging getAging();

    void setAging(Aging aging);

    GameResolver getGameResolver();

    void setGameResolver(GameResolver gameResolver);

    Injuries getInjuries();

    void setInjuries(Injuries injuries);

    Trading getTrading();

    void setTrading(Trading trading);

    Training getTraining();

    void setTraining(Training training);

    boolean gamePlayConfigValidator(JSONObject Obj);
}
