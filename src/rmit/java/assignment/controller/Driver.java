package rmit.java.assignment.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import rmit.java.assignment.database.ParticipantList;
import rmit.java.assignment.model.Athlete;
import rmit.java.assignment.model.Cycling;
import rmit.java.assignment.model.Game;
import rmit.java.assignment.model.Official;
import rmit.java.assignment.model.Running;
import rmit.java.assignment.model.Swimming;

/**
 *
 * Class Description: The driver class is where user interaction occurs, and it
 * uses other classes to manage the games.
 * 
 * @author : Carol Benita Saldanha
 */

public class Driver {

	private Game game;

	private Scanner scanInput = new Scanner(System.in);
	private ParticipantList participantList;
	
	public ParticipantList getParticipantList() {
		return participantList;
	}

	public void setParticipantList(ParticipantList participantList) {
		this.participantList = participantList;
	}

	private static final int OPTION_1 = 1;
	private static final int OPTION_2 = 2;
	private static final int OPTION_3 = 3;
	private static final int OPTION_4 = 4;
	private static final int OPTION_5 = 5;
	private static final int OPTION_6 = 6;

	public static final String SWIMMING = "SWIMMING";
	public static final String CYCLING = "CYCLING";
	public static final String RUNNING = "RUNNING";

	/**
	 * CONSTRUCTOR
	 * 
	 * intializes participantList, game
	 */
	public Driver() {
		participantList = new ParticipantList();
		game = new Game();
	}

	/**
	 * This method is used to display the options of the Game to the user
	 */


	/**
	 * This method is used to display the three games to the user
	 */


	/**
	 * This method is used to start the Ozlympics and gives six options to the
	 * user. 1) Select Game 2) Predict Winner 3) Start Game 4) Display Results
	 * 5) Display Points 6) Exit
	 *
	 * If the user enters any other input an Invalid Choice is displayed.
	 */
	

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	/**
	 * This method is used to display points of all the athletes in Ozlympics
	 */
	private void displayPoints() {

		HashMap<Athlete, Integer> pointsTable = new HashMap<Athlete, Integer>();

		for (Athlete swimmer : participantList.getSwimmers()) {
			pointsTable.put(swimmer, swimmer.getPoints());
		}
		for (Athlete cyclist : participantList.getCyclists()) {
			pointsTable.put(cyclist, cyclist.getPoints());
		}
		for (Athlete sprinter : participantList.getSprinters()) {
			pointsTable.put(sprinter, sprinter.getPoints());
		}
		for (Athlete superAthlete : participantList.getSuperAthletes()) {
			pointsTable.put(superAthlete, superAthlete.getPoints());
		}

		int maxPoints;
		int athleteCount = 0;
		Athlete nextAthlete = null;

		while (!pointsTable.isEmpty()) {
			maxPoints = 0;
			for (Athlete athlete : pointsTable.keySet()) {
				if (pointsTable.get(athlete) >= maxPoints) {
					maxPoints = pointsTable.get(athlete);
					nextAthlete = athlete;
				}
			}

			System.out.println(++athleteCount + ". " + nextAthlete + " Points: " + pointsTable.get(nextAthlete));

			pointsTable.remove(nextAthlete);
		}

	}

	/**
	 * This method is used to display the results of all games in Ozlympics.
	 */
	public void displayResults() {
		game.displaySwimmingResults();
		System.out.println();
//		game.displayCyclingResults();
//		System.out.println();
//		game.displayRunningResults();

	}

	/**
	 * This method is used to start the current game, record the time taken by
	 * the Athletes and compare the results of the game with the user
	 * prediction. The user Prediction is set to null after this method.
	 */
	public void startGame() {
		ArrayList<Athlete> athletes = null;
		Official official;
		switch (game.getCurrentGame()) {
		case SWIMMING:
			Swimming swimming = getLastSwimmingGame();
			athletes = swimming.getContestants();
			for (Athlete athlete : athletes) {
				swimming.recordAthleteTime(athlete.compete(), athlete);
			}
			
			official = swimming.getOfficial();
			swimming.setContestants( official.computeWinners(swimming.getTimings()));
//			if (swimming.getUserPredictedWinner() != null) {
//				if (swimming.getUserPredictedWinner().getUniqueID() == swimming.getContestants().get(0).getUniqueID()) {
//					System.out.println("CONGRADULATIONS! YOUR PREDICTION WAS CORRECT!");
//				}
//			}
//			swimming.setUserPredictedWinner(null);
			break;
//		case CYCLING:
//			Cycling cycling = getLastCyclingGame();
//			athletes = cycling.getContestants();
//			for (Athlete athlete : athletes) {
//				cycling.recordAthleteTime(athlete.compete(), athlete);
//			}
//			official = cycling.getOfficial();
//			cycling.setContestants(official.computeWinners(cycling.getTimings()));
////			if (cycling.getUserPredictedWinner() != null) {
////				if (cycling.getUserPredictedWinner().getUniqueID() == cycling.getContestants().get(0).getUniqueID()) {
////					System.out.println("CONGRADULATIONS! YOUR PREDICTION WAS CORRECT!");
////				}
////			}
////			cycling.setUserPredictedWinner(null);
//			break;
//		case RUNNING:
//			Running running = getLastRunningGame();
//			athletes = running.getContestants();
//			for (Athlete athlete : athletes) {
//				running.recordAthleteTime(athlete.compete(), athlete);
//			}
//			official = running.getOfficial();
//			running.setContestants(official.computeWinners(running.getTimings()));
////			if (running.getUserPredictedWinner() != null) {
////				if (running.getUserPredictedWinner().getUniqueID() == running.getContestants().get(0).getUniqueID()) {
////					System.out.println("CONGRADULATIONS! YOUR PREDICTION WAS CORRECT!");
////				}
////			}
////			running.setUserPredictedWinner(null);
////			break;
		default: System.out.println("Please, select a game first.");
			;
		}

	}

	/**
	 * This method displays the Athlete information to the user and asks him to
	 * predict the winner
	 **/

	/**
	 * This method returns the last running game selected
	 * 
	 * @return Running
	 */
	private Running getLastRunningGame() {
		try {
			ArrayList<Running> runningGames = game.getRunningGames();
			return runningGames.get(runningGames.size() - 1);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	/**
	 * This method returns the last cycling game selected
	 * 
	 * @return Cycling
	 */
	private Cycling getLastCyclingGame() {
		try {
			ArrayList<Cycling> cyclingGames = game.getCyclingGames();
			return cyclingGames.get(cyclingGames.size() - 1);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	/**
	 * This method returns the last swimming game selected
	 * 
	 * @return Swimming
	 */
	private Swimming getLastSwimmingGame() {
		try {
			ArrayList<Swimming> swimmingGames = game.getSwimmingGames();
			return swimmingGames.get(swimmingGames.size() - 1);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	/**
	 * This method allows the user to select a game It creates a new game and
	 * initializes the games parameters depending on the user input
	 * 
	 */
	
}
