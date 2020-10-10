package dhl.Validator;

import com.fasterxml.jackson.core.JsonProcessingException;
import dhl.Validator.Validator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.Iterator;
import java.util.Stack;

public class JSONValidator {

    Validator validator;

    public JSONValidator() {
        validator = new Validator();
    }

    public JSONObject mainValidator(JSONObject Obj) {
        Stack<String> stack = new Stack<>();
        JSONObject return_json = new JSONObject();


//        String missing_val = "";
        leagueValidator(Obj,stack);
        if(stack.isEmpty()) {
            return_json.put("isValid","True");
            return_json.put("Message","Null");
            return return_json;
        }
        else {
            return_json.put("isValid","False");
            return_json.put("Message",stack.pop());
            return return_json;
        }
//        divisionValidator(Obj);

    }

//    public Boolean JSONParserValidator(JSONObject Obj) {
//
//        try {
//            new JSONObject(Obj);
//        } catch () {
//        return true;
//    }

    public  Boolean leagueValidator(JSONObject Obj, Stack stack) {
        if(validator.valueIsPresent((String)Obj.get("leagueName"))) {
            conferenceValidator(Obj, stack);
            freeAgentValidator(Obj, stack);
        }
        else {
            stack.push("League Name Missing");
            return true;
        }
        return true;
    }

    public Boolean conferenceValidator(JSONObject Obj, Stack stack) {
        JSONArray conferenceArray = (JSONArray) (Obj.get("conferences"));
        Iterator conf_arr_iter = conferenceArray.iterator();
        while (conf_arr_iter.hasNext()) {
            JSONObject conferenceObject = (JSONObject) conf_arr_iter.next();
            String conferenceName = (String) conferenceObject.get("conferenceName");

            if (validator.valueIsPresent(conferenceName)) {
                divisionValidator(conferenceObject, stack);

            } else {
                stack.push("Conference Name missing");
                return false;
            }


        }
        return true;
    }

    public Boolean freeAgentValidator(JSONObject Obj, Stack stack) {
        JSONArray freeAgentArray = (JSONArray) (Obj.get("freeAgents"));
        if(freeAgentArray == null) {
            return false;
        }
        Iterator free_agent_iter = freeAgentArray.iterator();
        while (free_agent_iter.hasNext()) {
            JSONObject freeAgentObject = (JSONObject) free_agent_iter.next();
            String playerName = (String) freeAgentObject.get("playerName");
            String position = (String) freeAgentObject.get("position");
            String captain =  freeAgentObject.get("captain").toString();

            if (validator.valueIsPresent(playerName)) {
                if(validator.valueIsPresent(position)) {
                    if(validator.valueIsPresent(captain)) {
                    }
                    else{
                        stack.push("General Manager Missing in Free Agent");
                        return false;
                    }
                }
                else {
                    stack.push("Head Coach Missing in Free Agent");
                    return false;
                }
            } else {
                stack.push("Team Name Missing in Free Agent");
                return false;
            }
        }
        return true;
    }
    public Boolean divisionValidator(JSONObject Obj, Stack stack) {
        JSONArray divisionArray = (JSONArray) (Obj.get("divisions"));

        Iterator div_arr_iter = divisionArray.iterator();
        while (div_arr_iter.hasNext()) {
            JSONObject divisionObject = (JSONObject) div_arr_iter.next();

            String divisionName = (String) divisionObject.get("divisionName");

//            teamValidator(divisionObject);
            if (validator.valueIsPresent(divisionName)) {
                teamValidator(divisionObject, stack);

            } else {
                return true;
            }
//
        }
        return true;
    }
    public Boolean teamValidator(JSONObject Obj, Stack stack) {
        JSONArray teamArray = (JSONArray) (Obj.get("teams"));

        Iterator team_arr_iter = teamArray.iterator();
        while (team_arr_iter.hasNext()) {
            JSONObject teamObject = (JSONObject) team_arr_iter.next();

            String teamName = (String) teamObject.get("teamName");
            String headCoach = (String) teamObject.get("headCoach");
            String generalManager = (String) teamObject.get("generalManager");


            if (validator.valueIsPresent(teamName)) {
                if(validator.valueIsPresent(headCoach)) {
                    if(validator.valueIsPresent(generalManager)) {
                        playerValidator(teamObject, stack);

                    }
                    else{
                        stack.push("General Manager Missing");
                        return false;
                    }
                }
                else {
                    stack.push("Head Coach Missing");
                    return false;
                }
            } else {
                stack.push("Team Name Missing");
                return false;
            }
        }
        return true;
    }
    public Boolean playerValidator(JSONObject Obj, Stack stack) {
        JSONArray playersArray = (JSONArray) (Obj.get("players"));

        for (Object o : playersArray) {
            JSONObject playerObject = (JSONObject) o;

            String playerName = (String) playerObject.get("playerName");
            String position = (String) playerObject.get("position");
            String captain =  playerObject.get("captain").toString();

            if (validator.valueIsPresent(playerName)) {
                if(validator.valueIsPresent(position)) {
                    if(validator.valueIsPresent(captain)) {
                    }
                    else{
                        stack.push("General Manager Missing");
                        return false;
                    }
                }
                else {
                    stack.push("Head Coach Missing");
                    return false;
                }
            } else {
                stack.push("Team Name Missing");
                return false;
            }
        }
        return false;
    }
}
