package dhl.leagueModel.gamePlayConfig;

import dhl.persistence.database.CreateConfig;
import dhl.persistence.database.ICreateStoredProcedure;

import java.io.IOException;
import java.sql.SQLException;

public class GamePlayConfigPersistence implements IGamePlayConfigPersistence {

    @Override
    public boolean saveConfigToDB(int[] intVal, double[] doubleVal) {
        ICreateStoredProcedure SP = new CreateConfig(intVal[0], intVal[1], doubleVal[1], doubleVal[0], intVal[2], intVal[3], intVal[4], intVal[5], doubleVal[3], intVal[6], doubleVal[2], intVal[7]);
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
