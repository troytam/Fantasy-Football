import javax.swing.*;
import java.util.ArrayList;

/**
 * Application Class
 * <p>
 * Runs the program and implements all the classes
 *
 * @author Troy Tamura
 * <p>
 * November 21, 2021
 */

public class FantasyFootballApplication {

    //Message strings
    private static final String welcomeMessage = "Welcome to the Fantasy Football Application!";
    private static final String howItWorksMessage = "To use this application, please write all the names of the " +
            "players and their statistics";
    //Types of possible leagues (determines scoring)
    private static final String[] leagueType = {"Standard league", "0.5 point ppr", "1 point ppr"};
    //Two rosters
    //private static SkillPositionPlayer[] rosterOneArray = new SkillPositionPlayer[7];
    private static ArrayList<SkillPositionPlayer> rosterOneSkillPlayers = new ArrayList<>();
    //If ever equal to 1, quit the program
    private static int quitProgram = 0;

    public static void main(String[] args) {

        double teamOneTotalPoints = 0;

        //Introductory messages
        JOptionPane.showMessageDialog(null, welcomeMessage, "Fantasy Football Application",
                JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null,
                howItWorksMessage, "Fantasy Football Application",
                JOptionPane.INFORMATION_MESSAGE);

        //Set the type of scoring system for the league
        String leagueScoringSystem = leagueTypeInputDialog();
        if (quitProgram == 1) {
            return;
        }

        //Ask for name of first team
        String teamOneName = enterTeamNameDialog(1);
        if (quitProgram == 1) {
            return;
        }
        //Create skilled position players with statistics and add to roster
        SkillPositionPlayer firstQb = createPlayer("Quarterback");
        if (quitProgram == 1) {
            return;
        }
        rosterOneSkillPlayers.add(firstQb);
        /**
        SkillPositionPlayer firstRbOne = createPlayer("Running Back One");
        if (quitProgram == 1) {
            return;
        }
        rosterOneSkillPlayers.add(firstRbOne);
        SkillPositionPlayer firstRbTwo = createPlayer("Running Back Two");
        if (quitProgram == 1) {
            return;
        }
        rosterOneSkillPlayers.add(firstRbTwo);
        SkillPositionPlayer firstWrOne = createPlayer("Wide Receiver One");
        if (quitProgram == 1) {
            return;
        }
        rosterOneSkillPlayers.add(firstWrOne);
        SkillPositionPlayer firstWrTwo = createPlayer("Wide Receiver Two");
        if (quitProgram == 1) {
            return;
        }
        rosterOneSkillPlayers.add(firstWrTwo);
        SkillPositionPlayer firstTe = createPlayer("Tight End");
        if (quitProgram == 1) {
            return;
        }
        rosterOneSkillPlayers.add(firstTe);
        SkillPositionPlayer firstFlex = createPlayer("Flex");
        if (quitProgram == 1) {
            return;
        }
        rosterOneSkillPlayers.add(firstFlex);
         */

        //if the league scoring system is 1 point ppr, calculate total fantasy points for roster using formula
        if (leagueScoringSystem.equals("1 point ppr")) {
            for (int i = 0; i < rosterOneSkillPlayers.size(); i++) {
                teamOneTotalPoints += calculateOnePointPprFantasyPoints(rosterOneSkillPlayers.get(i));
                System.out.println(rosterOneSkillPlayers.get(i).getName());
                System.out.println(rosterOneSkillPlayers.get(i).getPoints());
            }
        }
        System.out.printf("%.2f",teamOneTotalPoints);
    }

    //Tells the application how to determine point distribution for receptions
    public static String leagueTypeInputDialog() {
        String league;
        league = (String) JOptionPane.showInputDialog(null, "Choose your type of league",
                "Fantasy Football", JOptionPane.QUESTION_MESSAGE, null, leagueType,
                leagueType[0]);
        if (league == null) {
            quitProgram = 1;
            return null;
        } else {
            return league;
        }
    }

    //Prompts for team name (will be shown in the end with all the scores)
    public static String enterTeamNameDialog(int teamNumber) {
        String teamName;
        boolean enterTeamName = false;
        do {
            teamName = JOptionPane.showInputDialog(null, "Enter name for Team " + teamNumber +
                    ":", "Fantasy Football", JOptionPane.QUESTION_MESSAGE);
            //if user wants to exit the program
            if (teamName == null) {
                enterTeamName = true;
                quitProgram = 1;
            } else if (teamName.isBlank()) {
                JOptionPane.showMessageDialog(null, "Team name cannot be empty!",
                        "Statistics", JOptionPane.ERROR_MESSAGE);
                enterTeamName = false;
            } else {
                enterTeamName = true;
            }
        } while (!enterTeamName);
        return teamName;
    }

