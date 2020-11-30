package dhl.stateMachineNew;

import dhl.leagueModel.ILeague;

public interface IJsonImport {

    ILeague importJson(String filePath, ILeague league);
}
