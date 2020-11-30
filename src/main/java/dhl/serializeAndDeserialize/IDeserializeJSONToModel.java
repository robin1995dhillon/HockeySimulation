package dhl.serializeAndDeserialize;

import dhl.leagueModel.ILeague;

public interface IDeserializeJSONToModel {
    ILeague jsonToLeague(String Path);

}
