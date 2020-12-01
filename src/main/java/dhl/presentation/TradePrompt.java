package dhl.presentation;

import dhl.presentation.inputOutput.IUserOutput;
import dhl.presentation.inputOutput.UserOutput;
import dhl.leagueModel.IPlayers;

import java.util.List;

public class TradePrompt implements ITradePrompt {

    private IUserOutput userOutput;

    public TradePrompt(){

        userOutput = new UserOutput();
    }

    @Override
    public void userAcceptRejectTrade(List<IPlayers> userPlayers) {

        userOutput.setOutput("****************************************************************************");
        userOutput.sendOutput();
//        userOutput.setOutput("Trade Rejected");
//        userOutput.sendOutput();
        System.out.format("%s%5s%10s%9s%10s%8s%10s%9s%11s", "Name", "Age", "Position", "Captain", "Checking", "Saving", "Shooting", "Skating", "Strength" + "\n");
        for (IPlayers p : userPlayers) {

            System.out.format("%s%5d%10s%9b%10d%8d%10d%9d%10.2f", p.getPlayerName(), p.getAge(), p.getPosition(), p.getCaptain(), p.getChecking(), p.getSaving(), p.getShooting(), p.getSkating(), p.getStrength());
            userOutput.setOutput("\n");
            userOutput.sendOutput();

        }
        userOutput.setOutput("****************************************************************************");
        userOutput.sendOutput();
        userOutput.setOutput("\n");
        userOutput.sendOutput();

    }
}
