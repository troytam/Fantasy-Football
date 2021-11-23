public class DefenseAndSpecialTeams {
    //name
    private String name;
    //defensive statistics
    private int yardsAllowed;
    private int pointsAllowed;
    private int sacks;
    private int defenseInterceptions;
    private int interceptionReturnTd;
    private int defenseFumblesRecovered;
    private int fumbleReturnTd;
    private int safety;
    private int twoPointReturn;
    //special teams statistics
    private int blockedPuntOrFg;
    private int blockedPuntOrFgTd;
    private int kickoffReturnTd;
    private int puntReturnTd;
    //amount of fantasy points
    private double points;

    public DefenseAndSpecialTeams(String name, int yardsAllowed, int pointsAllowed, int sacks, int defenseInterceptions,
                                  int interceptionReturnTd, int defenseFumblesRecovered, int fumbleReturnTd,
                                  int safety, int twoPointReturn, int blockedPuntOrFg, int blockedPuntOrFgTd,
                                  int kickoffReturnTd, int puntReturnTd, double points) {
        //name
        this.name = name;
        this.yardsAllowed = yardsAllowed;
        this.pointsAllowed = pointsAllowed;
        this.sacks = sacks;
        this.defenseInterceptions = defenseInterceptions;
        this.interceptionReturnTd = interceptionReturnTd;
        this.defenseFumblesRecovered = defenseFumblesRecovered;
        this.fumbleReturnTd = fumbleReturnTd;
        this.safety = safety;
        this.twoPointReturn = twoPointReturn;
        this.blockedPuntOrFg = blockedPuntOrFg;
        this.blockedPuntOrFgTd = blockedPuntOrFgTd;
        this.kickoffReturnTd = kickoffReturnTd;
        this.puntReturnTd = puntReturnTd;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYardsAllowed() {
        return yardsAllowed;
    }

    public void setYardsAllowed(int yardsAllowed) {
        this.yardsAllowed = yardsAllowed;
    }

    public int getPointsAllowed() {
        return pointsAllowed;
    }

    public void setPointsAllowed(int pointsAllowed) {
        this.pointsAllowed = pointsAllowed;
    }

    public int getSacks() {
        return sacks;
    }

    public void setSacks(int sacks) {
        this.sacks = sacks;
    }

    public int getDefenseInterceptions() {
        return defenseInterceptions;
    }

    public void setDefenseInterceptions(int defenseInterceptions) {
        this.defenseInterceptions = defenseInterceptions;
    }

    public int getInterceptionReturnTd() {
        return interceptionReturnTd;
    }

    public void setInterceptionReturnTd(int interceptionReturnTd) {
        this.interceptionReturnTd = interceptionReturnTd;
    }

    public int getDefenseFumblesRecovered() {
        return defenseFumblesRecovered;
    }

    public void setDefenseFumblesRecovered(int defenseFumblesRecovered) {
        this.defenseFumblesRecovered = defenseFumblesRecovered;
    }

    public int getFumbleReturnTd() {
        return fumbleReturnTd;
    }

    public void setFumbleReturnTd(int fumbleReturnTd) {
        this.fumbleReturnTd = fumbleReturnTd;
    }

    public int getSafety() {
        return safety;
    }

    public void setSafety(int safety) {
        this.safety = safety;
    }

    public int getTwoPointReturn() {
        return twoPointReturn;
    }

    public void setTwoPointReturn(int twoPointReturn) {
        this.twoPointReturn = twoPointReturn;
    }

    public int getBlockedPuntOrFg() {
        return blockedPuntOrFg;
    }

    public void setBlockedPuntOrFg(int blockedPuntOrFg) {
        this.blockedPuntOrFg = blockedPuntOrFg;
    }

    public int getBlockedPuntOrFgTd() {
        return blockedPuntOrFgTd;
    }

    public void setBlockedPuntOrFgTd(int blockedPuntOrFgTd) {
        this.blockedPuntOrFgTd = blockedPuntOrFgTd;
    }

    public int getKickoffReturnTd() {
        return kickoffReturnTd;
    }

    public void setKickoffReturnTd(int kickoffReturnTd) {
        this.kickoffReturnTd = kickoffReturnTd;
    }

    public int getPuntReturnTd() {
        return puntReturnTd;
    }

    public void setPuntReturnTd(int puntReturnTd) {
        this.puntReturnTd = puntReturnTd;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }
}
