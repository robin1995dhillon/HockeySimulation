package dhl.mock;

import dhl.leagueModel.freeAgents.FreeAgents;
import dhl.leagueModel.freeAgents.IFreeAgents;

import java.util.ArrayList;
import java.util.List;

public class MockFreeAgent {

    public static IFreeAgents createMock() {
        IFreeAgents freeAgents = new FreeAgents();
        freeAgents.setPlayerName("FreeAgent1");
        freeAgents.setPosition("forward");
        freeAgents.setAge(18);
        freeAgents.setSkating(20);
        freeAgents.setShooting(20);
        freeAgents.setChecking(20);
        freeAgents.setSaving(0);
        freeAgents.setStrength(40);
        return freeAgents;
    }

    public static IFreeAgents createMockTwo() {
        IFreeAgents freeAgents = new FreeAgents();
        freeAgents.setPlayerName("FreeAgent2");
        freeAgents.setPosition("forward");
        freeAgents.setAge(18);
        freeAgents.setSkating(15);
        freeAgents.setShooting(15);
        freeAgents.setChecking(15);
        freeAgents.setSaving(10);
        return freeAgents;
    }

    public static IFreeAgents createMockThree() {
        IFreeAgents freeAgents = new FreeAgents();
        freeAgents.setPlayerName("FreeAgent3");
        freeAgents.setPosition("defense");
        freeAgents.setAge(18);
        freeAgents.setSkating(30);
        freeAgents.setShooting(25);
        freeAgents.setChecking(25);
        freeAgents.setSaving(20);
        return freeAgents;
    }

    public static List<IFreeAgents> createMockAgentList() {

        List<IFreeAgents> availableAgents = new ArrayList<>();

        IFreeAgents player1 = new FreeAgents();
        player1.setPosition("forward");
        player1.setPlayerName("ABC");
        player1.setSkating(15);
        player1.setShooting(12);
        player1.setChecking(13);
        player1.setSaving(0);
        player1.setStrength(9.6);

        IFreeAgents player2 = new FreeAgents();
        player2.setPosition("forward");
        player2.setSkating(15);
        player2.setPlayerName("DEF");
        player2.setShooting(18);
        player2.setChecking(12);
        player2.setSaving(0);
        player2.setStrength(5.6);

        IFreeAgents player3 = new FreeAgents();
        player3.setPosition("goalie");
        player3.setSkating(15);
        player3.setPlayerName("GHI");
        player3.setShooting(16);
        player3.setChecking(17);
        player3.setSaving(0);
        player3.setStrength(6.7);

        availableAgents.add(player1);
        availableAgents.add(player2);
        availableAgents.add(player3);

        return availableAgents;


    }

    public static List<IFreeAgents> createMockAgentListExpected() {

        List<IFreeAgents> expectedAgentList = new ArrayList<>();
        IFreeAgents player2 = new FreeAgents();
        player2.setPosition("forward");
        player2.setSkating(15);
        player2.setPlayerName("DEF");
        player2.setShooting(18);
        player2.setChecking(12);
        player2.setSaving(0);
        player2.setStrength(5.6);

        IFreeAgents player3 = new FreeAgents();
        player3.setPosition("goalie");
        player3.setSkating(15);
        player3.setPlayerName("GHI");
        player3.setShooting(16);
        player3.setChecking(17);
        player3.setSaving(0);
        player3.setStrength(6.7);


        expectedAgentList.add(player2);
        expectedAgentList.add(player3);

        return expectedAgentList;
    }

    public static List<IFreeAgents> createMockAgentGoalieListExpected() {

        List<IFreeAgents> expectedAgentList = new ArrayList<>();
        IFreeAgents player2 = new FreeAgents();
        player2.setPosition("forward");
        player2.setSkating(15);
        player2.setPlayerName("DEF");
        player2.setShooting(18);
        player2.setChecking(12);
        player2.setSaving(0);
        player2.setStrength(5.6);

        IFreeAgents player1 = new FreeAgents();
        player1.setPosition("forward");
        player1.setPlayerName("ABC");
        player1.setSkating(15);
        player1.setShooting(12);
        player1.setChecking(13);
        player1.setSaving(0);
        player1.setStrength(9.6);


        expectedAgentList.add(player2);
        expectedAgentList.add(player1);

        return expectedAgentList;
    }
}
