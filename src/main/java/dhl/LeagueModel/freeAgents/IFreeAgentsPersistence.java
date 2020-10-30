package dhl.LeagueModel.freeAgents;

import org.json.simple.JSONObject;

public interface IFreeAgentsPersistence {
    JSONObject saveFreeAgentsToDB(String name, String position, int age, int[] freeAgentAttributes, int leagueID);
}
