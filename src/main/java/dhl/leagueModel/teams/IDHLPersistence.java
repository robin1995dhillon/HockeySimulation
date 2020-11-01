package dhl.leagueModel.teams;

public interface IDHLPersistence {
    void saveDHLTable(int leagueID, int conferenceID, int divisionID, int teamID);
}
