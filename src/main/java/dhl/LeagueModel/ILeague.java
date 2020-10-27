package dhl.LeagueModel;

import java.util.ArrayList;

public interface ILeague {
    public ArrayList<IConference> getConferences();

    public void setConferences(ArrayList<IConference> conferences);

    public String getLeagueName();

    public void setLeagueName(String leagueName);
    public ArrayList<IFreeAgents> getFreeAgents();
    public ArrayList<String> getGeneralManagers();
    public ArrayList<IHeadCoach> getCoaches();

    public void setFreeAgents(ArrayList<IFreeAgents> freeAgents);
    public void setHeadCoach(ArrayList<IHeadCoach> coaches);
    public void setGeneralManager(ArrayList<String> generalManagers);
    public  boolean isValid(ILeague league);
    public boolean isLeagueNamePresent();

}
