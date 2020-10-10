package dhl.InOut;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class JSONReader {

    public static JSONObject readJSON(String Path) {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = new JSONObject();
        try (FileReader reader = new FileReader(Path)) {
            Object obj = jsonParser.parse(reader);
            jsonObject = (JSONObject) obj;
        } catch(JsonProcessingException jp) {
            System.out.println("Invalid JSON - Parsing");
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }

        return jsonObject;
    }
}
