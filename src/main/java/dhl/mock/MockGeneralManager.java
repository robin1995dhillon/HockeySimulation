package dhl.mock;

import dhl.leagueModel.IGeneralManager;
import dhl.leagueModel.LeagueModelAbstractFactory;

import java.util.ArrayList;
import java.util.List;

public class MockGeneralManager {

    LeagueModelAbstractFactory leagueModelAbstractFactory;
    IGeneralManager generalManager;

    public MockGeneralManager() {
        leagueModelAbstractFactory = LeagueModelAbstractFactory.instance();
        generalManager = leagueModelAbstractFactory.getGeneralManager();
    }

    public IGeneralManager createGeneralManager() {
        generalManager.setName("General1");
        generalManager.setPersonality("gambler");
        return generalManager;
    }

    public IGeneralManager createGeneralManagerTwo() {
        generalManager.setName("General2");
        generalManager.setPersonality("shrewd");
        return generalManager;
    }

    public List<IGeneralManager> createGeneralManagerList() {
        IGeneralManager generalManager = createGeneralManager();
        IGeneralManager generalManager2 = createGeneralManagerTwo();
        List<IGeneralManager> generalManagerList = new ArrayList<>();
        generalManagerList.add(generalManager);
        generalManagerList.add(generalManager2);
        return generalManagerList;

    }
}
