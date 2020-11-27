//package dhl.persistence.database2;
//
//import dhl.leagueModel.conference.IConference;
//import dhl.leagueModel.IFreeAgents;
//import dhl.leagueModel.gamePlayConfig.IGamePlayConfig;
//import dhl.leagueModel.headCoach.IHeadCoach;
//import dhl.leagueModel.league.ILeague;
//import dhl.leagueModel.league.League;
//import java.io.IOException;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;
//
//public class LeagueDB implements ILeagueDB{
//
//    @Override
//    public int createLeague(String leagueName) throws SQLException, IOException{
//        IStoredProcedure storedProcedure = new StoredProcedure("create_league(?)");
//        storedProcedure.addParameter(1, leagueName);
//        ResultSet rs = storedProcedure.getResult();
//        int leagueId = 0;
//        while(rs.next()){
//            leagueId = rs.getInt(1);
//        }
//        storedProcedure.closeConnection();
//        return leagueId;
//    }
//
//    @Override
//    public boolean checkLeague(String leagueName) throws SQLException, IOException{
//        IStoredProcedure storedProcedure = new StoredProcedure("check_league(?)");
//        storedProcedure.addParameter(1, leagueName);
//        ResultSet rs = storedProcedure.getResult();
//        boolean exist = false;
//        while(rs.next()){
//            exist = rs.getBoolean(1);
//        }
//        storedProcedure.closeConnection();
//        return exist;
//    }
//
//    @Override
//    public ILeague getLeague(int teamId) throws SQLException, IOException{
//        IStoredProcedure storedProcedure = new StoredProcedure("get_league(?)");
//        storedProcedure.addParameter(1, teamId);
//        ResultSet rs = storedProcedure.getResult();
//        if(rs == null){
//            System.out.println("The league does not exist");
//        }
//        ILeague league = new League();
//        while(rs.next()){
//            int leagueId = rs.getInt(1);
//            league.setLeagueName(rs.getString(2));
//            IConferenceDB conferenceDB = new ConferenceDB();
//            List<IConference> conferenceList = conferenceDB.getAllConferenceInLeague(leagueId);
//            league.setConferences(conferenceList);
//            IFreeAgentDB freeAgentDB = new FreeAgentDB();
//            List<IFreeAgents> freeAgentList = freeAgentDB.getFreeAgent(leagueId);
//            league.setFreeAgents(freeAgentList);
//            ICoachDB coachDB = new CoachDB();
//            List<IHeadCoach> coachList = coachDB.getFreeCoach(leagueId);
//            league.setHeadCoach(coachList);
//            IManagerDB managerDB = new ManagerDB();
//            List<String> managerList = managerDB.getFreeManager(leagueId);
//            league.setGeneralManager(managerList);
//            IConfigDB configDB = new ConfigDB();
//            IGamePlayConfig gamePlayConfig = configDB.getConfig(leagueId);
//            league.setGameplayConfig(gamePlayConfig);
//        }
//        storedProcedure.closeConnection();
//        return league;
//    }
//
//    @Override
//    public void updateLeague() {
//
//    }
//}
