package dhl.stateMachine;

import dhl.leagueModel.ILeague;

public interface IJsonImport {

    ILeague importJson(String filePath, ILeague league) throws Exception;
}
