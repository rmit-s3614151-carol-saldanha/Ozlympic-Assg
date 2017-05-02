package rmit.java.assignment.database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
				participants.add(readLine);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		int correctFormat = checkFormat();
		if (correctFormat == 4) {
			addAthletes();
		}

	}

	public ArrayList<String> getParticipants() {
		return this.participants;
	}

	public int checkFormat() {
		int comma = 0;
		for (int i = 0; i < getParticipants().size(); i++) {

			comma = getParticipants().get(i).length() - getParticipants().get(i).replace(",", "").length();
			if (comma == 4) {
				return comma;
			}
		}
		return comma;
	}

	public void addAthletes() {
		int len = 0;
		String ID = "";
		String type = "";
		String name = "";
		String age = "";
		String state = "";

		for (int i = 0; i < getParticipants().size(); i++) {

			getParticipants().set(i, getParticipants().get(i).replace(" ", ""));
			len = getParticipants().get(i).indexOf(",");
			ID = getParticipants().get(i).substring(0, len);
			getParticipants().set(i, getParticipants().get(i).replace(ID + ",", ""));

			getParticipants().set(i, getParticipants().get(i).replace(" ", ""));
			len = getParticipants().get(i).indexOf(",");
			type = getParticipants().get(i).substring(0, len);
			getParticipants().set(i, getParticipants().get(i).replace(type + ",", ""));

			getParticipants().set(i, getParticipants().get(i).replace(" ", ""));
			len = getParticipants().get(i).indexOf(",");
			name = getParticipants().get(i).substring(0, len);
			getParticipants().set(i, getParticipants().get(i).replace(name + ",", ""));

			getParticipants().set(i, getParticipants().get(i).replace(" ", ""));
			len = getParticipants().get(i).indexOf(",");
			age = getParticipants().get(i).substring(0, len);
			getParticipants().set(i, getParticipants().get(i).replace(age + ",", ""));

			getParticipants().set(i, getParticipants().get(i).replace(" ", ""));
			len = getParticipants().get(i).indexOf(",");
			state = getParticipants().get(i);
			getParticipants().set(i, getParticipants().get(i).replace(state + ",", ""));

			if (ID.equals("") || type.equals("") || name.equals("") || age.equals("") || state.equals("")) {
				System.out.println("Error: Incorrect Data");
			} else {
				switch (type) {
				case SWIMMERS:
						
					break;
				case CYCLIST:

					break;
				case SPRINTERS:

					break;
				case SUPER:

					break;
				default:
					break;
				}
			}

		}

	}
	

}
