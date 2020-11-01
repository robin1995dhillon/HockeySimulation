package Presentation;
import static org.junit.jupiter.api.Assertions.assertEquals;

import dhl.leagueModel.IPlayers;
import dhl.leagueModel.players.Players;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class userAcceptRejectTest {

    @Test
    public void userAcceptRejectTradeTest(){
        List<IPlayers> userPlayers = new ArrayList<>();
        List<IPlayers> aiPlayers = new ArrayList<>();
        IPlayers user = new Players();
        IPlayers user2 = new Players();
        IPlayers ai = new Players();
        IPlayers ai2 = new Players();

        user.setPosition("forward");
        user.setPlayerName("ABC");
        user.setAge(32);
        user.setCaptain(true);
        user.setSkating(15);
        user.setShooting(18);
        user.setChecking(12);
        user.setSaving(0);
        double strengthUser = user.getShooting() + user.getSkating() + user.getChecking() / 2.0;
        user.setStrength(strengthUser);

        user2.setPosition("forward");
        user2.setPlayerName("DEF");
        user2.setSkating(12);
        user2.setAge(32);
        user2.setCaptain(false);
        user2.setShooting(16);
        user2.setChecking(11);
        user2.setSaving(0);
        double strengthUser2 = user2.getShooting() + user2.getSkating() + user2.getChecking() / 2.0;
        user2.setStrength(strengthUser2);

        ai.setPosition("forward");
        ai.setPlayerName("GHI");
        ai.setSkating(15);
        ai.setAge(32);
        ai.setCaptain(true);
        ai.setShooting(18);
        ai.setChecking(12);
        ai.setSaving(0);
        double strengthAi = user.getShooting() + user.getSkating() + user.getChecking() / 2.0;
        ai.setStrength(strengthAi);

        ai2.setPosition("forward");
        ai2.setPlayerName("JKL");
        ai2.setSkating(12);
        ai2.setAge(32);
        ai2.setCaptain(false);
        ai2.setShooting(16);
        ai2.setChecking(11);
        ai2.setSaving(0);
        double strengthAi2 = user2.getShooting() + user2.getSkating() + user2.getChecking() / 2.0;
        ai2.setStrength(strengthAi2);

        userPlayers.add(user);
        userPlayers.add(user2);
        aiPlayers.add(ai);
        aiPlayers.add(ai2);

        System.out.println("User Players");
        System.out.println("****************************************************************************");
        System.out.format("%s%5s%10s%9s%10s%8s%10s%9s%11s","Name","Age","Position","Captain","Checking","Saving","Shooting","Skating","Strength"+"\n");
        for(IPlayers p:userPlayers){

          System.out.format("%s%5d%10s%9b%10d%8d%10d%9d%10.2f",p.getPlayerName(),p.getAge(),p.getPosition(),p.getCaptain(),p.getChecking(),p.getSaving(),p.getShooting(),p.getSkating(),p.getStrength());
          System.out.println();

        }
        System.out.println("****************************************************************************");
        System.out.println();
        System.out.println("AI Players");
        System.out.println("****************************************************************************");
        System.out.format("%s%5s%10s%9s%10s%8s%10s%9s%11s","Name","Age","Position","Captain","Checking","Saving","Shooting","Skating","Strength"+"\n");

        for(IPlayers p:aiPlayers){

            System.out.format("%s%5d%10s%9b%10d%8d%10d%9d%10.2f",p.getPlayerName(),p.getAge(),p.getPosition(),p.getCaptain(),p.getChecking(),p.getSaving(),p.getShooting(),p.getSkating(),p.getStrength());
            System.out.println();

        }
        System.out.println("****************************************************************************");
    }

}
