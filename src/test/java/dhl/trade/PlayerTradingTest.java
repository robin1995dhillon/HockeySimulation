package dhl.trade;

import dhl.leagueModel.IPlayers;
import dhl.leagueModel.teams.ITeam;
import dhl.leagueModel.teams.Teams;
import dhl.mock.MockFreeAgent;
import dhl.mock.MockLeague;
import dhl.mock.MockPlayer;
import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTradingTest {

    @Test
    public void strengthTestForward() {

        IPlayers player;
        player = MockPlayer.createMock();
        double strength = player.getShooting() + player.getSkating() + player.getChecking() / 2.0;
        assertEquals(player.getShooting() + player.getSkating() + player.getChecking() / 2.0, strength);
    }

    @Test
    public void strengthTestDefense() {
        IPlayers player;
        player = MockPlayer.createMock();
        double strength = player.getSkating() + player.getChecking() + player.getShooting() / 2.0;
        assertEquals(player.getSkating() + player.getChecking() + player.getShooting() / 2.0, strength);

    }

    @Test
    public void strengthTestGoalie() {
        IPlayers player;
        player = MockPlayer.createMock();
        double strength = player.getSkating() + player.getSaving();
        assertEquals(player.getSkating() + player.getSaving(), strength);
    }

    @Test
    public void getPositionTypesOfferingTest() {

        IFreeAgentListAdd freeAgentListAdd = new FreeAgentList();
        freeAgentListAdd.setAvailableLeague(MockLeague.createMock());
        IPlayerTradingCondition condition = new PlayerTradingCondition();
        List<IPlayers> players;
        players = MockPlayer.createMockPlayerList();

        List<IPlayers> expectedList;
        expectedList = MockPlayer.getPositionTypesOfferingExpectedList();
        condition.getPositionTypesOffering(players);

        assertEquals(players.get(0).getPosition(), expectedList.get(0).getPosition());
    }



    @Test
    public void tradeAiTest() {
        double randomAcceptanceChance = 0.05;
        ITeam offeringTeam = MockPlayer.tradeAiOfferingPlayersTestMock();
        ITeam consideringTeam = MockPlayer.tradeAiConsideringPlayersTestMock();
        List<IPlayers> consideringFinal = MockPlayer.tradeAiConsideringFinalTeamTestMock();
        List<IPlayers> offeringFinal = MockPlayer.tradeAiOfferingFinalTeamTestMock();
        List<IPlayers> expectedConsideringTeam = MockPlayer.tradeAiExpectedConsideringTeamTestMock();
        List<IPlayers> expectedTradingTeam = MockPlayer.tradeAiExpectedTradingTeamTestMock();


        outer:
        for (IPlayers offeredPlayer : offeringFinal) {
            for (IPlayers tradePlayer : consideringFinal) {

                if (offeredPlayer.getStrength() < tradePlayer.getStrength() && Math.random() < randomAcceptanceChance) {

                    break outer;
                }
            }
        }

        offeringTeam.getPlayers().removeAll(offeringFinal);
        offeringTeam.getPlayers().addAll(consideringFinal);
        consideringTeam.getPlayers().removeAll(consideringFinal);
        consideringTeam.getPlayers().addAll(offeringFinal);

        assertEquals(offeringTeam.getPlayers().get(0).getPlayerName(), expectedTradingTeam.get(0).getPlayerName());
        assertEquals(offeringTeam.getPlayers().get(1).getPlayerName(), expectedTradingTeam.get(1).getPlayerName());
        assertEquals(offeringTeam.getPlayers().get(2).getPlayerName(), expectedTradingTeam.get(2).getPlayerName());
        assertEquals(offeringTeam.getPlayers().get(3).getPlayerName(), expectedTradingTeam.get(3).getPlayerName());

        assertEquals(consideringTeam.getPlayers().get(0).getPlayerName(), expectedConsideringTeam.get(0).getPlayerName());
        assertEquals(consideringTeam.getPlayers().get(1).getPlayerName(), expectedConsideringTeam.get(1).getPlayerName());
        assertEquals(consideringTeam.getPlayers().get(2).getPlayerName(), expectedConsideringTeam.get(2).getPlayerName());
        assertEquals(consideringTeam.getPlayers().get(3).getPlayerName(), expectedConsideringTeam.get(3).getPlayerName());

    }

    @Test
    public void tradeUserAcceptTest() {


        ITeam offeringTeam = MockPlayer.tradeAiOfferingPlayersTestMock();
        ITeam consideringTeam = MockPlayer.tradeAiConsideringPlayersTestMock();
        List<IPlayers> consideringFinal = MockPlayer.tradeAiConsideringFinalTeamTestMock();
        List<IPlayers> offeringFinal = MockPlayer.tradeAiOfferingFinalTeamTestMock();
        List<IPlayers> expectedConsideringTeam = MockPlayer.tradeAiExpectedConsideringTeamTestMock();
        List<IPlayers> expectedTradingTeam = MockPlayer.tradeAiExpectedTradingTeamTestMock();

        offeringTeam.getPlayers().removeAll(offeringFinal);
        offeringTeam.getPlayers().addAll(consideringFinal);
        consideringTeam.getPlayers().removeAll(consideringFinal);
        consideringTeam.getPlayers().addAll(offeringFinal);

        assertEquals(offeringTeam.getPlayers().get(0).getPlayerName(), expectedTradingTeam.get(0).getPlayerName());
        assertEquals(offeringTeam.getPlayers().get(1).getPlayerName(), expectedTradingTeam.get(1).getPlayerName());
        assertEquals(offeringTeam.getPlayers().get(2).getPlayerName(), expectedTradingTeam.get(2).getPlayerName());
        assertEquals(offeringTeam.getPlayers().get(3).getPlayerName(), expectedTradingTeam.get(3).getPlayerName());

        assertEquals(consideringTeam.getPlayers().get(0).getPlayerName(), expectedConsideringTeam.get(0).getPlayerName());
        assertEquals(consideringTeam.getPlayers().get(1).getPlayerName(), expectedConsideringTeam.get(1).getPlayerName());
        assertEquals(consideringTeam.getPlayers().get(2).getPlayerName(), expectedConsideringTeam.get(2).getPlayerName());
        assertEquals(consideringTeam.getPlayers().get(3).getPlayerName(), expectedConsideringTeam.get(3).getPlayerName());

    }



    @Test
    public void countTeamPlayers() {

        int count = 0;
        ITeam team = new Teams();
        List<IPlayers> players = MockPlayer.createMockPlayerList();
        team.setPlayers(players);

        for (IPlayers player : team.getPlayers()) {
            count++;
        }

        assertEquals(6, count);
    }
}