    //create a skill position player with their statistics
    public static SkillPositionPlayer createPlayer(String position) {
        //name
        String playerName = enterPlayerNameDialog(position);
        if (quitProgram == 1) {
            return null;
        }
        //passing
        String passing = enterPassingStatisticsDialog(playerName);
        if (quitProgram == 1) {
            return null;
        }
        String[] passingContents = passing.split(",");
        int passingYds = Integer.parseInt(passingContents[0]);
        int passingTds = Integer.parseInt(passingContents[1]);

        //rushing
        String rushing = enterRushingStatisticsDialog(playerName);
        if (quitProgram == 1) {
            return null;
        }
        String[] rushingContents = rushing.split(",");
        int rushingYds = Integer.parseInt(rushingContents[0]);
        int rushingTds = Integer.parseInt(rushingContents[1]);

        //receiving
        String receiving = enterReceivingStatisticsDialog(playerName);
        if (quitProgram == 1) {
            return null;
        }
        String[] receivingContents = receiving.split(",");
        int receptions = Integer.parseInt(receivingContents[0]);
        int receivingYds = Integer.parseInt(receivingContents[1]);
        int receivingTds = Integer.parseInt(receivingContents[2]);

        //2 point conversions
        String conversions = enterTwoPointConversionsStatisticsDialog(playerName);
        if (quitProgram == 1) {
            return null;
        }
        int twoPointConversions = Integer.parseInt(conversions);


        //turnovers
        String turnovers = enterTurnoversStatisticsDialog(playerName);
        if (quitProgram == 1) {
            return null;
        }
        String[] turnoversContents = turnovers.split(",");
        int interceptions = Integer.parseInt(turnoversContents[0]);
        int fumbles = Integer.parseInt(turnoversContents[1]);

        //create player
        SkillPositionPlayer player = new SkillPositionPlayer(playerName, position, passingYds,
                passingTds, rushingYds, rushingTds, receptions, receivingYds, receivingTds, twoPointConversions,
                interceptions, fumbles, 0);
        return player;
    }

    //method to ask for the players name as input in GUI
    public static String enterPlayerNameDialog(String position) {
        String playerName;
        boolean enterPlayerName = false;
        do {
            playerName = JOptionPane.showInputDialog(null, "Enter your " + position +
                    "'s name:", "Fantasy Football", JOptionPane.QUESTION_MESSAGE);
            if (playerName == null) {
                enterPlayerName = true;
                quitProgram = 1;
            } else if (playerName.isBlank()) {
                JOptionPane.showMessageDialog(null, "Team name cannot be empty!",
                        "Statistics", JOptionPane.ERROR_MESSAGE);
                enterPlayerName = false;
            } else {
                String[] splitName = playerName.split(" ");
                if (splitName.length != 2) {
                    JOptionPane.showMessageDialog(null, "Please enter a first and last name",
                            "Passing Statistics", JOptionPane.ERROR_MESSAGE);
                    enterPlayerName = false;
                } else {
                    enterPlayerName = true;
                }
            }
        } while (!enterPlayerName);
        return playerName;
    }

