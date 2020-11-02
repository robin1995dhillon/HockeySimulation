package dhl.serializeAndDeserialize.deserialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import dhl.leagueModel.conference.IConference;
import dhl.leagueModel.league.ILeague;
import dhl.leagueModel.league.League;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DeserializeJSONToModel implements IDeserializeJSONToModel {
    static ObjectMapper objectMapper;
    public ILeague league;

    public DeserializeJSONToModel() {
        objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }


    @Override
    public ILeague CreateLeague(String Path) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            byte[] Data = Files.readAllBytes(Paths.get(Path));
            JsonNode jsonNodeData = objectMapper.readTree(Data);
            league = DeserializeJSONToModel.createLeagueFromJSON(jsonNodeData, League.class);
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

    static <J> J createLeagueFromJSON(JsonNode jsonNode, Class<J> Object) {
        try {
            return DeserializeJSONToModel.objectMapper.treeToValue(jsonNode, Object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            System.out.println("Error while processing JSON. Please enter valid JSON");
            return null;
        }
    }

}
