package dhl;

import dhl.leagueModel.*;
import dhl.leagueModel.conference.Conference;
import dhl.leagueModel.division.Division;
import dhl.leagueModel.freeAgents.FreeAgents;
import dhl.leagueModel.headCoach.HeadCoach;
import dhl.leagueModel.league.League;
import dhl.leagueModel.players.Players;
import dhl.leagueModel.teams.Teams;
import dhl.mock.MockLeague;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

class SerializeModelToJSONTest {

    @Test
    void serializeModelToJSONTest() throws IOException {
        ILeague league = MockLeague.createMock();
        SerializeModelToJSON toJSON = new SerializeModelToJSON();
        System.out.println(toJSON.serializeModelToJSON(league));
    }
}