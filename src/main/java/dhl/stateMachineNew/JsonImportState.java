package dhl.stateMachineNew;

import dhl.leagueModel.league.ILeague;
import dhl.leagueModel.league.League;

public class JsonImportState implements IStateMachine {

    private final StateMachine stateMachine;
    private final String filePath;

    private ILeague league;
    private JsonImport json;


    JsonImportState(StateMachine machine, String filePath) {

        this.stateMachine = machine;
        this.filePath = filePath;
        league = new League();
        json = new JsonImport();

    }

    public IStateMachine entry() {

        return doTask();
    }

    public IStateMachine doTask() {

        if (filePath == null || filePath.isEmpty()) {
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

