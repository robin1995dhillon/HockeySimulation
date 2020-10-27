package dhl.gamePlayConfig;

public class GameResolver implements IGameResolver {
    private int randomWinChance;

    @Override
    public int getRandomWinChance() {
        return randomWinChance;
    }

    @Override
    public void setRandomWinChance(int randomWinChance) {
        this.randomWinChance = randomWinChance;
    }

}
