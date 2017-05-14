package rmit.java.assignment.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import java.sql.Timestamp;

import rmit.java.assignment.database.FileHandler;
import rmit.java.assignment.database.ParticipantList;

/**
 *
 * Class Description: Class that represents all games in ozlympics.
 * 
 * @author: Eashan Tilve
 */

public class Game {

	private ArrayList<Integer> uniqueCyclingID = new ArrayList<Integer>();
	private ArrayList<Integer> uniqueRunningID = new ArrayList<Integer>();
	private ArrayList<Integer> uniqueSwimmingID = new ArrayList<Integer>();
	private ArrayList<Swimming> swimmingGames = new ArrayList<Swimming>();

	private ArrayList<Cycling> cyclingGames = new ArrayList<Cycling>();
	private ArrayList<Running> runningGames = new ArrayList<Running>();
	HashMap<Athlete, Float> swimmwerTimings = null;
	HashMap<Athlete, Float> cyclingTimings = null;
	HashMap<Athlete, Float> sprinterTimings = null;
	private String currentGame;
	private static final char CYCLING_ID = 'C';
	private static final char RUNNING_ID = 'R';
	private static final char SWIMMING_ID = 'S';
	private static final int OFFICIALS_COUNT = 8;
	
	


	/**
	 * CONSTRUCTOR
	 * 
	 * Adds starting elements in uniqueCyclingID, uniqueRunningID and
	 * uniqueSwimmingID
	 */
	public Game() {
		super();
		uniqueCyclingID.add(0);
		uniqueRunningID.add(0);
		uniqueSwimmingID.add(0);

	}

	public HashMap<Athlete, Float> getSwimmwerTimings() {
		return swimmwerTimings;
	}

	public void setSwimmwerTimings(HashMap<Athlete, Float> swimmwerTimings) {
		this.swimmwerTimings = swimmwerTimings;
	}

	/**
	 * This method is used to set the game that is currently selected
	 * 
	 * @param int
	 *            currentGame: contains either 1,2 or 3 for swimming, cycling or
	 *            runnning respectively.
	 */
	public void setCurrentGame(String currentGame) {
		this.currentGame = currentGame;
	}

	/**
	 * This method is used to get the game that is currently selected
	 * 
	 * @return int currentGame: contains either 1,2 or 3 for swimming, cycling
	 *         or runnning respectively.
	 */
	public String getCurrentGame() {
		return currentGame;
	}

	/**
	 * This method is used to get an array list of all swimming games selected
	 * 
	 * @return ArrayList<Swimming> swimmingGames
	 */
	public ArrayList<Swimming> getSwimmingGames() {
		return swimmingGames;
	}

	/**
	 * This method is used to get an array list of all cycling games selected
	 * 
	 * @return ArrayList<Cycling> cyclingGames
	 */
	public ArrayList<Cycling> getCyclingGames() {
		return cyclingGames;
	}

	/**
	 * This method is used to get an array list of all running games selected
	 * 
	 * @return ArrayList<Running> runningGames
	 */
	public ArrayList<Running> getRunningGames() {
		return runningGames;
	}

	/**
	 * This method is used to generate a unique ID for a new cycling game
	 * 
	 * @return String unique ID for a new cycling game
	 */
	private String generateUniqueCyclingID() {
		int maxUniqueID = Collections.max(uniqueCyclingID) + 1;
		uniqueCyclingID.add(maxUniqueID);
		return CYCLING_ID + Integer.toString(maxUniqueID);

	}

	/**
	 * This method is used to generate a unique ID for a new running game
	 * 
	 * @return String unique ID for a new running game
	 */
	private String generateUniqueRunningID() {
		int maxUniqueID = Collections.max(uniqueRunningID) + 1;
		uniqueRunningID.add(maxUniqueID);
		return RUNNING_ID + Integer.toString(maxUniqueID);

	}

	/**
	 * This method is used to generate a unique ID for a new swimming game
	 * 
	 * @return String unique ID for a new swimming game
	 */
	private String generateUniqueSwimmingID() {
		int maxUniqueID = Collections.max(uniqueSwimmingID) + 1;
		uniqueSwimmingID.add(maxUniqueID);
		return SWIMMING_ID + Integer.toString(maxUniqueID);

	}

	/**
	 * This method is used to print the participants of the game
	 * 
	 * @return int athleteCount number of athletes that are a part of the game
	 */
	public int showParticipants(ArrayList<Athlete> athletes) {
		int athleteCount = 0;
		for (Athlete athlete : athletes) {
			System.out.print(++athleteCount + ". ");
			System.out.println(athlete);
		}
		return athleteCount;
	}

