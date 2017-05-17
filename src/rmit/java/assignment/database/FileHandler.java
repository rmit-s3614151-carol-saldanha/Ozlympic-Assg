package rmit.java.assignment.database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 * @author Carol Benita Saldanha
 * @version 1.0
 * @classDescription File Handler has read and write functions. It loads the
 *                   data from file into array objects an writes to file.
 *
 */
public class FileHandler {

	// File name
	private String participantList = "participants.txt";

	// Instance variables
	private ArrayList<String> participants = new ArrayList<String>();
	private ArrayList<String> games = new ArrayList<String>();
	private final String SWIMMERS = "swimmers";
	private final String CYCLIST = "cyclist";
	private final String SPRINTERS = "sprinters";
	private final String SUPER = "super";

	// Empty constructor
	public FileHandler() {
		

	}

	/**
	 * 
	 * @throws IOException
	 *             getsParticipantList from the file and stores into ArrayList
	 *             of strings
	 */
	public void getParticipantList() throws IOException {

		File f = new File(participantList);

		BufferedReader b = new BufferedReader(new FileReader(f.getAbsolutePath()));

		String readLine = "";

		while ((readLine = b.readLine()) != null) {
			if (readLine.length() > 0) {
				participants.add(readLine);
			}
		}
	}

	// Getter for list
	public ArrayList<String> getParticipants() {
		return this.participants;
	}

	/**
	 * 
	 * @param string
	 *            It writes game data on file.
	 */
	public void writeFile(String string) {

		FileWriter writer = null;

		try {
			writer = new FileWriter("game.txt", true);

			writer.write(string.toString() + "\n");
			System.out.println(writer);

			writer.close();// flushes the stream.

		} catch (IOException e) {
			System.err.println("File cannot be created, or cannot be opened");
			System.exit(0);
		}
	}

	/**
	 * Gets all the games played into an array list.
	 * 
	 * @throws IOException
	 */
	public void getPlayedGames() throws IOException {

		File f = new File("game.txt");

		BufferedReader b = new BufferedReader(new FileReader(f.getAbsolutePath()));

		String readLine = "";

		while ((readLine = b.readLine()) != null) {
			if (readLine.length() > 0) {
				games.add(readLine);
				System.out.println(readLine);
			}
		}

	}

	// Getter for games
	public ArrayList<String> getGames() {
		return this.games;
	}
	
	public void createFile() {
		System.out.println("Called");
		try {
			FileWriter writer = new FileWriter("game.txt");
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
