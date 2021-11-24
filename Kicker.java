public class Kicker {
    //name
    private String name;
    //make any PATs
    private int patMade;
    //FG statistics
    private int fgUnder39Made;
    private int fg40Made;
    private int fg50Made;
    private int fg60Made;
    //amount of fantasy points
    private int fgMissed;
    private double points;

    public Kicker(String name, int patMade, int fgUnder39Made, int fg40Made, int fg50Made, int fg60Made,
                  int fgMissed, double points) {
        this.name = name;
        this.patMade = patMade;
        this.fgUnder39Made = fgUnder39Made;
        this.fg40Made = fg40Made;
        this.fg50Made = fg50Made;
        this.fg60Made = fg60Made;
        this.fgMissed = fgMissed;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPatMade() {
        return patMade;
    }

    public void setPatMade(int patMade) {
        this.patMade = patMade;
    }

    public int getFgUnder39Made() {
        return fgUnder39Made;
    }

    public void setFgUnder39Made(int fgUnder39Made) {
        this.fgUnder39Made = fgUnder39Made;
    }

    public int getFg40Made() {
        return fg40Made;
    }

    public void setFg40Made(int fg40Made) {
        this.fg40Made = fg40Made;
    }

    public int getFg50Made() {
        return fg50Made;
    }

    public void setFg50Made(int fg50Made) {
        this.fg50Made = fg50Made;
    }

    public int getFg60Made() {
        return fg60Made;
    }

    public void setFg60Made(int fg60Made) {
        this.fg60Made = fg60Made;
    }

    public int getFgMissed() {
        return fgMissed;
    }

    public void setFgMissed(int fgMissed) {
        this.fgMissed = fgMissed;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }
}
