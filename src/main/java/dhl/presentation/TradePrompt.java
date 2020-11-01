package dhl.presentation;

import dhl.leagueModel.IPlayers;

import java.util.List;

 public class TradePrompt implements ITradePrompt {


     @Override
     public void userAcceptRejectTrade(List<IPlayers> userPlayers) {


         System.out.println("****************************************************************************");
         System.out.format("%s%5s%10s%9s%10s%8s%10s%9s%11s", "Name", "Age", "Position", "Captain", "Checking", "Saving", "Shooting", "Skating", "Strength" + "\n");
         for (IPlayers p : userPlayers) {

             System.out.format("%s%5d%10s%9b%10d%8d%10d%9d%10.2f", p.getPlayerName(), p.getAge(), p.getPosition(), p.getCaptain(), p.getChecking(), p.getSaving(), p.getShooting(), p.getSkating(), p.getStrength());
             System.out.println();

         }
         System.out.println("****************************************************************************");
         System.out.println();

     }
 }