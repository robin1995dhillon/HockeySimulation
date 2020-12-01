package dhl.leagueModel.gamePlayConfig;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = GmTable.class)
public interface IGmTable {
    double getShrewd();

    void setShrewd(double shrewd);

    double getNormal();

    void setNormal(double normal);

    double getGambler();

    void setGambler(double gambler);
}
