package dhl.leagueModel.gamePlayConfig;

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
        JSONObject gameResolverObject = (JSONObject) Obj.get("gameResolver");
        double randomWinChance = (double) gameResolverObject.get("randomWinChance");
        double[] gameResolverAttributes = {randomWinChance};
        boolean result = checkRange(gameResolverAttributes);
        return result;
    }

    @Override
    public boolean checkRange(double[] gameResolverAttributes) {
        for(double a: gameResolverAttributes) {
            if(a>=0 && a<=1) {
                continue;
            }
            else {
                return false;
            }
        }
        return true;
    }

}
