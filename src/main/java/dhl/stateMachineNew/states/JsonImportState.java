package dhl.stateMachineNew.states;

import dhl.leagueModel.LeagueModelAbstractFactory;
import dhl.leagueModel.league.ILeague;
import dhl.stateMachineNew.*;

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

    public IStateMachine entry() {

        return doTask();
    }

    public IStateMachine doTask() {
        this.filePath = this.stateMachine.getFilePath();
        if (this.filePath == null || this.filePath.isEmpty()) {
            System.out.println("filepath is null");
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

