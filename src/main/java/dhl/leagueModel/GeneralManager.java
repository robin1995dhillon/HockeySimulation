package dhl.leagueModel;

import java.util.List;

public class GeneralManager implements IGeneralManager {

    private String name;
    private String personality;


    public GeneralManager() {

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getPersonality() {
        return personality;
    }

    @Override
    public void setPersonality(String personality) {
        this.personality = personality;
    }

    @Override
    public IGeneralManager getManagerFromList(List<IGeneralManager> managerList, String managerName) {
        for (IGeneralManager manager : managerList) {
            if (manager.getName().equals(managerName)) {
                return manager;
            }
        }
        return null;
    }
}
