package dhl.Creator;

import dhl.LeagueModel.Conference;
import dhl.LeagueModel.Division;
import dhl.LeagueModel.League;
import dhl.LeagueModel.Teams;

import java.util.ArrayList;

public class TeamCreator {

    public League createTeam(String ManagerName, String HeadCoach, League league, String ConferenceName, String DivisionName, String TeamName) {

        ArrayList<Conference> Conference;
        ArrayList<Division> Divisions;
        ArrayList<Teams> Teams;
        Conference = league.getConferences();
        for(Conference c: Conference) {
            if(c.getConferenceName().toLowerCase().equals(ConferenceName.toLowerCase())) {
                Divisions = c.getDivisions();
                for(Division d: Divisions) {
                    if(d.getDivisionName().toLowerCase().equals(DivisionName.toLowerCase())) {
                        Teams = d.getTeams();
                        Teams team = new Teams();
                            team.setGeneralManager(ManagerName);
                            team.setHeadCoach(HeadCoach);
                            team.setTeamName(TeamName);
                        d.addTeam(team);
                    }
                }
            }
        }
//        for(Conference c: Conference) {
//            System.out.println(c.getConferenceName());
//            Divisions = c.getDivisions();
//            for(Division d: Divisions) {
//                System.out.println(d.getDivisionName());
//                Teams = d.getTeams();
//                for(Teams t: Teams) {
//                    System.out.println(t.getTeamName());
//                    System.out.println(t.getGeneralManager());
//                    System.out.println(t.getHeadCoach());
//                    }
//                }
//            }
        return league;
    }
}
