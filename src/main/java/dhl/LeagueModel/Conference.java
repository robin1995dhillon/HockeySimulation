package dhl.LeagueModel;

public class Conference {

    String ConferenceName = "";

    public Conference(String ConferenceName) {
        this.ConferenceName = ConferenceName;
        System.out.println(this.ConferenceName);
    }

    public String getConferenceName() {
        return ConferenceName;
    }

    public void setConferenceName(String conferenceName) {
        ConferenceName = conferenceName;
    }


}
