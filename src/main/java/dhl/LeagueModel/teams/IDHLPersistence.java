package dhl.LeagueModel.teams;

public interface IDHLPersistence {
    void saveDHLTable(int leagueID, int conferenceID, int divisionID, int teamID);
}
