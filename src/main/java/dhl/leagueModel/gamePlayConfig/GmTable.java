package dhl.leagueModel.gamePlayConfig;

public class GmTable implements IGmTable {
    private double shrewd;
    private double normal;
    private double gambler;

    public GmTable(double shrewd, double normal, double gambler) {
        this.shrewd = shrewd;
        this.normal = normal;
        this.gambler = gambler;
    }

    public GmTable() {
    }

    @Override
    public double getShrewd() {
        return shrewd;
    }

    @Override
    public void setShrewd(double shrewd) {
        this.shrewd = shrewd;
    }

    @Override
    public double getNormal() {
        return normal;
    }

    @Override
    public void setNormal(double normal) {
        this.normal = normal;
    }

    @Override
    public double getGambler() {
        return gambler;
    }

    @Override
    public void setGambler(double gambler) {
        this.gambler = gambler;
    }
}
