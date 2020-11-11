package dhl.persistence.loading;

import dhl.leagueModel.headCoach.IHeadCoach;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ILoadCoach {
    IHeadCoach loadHeadCoach(int teamId) throws IOException, SQLException;

    ArrayList<IHeadCoach> loadFreeCoach(int leagueId) throws IOException, SQLException;
}
