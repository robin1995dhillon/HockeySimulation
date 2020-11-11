package dhl.inputOutput;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JSONReader {

    public static JSONObject readJSON(String Path) {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = new JSONObject();
        try (FileReader reader = new FileReader(Path)) {
            Object obj = jsonParser.parse(reader);
            jsonObject = (JSONObject) obj;
        } catch (JsonProcessingException jp) {
            UserOutput userOutput = new UserOutput();
            userOutput.setOutput("Invalid JSON - Parsing");
            userOutput.sendOutput();
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }

        return jsonObject;
    }
}
