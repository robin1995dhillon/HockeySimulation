package dhl.gamePlayConfig;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import dhl.LeagueModel.Division;
import org.json.simple.JSONObject;

@JsonDeserialize(as= GameResolver.class)
public interface IGameResolver {
    int getRandomWinChance();

    void setRandomWinChance(int randomWinChance);

    boolean gameResolverValidator(JSONObject Obj);

    boolean checkRange(double[] gameResolverAttributes);
}
