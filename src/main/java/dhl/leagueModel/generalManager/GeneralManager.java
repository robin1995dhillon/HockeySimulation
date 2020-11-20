package dhl.leagueModel.generalManager;

public class GeneralManager implements IGeneralManager {

    private String name;
    private String personality;

    public GeneralManager(String name, String personality) {
        this.name = name;
        this.personality = personality;
    }

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
}
