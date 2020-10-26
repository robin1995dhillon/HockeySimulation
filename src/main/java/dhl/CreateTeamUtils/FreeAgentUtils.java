package dhl.CreateTeamUtils;

import dhl.LeagueModel.IFreeAgents;
import dhl.LeagueModel.IPlayers;

import java.util.ArrayList;

public class FreeAgentUtils implements IFreeAgentUtils {
    @Override
    public void displayFreeAgent(ArrayList<IFreeAgents> freeAgentList) {
        System.out.println(String.format("%-20s\t%-10s\t%-5s\t%-10s\t%-10s\t%-10s\t%-10s","name","position","age","skating","shooting","checking","saving"));
        for (IFreeAgents freeAgent : freeAgentList) {
            System.out.print(String.format("%-20s\t", freeAgent.getPlayerName()));
            System.out.print(String.format("%-10s\t", freeAgent.getPosition()));
            System.out.print(String.format("%-5d\t", freeAgent.getAge()));
            System.out.print(String.format("%-10d\t", freeAgent.getSkating()));
            System.out.print(String.format("%-10d\t", freeAgent.getShooting()));
            System.out.print(String.format("%-10d\t", freeAgent.getChecking()));
            System.out.println(String.format("%-10d", freeAgent.getSaving()));
        }
    }

    @Override
    public IFreeAgents getPlayer(ArrayList<IFreeAgents> freeAgentList, String freeAgentName) {
        for (IFreeAgents freeAgent : freeAgentList) {
            if(freeAgent.getPlayerName().equals(freeAgentName)){
                return freeAgent;
            }
        }
        return null;
    }

    @Override
    public void removeFreeAgent(ArrayList<IFreeAgents> freeAgentList, String freeAgentName) {
        for (IFreeAgents freeAgent : freeAgentList) {
            if(freeAgent.getPlayerName().equals(freeAgentName)){
                freeAgentList.remove(freeAgent);
            }
        }
    }

    @Override
    public boolean checkPosition(ArrayList<IFreeAgents> freeAgentList, String playerName, String position) {
        for (IFreeAgents freeAgent : freeAgentList) {
            if(freeAgent.getPlayerName().equals(playerName)){
                if(freeAgent.getPosition().equals(position)){
                    return true;
                }
            }
        }
        return false;
    }

}

