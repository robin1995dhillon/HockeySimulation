package dhl.serializeAndDeserialize.deserialize;

import dhl.leagueModel.ILeague;

public interface IDeserializeJSONToModel {
    ILeague jsonToLeague(String Path);

}
