package dhl.serializeAndDeserialize.serialize;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import dhl.leagueModel.league.ILeague;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SerializeModelToJSON implements ISerializeModelToJSON {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String serializeModelToJSON(ILeague league) throws IOException {
        ObjectWriter objectWriter = objectMapper.writer();
        objectWriter = objectWriter.with(SerializationFeature.INDENT_OUTPUT);
        String mapJakcson = objectWriter.writeValueAsString(league);
        FileWriter fw = new FileWriter(new File(System.getProperty("user.dir") +"\\src\\create.json"));
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(mapJakcson);
        bw.flush();
        bw.close();
        return mapJakcson;
    }

}
