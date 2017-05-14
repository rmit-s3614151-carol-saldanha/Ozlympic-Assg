package rmit.java.assignment.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import rmit.java.assignment.database.FileHandler;
import rmit.java.assignment.database.ParticipantList;
import rmit.java.assignment.database.SQLConnection;

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
	private SQLConnection con = new SQLConnection();
	private Connection connection = null;

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

		FileHandler set = new FileHandler();
		ArrayList<Athlete> swimmers = null;
		ArrayList<String> results = new ArrayList<String>();
		String sID = null;
		String oID = null;
		String aID = null;
		float times = 0;
		String insertResult = null;
		PreparedStatement stm = null;

		Swimming swimming = swimmingGames.get(swimmingGames.size() - 1);

		swimmers = swimming.getContestants();
		swimmwerTimings = swimming.getTimings();

		sID = generateUniqueSwimmingID();
		oID = swimming.getOfficial().getUniqueID();

		for (Athlete swimmer : swimmers)
			swimmer.setATime(swimmwerTimings.get(swimmer));

		swimming.setGameID(sID);
		set.writeFile(sID + "," + oID + "," + getTimeStamp() + "\n");

		try {

			connection = con.createConnection();

			for (Athlete swimmer : swimmers) {

				connection.setAutoCommit(false);

				times = swimmwerTimings.get(swimmer);
				aID = swimmer.getUniqueID();

				insertResult = "INSERT INTO results VALUES ('" + sID + "','" + oID + "','" + aID + "','"
						+ Float.toString(times) + "','" + swimmer.getPoints() + "');";

				stm = connection.prepareStatement(insertResult);
				stm.executeUpdate();

				set.writeFile(aID + "," + Float.toString(times) + "," + swimmer.getPoints());

			}
			connection.commit();

			set.writeFile("\n" + "\n");
		} catch (SQLException e) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException excep) {
				}
			}
			// e.printStackTrace();
		} finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {

					connection.setAutoCommit(true);
					connection.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		}

		return swimmers;
	}

	/**
	 * This method is used to print the reults of running games
	 * 
	 * @return
	 * 
	 */
	public ArrayList<Athlete> displayRunningResults() {

		FileHandler set = new FileHandler();
		ArrayList<Athlete> sprinters = null;

		String rID = null;
		String oID = null;
		float times = 0;
		String aID = null;
		String insertResult = null;
		PreparedStatement stm = null;

		Running running = runningGames.get(runningGames.size() - 1);

		sprinters = running.getContestants();
		sprinterTimings = running.getTimings();

		rID = generateUniqueRunningID();
		oID = running.getOfficial().getUniqueID();
		running.setGameID(rID);

		set.writeFile(rID + "," + oID + "," + getTimeStamp() + "\n");

		try {
			connection = con.createConnection();

			for (Athlete sprinter : sprinters) {

				connection.setAutoCommit(false);

				sprinter.setATime(sprinterTimings.get(sprinter));
				times = sprinterTimings.get(sprinter);
				aID = sprinter.getUniqueID();

				set.writeFile(aID + "," + Float.toString(times) + "," + sprinter.getPoints());

				insertResult = "INSERT INTO results VALUES ('" + rID + "','" + oID + "','" + aID + "','"
						+ Float.toString(times) + "','" + sprinter.getPoints() + "');";

				stm = connection.prepareStatement(insertResult);
				stm.executeUpdate();

			}
			connection.commit();

			set.writeFile("\n" + "\n");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException exception) {
					System.out.println("Error : please contact admin");
				}
			}
			// e.printStackTrace();
		} finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.setAutoCommit(true);
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		return sprinters;
	}

	/**
	 * This method is used to print the reults of cycling games
	 * 
	 * @return
	 * 
	 */
	public ArrayList<Athlete> displayCyclingResults() {

		FileHandler set = new FileHandler();
		ArrayList<Athlete> cyclists = null;

		String cID = null;
		String oID = null;
		float times = 0;
		String aID = null;
		String insertResult = null;
		PreparedStatement stm = null;

		Cycling cycling = cyclingGames.get(cyclingGames.size() - 1);

		cyclists = cycling.getContestants();
		cyclingTimings = cycling.getTimings();

		cID = generateUniqueCyclingID();
		cycling.setGameID(cID);
		oID = cycling.getOfficial().getUniqueID();

		set.writeFile(cID + "," + oID + "," + getTimeStamp() + "\n");

		try {
			connection = con.createConnection();

			for (Athlete cyclist : cyclists) {

				connection.setAutoCommit(false);
				cyclist.setATime(cyclingTimings.get(cyclist));
				times = cyclingTimings.get(cyclist);
				aID = cyclist.getUniqueID();

				set.writeFile(aID + "," + Float.toString(times) + "," + cyclist.getPoints());
				insertResult = "INSERT INTO results VALUES ('" + cID + "','" + oID + "','" + aID + "','"
						+ Float.toString(times) + "','" + cyclist.getPoints() + "');";

				stm = connection.prepareStatement(insertResult);
				stm.executeUpdate();

			}

			connection.commit();

			set.writeFile("\n" + "\n");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException excep) {
				}
			}
			e.printStackTrace();
		} finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.setAutoCommit(true);
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}

		set.writeFile("\n" + "\n");

		return cyclists;
	}

}
