package dhl.gamePlayConfig;

public class Training implements ITraining {
    private int daysUntilStatIncreaseCheck;

    @Override
    public int getDaysUntilStatIncreaseCheck() {
        return daysUntilStatIncreaseCheck;
    }

    @Override
    public void setDaysUntilStatIncreaseCheck(int daysUntilStatIncreaseCheck) {
        this.daysUntilStatIncreaseCheck = daysUntilStatIncreaseCheck;
    }

}
