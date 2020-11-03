package dhl.leagueModel.headCoach;

import dhl.persistence.saving.FreeCoachPersistence;
import dhl.persistence.saving.HeadCoachPersistence;
import dhl.persistence.saving.IFreeCoachPersistence;
import dhl.persistence.saving.IHeadCoachPersistence;

import java.util.List;

public class HeadCoach implements IHeadCoach {

    private String name;
    private double skating;
    private double shooting;
    private double checking;
    private double saving;

    public HeadCoach() {
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
    public double getSkating() {

        return skating;
    }

    @Override
    public void setSkating(double skating) {
        this.skating = skating;

    }

    @Override
    public double getShooting() {
        return shooting;

    }

    @Override
    public void setShooting(double shooting) {
        this.shooting = shooting;

    }

    @Override
    public double getChecking() {
        return checking;
    }

    @Override
    public void setChecking(double checking) {
        this.checking = checking;

    }

    @Override
    public double getSaving() {
        return saving;
    }

    @Override
    public void setSaving(double saving) {
        this.saving = saving;
    }

    @Override
    public IHeadCoach getCoachFromList(List<IHeadCoach> coachList, String coachName) {
        for (IHeadCoach coach : coachList) {
            if (coach.getName().equals(coachName)) {
                return coach;
            }
        }
        return null;
    }

    @Override
    public void saveHeadCoach(int teamID) {
        IHeadCoachPersistence headCoachPersistence = new HeadCoachPersistence();
        String headCoachName = this.getName();
        double[] headCoachAttributes = {this.getSkating(), this.getShooting(), this.getChecking(), this.getSaving()};
        headCoachPersistence.saveHeadCoachToDB(headCoachName, headCoachAttributes, teamID);
    }

    @Override
    public void saveFreeCoach(int leagueID) {
        IFreeCoachPersistence freeCoachPersistence = new FreeCoachPersistence();
        String freeCoachName = this.getName();
        double[] headCoachAttributes = {this.getSkating(), this.getShooting(), this.getChecking(), this.getSaving()};
        freeCoachPersistence.saveFreeCoachToDB(freeCoachName, headCoachAttributes, leagueID);
    }
}
