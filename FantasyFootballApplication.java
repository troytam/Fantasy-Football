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
    //Two rosters of skilled players
    private static ArrayList<SkillPositionPlayer> rosterOneSkillPlayers = new ArrayList<>();
    private static ArrayList<SkillPositionPlayer> rosterTwoSkillPlayers = new ArrayList<>();
    //If ever equal to 1, quit the program
    private static int quitProgram = 0;

    public static void main(String[] args) {

        //Total fantasy points for team
        double teamOneTotalPoints = 0;
        double teamTwoTotalPoints = 0;

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
        SkillPositionPlayer firstRbOne = createPlayer("Running Back One");
        if (quitProgram == 1) {
            return;
        }
        rosterOneSkillPlayers.add(firstRbOne);
        System.out.println(firstRbOne.getPoints());
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
        DefenseAndSpecialTeams firstDAndSt = createDefenseAndSt("D/ST");
        if (quitProgram == 1) {
            return;
        }
        Kicker firstKicker = createKicker("Kicker");
        if (quitProgram == 1) {
            return;
        }
        
        //Ask for name of second team
        String teamTwoName = enterTeamNameDialog(1);
        if (quitProgram == 1) {
            return;
        }
        //Create skilled position players with statistics and add to roster
        SkillPositionPlayer secondQb = createPlayer("Quarterback");
        if (quitProgram == 1) {
            return;
        }
        rosterTwoSkillPlayers.add(secondQb);
        SkillPositionPlayer secondRbOne = createPlayer("Running Back Two");
        if (quitProgram == 1) {
            return;
        }
        rosterTwoSkillPlayers.add(secondRbOne);
        SkillPositionPlayer secondRbTwo = createPlayer("Running Back Two");
        if (quitProgram == 1) {
            return;
        }
        rosterTwoSkillPlayers.add(secondRbTwo);
        SkillPositionPlayer secondWrOne = createPlayer("Wide Receiver Two");
        if (quitProgram == 1) {
            return;
        }
        rosterTwoSkillPlayers.add(secondWrOne);
        SkillPositionPlayer secondWrTwo = createPlayer("Wide Receiver Two");
        if (quitProgram == 1) {
            return;
        }
        rosterTwoSkillPlayers.add(secondWrTwo);
        SkillPositionPlayer secondTe = createPlayer("Tight End");
        if (quitProgram == 1) {
            return;
        }
        rosterTwoSkillPlayers.add(secondTe);
        SkillPositionPlayer secondFlex = createPlayer("Flex");
        if (quitProgram == 1) {
            return;
        }
        rosterTwoSkillPlayers.add(secondFlex);
        DefenseAndSpecialTeams secondDAndSt = createDefenseAndSt("D/ST");
        if (quitProgram == 1) {
            return;
        }
        Kicker secondKicker = createKicker("Kicker");
        if (quitProgram == 1) {
            return;
        }

        //if the league scoring system is 1 point ppr, calculate total fantasy points for roster using formula
        if (leagueScoringSystem.equals("1 point ppr")) {
            for (int i = 0; i < 7; i++) {
                double playersPointsOne = Math.round(calculateOnePointPprFantasyPoints(rosterOneSkillPlayers.get(i))
                        * 100.0) / 100.0;
                rosterOneSkillPlayers.get(i).setPoints(playersPointsOne);
                teamOneTotalPoints += playersPointsOne;
                System.out.println(rosterOneSkillPlayers.get(i).getPoints());
                double playersPointsTwo = Math.round(calculateOnePointPprFantasyPoints(rosterTwoSkillPlayers.get(i))
                        * 100.0) / 100.0;
                rosterTwoSkillPlayers.get(i).setPoints(playersPointsTwo);
                teamTwoTotalPoints += playersPointsTwo;
            }
        }

        //if the league scoring system is 0.5 point ppr, calculate total fantasy points for roster using formula
        if (leagueScoringSystem.equals("0.5 point ppr")) {
            for (int i = 0; i < 7; i++) {
                double playersPointsOne = Math.round(calculateHalfPointPprFantasyPoints(rosterOneSkillPlayers.get(i))
                        * 100.0) / 100.0;
                rosterOneSkillPlayers.get(i).setPoints(playersPointsOne);
                teamOneTotalPoints += playersPointsOne;
                double playersPointsTwo = Math.round(calculateHalfPointPprFantasyPoints(rosterTwoSkillPlayers.get(i))
                        * 100.0) / 100.0;
                rosterTwoSkillPlayers.get(i).setPoints(playersPointsTwo);
                teamTwoTotalPoints += playersPointsTwo;
            }
        }

        //if the league scoring system is a standard league, calculate total fantasy points for roster using formula
        if (leagueScoringSystem.equals("Standard League")) {
            for (int i = 0; i < 7; i++) {
                double playersPointsOne = Math.round(calculateStandardFantasyPoints(rosterOneSkillPlayers.get(i))
                        * 100.0) / 100.0;
                rosterOneSkillPlayers.get(i).setPoints(playersPointsOne);
                teamOneTotalPoints += playersPointsOne;
                double playersPointsTwo = Math.round(calculateStandardFantasyPoints(rosterTwoSkillPlayers.get(i))
                        * 100.0) / 100.0;
                rosterTwoSkillPlayers.get(i).setPoints(playersPointsTwo);
                teamTwoTotalPoints += playersPointsTwo;
            }
        }

        //calculate the fantasy points for the defense and special teams, and kicker
        double firstDAndStPointTotal = Math.round((calculateDefenseAndSpecialTeamsFantasyPoints(firstDAndSt) * 100.0)
                / 100.0);
        firstDAndSt.setPoints(firstDAndStPointTotal);
        teamOneTotalPoints += firstDAndStPointTotal;
        double firstKickerPointTotal = Math.round((calculateKickingFantasyPoints(firstKicker) * 100.0) / 100.0);
        firstKicker.setPoints(firstKickerPointTotal);
        teamOneTotalPoints += firstKickerPointTotal;

        double secondDAndStPointTotal = Math.round((calculateKickingFantasyPoints(firstKicker) * 100.0) / 100.0);
        secondDAndSt.setPoints(secondDAndStPointTotal);
        teamTwoTotalPoints += secondDAndStPointTotal;
        double secondKickerPointTotal = Math.round((calculateKickingFantasyPoints(firstKicker) * 100.0) / 100.0);
        secondKicker.setPoints(secondKickerPointTotal);
        teamTwoTotalPoints += secondKickerPointTotal;
        
        //print the messages with the scores for each team
        JOptionPane.showMessageDialog(null, createScoreString(rosterOneSkillPlayers, firstDAndSt,
                        firstKicker, teamOneTotalPoints), teamOneName + "'s Fantasy Points",
                JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, createScoreString(rosterTwoSkillPlayers, secondDAndSt,
                        secondKicker, teamTwoTotalPoints), teamOneName + "'s Fantasy Points",
                JOptionPane.INFORMATION_MESSAGE);
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

    //create a D/ST player with their statistics
    public static DefenseAndSpecialTeams createDefenseAndSt(String position) {
        //name
        String playerName = enterDefenseAndSpecialTeamsNameDialog(position);
        if (quitProgram == 1) {
            return null;
        }

        //yards allowed, points allowed, sacks
        String defensiveStatisticsOne = enterDefensiveStatisticsOneDialog(playerName);
        if (quitProgram == 1) {
            return null;
        }
        String[] defensiveContentsOne = defensiveStatisticsOne.split(",");
        int yardsAllowed = Integer.parseInt(defensiveContentsOne[0]);
        int pointsAllowed = Integer.parseInt(defensiveContentsOne[1]);
        int sacks = Integer.parseInt(defensiveContentsOne[2]);

        //interceptions, interception return TDs, fumbles recovered, fumble return TDs
        String defensiveStatisticsTwo = enterDefensiveStatisticsTwoDialog(playerName);
        if (quitProgram == 1) {
            return null;
        }
        String[] defensiveContentsTwo = defensiveStatisticsTwo.split(",");
        int interceptions = Integer.parseInt(defensiveContentsTwo[0]);
        int interceptionTd = Integer.parseInt(defensiveContentsTwo[1]);
        int fumblesRecovered = Integer.parseInt(defensiveContentsTwo[2]);
        int fumbleTds = Integer.parseInt(defensiveContentsTwo[3]);

        //safeties, two point conversion returns
        String defensiveStatisticsThree = enterDefensiveStatisticsThreeDialog(playerName);
        if (quitProgram == 1) {
            return null;
        }
        String[] defensiveContentsThree = defensiveStatisticsThree.split(",");
        int safeties = Integer.parseInt(defensiveContentsThree[0]);
        int twoPointConversionReturns = Integer.parseInt(defensiveContentsThree[1]);

        //blocked punts/FG, blocked punts/FG return TDs, kickoff and punt return TDs
        String specialTeamsStatistics = enterSpecialTeamsStatisticsDialog(playerName);
        if (quitProgram == 1) {
            return null;
        }
        String[] specialTeamsContent = specialTeamsStatistics.split(",");
        int blockedPuntOrFg = Integer.parseInt(specialTeamsContent[0]);
        int blockedPuntOrFgReturnTds = Integer.parseInt(specialTeamsContent[1]);
        int kickoffReturnTds = Integer.parseInt(specialTeamsContent[2]);
        int puntReturnTds = Integer.parseInt(specialTeamsContent[3]);

        //create player
        DefenseAndSpecialTeams dAndSt = new DefenseAndSpecialTeams(playerName, yardsAllowed, pointsAllowed,
                sacks, interceptions, interceptionTd, fumblesRecovered, fumbleTds, safeties,
                twoPointConversionReturns, blockedPuntOrFg, blockedPuntOrFgReturnTds, kickoffReturnTds, puntReturnTds,
                0);
        return dAndSt;
    }

    //create a D/ST player with their statistics
    public static Kicker createKicker(String position) {
        //name
        String playerName = enterPlayerNameDialog(position);
        if (quitProgram == 1) {
            return null;
        }

        //PAT and FG statistics
        String kickerStatistics = enterKickingStatisticsDialog(playerName);
        if (quitProgram == 1) {
            return null;
        }
        String[] kickerContents = kickerStatistics.split(",");
        int pats = Integer.parseInt(kickerContents[0]);
        int fg30 = Integer.parseInt(kickerContents[1]);
        int fg40 = Integer.parseInt(kickerContents[2]);
        int fg50 = Integer.parseInt(kickerContents[3]);
        int fg60 = Integer.parseInt(kickerContents[4]);
        int fgMissed = Integer.parseInt(kickerContents[5]);

        //create player
        Kicker kicker = new Kicker(playerName, pats, fg30, fg40, fg50, fg60, fgMissed, 0);
        return kicker;
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
                if (splitName.length < 2) {
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

    //method to ask for the D/STs name as input in GUI
    public static String enterDefenseAndSpecialTeamsNameDialog(String position) {
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
                enterPlayerName = true;
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
                    "two point conversions that " + name + " has successfully completed\nEnter a single " +
                    "number.", name + "'s Two Point Conversion Statistics", JOptionPane.QUESTION_MESSAGE);
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

    //method to ask for input of defensive statistics (yards allowed, points allowed, sacks)
    public static String enterDefensiveStatisticsOneDialog(String name) {
        String defensiveStatisticsPartOne;
        boolean enterStatistics = false;
        do {
            defensiveStatisticsPartOne = JOptionPane.showInputDialog(null, "Enter " + name +
                    " D/ST's number of yards allowed, points allowed, and sacks.\nThe format should be: " +
                    "yards allowed,points allowed,sacks\nExample: 300 yards allowed,21 points allowed,2 sacks: " +
                    "Enter: 300,21,2", name + "'s Defensive Statistics Part 1", JOptionPane.QUESTION_MESSAGE);
            if (defensiveStatisticsPartOne == null) {
                enterStatistics = true;
                quitProgram = 1;
            } else if (defensiveStatisticsPartOne.isBlank()) {
                JOptionPane.showMessageDialog(null, "Statistics cannot be empty!",
                        name + "'s Defensive Statistics Part 1", JOptionPane.ERROR_MESSAGE);
                enterStatistics = false;
            } else {
                //need the string to have only 3 integers
                String[] splitStatistics = defensiveStatisticsPartOne.split(",");
                if (splitStatistics.length != 3) {
                    JOptionPane.showMessageDialog(null, "Please enter statistics in the " +
                            "correct format", name + "'s Defensive Statistics Part 1", JOptionPane.ERROR_MESSAGE);
                    enterStatistics = false;
                } else {
                    //check if the input string has 3 integers (yards allowed, points allowed, sacks)
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
                                        "the correct format", name + "'s Defensive Statistics Part 1",
                                JOptionPane.ERROR_MESSAGE);
                        enterStatistics = false;
                    } else {
                        int yardsAllowed = Integer.parseInt(splitStatistics[0]);
                        int pointsAllowed = Integer.parseInt(splitStatistics[1]);
                        int sacks = Integer.parseInt(splitStatistics[2]);
                        //check if yards allowed is negative (is not possible)
                        if (yardsAllowed < 0) {
                            JOptionPane.showMessageDialog(null, "The amount of yards allowed "
                                            + "cannot be negative", name + "'s Defensive Statistics Part 1",
                                    JOptionPane.ERROR_MESSAGE);
                            enterStatistics = false;
                            //check if points allowed is negative (is not possible)
                        } else if (pointsAllowed < 0) {
                            JOptionPane.showMessageDialog(null, "The amount of " +
                                    "points allowed cannot be negative", name + "'s Defensive " +
                                    "Statistics Part 1", JOptionPane.ERROR_MESSAGE);
                            enterStatistics = false;
                            //check if sacks is negative (is not possible)
                        } else if (sacks < 0) {
                            JOptionPane.showMessageDialog(null, "The amount of " +
                                            "sacks cannot be negative", name + "'s Defensive Statistics Part 1",
                                    JOptionPane.ERROR_MESSAGE);
                            enterStatistics = false;
                        } else {
                            enterStatistics = true;
                        }
                    }
                }
            }
        } while (!enterStatistics);
        return defensiveStatisticsPartOne;
    }

    //method to ask for input of defensive statistics (ints, int return TDs, fumbles, fumble return TDs)
    public static String enterDefensiveStatisticsTwoDialog(String name) {
        String defensiveStatisticsPartTwo;
        boolean enterStatistics = false;
        do {
            defensiveStatisticsPartTwo = JOptionPane.showInputDialog(null, "Enter " + name +
                    " D/ST's number of interceptions, interception return TDs, fumbles recovered and fumble " +
                    "return TDs.\nThe format should be: interceptions,interception return TDs,fumbles " +
                    "recovered, fumble return TDs\nExample: 0 interceptions, 0 interception return TDs, 2 " +
                    "fumbles recovered, 1 fumble return TD: " + "Enter: 0,0,2,1", name + "'s " +
                    "Defensive Statistics Part 2", JOptionPane.QUESTION_MESSAGE);
            if (defensiveStatisticsPartTwo == null) {
                enterStatistics = true;
                quitProgram = 1;
            } else if (defensiveStatisticsPartTwo.isBlank()) {
                JOptionPane.showMessageDialog(null, "Statistics cannot be empty!",
                        name + "'s Defensive Statistics Part 2", JOptionPane.ERROR_MESSAGE);
                enterStatistics = false;
            } else {
                //need the string to have only 4 integers
                String[] splitStatistics = defensiveStatisticsPartTwo.split(",");
                if (splitStatistics.length != 4) {
                    JOptionPane.showMessageDialog(null, "Please enter statistics in the " +
                            "correct format", name + "'s Defensive Statistics Part 2", JOptionPane.ERROR_MESSAGE);
                    enterStatistics = false;
                } else {
                    //check if the input string has 4 integers (ints, int return TDs, fumbles, fumble return TDs)
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
                                        "the correct format", name + "'s Defensive Statistics Part 2",
                                JOptionPane.ERROR_MESSAGE);
                        enterStatistics = false;
                    } else {
                        int interceptions = Integer.parseInt(splitStatistics[0]);
                        int interceptionTds = Integer.parseInt(splitStatistics[1]);
                        int fumbles = Integer.parseInt(splitStatistics[2]);
                        int fumbleTds = Integer.parseInt(splitStatistics[3]);
                        //check if interceptions is negative (is not possible)
                        if (interceptions < 0) {
                            JOptionPane.showMessageDialog(null, "The amount of interceptions "
                                            + "cannot be negative", name + "'s Defensive Statistics Part 2",
                                    JOptionPane.ERROR_MESSAGE);
                            enterStatistics = false;
                            //check if interception return TDs is negative (is not possible)
                        } else if (interceptionTds < 0) {
                            JOptionPane.showMessageDialog(null, "The amount of interception" +
                                    "return TDs cannot be negative", name + "'s Defensive " +
                                    "Statistics Part 2", JOptionPane.ERROR_MESSAGE);
                            enterStatistics = false;
                            //check if fumbles recovered is negative (is not possible)
                        } else if (fumbles < 0) {
                            JOptionPane.showMessageDialog(null, "The amount of " +
                                    "fumbles recovered cannot be negative", name + "'s Defensive " +
                                    "Statistics Part 2", JOptionPane.ERROR_MESSAGE);
                            enterStatistics = false;
                            //check if fumble return TDs is negative (is not possible)
                        } else if (fumbleTds < 0) {
                            JOptionPane.showMessageDialog(null, "The amount of " +
                                    "fumbles return TDs cannot be negative", name + "'s Defensive " +
                                    "Statistics Part 2", JOptionPane.ERROR_MESSAGE);
                            enterStatistics = false;
                            //can not have any interception return tds if no interceptions
                        } else if (interceptions == 0 && interceptionTds > 0) {
                            JOptionPane.showMessageDialog(null, "There cannot be any " +
                                    "interception return TDs if there are no interceptions", name + "'s " +
                                    "Defensive Statistics Part 2", JOptionPane.ERROR_MESSAGE);
                            enterStatistics = false;
                            //can not have any fumble return tds if no interceptions
                        } else if (fumbles == 0 && fumbleTds > 0) {
                            JOptionPane.showMessageDialog(null, "There cannot be any " +
                                    "fumble return TDs if there are no fumbles recovered", name + "'s " +
                                    "Defensive Statistics Part 2", JOptionPane.ERROR_MESSAGE);
                            enterStatistics = false;
                        } else {
                            enterStatistics = true;
                        }
                    }
                }
            }
        } while (!enterStatistics);
        return defensiveStatisticsPartTwo;
    }

    //method to ask for input of defensive statistics (safeties, two point conversion returns)
    public static String enterDefensiveStatisticsThreeDialog(String name) {
        String defensiveStatisticsPartThree;
        boolean enterStatistics = false;
        do {
            defensiveStatisticsPartThree = JOptionPane.showInputDialog(null, "Enter " + name +
                    " D/ST's number of safeties and 2 point conversion returns.\nThe format should be: " +
                    "safeties,conversion returns\nExample: 1 safety, 1 2 pt conversion returned: " +
                    "Enter: 1,1", name + "'s Defensive Statistics Part 3", JOptionPane.QUESTION_MESSAGE);
            if (defensiveStatisticsPartThree == null) {
                enterStatistics = true;
                quitProgram = 1;
            } else if (defensiveStatisticsPartThree.isBlank()) {
                JOptionPane.showMessageDialog(null, "Statistics cannot be empty!",
                        name + "'s Defensive Statistics Part 3", JOptionPane.ERROR_MESSAGE);
                enterStatistics = false;
            } else {
                //need the string to have only 2 integers
                String[] splitStatistics = defensiveStatisticsPartThree.split(",");
                if (splitStatistics.length != 2) {
                    JOptionPane.showMessageDialog(null, "Please enter statistics in the " +
                            "correct format", name + "'s Defensive Statistics Part 3", JOptionPane.ERROR_MESSAGE);
                    enterStatistics = false;
                } else {
                    //check if the input string has 2 integers (safeties, two point conversion returns)
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
                                        "the correct format", name + "'s Defensive Statistics Part 3",
                                JOptionPane.ERROR_MESSAGE);
                        enterStatistics = false;
                    } else {
                        //check if yards allowed is negative (is not possible)
                        if (Integer.parseInt(splitStatistics[0]) < 0) {
                            JOptionPane.showMessageDialog(null, "The amount of safeties "
                                            + "cannot be negative", name + "'s Defensive Statistics Part 3",
                                    JOptionPane.ERROR_MESSAGE);
                            enterStatistics = false;
                            //check if points allowed is negative (is not possible)
                        } else if (Integer.parseInt(splitStatistics[1]) < 0) {
                            JOptionPane.showMessageDialog(null, "The amount of " +
                                    "2 point conversion returns cannot be negative", name + "'s Defensive " +
                                    "Statistics Part 3", JOptionPane.ERROR_MESSAGE);
                            enterStatistics = false;
                        } else {
                            enterStatistics = true;
                        }
                    }
                }
            }
        } while (!enterStatistics);
        return defensiveStatisticsPartThree;
    }

    //method to ask for input of ST statistics (blocked FG/punts, blocked FG/punt TDs, kickoff and punt return TDs)
    public static String enterSpecialTeamsStatisticsDialog(String name) {
        String specialTeamsStatistics;
        boolean enterStatistics = false;
        do {
            specialTeamsStatistics = JOptionPane.showInputDialog(null, "Enter " + name +
                            " D/ST's number of blocked FG/punts, blocked FG/punts return TDs, kickoff return TDs and "
                            + "punt return TDs.\nThe format should be: blocked FG/punts,blocked FG/punts return TDs," +
                            "kickoff return TDs and punt return TDs\nExample: 1 blocked FG/punt, 0 blocked FG/punt " +
                            "return TDs, 1 kickoff return TD, 0 punt return TD: " + "Enter: 1,0,1,0",
                    name + "'s Special Teams Statistics", JOptionPane.QUESTION_MESSAGE);
            if (specialTeamsStatistics == null) {
                enterStatistics = true;
                quitProgram = 1;
            } else if (specialTeamsStatistics.isBlank()) {
                JOptionPane.showMessageDialog(null, "Statistics cannot be empty!",
                        name + "'s Special Teams Statistics", JOptionPane.ERROR_MESSAGE);
                enterStatistics = false;
            } else {
                //need the string to have only 4 integers
                String[] splitStatistics = specialTeamsStatistics.split(",");
                if (splitStatistics.length != 4) {
                    JOptionPane.showMessageDialog(null, "Please enter statistics in the " +
                            "correct format", name + "'s Special Teams Statistics", JOptionPane.ERROR_MESSAGE);
                    enterStatistics = false;
                } else {
                    //check if the input string has 4 integers (blocked punts/FG and TD, kickoff and punt return TDs)
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
                                        "the correct format", name + "'s Special Teams Statistics",
                                JOptionPane.ERROR_MESSAGE);
                        enterStatistics = false;
                    } else {
                        int blockedPuntOrFg = Integer.parseInt(splitStatistics[0]);
                        int blockedPuntOrFgTd = Integer.parseInt(splitStatistics[1]);
                        int kickoffReturnTd = Integer.parseInt(splitStatistics[2]);
                        int puntReturnTd = Integer.parseInt(splitStatistics[3]);
                        //check if interceptions is negative (is not possible)
                        if (blockedPuntOrFg < 0) {
                            JOptionPane.showMessageDialog(null, "The amount of blocked punt/" +
                                            "FG cannot be negative", name + "'s Special Teams Statistics",
                                    JOptionPane.ERROR_MESSAGE);
                            enterStatistics = false;
                            //check if interception return TDs is negative (is not possible)
                        } else if (blockedPuntOrFgTd < 0) {
                            JOptionPane.showMessageDialog(null, "The amount of blocked punt/" +
                                    "FG return TDs cannot be negative", name + "'s Special Teams " +
                                    "Statistics", JOptionPane.ERROR_MESSAGE);
                            enterStatistics = false;
                            //check if fumbles recovered is negative (is not possible)
                        } else if (kickoffReturnTd < 0) {
                            JOptionPane.showMessageDialog(null, "The amount of kickoff " +
                                            "return TDs cannot be negative", name + "'s Special Teams Statistics",
                                    JOptionPane.ERROR_MESSAGE);
                            enterStatistics = false;
                            //check if fumble return TDs is negative (is not possible)
                        } else if (puntReturnTd < 0) {
                            JOptionPane.showMessageDialog(null, "The amount of punt return" +
                                            "TDs cannot be negative", name + "'s Special Teams Statistics",
                                    JOptionPane.ERROR_MESSAGE);
                            enterStatistics = false;
                            //can not have any interception return tds if no interceptions
                        } else if (blockedPuntOrFg == 0 && blockedPuntOrFgTd > 0) {
                            JOptionPane.showMessageDialog(null, "There cannot be any " +
                                    "blocked punt/FG return TDs if there are no blocked punt/FGs", name +
                                    "'s Special Teams Statistics", JOptionPane.ERROR_MESSAGE);
                            enterStatistics = false;
                            //can not have any fumble return tds if no interceptions
                        } else {
                            enterStatistics = true;
                        }
                    }
                }
            }
        } while (!enterStatistics);
        return specialTeamsStatistics;
    }

    public static String enterKickingStatisticsDialog(String name) {
        String kickingStatistics;
        boolean enterStatistics = false;
        do {
            kickingStatistics = JOptionPane.showInputDialog(null, "Enter " + name +
                            "'s number of made PAT's, made 1-39 yd FGs, made 40-49 yd FGs, made 50-59 yd FGs, made " +
                            "60+ yds FGs and missed FGs .\nThe format should be: PAT's,1-39 yd FGs,40-49 yd FGs," +
                            "50-59 yd FGs,60+ yds FGs,Missed FGs\nExample: 2 PATs, 1 1-39 yd FG, 2 40-" +
                            "49 yd FGs, 1 50-59 yd FG, 0 60+ yds FGs, 1 missed FG Attempt: Enter: 2,1,2,1,0,1",
                    name + "'s Kicking Statistics", JOptionPane.QUESTION_MESSAGE);
            if (kickingStatistics == null) {
                enterStatistics = true;
                quitProgram = 1;
            } else if (kickingStatistics.isBlank()) {
                JOptionPane.showMessageDialog(null, "Statistics cannot be empty!",
                        name + "'s Kicking Statistics", JOptionPane.ERROR_MESSAGE);
                enterStatistics = false;
            } else {
                //need the string to have only 6 integers
                String[] splitStatistics = kickingStatistics.split(",");
                if (splitStatistics.length != 6) {
                    JOptionPane.showMessageDialog(null, "Please enter statistics in the " +
                            "correct format", name + "'s Kicking Statistics", JOptionPane.ERROR_MESSAGE);
                    enterStatistics = false;
                } else {
                    //check if the input string has 6 integers (PAT and FG statistics)
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
                                "the correct format", name + "'s Kicking Statistics", JOptionPane.ERROR_MESSAGE);
                        enterStatistics = false;
                    } else {
                        //check if any of the numbers are negative (is not possible)
                        if (Integer.parseInt(splitStatistics[0]) < 0) {
                            JOptionPane.showMessageDialog(null, "The amount of made PATs " +
                                            "cannot be negative", name + "'s Kicking Statistics",
                                    JOptionPane.ERROR_MESSAGE);
                            enterStatistics = false;
                        } else if (Integer.parseInt(splitStatistics[1]) < 0) {
                            JOptionPane.showMessageDialog(null, "The amount of made 1-39 yd" +
                                            "FGs cannot be negative", name + "'s Kicking Statistics",
                                    JOptionPane.ERROR_MESSAGE);
                            enterStatistics = false;
                        } else if (Integer.parseInt(splitStatistics[2]) < 0) {
                            JOptionPane.showMessageDialog(null, "The amount of made 40-49 yd "
                                            + "FGss cannot be negative", name + "'s Kicking Statistics",
                                    JOptionPane.ERROR_MESSAGE);
                            enterStatistics = false;
                        } else if (Integer.parseInt(splitStatistics[3]) < 0) {
                            JOptionPane.showMessageDialog(null, "The amount of made 50-59 yd "
                                            + "FGs cannot be negative", name + "'s Kicking Statistics",
                                    JOptionPane.ERROR_MESSAGE);
                            enterStatistics = false;
                        } else if (Integer.parseInt(splitStatistics[4]) < 0) {
                            JOptionPane.showMessageDialog(null, "The amount of 60+ yd " +
                                            "FGs cannot be negative", name + "'s Kicking Statistics",
                                    JOptionPane.ERROR_MESSAGE);
                            enterStatistics = false;
                        } else if (Integer.parseInt(splitStatistics[5]) < 0) {
                            JOptionPane.showMessageDialog(null, "The amount of missed FGs " +
                                            "cannot be negative", name + "'s Kicking Statistics",
                                    JOptionPane.ERROR_MESSAGE);
                            enterStatistics = false;
                        } else {
                            enterStatistics = true;
                        }
                    }
                }
            }
        } while (!enterStatistics);
        return kickingStatistics;
    }

    //calculate the amount of fantasy points then set points to tne skill position player
    public static double calculateOnePointPprFantasyPoints(SkillPositionPlayer skillPositionPlayer) {
        double totalFantasyPoints = 0;
        totalFantasyPoints += (double) skillPositionPlayer.getPassingYards() * 0.04;
        totalFantasyPoints += (double) skillPositionPlayer.getPassingTouchdowns() * 4;
        totalFantasyPoints += (double) skillPositionPlayer.getRushingYards() * 0.1;
        totalFantasyPoints += (double) skillPositionPlayer.getRushingTouchdowns() * 6;
        totalFantasyPoints += (double) skillPositionPlayer.getReceptions() * 1;
        totalFantasyPoints += (double) skillPositionPlayer.getReceivingYards() * 0.1;
        totalFantasyPoints += (double) skillPositionPlayer.getReceivingTouchdowns() * 6;
        totalFantasyPoints += (double) skillPositionPlayer.getTwoPointConversions() * 2;
        totalFantasyPoints += (double) skillPositionPlayer.getInterceptions() * -2;
        totalFantasyPoints += (double) skillPositionPlayer.getFumblesLost() * -2;
        skillPositionPlayer.setPoints(totalFantasyPoints);
        return totalFantasyPoints;
    }

    //calculate the amount of fantasy points then set points to tne skill position player
    public static double calculateHalfPointPprFantasyPoints(SkillPositionPlayer skillPositionPlayer) {
        double totalFantasyPoints = 0;
        totalFantasyPoints += (double) skillPositionPlayer.getPassingYards() * 0.04;
        totalFantasyPoints += (double) skillPositionPlayer.getPassingTouchdowns() * 4;
        totalFantasyPoints += (double) skillPositionPlayer.getRushingYards() * 0.1;
        totalFantasyPoints += (double) skillPositionPlayer.getRushingTouchdowns() * 6;
        totalFantasyPoints += (double) skillPositionPlayer.getReceptions() * 0.5;
        totalFantasyPoints += (double) skillPositionPlayer.getReceivingYards() * 0.1;
        totalFantasyPoints += (double) skillPositionPlayer.getReceivingTouchdowns() * 6;
        totalFantasyPoints += (double) skillPositionPlayer.getTwoPointConversions() * 2;
        totalFantasyPoints += (double) skillPositionPlayer.getInterceptions() * -2;
        totalFantasyPoints += (double) skillPositionPlayer.getFumblesLost() * -2;
        skillPositionPlayer.setPoints(totalFantasyPoints);
        return totalFantasyPoints;
    }

    //calculate the amount of fantasy points then set points to tne skill position player
    public static double calculateStandardFantasyPoints(SkillPositionPlayer skillPositionPlayer) {
        double totalFantasyPoints = 0;
        totalFantasyPoints += (double) skillPositionPlayer.getPassingYards() * 0.04;
        totalFantasyPoints += (double) skillPositionPlayer.getPassingTouchdowns() * 4;
        totalFantasyPoints += (double) skillPositionPlayer.getRushingYards() * 0.1;
        totalFantasyPoints += (double) skillPositionPlayer.getRushingTouchdowns() * 6;
        totalFantasyPoints += (double) skillPositionPlayer.getReceivingYards() * 0.1;
        totalFantasyPoints += (double) skillPositionPlayer.getReceivingTouchdowns() * 6;
        totalFantasyPoints += (double) skillPositionPlayer.getTwoPointConversions() * 2;
        totalFantasyPoints += (double) skillPositionPlayer.getInterceptions() * -2;
        totalFantasyPoints += (double) skillPositionPlayer.getFumblesLost() * -2;
        skillPositionPlayer.setPoints(totalFantasyPoints);
        return totalFantasyPoints;
    }

    //calculate the amount of fantasy points then set the total points for defense and special teams
    public static double calculateDefenseAndSpecialTeamsFantasyPoints(DefenseAndSpecialTeams dAndSt) {
        double totalFantasyPoints = 0.0;
        int yardsAllowed = dAndSt.getYardsAllowed();
        double yardsAllowedFantasyPoints = 0.0;
        int pointsAllowed = dAndSt.getPointsAllowed();
        double pointsAllowedFantasyPoints = 0.0;
        //determine amount of fantasy points for yards allowed
        if (yardsAllowed < 100) {
            yardsAllowedFantasyPoints = 5;
        } else if (yardsAllowed < 200) {
            yardsAllowedFantasyPoints = 3;
        } else if (yardsAllowed < 300) {
            yardsAllowedFantasyPoints = 2;
        } else if (yardsAllowed < 350) {
            yardsAllowedFantasyPoints = 0;
        } else if (yardsAllowed < 400) {
            yardsAllowedFantasyPoints = -1;
        } else if (yardsAllowed < 450) {
            yardsAllowedFantasyPoints = -3;
        } else if (yardsAllowed < 500) {
            yardsAllowedFantasyPoints = -5;
        } else if (yardsAllowed < 550) {
            yardsAllowedFantasyPoints = -6;
        } else {
            yardsAllowedFantasyPoints = -7;
        }
        //determine amount of fantasy points for points allowed
        if (pointsAllowed == 0) {
            pointsAllowedFantasyPoints = 5;
        } else if (pointsAllowed < 7) {
            pointsAllowedFantasyPoints = 4;
        } else if (pointsAllowed < 14) {
            pointsAllowedFantasyPoints = 3;
        } else if (pointsAllowed < 18) {
            pointsAllowedFantasyPoints = 1;
        } else if (pointsAllowed < 28) {
            pointsAllowedFantasyPoints = -1;
        } else if (pointsAllowed < 35) {
            pointsAllowedFantasyPoints = -3;
        } else {
            pointsAllowedFantasyPoints = -5;
        }
        totalFantasyPoints += yardsAllowedFantasyPoints;
        totalFantasyPoints += pointsAllowedFantasyPoints;
        totalFantasyPoints += (double) dAndSt.getSacks() * 1;
        totalFantasyPoints += (double) dAndSt.getDefenseInterceptions() * 2;
        totalFantasyPoints += (double) dAndSt.getInterceptionReturnTd() * 6;
        totalFantasyPoints += (double) dAndSt.getDefenseFumblesRecovered() * 2;
        totalFantasyPoints += (double) dAndSt.getFumbleReturnTd() * 6;
        totalFantasyPoints += (double) dAndSt.getSafety() * 2;
        totalFantasyPoints += (double) dAndSt.getTwoPointReturn() * 2;
        totalFantasyPoints += (double) dAndSt.getBlockedPuntOrFg() * 2;
        totalFantasyPoints += (double) dAndSt.getBlockedPuntOrFgTd() * 6;
        totalFantasyPoints += (double) dAndSt.getKickoffReturnTd() * 6;
        totalFantasyPoints += (double) dAndSt.getPuntReturnTd() * 6;
        dAndSt.setPoints(totalFantasyPoints);
        return totalFantasyPoints;
    }

    //calculate the amount of fantasy points then set points to tne skill position player
    public static double calculateKickingFantasyPoints(Kicker kicker) {
        double totalFantasyPoints = 0;
        totalFantasyPoints += (double) kicker.getPatMade() * 1;
        totalFantasyPoints += (double) kicker.getFgUnder39Made() * 3;
        totalFantasyPoints += (double) kicker.getFg40Made() * 4;
        totalFantasyPoints += (double) kicker.getFg50Made() * 5;
        totalFantasyPoints += (double) kicker.getFg60Made() * 6;
        totalFantasyPoints += (double) kicker.getFgMissed() * -1;
        kicker.setPoints(totalFantasyPoints);
        return totalFantasyPoints;
    }

    public static String createScoreString(ArrayList <SkillPositionPlayer> skillPositionPlayers,
                                           DefenseAndSpecialTeams defenseAndSpecialTeams, Kicker kicker,
                                           double totalPoints) {
        StringBuilder scoreStringBuilder = new StringBuilder();
        for (int i = 0; i < skillPositionPlayers.size(); i++) {
            scoreStringBuilder.append(skillPositionPlayers.get(i).getPosition() + " - ");
            scoreStringBuilder.append(skillPositionPlayers.get(i).getName() + ": ");
            scoreStringBuilder.append(skillPositionPlayers.get(i).getPoints());
            scoreStringBuilder.append("\n");
        }
        scoreStringBuilder.append("Defense and Special Teams - " + defenseAndSpecialTeams.getName() + ": " +
                defenseAndSpecialTeams.getPoints());
        scoreStringBuilder.append("\n");
        scoreStringBuilder.append("Kicker - " + kicker.getName() + ": " + kicker.getPoints());
        scoreStringBuilder.append("\n");
        scoreStringBuilder.append("Total Points - " + Math.round(totalPoints * 100.0) / 100.0);
        return scoreStringBuilder.toString();
    }


}
