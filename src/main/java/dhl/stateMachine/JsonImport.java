package dhl.stateMachine;

import dhl.Configurables;
import dhl.presentation.inputOutput.IUserOutput;
import dhl.presentation.inputOutput.InputOutputAbstractFactory;
import dhl.presentation.inputOutput.JSONReader;
import dhl.leagueModel.ILeague;
import dhl.serializeAndDeserialize.DeserializeJSONToModel;
import dhl.serializeAndDeserialize.IDeserializeJSONToModel;
import dhl.validator.JSONValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;

public class JsonImport implements IJsonImport{
    private static final Logger logger = LogManager.getLogger(JsonImport.class);
    private final IUserOutput output;
    private InputOutputAbstractFactory inputOutputAbstractFactory;

    public JsonImport() {
        inputOutputAbstractFactory = InputOutputAbstractFactory.instance();
        output = inputOutputAbstractFactory.createUserOutput();

    }

    public ILeague importJson(String filePath, ILeague league) throws Exception {
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
            if (league.isValid(league)) {
                output.setOutput("Valid JSON!\n");
                output.sendOutput();
            } else {
                output.setOutput("Invalid JSON");
                output.sendErrorOutput();
                output.setOutput((String) JSONValidator.get("Message"));
                output.sendErrorOutput();
                logger.error("Invalid Json import.");
                return null;
            }
        }
        return league;
    }
}