	/**
	 * TIMESTAMP
	 */
	public Timestamp getTimeStamp() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		return timestamp;
	}

	/**
	 * This method is used to print the reults of swimming games
	 * 
	 */

	public ArrayList<Athlete> displaySwimmingResults() {
		FileHandler s = new FileHandler();
		ArrayList<Athlete> swimmers = null;

		ArrayList<String> swimmingResults = new ArrayList<String>();

		int athleteCount = 0;
		ArrayList<String> results = new ArrayList<String>();

		String sID = null;
		String oID = null;
		String aID = null;
		float times = 0;
		System.out.println("Swimming GAMES:");

		Swimming swimming = swimmingGames.get(swimmingGames.size() - 1);
		
		swimmers = swimming.getContestants();
		swimmwerTimings = swimming.getTimings();


		athleteCount = 0;

		// System.out.println("SWIMMING GAME " + swimming.getGameID());
		for (Athlete swimmer : swimmers) {
			// System.out.println(++athleteCount + ". " + swimmer + " Time:
			// " + timings.get(swimmer));
			swimmer.setATime(swimmwerTimings.get(swimmer));
			swimmingResults.add(++athleteCount + ". " + swimmer + " Time: " + swimmwerTimings.get(swimmer));
		}
		// System.out.println("REFREE: " + swimming.getOfficial());
		// System.out.println();

		sID = generateUniqueSwimmingID();
		swimming.setGameID(sID);
		System.out.println();
		System.out.println("SWIMMING GAME " + sID);
		oID = swimming.getOfficial().getUniqueID();
		System.out.println("REFREE: " + oID);

		s.writeFile(sID + "," + oID + "," + getTimeStamp() + "\n");

		for (Athlete swimmer : swimmers) {
			times = swimmwerTimings.get(swimmer);
			// System.out.println(++athleteCount + ". " + swimmers + " Time:
			// " + timings.get(swimmers));
			results.add(++athleteCount + ". " + swimmer + " Time: " + times);
			aID = swimmer.getUniqueID();
			s.writeFile(aID + "," + Float.toString(times) + "," + swimmer.getPoints());
		
		}

		s.writeFile("\n" + "\n");
		
		return swimmers;

	}

	/**
	 * This method is used to print the reults of running games
	 * 
	 * @return
	 * 
	 */
	public ArrayList<Athlete> displayRunningResults() {
		FileHandler s = new FileHandler();
		ArrayList<Athlete> sprinters = null;
		ArrayList<String> runningResults = new ArrayList<String>();
		
		int athleteCount = 0;
		String rID = null;
		String oID = null;
		float times = 0;
		String aID = null;

		System.out.println("RUNNING GAMES:");
		Running running = runningGames.get(runningGames.size() - 1);
		sprinters = running.getContestants();
		sprinterTimings = running.getTimings();
		athleteCount = 0;

		rID = generateUniqueRunningID();
		oID = running.getOfficial().getUniqueID();
		System.out.println("REFREE: " + oID);

		s.writeFile(rID + "," + oID + "," + getTimeStamp() + "\n");

		System.out.println("RUNNING GAME ID " + running.getGameID());
		for (Athlete sprinter : sprinters) {
			sprinter.setATime(sprinterTimings.get(sprinter));
			// System.out.println(++athleteCount + ". " + sprinter + " Time:
			// " + timings.get(sprinter));
			times = sprinterTimings.get(sprinter);
			aID = sprinter.getUniqueID();
			s.writeFile(aID + "," + Float.toString(times) + "," + sprinter.getPoints());
			runningResults.add(++athleteCount + ". " + sprinter + " Time: " + sprinterTimings.get(sprinter));

			System.out.println("REFREE: " + running.getOfficial());
			System.out.println();

		}
		s.writeFile("\n" + "\n");

		return sprinters;
	}

	/**
	 * This method is used to print the reults of cycling games
	 * 
	 * @return
	 * 
	 */
	public ArrayList<Athlete> displayCyclingResults() {
		FileHandler s = new FileHandler();
		ArrayList<Athlete> cyclists = null;
		ArrayList<String> cyclingResults = new ArrayList<String>();
		
		int athleteCount = 0;
		String cID = null;
		String oID = null;
		float times = 0;
		String aID = null;

		System.out.println("CYCLING GAMES:");
		Cycling cycling = cyclingGames.get(cyclingGames.size() - 1);

		cyclists = cycling.getContestants();
		cyclingTimings = cycling.getTimings();
		athleteCount = 0;
		cID = generateUniqueCyclingID();
		
		System.out.println();
		System.out.println("Cycling GAME " + cID);
		oID = cycling.getOfficial().getUniqueID();
		System.out.println("REFREE: " + oID);

		s.writeFile(cID + "," + oID + "," + getTimeStamp() + "\n");

		for (Athlete cyclist : cyclists) {
			// System.out.println(++athleteCount + ". " + cyclist + " Time:
			// " + timings.get(cyclist));
			cyclist.setATime(cyclingTimings.get(cyclist));
			times = cyclingTimings.get(cyclist);
			aID = cyclist.getUniqueID();
			s.writeFile(aID + "," + Float.toString(times) + "," + cyclist.getPoints());
			cyclingResults.add(++athleteCount + ". " + cyclist + " Time: " + cyclingTimings.get(cyclist));
		}
		System.out.println("REFREE: " + cycling.getOfficial());
		System.out.println();

		s.writeFile("\n" + "\n");
		
		return cyclists;
	}

	/**
	 * This method is used to get an official randomly from the participant
	 * list.
	 * 
	 * @param ParticipantList
	 *            participantList
	 * @return Official official
	 */
	public Official assignOfficial(ParticipantList participantList) {
		int random = (int) (Math.random() * OFFICIALS_COUNT);

		return participantList.getOfficials().get(random);
	}



	

}
