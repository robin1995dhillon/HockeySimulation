package dhl.CreateTeamUtils;

import dhl.LeagueModel.IHeadCoach;

import java.util.ArrayList;

public interface ICoachUtils {
    public void displayCoach(ArrayList<IHeadCoach> coachList);
    public void removeCoach(ArrayList<IHeadCoach> coachList, String coachName);
}
