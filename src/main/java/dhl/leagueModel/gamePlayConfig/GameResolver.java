package dhl.leagueModel.gamePlayConfig;

import dhl.Configurables;
import org.json.simple.JSONObject;

public class GameResolver implements IGameResolver {
    private double randomWinChance;

    @Override
    public double getRandomWinChance() {
        return randomWinChance;
    }

    @Override
    public void setRandomWinChance(double randomWinChance) {
        this.randomWinChance = randomWinChance;
    }

    @Override
    public boolean gameResolverValidator(JSONObject Obj) {
        JSONObject gameResolverObject = (JSONObject) Obj.get(Configurables.GAMERESOLVER.getAction());
        double randomWinChance = (double) gameResolverObject.get(Configurables.RANDOMWINCHANCE.getAction());
        double[] gameResolverAttributes = {randomWinChance};
        boolean result = checkRange(gameResolverAttributes);
        return result;
    }

    @Override
    public boolean checkRange(double[] gameResolverAttributes) {
        for (double attributeValue : gameResolverAttributes) {
            if (attributeValue >= 0 && attributeValue <= 1) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

}
