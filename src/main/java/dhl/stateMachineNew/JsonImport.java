package dhl.stateMachineNew;

import dhl.Configurables;
import dhl.inputOutput.IUserOutput;
import dhl.inputOutput.JSONReader;
import dhl.inputOutput.UserOutput;
import dhl.leagueModel.ILeague;
import dhl.serializeAndDeserialize.DeserializeJSONToModel;
import dhl.serializeAndDeserialize.IDeserializeJSONToModel;
import dhl.validator.JSONValidator;
import org.json.simple.JSONObject;

public class JsonImport implements IJsonImport{

    private final IUserOutput output;

    public JsonImport() {
        output = new UserOutput();
    }

    public ILeague importJson(String filePath, ILeague league) {
        JSONObject Object = JSONReader.readJSON(filePath);
        output.setOutput("Loaded JSON:");
        output.sendOutput();
        output.setOutput("\nValidating the JSON...");
        output.sendOutput();
        JSONValidator jsonValidator = new JSONValidator();
        JSONObject JSONValidator = jsonValidator.mainValidator(Object);
        if (JSONValidator.get(Configurables.ISVALID.getAction()).equals(Configurables.TRUE.getAction())) {
            IDeserializeJSONToModel IDeserializeJSONToModel = new DeserializeJSONToModel();
            league = IDeserializeJSONToModel.jsonToLeague(filePath);
//            stateMachine.setLeague(league);
            if (league.isValid(league)) {
                output.setOutput("Valid JSON!\n");
                output.sendOutput();
            } else {
                output.setOutput("Invalid JSON");
                output.sendErrorOutput();
                output.setOutput((String) JSONValidator.get("Message"));
                output.sendErrorOutput();
                return null;
            }
        }
        return league;
    }
}
