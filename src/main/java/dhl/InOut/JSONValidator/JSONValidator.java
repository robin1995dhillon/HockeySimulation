package dhl.InOut.JSONValidator;

import dhl.Validator.Validator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.Iterator;
import java.util.Stack;

public class JSONValidator {

    public static JSONObject mainValidator(JSONObject Obj) {
        Stack<String> stack = new Stack<>();
        JSONObject return_json = new JSONObject();


//        String missing_val = "";
        leagueValidator(Obj,stack);
        if(stack.isEmpty()) {
            System.out.println("Missing Value" + stack);
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

    public static Boolean leagueValidator(JSONObject Obj, Stack stack) {
        if(Validator.valueIsPresent((String)Obj.get("leagueName"))) {
            conferenceValidator(Obj, stack);
        }
        else {
            stack.push("League Name Missing");
            return true;
        }
        return true;
    }

    public static Boolean conferenceValidator(JSONObject Obj, Stack stack) {
        JSONArray conferenceArray = (JSONArray) (Obj.get("conferences"));
        System.out.println(conferenceArray);
        Iterator conf_arr_iter = conferenceArray.iterator();
        while (conf_arr_iter.hasNext()) {
            JSONObject conferenceObject = (JSONObject) conf_arr_iter.next();
            System.out.println("ConferenceObject" + conferenceObject);
            String conferenceName = (String) conferenceObject.get("conferenceName");
            System.out.println(conferenceName);

            if (Validator.valueIsPresent(conferenceName)) {
                divisionValidator(conferenceObject, stack);

            } else {
                stack.push("Conference Name missing");
                return false;
            }


        }
        return true;
    }
    public static Boolean divisionValidator(JSONObject Obj, Stack stack) {
        JSONArray divisionArray = (JSONArray) (Obj.get("divisions"));
        System.out.println(divisionArray);
        Iterator div_arr_iter = divisionArray.iterator();
        while (div_arr_iter.hasNext()) {
            JSONObject divisionObject = (JSONObject) div_arr_iter.next();
            System.out.println("DivisionObject" + divisionObject);
            String divisionName = (String) divisionObject.get("divisionName");
            System.out.println(divisionName);
//            teamValidator(divisionObject);
            if (Validator.valueIsPresent(divisionName)) {
                teamValidator(divisionObject, stack);

            } else {
                return true;
            }
//
        }
        return true;
    }
    public static Boolean teamValidator(JSONObject Obj, Stack stack) {
        JSONArray teamArray = (JSONArray) (Obj.get("teams"));
        System.out.println(teamArray);
        Iterator team_arr_iter = teamArray.iterator();
        while (team_arr_iter.hasNext()) {
            JSONObject teamObject = (JSONObject) team_arr_iter.next();
            System.out.println("DivisionObject" + teamObject);
            String teamName = (String) teamObject.get("teamName");
            String headCoach = (String) teamObject.get("headCoach");
            String generalManager = (String) teamObject.get("generalManager");
            System.out.println(teamName);
            System.out.println(headCoach);
            System.out.println(generalManager);

            if (Validator.valueIsPresent(teamName)) {
                if(Validator.valueIsPresent(headCoach)) {
                    if(Validator.valueIsPresent(generalManager)) {
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
    public static Boolean playerValidator(JSONObject Obj, Stack stack) {
        JSONArray playersArray = (JSONArray) (Obj.get("players"));
        System.out.println(playersArray);
        for (Object o : playersArray) {
            JSONObject playerObject = (JSONObject) o;
            System.out.println("playerObject" + playerObject);
            String playerName = (String) playerObject.get("playerName");
            String position = (String) playerObject.get("position");
            Boolean captain = (Boolean) playerObject.get("captain");
            System.out.println(playerName);
            System.out.println(position);
            System.out.println(captain);
//            if (Validator.isEmpty(playerName) && Validator.isEmpty(position) && Validator.isEmpty(generalManager)) {
//                return false;
//            } else {
//                return true;
//            }
        }
        return false;
    }
}
