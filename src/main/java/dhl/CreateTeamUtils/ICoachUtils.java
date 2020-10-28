package dhl.CreateTeamUtils;

import dhl.LeagueModel.IHeadCoach;

import java.util.List;


public interface ICoachUtils {
    void displayCoach(List<IHeadCoach> coachList);
    void removeCoach(List<IHeadCoach> coachList, String coachName);
}