    //method to ask for input of passing statistics
    public static String enterPassingStatisticsDialog(String name) {
        String passingStatistics;
        boolean enterStatistics = false;
        do {
            passingStatistics = JOptionPane.showInputDialog(null, "Enter " + name +
                            "'s passing " + "yds and passing TDs.\nThe format should be: " +
                            "passing yds,TDs\nExample: 250 passing yds and 2 TDs" + ", Enter: 250,2",
                    name + "'s Passing Statistics", JOptionPane.QUESTION_MESSAGE);
            if (passingStatistics == null) {
                enterStatistics = true;
                quitProgram = 1;
            } else if (passingStatistics.isBlank()) {
                JOptionPane.showMessageDialog(null, "Statistics cannot be empty!",
                        name + "'s Passing Statistics", JOptionPane.ERROR_MESSAGE);
                enterStatistics = false;
            } else {
                //need the string to have only 2 statistics
                String[] splitStatistics = passingStatistics.split(",");
                if (splitStatistics.length != 2) {
                    JOptionPane.showMessageDialog(null, "Please enter statistics in the " +
                            "correct format", name + "'s Passing Statistics", JOptionPane.ERROR_MESSAGE);
                    enterStatistics = false;
                } else {
                    //check if the input string has 2 integers (yards and TDs)
                    int checkIfIntegers = 0;
                    for (int i = 0; i < splitStatistics.length; i++) {
                        try {
                            int statisticsContent = Integer.parseInt(splitStatistics[i]);
                        } catch (NumberFormatException exception) {
                            checkIfIntegers++;
                        }
                    }
                    if (checkIfIntegers != 0) {
                        JOptionPane.showMessageDialog(null, "Please enter statistics in " +
                                "the correct format", name + "'s Passing Statistics", JOptionPane.ERROR_MESSAGE);
                        enterStatistics = false;
                    } else {
                        //check if the passing TDs are negative (is not possible)
                        if (Integer.parseInt(splitStatistics[1]) < 0) {
                            JOptionPane.showMessageDialog(null, "The amount of passing TDs " +
                                            "cannot be negative", name + "'s Passing Statistics",
                                    JOptionPane.ERROR_MESSAGE);
                            enterStatistics = false;
                        } else {
                            enterStatistics = true;
                        }
                    }
                }
            }
        } while (!enterStatistics);
        return passingStatistics;
    }

    //method to ask for input of rushing statistics
    public static String enterRushingStatisticsDialog(String name) {
        String rushingStatistics;
        boolean enterStatistics = false;
        do {
            rushingStatistics = JOptionPane.showInputDialog(null, "Enter " + name +
                            "'s rushing " + "yds and rushing TDs.\nThe format should be: " +
                            "rushing yds,TDs\nExample: 100 rushing yds and 3 TDs" + ", Enter: 100,3",
                    name + "'s Rushing Statistics", JOptionPane.QUESTION_MESSAGE);
            if (rushingStatistics == null) {
                enterStatistics = true;
                quitProgram = 1;
            } else if (rushingStatistics.isBlank()) {
                JOptionPane.showMessageDialog(null, "Statistics cannot be empty!",
                        name + "'s Rushing Statistics", JOptionPane.ERROR_MESSAGE);
                enterStatistics = false;
            } else {
                //need the string to have only 2 integers
                String[] splitStatistics = rushingStatistics.split(",");
                if (splitStatistics.length != 2) {
                    JOptionPane.showMessageDialog(null, "Please enter statistics in the " +
                            "correct format", name + "'s Rushing Statistics", JOptionPane.ERROR_MESSAGE);
                    enterStatistics = false;
                } else {
                    //check if the input string has 2 integers (yards and TDs)
                    int checkIfIntegers = 0;
                    for (int i = 0; i < splitStatistics.length; i++) {
                        try {
                            int statisticsContent = Integer.parseInt(splitStatistics[i]);
                        } catch (NumberFormatException exception) {
                            checkIfIntegers++;
                        }
                    }
                    if (checkIfIntegers != 0) {
                        JOptionPane.showMessageDialog(null, "Please enter statistics in " +
                                "the correct format", name + "'s Rushing Statistics", JOptionPane.ERROR_MESSAGE);
                        enterStatistics = false;
                    } else {
                        //check if the rushing TDs is negative (is not possible)
                        if (Integer.parseInt(splitStatistics[1]) < 0) {
                            JOptionPane.showMessageDialog(null, "The amount of rushing " +
                                            "TDs cannot be negative", name + "'s Rushing Statistics",
                                    JOptionPane.ERROR_MESSAGE);
                            enterStatistics = false;
                        } else {
                            enterStatistics = true;
                        }
                    }
                }
            }
        } while (!enterStatistics);
        return rushingStatistics;
    }

