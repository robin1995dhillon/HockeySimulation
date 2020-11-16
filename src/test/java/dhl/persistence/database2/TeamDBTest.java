//package dhl.persistence.database2;
//
//import dhl.leagueModel.teams.ITeam;
//import org.junit.jupiter.api.Test;
//
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.List;
//
//public class TeamDBTest {
////    @Test
////    public void createTeamTest(){
////        ITeamDB t = new TeamDB();
////        try {
////            System.out.println(t.createTeam("mnbv","xzzc",false));
////        } catch (IOException exception) {
////            exception.printStackTrace();
////        } catch (SQLException throwables) {
////            throwables.printStackTrace();
////        }
////    }
//
//    @Test
//    public void checkTeamTest(){
//        ITeamDB t = new TeamDB();
//        try {
//            System.out.println(t.checkTeam("mnbv"));
//            System.out.println(t.checkTeam("opkjj"));
//        } catch (IOException exception) {
//            exception.printStackTrace();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }
//
//    @Test
//    public void getAllTeamInDivision(){
//        ITeamDB t = new TeamDB();
//        try {
//            List<ITeam> teamList = t.getAllTeamInDivision(1);
//            for(ITeam team : teamList){
//                System.out.print(team.getTeamName() + "\t");
//                System.out.print(team.getGeneralManager() + "\t");
//                System.out.println(team.getHeadCoach().getName());
//            }
//        } catch (IOException exception) {
//            exception.printStackTrace();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }
//}
