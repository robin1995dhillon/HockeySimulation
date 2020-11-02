package dhl.serializeAndDeserialize.deserialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import dhl.inputOutput.UserOutput;
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
    UserOutput userOutput;

    public DeserializeJSONToModel() {
        objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        userOutput = new UserOutput();
    }


    @Override
    public ILeague jsonToLeague(String Path) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            byte[] Data = Files.readAllBytes(Paths.get(Path));
            JsonNode jsonNodeData = objectMapper.readTree(Data);
            league = DeserializeJSONToModel.createLeagueFromJSON(jsonNodeData, League.class);
            if (league.equals(null)) {
                userOutput.setOutput("JSON Syntax Error. Please correct it and try again!");
                userOutput.sendOutput();
                return null;
            }
            userOutput.setOutput("League: ");
            userOutput.sendOutput();
            userOutput.setOutput(league.getLeagueName());
            userOutput.sendOutput();
            userOutput.setOutput("\nConferences:");
            userOutput.sendOutput();
            for (IConference c : league.getConferences()) {
                userOutput.setOutput(c.getConferenceName());
                userOutput.sendOutput();
            }
        } catch (JsonProcessingException jp) {
            userOutput.setOutput("Invalid JSON");
            userOutput.sendOutput();
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
            return null;
        }
    }

}
