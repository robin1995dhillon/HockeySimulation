package dhl.LeagueModel.freeAgents;

import org.json.simple.JSONObject;

public interface IFreeAgentsPersistence {
    JSONObject saveDivisionToDB(String conferenceName);
}
