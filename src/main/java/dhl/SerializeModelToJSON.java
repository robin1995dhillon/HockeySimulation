package dhl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import dhl.LeagueModel.ILeague;

public class SerializeModelToJSON {
    private ObjectMapper objectMapper = new ObjectMapper();

    public String serializeModelToJSON(ILeague league) throws JsonProcessingException {
        ObjectWriter objectWriter = objectMapper.writer();
        objectWriter = objectWriter.with(SerializationFeature.INDENT_OUTPUT);
        String mapJakcson = objectWriter.writeValueAsString(league);
        return mapJakcson;
    }

}
