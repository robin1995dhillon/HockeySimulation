package dhl.persistence.loading;

import dhl.leagueModel.gamePlayConfig.IGamePlayConfig;

import java.io.IOException;
import java.sql.SQLException;

public interface ILoadGamePlayConfig {
    IGamePlayConfig loadGameGonfig(int leagueId) throws IOException, SQLException;
}
