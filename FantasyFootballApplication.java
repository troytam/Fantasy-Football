import javax.swing.*;

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
    private static final String [] leagueType = {"Standard league", "0.5 point ppr", "1 point ppr"};
    //If ever equal to 1, quit the program
    private static int quitProgram = 0;

    public static void main(String[] args) {

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

        //Create first team
        String teamOneName = enterTeamNameDialog(1);
        if (quitProgram == 1) {
            return;
        }
        SkillPositionPlayer firstQb = createPlayer("Quarterback");
        if (quitProgram == 1) {
            return;
        }
        SkillPositionPlayer firstRbOne = createPlayer("Running Back One");
        if (quitProgram == 1) {
            return;
        }
        SkillPositionPlayer firstRbTwo = createPlayer("Running Back Two");
        if (quitProgram == 1) {
            return;
        }
        SkillPositionPlayer firstWrOne = createPlayer("Wide Receiver One");
        if (quitProgram == 1) {
            return;
        }
        SkillPositionPlayer firstWrTwo = createPlayer("Wide Receiver Two");
        if (quitProgram == 1) {
            return;
        }
        SkillPositionPlayer firstTE = createPlayer("Tight End");
        if (quitProgram == 1) {
            return;
        }
        SkillPositionPlayer firstFlex = createPlayer("Flex");
        if (quitProgram == 1) {
            return;
        }
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
        String turnovers = enterTurnoversStatisticsDialog(playerName);
        if (quitProgram == 1) {
            return null;
        }
        //turnovers
        String[] turnoversContents = turnovers.split(",");
        int interceptions = Integer.parseInt(turnoversContents[0]);
        int fumbles = Integer.parseInt(turnoversContents[1]);

        //create player
        SkillPositionPlayer player = new SkillPositionPlayer(playerName, position, passingYds,
                passingTds, rushingYds, rushingTds, receptions, receivingYds, receivingTds, interceptions,
                fumbles);
        return player;
    }

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
                String[] splitStatistics = passingStatistics.split(",");
                if (splitStatistics.length != 2) {
                    JOptionPane.showMessageDialog(null, "Please enter statistics in the " +
                            "correct format", name + "'s Passing Statistics", JOptionPane.ERROR_MESSAGE);
                    enterStatistics = false;
                } else {
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
                String[] splitStatistics = rushingStatistics.split(",");
                if (splitStatistics.length != 2) {
                    JOptionPane.showMessageDialog(null, "Please enter statistics in the " +
                            "correct format", name + "'s Rushing Statistics", JOptionPane.ERROR_MESSAGE);
                    enterStatistics = false;
                } else {
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
                String[] splitStatistics = receivingStatistics.split(",");
                if (splitStatistics.length != 3) {
                    JOptionPane.showMessageDialog(null, "Please enter statistics in the " +
                            "correct format", name + "'s Receiving Statistics", JOptionPane.ERROR_MESSAGE);
                    enterStatistics = false;
                } else {
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
                        if (receptions < 0) {
                            JOptionPane.showMessageDialog(null, "The amount of receptions " +
                                            "cannot be negative", name + "'s Receiving Statistics",
                                    JOptionPane.ERROR_MESSAGE);
                            enterStatistics = false;
                        } else if (receivingTds < 0) {
                            JOptionPane.showMessageDialog(null, "The amount of " +
                                    "receiving TDs cannot be negative", name + "'s Receiving " +
                                    "Statistics", JOptionPane.ERROR_MESSAGE);
                            enterStatistics = false;
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
                String[] splitStatistics = turnoversStatistics.split(",");
                if (splitStatistics.length != 2) {
                    JOptionPane.showMessageDialog(null, "Please enter statistics in the " +
                            "correct format", name + "'s Turnover Statistics", JOptionPane.ERROR_MESSAGE);
                    enterStatistics = false;
                } else {
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
                        if (Integer.parseInt(splitStatistics[0]) < 0) {
                            JOptionPane.showMessageDialog(null, "The amount of interceptions" +
                                            " cannot be negative", name + "'s Turnover Statistics",
                                    JOptionPane.ERROR_MESSAGE);
                            enterStatistics = false;
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


}
