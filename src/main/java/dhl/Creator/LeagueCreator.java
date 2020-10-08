package dhl.Creator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import dhl.LeagueModel.Conference;
import dhl.LeagueModel.League;
import org.json.simple.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LeagueCreator {
    static ObjectMapper objectMapper;
    public League league;
    public LeagueCreator() {
        objectMapper = new ObjectMapper();
    }

    public League CreateLeague(JSONObject Obj) {
        System.out.println("Inside Create League");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            byte[] Data = Files.readAllBytes(Paths.get("src/Data.json"));
            JsonNode jsonNodeData = objectMapper.readTree(Data);
            System.out.println("Data is" + jsonNodeData);
            league = createLeagueFromJSON(jsonNodeData, League.class);
            System.out.println(league.getLeagueName());
            for(Conference c : league.getConferences()) {
                System.out.println(c.getConferenceName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return league;
    }
    public static <J> J createLeagueFromJSON(JsonNode jsonNode, Class<J> Object) throws JsonProcessingException {
        return objectMapper.treeToValue(jsonNode, Object);
    }
}
