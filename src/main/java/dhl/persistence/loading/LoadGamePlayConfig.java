package dhl.persistence.loading;

import dhl.persistence.database.GetConfig;
import dhl.persistence.database.IGetStoredProcedure;
import dhl.leagueModel.gamePlayConfig.*;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoadGamePlayConfig implements ILoadGamePlayConfig {

    public IGamePlayConfig loadGameConfig(int leagueId) throws IOException, SQLException {
        IGetStoredProcedure getConfig = new GetConfig(leagueId);
        ResultSet rsGetConfig = getConfig.executeProcedure();
        IGamePlayConfig gamePlayConfig = new GamePlayConfig();
        while(rsGetConfig.next()){
            IAging aging = new Aging();
            aging.setAverageRetirementAge(rsGetConfig.getInt("average_retirement_age"));
            aging.setMaximumAge(rsGetConfig.getInt("maximum_age"));
            gamePlayConfig.setAging(aging);
            IGameResolver gameResolver = new GameResolver();
            gameResolver.setRandomWinChance(rsGetConfig.getDouble("random_win_chance"));
            gamePlayConfig.setGameResolver(gameResolver);
            IInjuries injuries = new Injuries();
            injuries.setRandomInjuryChance(rsGetConfig.getDouble("random_injury_chance"));
            injuries.setInjuryDaysLow(rsGetConfig.getInt("injury_days_low"));
            injuries.setInjuryDaysHigh(rsGetConfig.getInt("injury_days_high"));
            gamePlayConfig.setInjuries(injuries);
            ITraining training = new Training();
            training.setDaysUntilStatIncreaseCheck(rsGetConfig.getInt("days_until_stat_increase_check"));
            gamePlayConfig.setTraining(training);
            ITrading trading = new Trading();
            trading.setLossPoint(rsGetConfig.getInt("loss_point"));
            trading.setRandomTradeOfferChance(rsGetConfig.getDouble("random_trade_offer_chance"));
            trading.setMaxPlayersPerTrade(rsGetConfig.getInt("max_players_per_trade"));
            trading.setRandomAcceptanceChance(rsGetConfig.getDouble("random_acceptance_chance"));
            gamePlayConfig.setTrading(trading);
        }
        return gamePlayConfig;
    }
}
