//package dhl.persistence.database2;
//
//import dhl.leagueModel.gamePlayConfig.*;
//
//import java.io.IOException;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class ConfigDB implements IConfigDB {
//
//    @Override
//    public void createConfig(IGamePlayConfig config, int leagueId) throws IOException, SQLException {
//        IStoredProcedure storedProcedure = new StoredProcedure("create_config(?,?,?,?,?,?,?,?,?,?,?,?)");
//        storedProcedure.addParameter(1, config.getAging().getAverageRetirementAge());
//        storedProcedure.addParameter(2, config.getAging().getMaximumAge());
//        storedProcedure.addParameter(3, config.getGameResolver().getRandomWinChance());
//        storedProcedure.addParameter(4, config.getInjuries().getRandomInjuryChance());
//        storedProcedure.addParameter(5, config.getInjuries().getInjuryDaysLow());
//        storedProcedure.addParameter(6, config.getInjuries().getInjuryDaysHigh());
//        storedProcedure.addParameter(7, config.getTraining().getDaysUntilStatIncreaseCheck());
//        storedProcedure.addParameter(8, config.getTrading().getLossPoint());
//        storedProcedure.addParameter(9, config.getTrading().getRandomTradeOfferChance());
//        storedProcedure.addParameter(10, config.getTrading().getMaxPlayersPerTrade());
//        storedProcedure.addParameter(11, config.getTrading().getRandomAcceptanceChance());
//        storedProcedure.addParameter(12, leagueId);
//        storedProcedure.execute();
//        storedProcedure.closeConnection();
//    }
//
//    @Override
//    public IGamePlayConfig getConfig(int leagueId) throws IOException, SQLException {
//        IStoredProcedure storedProcedure = new StoredProcedure("get_config(?)");
//        storedProcedure.addParameter(1, leagueId);
//        ResultSet rs = storedProcedure.getResult();
//        if(rs == null){
//            System.out.println("This league does not have game play configs");
//        }
//        IGamePlayConfig gamePlayConfig = new GamePlayConfig();
//        while(rs.next()){
//            IAging aging = new Aging();
//            aging.setAverageRetirementAge(rs.getInt(2));
//            aging.setMaximumAge(rs.getInt(3));
//            gamePlayConfig.setAging(aging);
//            IGameResolver gameResolver = new GameResolver();
//            gameResolver.setRandomWinChance(rs.getDouble(4));
//            gamePlayConfig.setGameResolver(gameResolver);
//            IInjuries injuries = new Injuries();
//            injuries.setRandomInjuryChance(rs.getDouble(5));
//            injuries.setInjuryDaysLow(rs.getInt(6));
//            injuries.setInjuryDaysHigh(rs.getInt(7));
//            gamePlayConfig.setInjuries(injuries);
//            ITraining training = new Training();
//            training.setDaysUntilStatIncreaseCheck(rs.getInt(8));
//            gamePlayConfig.setTraining(training);
//            ITrading trading = new Trading();
//            trading.setLossPoint(rs.getInt(9));
//            trading.setRandomTradeOfferChance(rs.getDouble(10));
//            trading.setMaxPlayersPerTrade(rs.getInt(11));
//            trading.setRandomAcceptanceChance(rs.getDouble(12));
//            gamePlayConfig.setTrading(trading);
//        }
//        return gamePlayConfig;
//    }
//
//    @Override
//    public void updateConfig() {
//
//    }
//}