    //method to ask for input of receiving statistics
    public static String enterReceivingStatisticsDialog(String name) {
        String receivingStatistics;
        boolean enterStatistics = false;
        do {
            receivingStatistics = JOptionPane.showInputDialog(null, "Enter " + name +
                    "'s number of receptions, receiving " + "yds and receiving TDs.\nThe format should be: " +
                    "receiving yds,TDs\nExample: 8 receptions, 125 receiving yds and 1 TDs" + ", " +
                    "Enter: 8,125,1", name + "'s Receiving Statistics", JOptionPane.QUESTION_MESSAGE);
            if (receivingStatistics == null) {
                enterStatistics = true;
                quitProgram = 1;
            } else if (receivingStatistics.isBlank()) {
                JOptionPane.showMessageDialog(null, "Statistics cannot be empty!",
                        name + "'s Receiving Statistics", JOptionPane.ERROR_MESSAGE);
                enterStatistics = false;
            } else {
                //need the string to have only 3 integers
                String[] splitStatistics = receivingStatistics.split(",");
                if (splitStatistics.length != 3) {
                    JOptionPane.showMessageDialog(null, "Please enter statistics in the " +
                            "correct format", name + "'s Receiving Statistics", JOptionPane.ERROR_MESSAGE);
                    enterStatistics = false;
                } else {
                    //check if the input string has 3 integers (receptions, yards and TDs)
                    int checkIfIntegers = 0;
                    for (int i = 0; i < splitStatistics.length; i++) {
                        try {
                            int statisticsContent = Integer.parseInt(splitStatistics[i]);
                        } catch (NumberFormatException exception) {
                            checkIfIntegers++;
                        }
                    }
                    if (checkIfIntegers != 0) {
                        JOptionPane.showMessageDialog(null, "Please enter statistics in " +
                                "the correct format", name + "'s Receiving Statistics", JOptionPane.ERROR_MESSAGE);
                        enterStatistics = false;
                    } else {
                        int receptions = Integer.parseInt(splitStatistics[0]);
                        int receivingYds = Integer.parseInt(splitStatistics[1]);
                        int receivingTds = Integer.parseInt(splitStatistics[2]);
                        //check if number of receptions is negative (is not possible)
                        if (receptions < 0) {
                            JOptionPane.showMessageDialog(null, "The amount of receptions " +
                                            "cannot be negative", name + "'s Receiving Statistics",
                                    JOptionPane.ERROR_MESSAGE);
                            enterStatistics = false;
                            //check if number of TDs is negative (is not possible)
                        } else if (receivingTds < 0) {
                            JOptionPane.showMessageDialog(null, "The amount of " +
                                    "receiving TDs cannot be negative", name + "'s Receiving " +
                                    "Statistics", JOptionPane.ERROR_MESSAGE);
                            enterStatistics = false;
                            //check statistics as whole... if no receptions then the player has no receiving statistics
                        } else if ((receptions == 0 && receivingYds > 0) || (receptions == 0 && receivingTds > 0)) {
                            JOptionPane.showMessageDialog(null, "If a player has zero " +
                                            "receptions, they should not have any receiving statistics",
                                    name + "'s Receiving Statistics", JOptionPane.ERROR_MESSAGE);
                            enterStatistics = false;
                        } else {
                            enterStatistics = true;
                        }
                    }
                }
            }
        } while (!enterStatistics);
        return receivingStatistics;
    }

    //method to ask for input of 2 point conversion statistics
    public static String enterTwoPointConversionsStatisticsDialog(String name) {
        String conversionStatistics;
        boolean enterStatistics = false;
        do {
            conversionStatistics = JOptionPane.showInputDialog(null, "Enter the amount of " +
                            "two point conversions that " + name + " has successfully completed\nEnter a single number.",
                    name + "'s Two Point Conversion Statistics", JOptionPane.QUESTION_MESSAGE);
            if (conversionStatistics == null) {
                enterStatistics = true;
                quitProgram = 1;
            } else if (conversionStatistics.isBlank()) {
                JOptionPane.showMessageDialog(null, "Statistics cannot be empty!",
                        name + "'s Two Point Conversion Statistics", JOptionPane.ERROR_MESSAGE);
                enterStatistics = false;
            } else {
                //check to see if the input string was a single integer
                int checkIfIntegers = 0;
                try {
                    int statisticsContent = Integer.parseInt(conversionStatistics);
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(null, "Please enter statistics in " +
                                    "the correct format", name + "'s Two Point Conversion Statistics",
                            JOptionPane.ERROR_MESSAGE);
                    checkIfIntegers++;
                }
                if (checkIfIntegers != 0) {
                    enterStatistics = false;
                } else {
                    //check to see if number of conversions is negative (is not possible)
                    if (Integer.parseInt(conversionStatistics) < 0) {
                        JOptionPane.showMessageDialog(null, "The amount of conversions " +
                                        "cannot be negative", name + "'s Two Point Conversion Statistics",
                                JOptionPane.ERROR_MESSAGE);
                        enterStatistics = false;
                    } else {
                        enterStatistics = true;
                    }
                }
            }
        } while (!enterStatistics);
        return conversionStatistics;
    }

