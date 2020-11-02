package dhl.loading;

import dhl.gamePlayConfig.IGamePlayConfig;

import java.io.IOException;
import java.sql.SQLException;

public interface ILoadGamePlayConfig {
    IGamePlayConfig loadGameGonfig(int leagueId) throws IOException, SQLException;
}
