package dhl.leagueModel.trade;

import dhl.leagueModel.*;
import dhl.leagueModel.gamePlayConfig.IGamePlayConfig;
import dhl.mock.MockLeague;
import dhl.mock.MockPlayer;
import dhl.mock.MockTeam;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTradingTest {

    IPlayerTradingCondition condition = LeagueModelAbstractFactory.instance().getPLayerTradingCondition();
    IGamePlayConfig gamePlayConfig = LeagueModelAbstractFactory.instance().getGamePlayConfig();

    @Test
    public void strengthTestForward() {

        IPlayers player;
        player = MockPlayer.createMock();
        double strength = player.calculateStrength();
        assertEquals(37.0, strength);
    }

    @Test
    public void strengthTestDefense() {
        IPlayers player;
        player = MockPlayer.createMockDefense();
        double strength = player.calculateStrength();
        assertEquals(37.0, strength);

    }

    @Test
    public void strengthTestGoalie() {
        IPlayers player;
        player = MockPlayer.createMockGoalie();
        double strength = player.getSkating() + player.getSaving();
        assertEquals(31, strength);
    }

    @Test
    public void getPositionTypesOfferingTest() {

        List<IPlayers> players = MockTeam.MockTeamWithThirtyPlayers().getPlayers();
        String position = players.get(0).getPosition();
        List<IPlayers> listOutput = condition.getPositionTypesOffering(players);
        assertEquals(position,listOutput.get(0).getPosition());

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