    //method to ask for input of turnover statistics
    public static String enterTurnoversStatisticsDialog(String name) {
        String turnoversStatistics;
        boolean enterStatistics = false;
        do {
            turnoversStatistics = JOptionPane.showInputDialog(null, "Enter " + name +
                            "'s number of interceptions and fumbles lost.\nThe format should be: " +
                            "turnovers,interceptions\nExample: 2 interceptions and 1 fumble" + ", Enter: 2,1",
                    name + "'s Turnover Statistics", JOptionPane.QUESTION_MESSAGE);
            if (turnoversStatistics == null) {
                enterStatistics = true;
                quitProgram = 1;
            } else if (turnoversStatistics.isBlank()) {
                JOptionPane.showMessageDialog(null, "Statistics cannot be empty!",
                        name + "'s Turnover Statistics", JOptionPane.ERROR_MESSAGE);
                enterStatistics = false;
            } else {
                //need the string to only have 2 integers
                String[] splitStatistics = turnoversStatistics.split(",");
                if (splitStatistics.length != 2) {
                    JOptionPane.showMessageDialog(null, "Please enter statistics in the " +
                            "correct format", name + "'s Turnover Statistics", JOptionPane.ERROR_MESSAGE);
                    enterStatistics = false;
                } else {
                    //check if the input string has 2 integers (interceptions, and fumbles lost)
                    int checkIfIntegers = 0;
                    for (int i = 0; i < splitStatistics.length; i++) {
                        try {
                            int statisticsContent = Integer.parseInt(splitStatistics[i]);
                        } catch (NumberFormatException exception) {
                            checkIfIntegers++;
                        }
                    }
                    if (checkIfIntegers != 0) {
                        JOptionPane.showMessageDialog(null, "Please enter statistics in " +
                                "the correct format", name + "'s Turnover Statistics", JOptionPane.ERROR_MESSAGE);
                        enterStatistics = false;
                    } else {
                        //check the interceptions to see if negative (is not possible)
                        if (Integer.parseInt(splitStatistics[0]) < 0) {
                            JOptionPane.showMessageDialog(null, "The amount of interceptions" +
                                            " cannot be negative", name + "'s Turnover Statistics",
                                    JOptionPane.ERROR_MESSAGE);
                            enterStatistics = false;
                            //check the fumbles to see if negative (is not possible)
                        } else if (Integer.parseInt(splitStatistics[1]) < 0) {
                            JOptionPane.showMessageDialog(null, "The amount of fumbles lost" +
                                            " cannot be negative", name + "'s Turnover Statistics",
                                    JOptionPane.ERROR_MESSAGE);
                            enterStatistics = false;
                        } else {
                            enterStatistics = true;
                        }
                    }
                }
            }
        } while (!enterStatistics);
        return turnoversStatistics;
    }

    //calculate the amount of fantasy points per player using multiple formulas then set fantasy points to a player
    public static double calculateOnePointPprFantasyPoints(SkillPositionPlayer skillPositionPlayer) {
        double totalFantasyPoints = 0;
        totalFantasyPoints += (double) skillPositionPlayer.getPassingYards() * 0.04;
        totalFantasyPoints += (double) skillPositionPlayer.getPassingTouchdowns() * 4;
        totalFantasyPoints += (double) skillPositionPlayer.getRushingYards() * 0.1;
        totalFantasyPoints += (double) skillPositionPlayer.getRushingTouchdowns() * 6;
        totalFantasyPoints += (double) skillPositionPlayer.getReceptions() * 1;
        totalFantasyPoints += (double) skillPositionPlayer.getReceivingYards() * 0.1;
        totalFantasyPoints += (double) skillPositionPlayer.getReceivingTouchdowns() * 6;
        totalFantasyPoints += (double) skillPositionPlayer.getTwoPointConversions() * 6;
        totalFantasyPoints += (double) skillPositionPlayer.getInterceptions() * -2;
        totalFantasyPoints += (double) skillPositionPlayer.getFumblesLost() * -2;
        skillPositionPlayer.setPoints(totalFantasyPoints);
        System.out.println(totalFantasyPoints);
        return totalFantasyPoints;
    }


}
