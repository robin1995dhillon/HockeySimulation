package dhl.persistence.saving;

public interface IDHLPersistence {
    void saveDHLTable(int leagueID, int conferenceID, int divisionID, int teamID);
}
