package dhl.serializeAndDeserialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import dhl.leagueModel.ILeague;
import dhl.presentation.inputOutput.InputOutputAbstractFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SerializeModelToJSON implements ISerializeModelToJSON {

    private ObjectMapper objectMapper;

    public SerializeModelToJSON() {
        objectMapper = new ObjectMapper();
    }

    @Override
    public String serializeModelToJSON(ILeague league) throws JsonProcessingException {
        ObjectWriter objectWriter = objectMapper.writer();
        objectWriter = objectWriter.with(SerializationFeature.INDENT_OUTPUT);
        String mapJackson = objectWriter.writeValueAsString(league);
        return mapJackson;
    }

    @Override
    public void saveToFile(String mapJackson) throws IOException {
        FileWriter fw = new FileWriter(new File(System.getProperty("user.dir") + "\\src\\saveFile.json"));
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(mapJackson);
        bw.flush();
        bw.close();
    }

}
