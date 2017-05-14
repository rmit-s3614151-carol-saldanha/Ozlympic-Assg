package rmit.java.assignment.database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import rmit.java.assignment.model.Game;

public class FileHandler {
	// File name
	private String participantList = "participants.txt";
	private ArrayList<String> participants = new ArrayList<String>();
	private final String SWIMMERS = "swimmers";
	private final String CYCLIST = "cyclist";
	private final String SPRINTERS = "sprinters";
	private final String SUPER = "super";

	public FileHandler() {

	}

	public void getParticipantList() {
		try {

			File f = new File(participantList);

			BufferedReader b = new BufferedReader(new FileReader(f.getAbsolutePath()));

			String readLine = "";
			int count = 0;

			while ((readLine = b.readLine()) != null) {
				if (readLine.length() > 0) {
					participants.add(readLine);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public ArrayList<String> getParticipants() {
		return this.participants;
	}

	public void writeFile(String string) {

		FileWriter writer = null;

		try {
			writer = new FileWriter("game.txt", true);

			writer.write(string.toString() + "\n");

			writer.close();// flushes the stream.

		} catch (IOException e) {
			System.err.println("File cannot be created, or cannot be opened");
			System.exit(0);
		}
	}

}
