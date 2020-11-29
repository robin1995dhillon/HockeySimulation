package dhl.validator;

import dhl.Configurables;
import dhl.leagueModel.conference.IConference;
import dhl.leagueModel.division.IDivision;
import dhl.leagueModel.IFreeAgents;
import dhl.leagueModel.generalManager.IGeneralManager;
import dhl.leagueModel.headCoach.IHeadCoach;
import dhl.leagueModel.league.ILeague;
import dhl.leagueModel.teams.ITeam;

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
        for (IConference conference : conferenceList) {
            divisionList = conference.getDivisions();
            for (IDivision division : divisionList) {
                teamList = division.getTeams();
                for (ITeam teams : teamList) {
                    if (teams.getTeamName().toLowerCase().equals(team.toLowerCase())) {
                        teams.setTeamType(Configurables.USER.getAction());
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean managerChecker(List<IGeneralManager> managerList, String managerName) {
        for (IGeneralManager manager : managerList) {
            if (manager.getName().equalsIgnoreCase(managerName)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean coachChecker(List<IHeadCoach> coachList, String coachName) {
        for (IHeadCoach headCoach : coachList) {
            if (headCoach.getName().equalsIgnoreCase(coachName)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean freeAgentChecker(List<IFreeAgents> freeAgentList, String freeAgentName) {
        for (IFreeAgents freeAgent : freeAgentList) {
            if (freeAgent.getPlayerName().equalsIgnoreCase(freeAgentName)) {
                return true;
            }
        }
        return false;
    }
}
