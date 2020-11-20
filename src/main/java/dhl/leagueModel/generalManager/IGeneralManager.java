package dhl.leagueModel.generalManager;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


@JsonDeserialize(as = GeneralManager.class)
public interface IGeneralManager {
    String getName();

    void setName(String name);

    String getPersonality();

    void setPersonality(String personality);
}
