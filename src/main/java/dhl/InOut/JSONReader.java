package dhl.InOut;

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
//            Set Outer_Keys = jsonObject.keySet();
//            Iterator iter = Outer_Keys.iterator();
//            String league_name = (String)iter.next();

//            while (iter.hasNext()) {
//                String Curr_Key = (String) iter.next();
//                JSONArray freeAgents = (JSONArray) jsonObject.get(Curr_Key);
//                System.out.println("Inside" +  freeAgents);
//                Iterator iterator = freeAgents.iterator();
//                while (iterator.hasNext()) {
//                    Object free_agent_info = iterator.next();
//
//                    JSONObject json_free_agent_info = (JSONObject) free_agent_info;
//                    System.out.println(json_free_agent_info);
////                    String free_agent_name = (String) json_free_agent_info.get("playerName");
//                }
//            }
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}
