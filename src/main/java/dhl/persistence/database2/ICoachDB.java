package dhl.persistence.database2;

import dhl.leagueModel.headCoach.IHeadCoach;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface ICoachDB {
    void createHeadCoach(IHeadCoach headCoach, int teamId) throws IOException, SQLException;
    void createFreeCoach(IHeadCoach freeCoach, int leagueId) throws IOException, SQLException;
    IHeadCoach getHeadCoach(int teamId) throws IOException, SQLException;
    List<IHeadCoach> getFreeCoach(int leagueId) throws IOException, SQLException;
    void updateHeadCoach();
    void updateFreeCoach();
}
