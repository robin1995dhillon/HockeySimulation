//package dhl.persistence.database2;
//
//import dhl.leagueModel.players.IPlayers;
//import dhl.leagueModel.players.Players;
//
//import java.io.IOException;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class PlayerDB implements IPlayerDB{
//
//    @Override
//    public void createPlayer(IPlayers players, int teamId) throws IOException, SQLException {
//        IStoredProcedure storedProcedure = new StoredProcedure("create_player(?,?,?,?,?,?,?,?,?,?,?,?)");
//        storedProcedure.addParameter(1, players.getPlayerName());
//        storedProcedure.addParameter(2, players.getPosition());
//        storedProcedure.addParameter(3, players.getCaptain());
//        storedProcedure.addParameter(4, players.getAge());
//        storedProcedure.addParameter(5, players.getSkating());
//        storedProcedure.addParameter(6, players.getShooting());
//        storedProcedure.addParameter(7, players.getChecking());
//        storedProcedure.addParameter(8, players.getSaving());
//        storedProcedure.addParameter(9, teamId);
//        storedProcedure.addParameter(10, players.isRetired());
//        storedProcedure.addParameter(11, players.isInjured());
//        storedProcedure.addParameter(12, players.getInjuredDays());
//        storedProcedure.execute();
//        storedProcedure.closeConnection();
//    }
//
//    @Override
//    public List<IPlayers> getTeamPlayer(int teamId) throws IOException, SQLException {
//        IStoredProcedure storedProcedure = new StoredProcedure("get_team_player(?)");
//        storedProcedure.addParameter(1, teamId);
//        ResultSet rs = storedProcedure.getResult();
//        if(rs == null){
//            System.out.println("This team does not have players");
//        }
//        List<IPlayers> playerList = new ArrayList<>();
//        while(rs.next()){
//            IPlayers player = new Players();
//            player.setPlayerName(rs.getString(2));
//            player.setPosition(rs.getString(3));
//            player.setCaptain(rs.getBoolean(4));
//            player.setAge(rs.getInt(5));
//            player.setSkating(rs.getInt(6));
//            player.setShooting(rs.getInt(7));
//            player.setChecking(rs.getInt(8));
//            player.setSaving(rs.getInt(9));
//            player.setInjured(rs.getBoolean(10));
//            player.setRetired(rs.getBoolean(11));
//            player.setInjuredDays(rs.getInt(12));
//            playerList.add(player);
//        }
//        storedProcedure.closeConnection();
//        return playerList;
//    }
//
//    @Override
//    public void updatePlayer() {
//
//    }
//}
