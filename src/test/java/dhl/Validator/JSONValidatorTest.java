package dhl.Validator;


import dhl.MockJSONObject;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class JSONValidatorTest {

    @Test
    void mainValidator() {
        JSONObject mockObject = MockJSONObject.createMock();
        JSONValidator jsonValidator = new JSONValidator();
        JSONObject mock_main = (JSONObject)mockObject.get("league");
        JSONObject obj= jsonValidator.mainValidator(mock_main);
        assertEquals("True",obj.get("isValid"));
    }

    @Test
    void leagueValidator() {
        JSONObject mockObject = MockJSONObject.createMock();
        Stack stack = new Stack();
        JSONObject league_mock = (JSONObject)mockObject.get("league");
        JSONValidator jsonValidator = new JSONValidator();
        Boolean result= jsonValidator.leagueValidator(league_mock,stack);
        assertEquals(true,result);
    }

    @Test
    void conferenceValidator() {
        JSONObject mockObject = MockJSONObject.createMock();
        Stack stack = new Stack();
        JSONObject conference_mock = (JSONObject)mockObject.get("league");
        System.out.println(conference_mock);
        JSONValidator jsonValidator = new JSONValidator();
        Boolean result= jsonValidator.conferenceValidator(conference_mock,stack);
        assertEquals(true,result);
    }

    @Test
    void freeAgentValidator() {
    }

    @Test
    void divisionValidator() {
        JSONObject mockObject = MockJSONObject.createMock();
        Stack stack = new Stack();
        JSONObject division_mock = (JSONObject)mockObject.get("conference");
        JSONValidator jsonValidator = new JSONValidator();
        Boolean result= jsonValidator.divisionValidator(division_mock,stack);
        assertEquals(true,result);
    }

    @Test
    void teamValidator() {
        JSONObject mockObject = MockJSONObject.createMock();
        Stack stack = new Stack();
        JSONObject team_mock = (JSONObject)mockObject.get("division");
        JSONValidator jsonValidator = new JSONValidator();
        Boolean result= jsonValidator.teamValidator(team_mock,stack);
        assertEquals(true,result);
    }

    @Test
    void playerValidator() {
        JSONObject mockObject = MockJSONObject.createMock();
        Stack stack = new Stack();
        JSONObject player_mock = (JSONObject)mockObject.get("team");
        JSONValidator jsonValidator = new JSONValidator();
        Boolean result= jsonValidator.playerValidator(player_mock,stack);
        assertEquals(false,result);
    }
}