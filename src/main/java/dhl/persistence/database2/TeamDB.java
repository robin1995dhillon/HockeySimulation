//package dhl.persistence.database2;
//
//import dhl.leagueModel.headCoach.IHeadCoach;
//import dhl.leagueModel.players.IPlayers;
//import dhl.leagueModel.teams.ITeam;
//import dhl.leagueModel.teams.Teams;
//import java.io.IOException;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class TeamDB implements ITeamDB{
//
//    @Override
//    public int createTeam(String teamName, String managerName, boolean is_user) throws IOException, SQLException {
//        IStoredProcedure storedProcedure = new StoredProcedure("create_team(?,?,?)");
//        storedProcedure.addParameter(1, teamName);
//        storedProcedure.addParameter(2, managerName);
//        storedProcedure.addParameter(3, is_user);
//        ResultSet rs = storedProcedure.getResult();
//        int teamId = 0;
//        while(rs.next()){
//            teamId = rs.getInt(1);
//        }
//        storedProcedure.closeConnection();
//        return teamId;
//    }
//
//    @Override
//    public boolean checkTeam(String teamName) throws IOException, SQLException {
//        IStoredProcedure storedProcedure = new StoredProcedure("check_team(?)");
//        storedProcedure.addParameter(1, teamName);
//        ResultSet rs = storedProcedure.getResult();
//        boolean exist = false;
//        while(rs.next()){
//            exist = rs.getBoolean(1);
//        }
//        storedProcedure.closeConnection();
//        return exist;
//    }
//
////    @Override
////    public List<ITeam> getAllTeamInDivision(int divisionId) throws IOException, SQLException {
////        IStoredProcedure storedProcedure = new StoredProcedure("get_all_team_in_division(?)");
////        storedProcedure.addParameter(1, divisionId);
////        ResultSet rs = storedProcedure.getResult();
////        if(rs == null){
////            System.out.println("This division does not have teams");
////        }
////        List<ITeam> teamList = new ArrayList<>();
////        while(rs.next()){
////            int teamId = rs.getInt(1);
////            ITeam team = new Teams();
////            team.setTeamName(rs.getString(2));
////            team.setGeneralManager(rs.getString(3));
////            ICoachDB coachDB = new CoachDB();
////            IHeadCoach headCoach = coachDB.getHeadCoach(teamId);
////            team.setHeadCoach(headCoach);
////            IPlayerDB playerDB = new PlayerDB();
////            List<IPlayers> playerList = playerDB.getTeamPlayer(teamId);
////            team.setPlayers(playerList);
////            team.setIsUser(rs.getBoolean(4));
////            teamList.add(team);
////        }
////        storedProcedure.closeConnection();
////        return teamList;
////    }
//
//    @Override
//    public int getTeamIdByTeamName(String teamName) throws IOException, SQLException {
//        IStoredProcedure storedProcedure = new StoredProcedure("get_team_by_name(?)");
//        storedProcedure.addParameter(1, teamName);
//        ResultSet rs = storedProcedure.getResult();
//        int teamId = 0;
//        while(rs.next()){
//            teamId = rs.getInt(1);
//        }
//        return teamId;
//    }
//
//    @Override
//    public void updateTeam() {
//
//    }
//}
