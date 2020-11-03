package dhl.leagueModel.gamePlayConfig;

public interface IGamePlayConfigPersistence {
    boolean saveConfigToDB(int[] intVal, double[] doubleVal);
}
