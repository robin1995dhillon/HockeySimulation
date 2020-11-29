package dhl;

import dhl.leagueModel.*;
import dhl.leagueModel.gamePlayConfig.IAging;
import dhl.leagueModel.gamePlayConfig.ITrading;
import dhl.leagueModel.gamePlayConfig.Trading;
import dhl.mock.MockFreeAgent;
import dhl.stateMachineNew.PlayerDraft;
import org.junit.jupiter.api.Test;

public class random {
    IAging aging;
    ITrading trading;
    ITrading trading2;

    @Test
    void randomTest() {
        LeagueModelAbstractFactory leagueModelAbstractFactory = LeagueModelAbstractFactory.instance();
        aging = leagueModelAbstractFactory.getGamePlayConfig().getAging();
        System.out.println(aging.getStatDecayChance());
        trading = leagueModelAbstractFactory.getGamePlayConfig().getTrading();
        System.out.println(trading);
//        trading2 = new Trading();
//        System.out.println(trading2);
        trading2 = leagueModelAbstractFactory.getGamePlayConfig().getTrading();
        System.out.println(trading2);
    }

//    @Test
//    void ageFreeAgent() {
//
//        IFreeAgents freeAgents = new FreeAgents();
//        freeAgents.setPlayerName("Play1");
//        freeAgents.setPosition("forward");
//        freeAgents.setBirthDay(28);
//        freeAgents.setBirthMonth(6);
//        freeAgents.setBirthYear(1997);
//        freeAgents.agePlayer(10);
//        System.out.println(freeAgents.getPlayerCurrentDate());
//        System.out.println(freeAgents.getAge());
//    }
//    @Test
//    void random2() {
//        PlayerDraft playerDraft = new PlayerDraft();
//        playerDraft.getTeamStandingList();
//    }


}
