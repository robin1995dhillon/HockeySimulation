package dhl.serializeAndDeserialize.serialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import dhl.leagueModel.ILeague;

import java.io.IOException;

public interface ISerializeModelToJSON {
    String serializeModelToJSON(ILeague league) throws JsonProcessingException;
    void saveToFile(String mapJackson) throws IOException;
}
