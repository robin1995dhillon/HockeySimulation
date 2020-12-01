package dhl.validator;

import dhl.leagueModel.IFreeAgents;
import dhl.leagueModel.IGeneralManager;
import dhl.leagueModel.IHeadCoach;
import dhl.leagueModel.ILeague;

import java.util.List;

public interface IChecker {
    boolean conferenceChecker(String Conference, ILeague ILeague);

    boolean divisionChecker(String Division, ILeague ILeague);

    boolean teamChecker(String Team, ILeague ILeague);

    boolean managerChecker(List<IGeneralManager> managerList, String managerName);

    boolean coachChecker(List<IHeadCoach> coachList, String coachName);

    boolean freeAgentChecker(List<IFreeAgents> freeAgentList, String freeAgentName);
}
