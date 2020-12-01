package dhl.serializeAndDeserialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dhl.presentation.inputOutput.IUserOutput;
import dhl.presentation.inputOutput.InputOutputAbstractFactory;
import dhl.presentation.inputOutput.UserOutput;
import dhl.leagueModel.IConference;
import dhl.leagueModel.ILeague;
import dhl.leagueModel.League;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DeserializeJSONToModel implements IDeserializeJSONToModel {
    static ObjectMapper objectMapper;
    public ILeague league;
    InputOutputAbstractFactory inputOutputAbstractFactory;
    IUserOutput userOutput;

    public DeserializeJSONToModel() {
        inputOutputAbstractFactory = InputOutputAbstractFactory.instance();
        objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        userOutput = inputOutputAbstractFactory.createUserOutput();
    }


    @Override
    public ILeague jsonToLeague(String Path) {
        try {
            byte[] data = Files.readAllBytes(Paths.get(Path));
            JsonNode jsonNodeData = objectMapper.readTree(data);
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
        } catch (JsonProcessingException jsonProcessingException) {
            userOutput.setOutput("Invalid JSON");
            userOutput.sendOutput();
            jsonProcessingException.printStackTrace();
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
