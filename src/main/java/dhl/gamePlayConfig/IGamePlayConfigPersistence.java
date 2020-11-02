package dhl.gamePlayConfig;

import java.util.ArrayList;

public interface IGamePlayConfigPersistence {
    boolean saveConfigToDB(int[] intVal, double[] doubleVal);
}
