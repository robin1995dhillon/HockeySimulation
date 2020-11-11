package dhl.leagueModel.gamePlayConfig;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.json.simple.JSONObject;

@JsonDeserialize(as = GameResolver.class)
public interface IGameResolver {
    double getRandomWinChance();

    void setRandomWinChance(double randomWinChance);

    boolean gameResolverValidator(JSONObject Obj);

    boolean checkRange(double[] gameResolverAttributes);
}
