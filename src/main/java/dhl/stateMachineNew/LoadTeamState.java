package dhl.stateMachineNew;

import dhl.inputOutput.IUserInput;
import dhl.inputOutput.IUserOutput;
import dhl.inputOutput.UserInput;
import dhl.inputOutput.UserOutput;
import dhl.leagueModel.league.ILeague;
import dhl.leagueModel.league.League;
import dhl.persistence.database.CheckTeam;
import dhl.persistence.database.ICheckStoredProcedure;
import dhl.persistence.loading.ILoadLeague;
import dhl.serializeAndDeserialize.deserialize.DeserializeJSONToModel;
import dhl.serializeAndDeserialize.deserialize.IDeserializeJSONToModel;
import dhl.validator.Checker;
import dhl.validator.IChecker;
//import dhl.persistence.loading.LoadLeague;

import java.io.IOException;
import java.sql.SQLException;

public class LoadTeamState implements IStateMachine{

    private final IUserOutput output;
    private final IUserInput input;
    //private ILoadLeague loadLeague;
    private final StateMachine stateMachine;
    private IDeserializeJSONToModel deserializeJSONToModel = new DeserializeJSONToModel();
    private IChecker checker = new Checker();

    LoadTeamState(StateMachine machine){
        this.stateMachine = machine;
        output = new UserOutput();
        input = new UserInput();
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
//        ICheckStoredProcedure storedProcedure = new CheckTeam(teamName);
//        boolean isExist = false;
//        try {
//            storedProcedure.executeProcedure();
//            isExist = storedProcedure.getExist();
//        } catch (IOException | SQLException e) {
//            e.printStackTrace();
//        }
//        if (isExist) {
//            output.setOutput("Found the team. Loading...");
//            output.sendOutput();
//            try {
//                loadLeague.loadLeague(teamName);
//            } catch (IOException | SQLException e) {
//                e.printStackTrace();
//            }
//            return stateMachine.getPlayerChoice();
//        } else {
//            output.setOutput(" No such team. Quitting simulation.");
//            output.sendOutput();
//            System.exit(0);
//        }

    }

    public void exit() {

    }


}
