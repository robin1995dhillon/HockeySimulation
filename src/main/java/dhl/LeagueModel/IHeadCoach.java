package dhl.LeagueModel;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import dhl.LeagueModel.headCoach.HeadCoach;

import java.util.List;

@JsonDeserialize(as= HeadCoach.class)
public interface IHeadCoach {

    String getName();
    void setName(String name);

    double getSkating();
    void setSkating(double skating);

    double getShooting();
    void setShooting(double shooting);

    double getChecking();
    void setChecking(double checking);

    double getSaving();
    void setSaving(double saving);

    IHeadCoach getCoachFromList(List<IHeadCoach> coachList , String coachName);

    void saveHeadCoach(int teamID);
}
