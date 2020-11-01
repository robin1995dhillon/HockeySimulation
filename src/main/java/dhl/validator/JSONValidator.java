package dhl.validator;

import dhl.gamePlayConfig.GamePlayConfig;
import dhl.gamePlayConfig.IGamePlayConfig;
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
    }
    public boolean leagueValidator(JSONObject Obj, Stack stack) {
        if(validator.valueIsPresent((String)Obj.get("leagueName"))) {
            IGamePlayConfig gamePlayConfig = new GamePlayConfig();
            conferenceValidator(Obj, stack);
            freeAgentValidator(Obj, stack);
            coachValidator(Obj, stack);
            generalManagersValidator(Obj, stack);
            gamePlayConfig.gamePlayConfigValidator(Obj);
        }
        else {
            stack.push("League Name Missing");
            return false;
        }
        return true;
    }

    private boolean generalManagersValidator(JSONObject obj, Stack stack) {
        JSONArray generalManagersArray = (JSONArray)obj.get("generalManagers");

        Iterator general_manager_iter = generalManagersArray.iterator();
        while(general_manager_iter.hasNext()) {
            String val = (String)general_manager_iter.next();
            if(!validator.valueIsPresent(val)) {
                stack.push("General Manager Value Missing");
                return false;
            }
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
            System.out.println(freeAgentObject.get("age"));
            int age = ((Long)freeAgentObject.get("age")).intValue();
            int skating = ((Long)freeAgentObject.get("skating")).intValue();
            int shooting = ((Long)freeAgentObject.get("shooting")).intValue();
            int checking = ((Long)freeAgentObject.get("checking")).intValue();
            int saving = ((Long)freeAgentObject.get("saving")).intValue();
            int [] stats_array = {skating,shooting,checking,saving};
            String [] stats_name = {"skating", "shooting", "checking", "saving"};
            if (validator.valueIsPresent(playerName)) {

                if(validator.valueIsPresent(position)) {
                }
                else {
                    stack.push("Position Missing in Free Agent");
                    return false;
                }
            } else {
                stack.push("PLayer Name Missing in Free Agent");
                return false;
            }
            for(int i=0;i<stats_array.length;i++) {
                if(!validator.checkRange(stats_array[i])) {
                    stack.push(stats_name[i] + "should be between 1 and 20");
                    System.out.println("Value should be between 1 and 20");
                    return false;
                }
            }
        }
        return true;
    }

    public Boolean coachValidator(JSONObject Obj, Stack stack) {
        System.out.println("Inside Coach");
        JSONArray coachArray = (JSONArray) (Obj.get("coaches"));
        if(coachArray==null) {
            return false;
        }
        Iterator coach_iter = coachArray.iterator();
        while(coach_iter.hasNext()) {
            JSONObject coachObject = (JSONObject) coach_iter.next();
            attributesValidator(coachObject, stack);
        }
        return true;
    }
    public Boolean divisionValidator(JSONObject Obj, Stack stack) {
        JSONArray divisionArray = (JSONArray) (Obj.get("divisions"));

        Iterator div_arr_iter = divisionArray.iterator();
        while (div_arr_iter.hasNext()) {
            JSONObject divisionObject = (JSONObject) div_arr_iter.next();

            String divisionName = (String) divisionObject.get("divisionName");
            System.out.println(divisionObject);
            if (validator.valueIsPresent(divisionName)) {
                teamValidator(divisionObject, stack);

            } else {
                return true;
            }
        }
        return true;
    }
    public Boolean teamValidator(JSONObject Obj, Stack stack) {
        JSONArray teamArray = (JSONArray) (Obj.get("teams"));

        Iterator team_arr_iter = teamArray.iterator();
        while (team_arr_iter.hasNext()) {
            JSONObject teamObject = (JSONObject) team_arr_iter.next();
            String teamName = teamObject.get("teamName").toString();
            String generalManager = teamObject.get("generalManager").toString();
            if (validator.valueIsPresent(teamName)) {
                    if(validator.valueIsPresent(generalManager)) {
                        playerValidator(teamObject, stack);
                         headCoachValidator(teamObject,stack);
                    }
                    else{
                        stack.push("General Manager Missing");
                        return false;
                        }
            } else {
                stack.push("Team Name Missing");
                return false;
            }
        }
        return true;
    }
    public Boolean headCoachValidator(JSONObject Obj, Stack stack) {
        JSONObject headCoach = (JSONObject) Obj.get("headCoach");
        attributesValidator(headCoach, stack);
        return true;
    }

    public Boolean playerValidator(JSONObject Obj, Stack stack) {
        JSONArray playersArray = (JSONArray) (Obj.get("players"));

        for (Object o : playersArray) {
            JSONObject playerObject = (JSONObject) o;

            String playerName = (String) playerObject.get("playerName");
            String position = (String) playerObject.get("position");
            String captain =  playerObject.get("captain").toString();
            int age = ((Long)playerObject.get("age")).intValue();
            int skating = ((Long)playerObject.get("skating")).intValue();
            int shooting = ((Long)playerObject.get("shooting")).intValue();
            int checking = ((Long)playerObject.get("checking")).intValue();
            int saving = ((Long)playerObject.get("saving")).intValue();
            int [] stats_array = {skating,shooting,checking,saving};
            String [] stats_name = {"skating", "shooting", "checking", "saving"};
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
            for(int i=0;i<stats_array.length;i++) {
                if(!validator.checkRange(stats_array[i])) {
                    stack.push(stats_name[i] + "should be between 1 and 20");
                    System.out.println("Value should be between 1 and 20");
                    return false;
                }
            }
        }
        return false;
    }
    public Boolean attributesValidator(JSONObject Obj, Stack stack) {
        System.out.println("Inside Attributes");
        System.out.println(Obj);
        String name = (String) Obj.get("name");
        Double skating = (Double) Obj.get("skating");
        Double shooting = (Double) Obj.get("shooting");
        Double checking = (Double) Obj.get("checking");
        Double saving = (Double) Obj.get("saving");
        Double[] detailsValue = {skating,shooting,checking,saving};
        String[] detailsName = {"skating", "shooting", "checking", "saving"};
        if(!validator.valueIsPresent(name)) {
            stack.push("Name is Missing");
            System.out.println("Name is Missing");
            return false;
        }
        for(int i=0;i<detailsValue.length;i++) {
            if(!validator.valueIsPresent(detailsValue[i])) {
                stack.push(detailsName[i] + "is Missing");
                return false;
            }
        }
        return true;
    }
}
