package dhl.validator;

import dhl.presentation.inputOutput.IUserOutput;
import dhl.Configurables;
import dhl.presentation.inputOutput.InputOutputAbstractFactory;
import dhl.presentation.inputOutput.UserOutput;
import dhl.leagueModel.LeagueModelAbstractFactory;
import dhl.leagueModel.gamePlayConfig.IGamePlayConfig;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Iterator;
import java.util.Stack;

public class JSONValidator implements IJSONValidator {

    IValidator validator;
    private IUserOutput userOutput;
    private IGamePlayConfig gamePlayConfig;
    LeagueModelAbstractFactory leagueModelAbstractFactory;
    InputOutputAbstractFactory inputOutputAbstractFactory;
    ValidatorAbstractFactory validatorAbstractFactory;

    public JSONValidator() {
        inputOutputAbstractFactory = InputOutputAbstractFactory.instance();
        leagueModelAbstractFactory = LeagueModelAbstractFactory.instance();
        validator = validatorAbstractFactory.getValidator();
        userOutput = inputOutputAbstractFactory.createUserOutput();
        gamePlayConfig = leagueModelAbstractFactory.getGamePlayConfig();
    }

    @Override
    public JSONObject mainValidator(JSONObject Obj) throws Exception {
        Stack<String> stack = new Stack<>();
        JSONObject returnObject = new JSONObject();
        leagueValidator(Obj, stack);
        if (stack.isEmpty()) {
            returnObject.put("isValid", "True");
            returnObject.put("Message", "Null");
            return returnObject;
        } else {
            returnObject.put("isValid", "False");
            returnObject.put("Message", stack.pop());
            return returnObject;
        }
    }

    @Override
    public boolean leagueValidator(JSONObject Obj, Stack stack) throws Exception {
        if (validator.valueIsPresent((String) Obj.get(Configurables.LEAGUENAME.getAction()))) {
            conferenceValidator(Obj, stack);
            freeAgentValidator(Obj, stack);
            coachValidator(Obj, stack);
            generalManagersValidator(Obj, stack);
            gamePlayConfig.gamePlayConfigValidator(Obj);
        } else {
            stack.push("League Name Missing");
            return false;
        }
        return true;
    }

    private boolean generalManagersValidator(JSONObject Obj, Stack stack) throws Exception {
        JSONArray generalManagersArray = (JSONArray) Obj.get(Configurables.GENERALMANAGERS.getAction());
        Iterator generalManagerIter = generalManagersArray.iterator();
        if (generalManagerIter == null) {
            throw new Exception("General Manager is missing");
        }
        while (generalManagerIter.hasNext()) {
            JSONObject managerObject = (JSONObject) generalManagerIter.next();
            String managerName = (String) managerObject.get(Configurables.NAME.getAction());
            String personality = (String) managerObject.get(Configurables.PERSONALITY.getAction());
            if(validator.valueIsPresent(managerName)) {
                if(validator.valueIsPresent(personality)) {

                } else {
                    stack.push("Personality Missing in General Manager!");
                }
            }  else {
                stack.push("Manager Name Missing!");
            }
        }
        return true;
    }

    @Override
    public Boolean conferenceValidator(JSONObject Obj, Stack stack) throws Exception {
        JSONArray conferenceArray = (JSONArray) (Obj.get(Configurables.CONFERENCES.getAction()));
        Iterator confArrIter = conferenceArray.iterator();
        if (conferenceArray == null) {
            throw new Exception("Conference is missing");
        }
        while (confArrIter.hasNext()) {
            JSONObject conferenceObject = (JSONObject) confArrIter.next();
            String conferenceName = (String) conferenceObject.get(Configurables.CONFERENCENAME.getAction());

            if (validator.valueIsPresent(conferenceName)) {
                divisionValidator(conferenceObject, stack);
            } else {
                stack.push("Conference Name missing");
                return false;
            }
        }
        return true;
    }

