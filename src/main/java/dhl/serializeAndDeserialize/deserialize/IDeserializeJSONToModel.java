package dhl.serializeAndDeserialize.deserialize;

import dhl.leagueModel.league.ILeague;

public interface IDeserializeJSONToModel {
    ILeague jsonToLeague(String Path);
}
