package dhl.serializeAndDeserialize.serialize;

import dhl.leagueModel.league.ILeague;

import java.io.IOException;

public interface ISerializeModelToJSON {
    String serializeModelToJSON(ILeague league) throws IOException;
}
