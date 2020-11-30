package dhl.stateMachineNew;

import dhl.leagueModel.league.ILeague;

public interface IJsonImport {

    ILeague importJson(String filePath, ILeague league);
}
