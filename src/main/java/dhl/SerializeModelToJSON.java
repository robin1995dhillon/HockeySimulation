package dhl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import dhl.leagueModel.ILeague;

import java.io.IOException;

public class SerializeModelToJSON {
    private ObjectMapper objectMapper = new ObjectMapper();

    public String serializeModelToJSON(ILeague league) throws IOException {
        ObjectWriter objectWriter = objectMapper.writer();
        objectWriter = objectWriter.with(SerializationFeature.INDENT_OUTPUT);
        String mapJakcson = objectWriter.writeValueAsString(league);
//        FileWriter fw = new FileWriter(new File(System.getProperty("user.dir") +"\\src\\create.json"));
//        BufferedWriter bw = new BufferedWriter(fw);
//        bw.write(mapJakcson);
//        bw.flush();
//        bw.close();
        return mapJakcson;
    }

}
