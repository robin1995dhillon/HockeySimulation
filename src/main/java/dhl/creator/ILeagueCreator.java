package dhl.creator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import dhl.leagueModel.league.ILeague;

public interface ILeagueCreator {
    static <J> J createLeagueFromJSON(JsonNode jsonNode, Class<J> Object) {
        try {
            return LeagueCreator.objectMapper.treeToValue(jsonNode, Object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            System.out.println("Error while processing JSON. Please enter valid JSON");
            return null;
        }
    }

    ILeague CreateLeague(String Path);
}
