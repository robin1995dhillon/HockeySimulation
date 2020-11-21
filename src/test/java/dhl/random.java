package dhl;

import dhl.leagueModel.LeagueModelAbstractFactory;
import dhl.leagueModel.LeagueModelConcrete;
import dhl.leagueModel.gamePlayConfig.IAging;
import dhl.leagueModel.gamePlayConfig.ITrading;
import dhl.leagueModel.gamePlayConfig.Trading;
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
        trading2 = new Trading();
        System.out.println(trading2);
        trading2 = leagueModelAbstractFactory.getGamePlayConfig().getTrading();
        System.out.println(trading2);
    }
}
