package dhl.stateMachine.states;

import dhl.leagueModel.ILeague;
import dhl.leagueModel.LeagueModelAbstractFactory;
import dhl.stateMachine.IJsonImport;
import dhl.stateMachine.IStateMachine;
import dhl.stateMachine.StateMachine;
import dhl.stateMachine.StateMachineAbstractFactory;

public class JsonImportState implements IStateMachine {

    private  StateMachine stateMachine;
    private  String filePath;
    private ILeague league;
    private IJsonImport json;


    public JsonImportState(StateMachine machine) {
        this.stateMachine = machine;
        league = LeagueModelAbstractFactory.instance().getLeague();
        json = StateMachineAbstractFactory.instance().getJsonImport();

    }

    public IStateMachine entry() throws Exception {
        return doTask();
    }

    public IStateMachine doTask() throws Exception {
        this.filePath = this.stateMachine.getFilePath();
        if (this.filePath == null || this.filePath.isEmpty()) {
            return stateMachine.getLoadTeam();
        } else {
            league = json.importJson(filePath,league);
            stateMachine.setLeague(league);
        }
        return stateMachine.getCreateTeam();

    }

    public void exit() {

    }


}

