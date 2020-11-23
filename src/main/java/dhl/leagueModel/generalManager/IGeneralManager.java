package dhl.leagueModel.generalManager;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;


@JsonDeserialize(as = GeneralManager.class)
public interface IGeneralManager {
    String getName();

    void setName(String name);

    String getPersonality();

    void setPersonality(String personality);

    IGeneralManager getManagerFromList(List<IGeneralManager> managerList, String managerName);
}
