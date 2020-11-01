package Presentation;
import static org.junit.jupiter.api.Assertions.assertEquals;

import dhl.leagueModel.IPlayers;
import dhl.leagueModel.players.Players;
import dhl.mock.MockPlayer;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class userAcceptRejectTest {

    @Test
    public void userAcceptRejectTradeTest(){
        List<IPlayers> userPlayers = new ArrayList<>();
        List<IPlayers> aiPlayers = new ArrayList<>();
        IPlayers user = MockPlayer.createMock();
        IPlayers user2 = MockPlayer.createMockTwo();
        IPlayers ai = MockPlayer.createMock();
        IPlayers ai2 = MockPlayer.createMockTwo();


        userPlayers.add(user);
        userPlayers.add(user2);
        aiPlayers.add(ai);
        aiPlayers.add(ai2);

        System.out.println("User Players");
        System.out.println("****************************************************************************");
        System.out.format("%s%8s%10s%9s%10s%8s%10s%9s%11s","Name","Age","Position","Captain","Checking","Saving","Shooting","Skating","Strength"+"\n");
        for(IPlayers p:userPlayers){

          System.out.format("%s%5d%10s%9b%10d%8d%10d%9d%10.2f",p.getPlayerName(),p.getAge(),p.getPosition(),p.getCaptain(),p.getChecking(),p.getSaving(),p.getShooting(),p.getSkating(),p.getStrength());
          System.out.println();

        }
        System.out.println("****************************************************************************");
        System.out.println();
        System.out.println("AI Players");
        System.out.println("****************************************************************************");
        System.out.format("%s%8s%10s%9s%10s%8s%10s%9s%11s","Name","Age","Position","Captain","Checking","Saving","Shooting","Skating","Strength"+"\n");

        for(IPlayers p:aiPlayers){

            System.out.format("%s%5d%10s%9b%10d%8d%10d%9d%10.2f",p.getPlayerName(),p.getAge(),p.getPosition(),p.getCaptain(),p.getChecking(),p.getSaving(),p.getShooting(),p.getSkating(),p.getStrength());
            System.out.println();

        }
        System.out.println("****************************************************************************");
    }

}