    @Override
    public Boolean freeAgentValidator(JSONObject Obj, Stack stack) throws Exception {
        JSONArray freeAgentArray = (JSONArray) (Obj.get(Configurables.FREEAGENTS.getAction()));
        if (freeAgentArray == null) {
            throw new Exception("Free Agent is Missing");
        }
        Iterator freeAgentIter = freeAgentArray.iterator();
        while (freeAgentIter.hasNext()) {
            JSONObject freeAgentObject = (JSONObject) freeAgentIter.next();
            String playerName = (String) freeAgentObject.get(Configurables.PLAYERNAME.getAction());
            String position = (String) freeAgentObject.get(Configurables.POSITION.getAction());
            int skating = ((Long) freeAgentObject.get(Configurables.SKATING.getAction())).intValue();
            int shooting = ((Long) freeAgentObject.get(Configurables.SHOOTING.getAction())).intValue();
            int checking = ((Long) freeAgentObject.get(Configurables.CHECKING.getAction())).intValue();
            int saving = ((Long) freeAgentObject.get(Configurables.SAVING.getAction())).intValue();
            int[] stats_array = {skating, shooting, checking, saving};
            String[] stats_name = {"skating", "shooting", "checking", "saving"};
            if (validator.valueIsPresent(playerName)) {

                if (validator.valueIsPresent(position)) {
                } else {
                    stack.push("Position Missing in Free Agent");
                    return false;
                }
            } else {
                stack.push("PLayer Name Missing in Free Agent");
                return false;
            }
            for (int i = 0; i < stats_array.length; i++) {
                if (!validator.checkRange(stats_array[i])) {
                    stack.push(stats_name[i] + "should be between 1 and 20");
                    userOutput.setOutput("Value should be between 1 and 20");
                    userOutput.sendOutput();

                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public Boolean coachValidator(JSONObject Obj, Stack stack) throws Exception {
        JSONArray coachArray = (JSONArray) (Obj.get(Configurables.COACHES.getAction()));
        if (coachArray == null) {
            throw new Exception("Coach is missing");
        }
        Iterator coach_iter = coachArray.iterator();
        while (coach_iter.hasNext()) {
            JSONObject coachObject = (JSONObject) coach_iter.next();
            attributesValidator(coachObject, stack);
        }
        return true;
    }

    @Override
    public Boolean divisionValidator(JSONObject Obj, Stack stack) throws Exception {
        JSONArray divisionArray = (JSONArray) (Obj.get(Configurables.DIVISIONS.getAction()));
        if (divisionArray == null) {
            throw new Exception("Free Agent is Missing");
        }
        Iterator divArrIter = divisionArray.iterator();
        while (divArrIter.hasNext()) {
            JSONObject divisionObject = (JSONObject) divArrIter.next();
            String divisionName = (String) divisionObject.get(Configurables.DIVISIONNAME.getAction());
            if (validator.valueIsPresent(divisionName)) {
                teamValidator(divisionObject, stack);
            } else {
                return true;
            }
        }
        return true;
    }

    @Override
    public Boolean teamValidator(JSONObject Obj, Stack stack) throws Exception {
        JSONArray teamArray = (JSONArray) (Obj.get(Configurables.TEAMS.getAction()));
        Iterator teamArrIter = teamArray.iterator();
        while (teamArrIter.hasNext()) {
            JSONObject teamObject = (JSONObject) teamArrIter.next();
            String teamName = teamObject.get(Configurables.TEAMNAME.getAction()).toString();
            String generalManager = teamObject.get(Configurables.GENERALMANAGER.getAction()).toString();
            if (validator.valueIsPresent(teamName)) {
                if (validator.valueIsPresent(generalManager)) {
                    playerValidator(teamObject, stack);
                    headCoachValidator(teamObject, stack);
                } else {
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

    @Override
    public Boolean headCoachValidator(JSONObject Obj, Stack stack) {
        JSONObject headCoach = (JSONObject) Obj.get(Configurables.HEADCOACH.getAction());
        attributesValidator(headCoach, stack);
        return true;
    }

    @Override
    public Boolean playerValidator(JSONObject Obj, Stack stack) throws Exception {
        JSONArray playersArray = (JSONArray) (Obj.get(Configurables.PLAYERS.getAction()));

        if (playersArray == null) {
            throw new Exception("Players is missing");
        }

        for (Object o : playersArray) {
            JSONObject playerObject = (JSONObject) o;

            String playerName = (String) playerObject.get(Configurables.PLAYERNAME.getAction());
            String position = (String) playerObject.get(Configurables.POSITION.getAction());
            String captain = playerObject.get(Configurables.CAPTAIN.getAction()).toString();
            int skating = ((Long) playerObject.get(Configurables.SKATING.getAction())).intValue();
            int shooting = ((Long) playerObject.get(Configurables.SHOOTING.getAction())).intValue();
            int checking = ((Long) playerObject.get(Configurables.CHECKING.getAction())).intValue();
            int saving = ((Long) playerObject.get(Configurables.SAVING.getAction())).intValue();
            int birthDay = ((Long) playerObject.get(Configurables.BIRTHDAY.getAction())).intValue();
            int birthMonth = ((Long) playerObject.get(Configurables.BIRTHMONTH.getAction())).intValue();
            int birthYear = ((Long) playerObject.get(Configurables.BIRTHYEAR.getAction())).intValue();
            int[] statsArray = {skating, shooting, checking, saving};
            String[] statsName = {"skating", "shooting", "checking", "saving"};
            if (validator.valueIsPresent(playerName)) {
                if (validator.valueIsPresent(position)) {
                    if (validator.valueIsPresent(captain)) {
                    } else {
                        stack.push("General Manager Missing");
                        return false;
                    }
                } else {
                    stack.push("Head Coach Missing");
                    return false;
                }
            } else {
                stack.push("Team Name Missing");
                return false;
            }
            for (int i = 0; i < statsArray.length; i++) {
                if (validator.checkRange(statsArray[i])) {
                    continue;
                }
                else {
                    stack.push(statsName[i] + "should be between 1 and 20");
                    userOutput.setOutput("Value should be between 1 and 20");
                    userOutput.sendOutput();
                    return false;
                }
            }
            if (validator.checkBirthDay(birthDay)) {
                    if(validator.checkBirthMonth(birthMonth)) {
                        if(validator.checkBirthYear(birthYear)) {

                        }
                        else {
                            stack.push("Birth Month should be between 1 and 2020");
                        }
                    }
                    else {
                        stack.push("Birth Month should be between 1 and 12");
                    }
                }
            else {
                    stack.push("Birth Date should be between 1 and 31");
                }
        }
        return false;
    }

    @Override
    public Boolean attributesValidator(JSONObject Obj, Stack stack) {
        String name = (String) Obj.get(Configurables.NAME.getAction());
        Double skating = (Double) Obj.get(Configurables.SKATING.getAction());
        Double shooting = (Double) Obj.get(Configurables.SHOOTING.getAction());
        Double checking = (Double) Obj.get(Configurables.CHECKING.getAction());
        Double saving = (Double) Obj.get(Configurables.SAVING.getAction());
        Double[] detailsValue = {skating, shooting, checking, saving};
        String[] detailsName = {"skating", "shooting", "checking", "saving"};
        if (validator.valueIsPresent(name)) {
        } else {
            stack.push("Name is Missing");
            userOutput.setOutput("Name is Missing");
            userOutput.sendOutput();
            return false;
        }
        for (int i = 0; i < detailsValue.length; i++) {
            if (validator.valueIsPresent(detailsValue[i])) {
            }
            else {
                stack.push(detailsName[i] + "is Missing");
                return false;
            }
        }
        return true;
    }
}
