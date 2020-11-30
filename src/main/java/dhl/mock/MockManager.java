package dhl.mock;

import dhl.leagueModel.GeneralManager;
import dhl.leagueModel.IGeneralManager;

import java.util.ArrayList;
import java.util.List;

public class MockManager {

    public static List<IGeneralManager> createMock() {
        List<IGeneralManager> generalManagerArray = new ArrayList<>();
        IGeneralManager manager1 = new GeneralManager();
        manager1.setName("Manager1");
        manager1.setPersonality("gambler");
        generalManagerArray.add(manager1);
        IGeneralManager manager2 = new GeneralManager();
        manager2.setName("Manager2");
        manager2.setPersonality("normal");
        generalManagerArray.add(manager2);
        IGeneralManager manager3 = new GeneralManager();
        manager3.setName("Manager3");
        manager3.setPersonality("shrewd");
        generalManagerArray.add(manager3);
        return generalManagerArray;
    }
}
