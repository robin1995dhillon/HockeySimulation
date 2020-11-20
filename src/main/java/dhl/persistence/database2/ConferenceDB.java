//package dhl.persistence.database2;
//
//import dhl.leagueModel.conference.Conference;
//import dhl.leagueModel.conference.IConference;
//import dhl.leagueModel.division.IDivision;
//
//import java.io.IOException;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ConferenceDB implements IConferenceDB{
//
//    @Override
//    public int createConference(String conferenceName) throws IOException, SQLException {
//        IStoredProcedure storedProcedure = new StoredProcedure("create_conference(?)");
//        storedProcedure.addParameter(1, conferenceName);
//        ResultSet rs = storedProcedure.getResult();
//        int conferenceId = 0;
//        while(rs.next()){
//            conferenceId = rs.getInt(1);
//        }
//        storedProcedure.closeConnection();
//        return conferenceId;
//    }
//
//    @Override
//    public List<IConference> getAllConferenceInLeague(int leagueId) throws IOException, SQLException {
//        IStoredProcedure storedProcedure = new StoredProcedure("get_all_conference_in_league(?)");
//        storedProcedure.addParameter(1, leagueId);
//        ResultSet rs = storedProcedure.getResult();
//        if(rs == null){
//            System.out.println("This league does not have conferences");
//        }
//        List<IConference> conferenceList = new ArrayList<>();
//        while(rs.next()){
//            int conferenceId = rs.getInt(1);
//            IConference conference = new Conference();
//            conference.setConferenceName(rs.getString(2));
//            IDivisionDB divisionDB = new DivisionDB();
//            List<IDivision> divisionList = divisionDB.getAllDivisionInConference(conferenceId);
//            conference.setDivisions(divisionList);
//            conferenceList.add(conference);
//        }
//        return conferenceList;
//    }
//
//    @Override
//    public void updateConference() {
//
//    }
//}
