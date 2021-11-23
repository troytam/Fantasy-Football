/**
 * Skill Position Football Player Class
 *
 * Has all the methods needed for a skill position football player
 *
 * @author Troy Tamura
 *
 * November 21, 2021
 */
public class SkillPositionPlayer {

    //basic information
    private String name;
    private String position;
    //passing statistics
    private int passingYards;
    private int passingTouchdowns;
    //rushing statistics
    private int rushingYards;
    private int rushingTouchdowns;
    //receiving statistics
    private int receptions;
    private int receivingYards;
    private int receivingTouchdowns;
    //2 point conversion statistics
    private int twoPointConversions;
    //turnover statistics
    private int interceptions;
    private int fumblesLost;
    //amount of fantasy points
    private double points;

    public SkillPositionPlayer(String name, String position, int passingYards, int passingTouchdowns,
                               int rushingYards, int rushingTouchdowns, int receptions, int receivingYards,
                               int receivingTouchdowns, int twoPointConversions, int interceptions,
                               int fumblesLost, double points) {
        this.name = name;
        this.position = position;
        this.passingYards = passingYards;
        this.passingTouchdowns = passingTouchdowns;
        this.rushingYards = rushingYards;
        this.rushingTouchdowns = rushingTouchdowns;
        this.receptions = receptions;
        this.receivingYards = receivingYards;
        this.receivingTouchdowns = receivingTouchdowns;
        this.twoPointConversions = twoPointConversions;
        this.interceptions = interceptions;
        this.fumblesLost = fumblesLost;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getPassingYards() {
        return passingYards;
    }

    public void setPassingYards(int passingYards) {
        this.passingYards = passingYards;
    }

    public int getPassingTouchdowns() {
        return passingTouchdowns;
    }

    public void setPassingTouchdowns(int passingTouchdowns) {
        this.passingTouchdowns = passingTouchdowns;
    }

    public int getRushingYards() {
        return rushingYards;
    }

    public void setRushingYards(int rushingYards) {
        this.rushingYards = rushingYards;
    }

    public int getRushingTouchdowns() {
        return rushingTouchdowns;
    }

    public void setRushingTouchdowns(int rushingTouchdowns) {
        this.rushingTouchdowns = rushingTouchdowns;
    }

    public int getReceptions() {
        return receptions;
    }

    public void setReceptions(int receptions) {
        this.receptions = receptions;
    }

    public int getReceivingYards() {
        return receivingYards;
    }

    public void setReceivingYards(int receivingYards) {
        this.receivingYards = receivingYards;
    }

    public int getReceivingTouchdowns() {
        return receivingTouchdowns;
    }

    public void setReceivingTouchdowns(int receivingTouchdowns) {
        this.receivingTouchdowns = receivingTouchdowns;
    }

    public int getTwoPointConversions() {
        return twoPointConversions;
    }

    public void setTwoPointConversions(int twoPointConversions) {
        this.twoPointConversions = twoPointConversions;
    }

    public int getInterceptions() {
        return interceptions;
    }

    public void setInterceptions(int interceptions) {
        this.interceptions = interceptions;
    }

    public int getFumblesLost() {
        return fumblesLost;
    }

    public void setFumblesLost(int fumblesLost) {
        this.fumblesLost = fumblesLost;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }
}
