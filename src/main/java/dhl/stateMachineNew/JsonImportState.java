package dhl.stateMachineNew;

import dhl.leagueModel.league.ILeague;
import dhl.leagueModel.league.League;

public class JsonImportState implements IStateMachine {

    private final StateMachine stateMachine;
    private final String filePath;

    private ILeague league;
    private JsonImport json;


    JsonImportState(StateMachine machine) {

        this.stateMachine = machine;
        this.filePath = this.stateMachine.getFilePath();
        league = new League();
        json = new JsonImport();

    }

    public IStateMachine entry() {

        return doTask();
    }

    public IStateMachine doTask() {

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

