package dhl.LeagueModel.headCoach;

import dhl.LeagueModel.IHeadCoach;
import org.json.simple.JSONObject;

public interface IHeadCoachPersistence {
    JSONObject saveHeadCoachToDB(IHeadCoach HeadCoach);
}