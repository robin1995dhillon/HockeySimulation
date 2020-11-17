package dhl.persistence.database2;

import dhl.leagueModel.gamePlayConfig.IGamePlayConfig;

import java.io.IOException;
import java.sql.SQLException;

public interface IConfigDB {
    void createConfig(IGamePlayConfig config, int leagueId) throws IOException, SQLException;
    IGamePlayConfig getConfig(int leagueId) throws IOException, SQLException;
    void updateConfig();
}
