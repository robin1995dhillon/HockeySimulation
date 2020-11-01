package dhl.creator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import dhl.leagueModel.IConference;
import dhl.leagueModel.ILeague;
import dhl.leagueModel.league.League;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LeagueCreator {
    static ObjectMapper objectMapper;
    public ILeague league;

    public LeagueCreator() {
//        objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper = new ObjectMapper();
    }


    public ILeague CreateLeague(String Path) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            byte[] Data = Files.readAllBytes(Paths.get(Path));
            JsonNode jsonNodeData = objectMapper.readTree(Data);
            System.out.println(jsonNodeData);
            league = createLeagueFromJSON(jsonNodeData, League.class);
            System.out.println("League:");
            System.out.println(league.getLeagueName());
            System.out.println("\nConferences:");
            for (IConference c : league.getConferences()) {
                System.out.println(c.getConferenceName());
            }
        } catch (JsonProcessingException jp) {
            System.out.println("Invalid JSON");
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return league;
    }

    public static <J> J createLeagueFromJSON(JsonNode jsonNode, Class<J> Object) {
        try {
            return objectMapper.treeToValue(jsonNode, Object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            System.out.println("Error while processing JSON. Please enter valid JSON");
            return null;
        }
    }

}
