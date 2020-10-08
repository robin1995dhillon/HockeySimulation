package dhl.Validator;

//import dhl.LeagueModel;
import dhl.LeagueModel.*;

import java.util.ArrayList;
import java.util.Iterator;

public class ConferenceChecker {

//    public ConferenceChecker() {
//
//    }

    public boolean ConferenceChecker(String Conference, League league) {
        for (Conference c: league.getConferences()) {
            if(c.getConferenceName().toLowerCase().equals(Conference.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public boolean DivisionChecker(String Division, League league) {
        ArrayList<Conference> Conference;
        ArrayList<Division> Divisions;
        Conference = league.getConferences();
        for(Conference c: Conference) {
            Divisions = c.getDivisions();
            for(Division d: Divisions) {
                System.out.println(d.getDivisionName());
                if(d.getDivisionName().toLowerCase().equals(Division.toLowerCase())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean TeamChecker(String Team, League league) {
        ArrayList<Conference> Conference;
        ArrayList<Division> Divisions;
        ArrayList<Teams> Teams;
        Conference = league.getConferences();
        for(Conference c: Conference) {
            Divisions = c.getDivisions();
            for(Division d: Divisions) {
                Teams = d.getTeams();
                for(Teams t: Teams) {
                    if(t.getTeamName().toLowerCase().equals(Team.toLowerCase())) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
