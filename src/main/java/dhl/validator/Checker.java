package dhl.validator;

import dhl.leagueModel.conference.IConference;
import dhl.leagueModel.division.IDivision;
import dhl.leagueModel.freeAgents.IFreeAgents;
import dhl.leagueModel.headCoach.IHeadCoach;
import dhl.leagueModel.league.ILeague;
import dhl.leagueModel.teams.ITeam;

import java.util.ArrayList;
import java.util.List;

public class Checker implements IChecker {


    public boolean conferenceChecker(String conference, ILeague league) {
        for (IConference c : league.getConferences()) {
            if (c.getConferenceName().toLowerCase().equals(conference.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public boolean divisionChecker(String division, ILeague league) {
        List<IConference> conferenceList;
        List<IDivision> divisionList;
        conferenceList = league.getConferences();
        for (IConference c : conferenceList) {
            divisionList = c.getDivisions();
            for (IDivision d : divisionList) {
                if (d.getDivisionName().toLowerCase().equals(division.toLowerCase())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean teamChecker(String team, ILeague league) {
        List<IConference> conferenceList;
        List<IDivision> divisionList;
        List<ITeam> teamList;
        conferenceList = league.getConferences();
        for (IConference c : conferenceList) {
            divisionList = c.getDivisions();
            for (IDivision d : divisionList) {
                teamList = d.getTeams();
                for (ITeam t : teamList) {
                    if (t.getTeamName().toLowerCase().equals(team.toLowerCase())) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @Override
    public boolean managerChecker(List<String> managerList, String managerName) {
        for (String s : managerList) {
            if (s.equals(managerName)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean coachChecker(List<IHeadCoach> coachList, String coachName) {
        for (IHeadCoach headCoach : coachList) {
            if (headCoach.getName().equals(coachName)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean freeAgentChecker(List<IFreeAgents> freeAgentList, String freeAgentName) {
        for (IFreeAgents freeAgent : freeAgentList) {
            if (freeAgent.getPlayerName().equals(freeAgentName)) {
                return true;
            }
        }
        return false;
    }
}
