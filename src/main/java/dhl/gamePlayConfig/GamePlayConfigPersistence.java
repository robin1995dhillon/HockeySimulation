package dhl.gamePlayConfig;

import dhl.database.CreateConfig;
import dhl.database.ICreateStoredProcedure;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class GamePlayConfigPersistence implements IGamePlayConfigPersistence {

    @Override
    public boolean saveConfigToDB(int[] intVal, double[] doubleVal) {

        ICreateStoredProcedure SP = new CreateConfig(intVal[0],intVal[1],intVal[2],doubleVal[0],intVal[3],intVal[4],intVal[5],intVal[6],intVal[7],intVal[8],intVal[9],intVal[10]);
        try {
            SP.executeProcedure();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

}
