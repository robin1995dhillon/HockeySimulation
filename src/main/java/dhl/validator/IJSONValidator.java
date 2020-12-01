package dhl.validator;

import org.json.simple.JSONObject;

import java.util.Stack;

public interface IJSONValidator {
    JSONObject mainValidator(JSONObject Obj) throws Exception;

    boolean leagueValidator(JSONObject Obj, Stack stack) throws Exception;

    Boolean conferenceValidator(JSONObject Obj, Stack stack) throws Exception;

    Boolean freeAgentValidator(JSONObject Obj, Stack stack) throws Exception;

    Boolean coachValidator(JSONObject Obj, Stack stack) throws Exception;

    Boolean divisionValidator(JSONObject Obj, Stack stack) throws Exception;

    Boolean teamValidator(JSONObject Obj, Stack stack) throws Exception;

    Boolean headCoachValidator(JSONObject Obj, Stack stack);

    Boolean playerValidator(JSONObject Obj, Stack stack) throws Exception;

    Boolean attributesValidator(JSONObject Obj, Stack stack);
}
