package dhl.stateMachine.states;

import dhl.presentation.inputOutput.*;
import dhl.leagueModel.ILeague;
import dhl.serializeAndDeserialize.DeserializeJSONToModel;
import dhl.serializeAndDeserialize.IDeserializeJSONToModel;
import dhl.stateMachine.IStateMachine;
import dhl.stateMachine.StateMachine;
import dhl.validator.IChecker;
import dhl.validator.ValidatorAbstractFactory;


public class LoadTeamState implements IStateMachine {

    private final IUserOutput output;
    private final IUserInput input;
    private final StateMachine stateMachine;
    private IDeserializeJSONToModel deserializeJSONToModel = new DeserializeJSONToModel();
    private IChecker checker;
    private ValidatorAbstractFactory validatorAbstractFactory;
    InputOutputAbstractFactory inputOutputAbstractFactory;


    public LoadTeamState(StateMachine machine){
        validatorAbstractFactory = ValidatorAbstractFactory.instance();
        inputOutputAbstractFactory = InputOutputAbstractFactory.instance();
        this.stateMachine = machine;
        checker = validatorAbstractFactory.getChecker();
        output = inputOutputAbstractFactory.createUserOutput();
        input = inputOutputAbstractFactory.createUserInput();
    }

    public IStateMachine entry() {
        return doTask();
    }

    public IStateMachine doTask() {
        String teamName;
        output.setOutput("Please enter the name of the team you want to load");
        output.sendOutput();
        input.setInput();
        teamName = input.getInput();
        ILeague league;
        try {
            league = deserializeJSONToModel.jsonToLeague("src\\saveFile.json");
        } catch (Exception e) {
            throw e;
        }
        if(checker.teamChecker(teamName, league)){
            output.setOutput("Found the team. Loading...");
            output.sendOutput();
            stateMachine.setLeague(league);
            return stateMachine.getPlayerChoice();
        } else {
            output.setOutput(" No such team. Quitting simulation.");
            output.sendOutput();
            System.exit(0);
        }
        return null;
    }

    public void exit() {
    }
}
