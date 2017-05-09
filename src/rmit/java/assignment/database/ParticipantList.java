package rmit.java.assignment.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import rmit.java.assignment.model.Athlete;
import rmit.java.assignment.model.Cyclist;
import rmit.java.assignment.model.Official;
import rmit.java.assignment.model.Sprinter;
import rmit.java.assignment.model.SuperAthlete;
import rmit.java.assignment.model.Swimmer;

/**
 *
 * Class Description: Database Class that contains data of all the participants
 * 
 * @author : Carol Benita Saldanha
 */
public class ParticipantList {

	private ArrayList<Athlete> swimmers = new ArrayList<Athlete>();
	private ArrayList<Athlete> sprinters = new ArrayList<Athlete>();
	private ArrayList<Athlete> cyclists = new ArrayList<Athlete>();
	private ArrayList<Athlete> superAthletes = new ArrayList<Athlete>();
	private ArrayList<Official> officials = new ArrayList<Official>();
	private ArrayList<Integer> uniqueIDList = new ArrayList<Integer>();
	private final String SWIMMERS = "swimmers";
	private final String CYCLIST = "cyclists";
	private final String SPRINTERS = "sprinters";
	private final String SUPER = "super";
	private String id = "";
	FileHandler getFile = new FileHandler();
	SQLConnection connect = new SQLConnection();

	/**
	 * This method is used to generates unique ID
	 * 
	 * @return int returns the ID of the participants
	 */
	public void setUniqueID(String id) {
		this.id = id;
	}

	public String getUniqueID() {
		return id;
	}

	/**
	 * This method is used to get all the swimmers that will be taking part in
	 * Ozlympics
	 * 
	 * @return ArrayList<Athlete> swimmer returns all the swimmers taking part
	 *         in Ozlympics
	 */
	public ArrayList<Athlete> getSwimmers() {
		return swimmers;
	}

	/**
	 * This method is used to get all the sprinters that will be taking part in
	 * Ozlympics
	 * 
	 * @return ArrayList<Athlete> sprinters returns all the sprinters taking
	 *         part in Ozlympics
	 */
	public ArrayList<Athlete> getSprinters() {
		return sprinters;
	}

	/**
	 * This method is used to get all the cyclists that will be taking part in
	 * Ozlympics
	 * 
	 * @return ArrayList<Athlete> cyclists returns all the cyclists taking part
	 *         in Ozlympics
	 */
	public ArrayList<Athlete> getCyclists() {
		return cyclists;
	}

	/**
	 * This method is used to get all the superAthletes that will be taking part
	 * in Ozlympics
	 * 
	 * @return ArrayList<Athlete> superAthletes returns all the superAthletes
	 *         taking part in Ozlympics
	 */
	public ArrayList<Athlete> getSuperAthletes() {
		return superAthletes;
	}

	/**
	 * This method is used to get all the officials that will be taking part in
	 * Ozlympics
	 * 
	 * @return ArrayList<Athlete> officials returns all the officials taking
	 *         part in Ozlympics
	 */
	public ArrayList<Official> getOfficials() {
		return officials;
	}

	/**
	 * CONSTRUCTOR
	 * 
	 * creates the database of all participants
	 * 
	 */
	public ParticipantList() {

		try {
			if (connect.createConnection() == true) {
				System.out.println("handle database connection");
				
				
			
					
				 
			} else {
				getFile.getParticipantList();
				int checkFormat = checkFormat();

				if (checkFormat == 4) {

					addAthletes();
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int checkFormat() {
		int comma = 0;
		for (int i = 0; i < getFile.getParticipants().size(); i++) {

			comma = getFile.getParticipants().get(i).length()
					- getFile.getParticipants().get(i).replace(",", "").length();
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

		for (int i = 0; i < getFile.getParticipants().size(); i++) {

			getFile.getParticipants().set(i, getFile.getParticipants().get(i).replace(" ", ""));
			len = getFile.getParticipants().get(i).indexOf(",");
			ID = getFile.getParticipants().get(i).substring(0, len);
			getFile.getParticipants().set(i, getFile.getParticipants().get(i).replace(ID + ",", ""));

			getFile.getParticipants().set(i, getFile.getParticipants().get(i).replace(" ", ""));
			len = getFile.getParticipants().get(i).indexOf(",");
			type = getFile.getParticipants().get(i).substring(0, len);
			getFile.getParticipants().set(i, getFile.getParticipants().get(i).replace(type + ",", ""));

			getFile.getParticipants().set(i, getFile.getParticipants().get(i).replace(" ", ""));
			len = getFile.getParticipants().get(i).indexOf(",");
			name = getFile.getParticipants().get(i).substring(0, len);
			getFile.getParticipants().set(i, getFile.getParticipants().get(i).replace(name + ",", ""));

			getFile.getParticipants().set(i, getFile.getParticipants().get(i).replace(" ", ""));
			len = getFile.getParticipants().get(i).indexOf(",");
			age = getFile.getParticipants().get(i).substring(0, len);
			getFile.getParticipants().set(i, getFile.getParticipants().get(i).replace(age + ",", ""));

			getFile.getParticipants().set(i, getFile.getParticipants().get(i).replace(" ", ""));
			len = getFile.getParticipants().get(i).indexOf(",");
			state = getFile.getParticipants().get(i);
			getFile.getParticipants().set(i, getFile.getParticipants().get(i).replace(state + ",", ""));

			if (ID.equals("") || type.equals("") || name.equals("") || age.equals("") || state.equals("")) {
				System.out.println("Error: Incorrect Data");
			} else {
				setUniqueID(ID);
				switch (type) {
				case SWIMMERS:

					for (int j = 0; j < getSwimmers().size(); j++) {

						if (getSwimmers().get(j).getUniqueID().contains(ID) == true) {

							getSwimmers().remove(j);

						}
					}
					getSwimmers().add(new Swimmer(name, age, state, ID));
					break;
				case CYCLIST:

					for (int j = 0; j < getCyclists().size(); j++) {

						if (getCyclists().get(j).getUniqueID().contains(ID) == true) {

							getCyclists().remove(j);

						}
					}
					getCyclists().add(new Cyclist(name, age, state, ID));
					break;
				case SPRINTERS:

					for (int j = 0; j < getSprinters().size(); j++) {

						if (getSprinters().get(j).getUniqueID().contains(ID) == true) {

							getSprinters().remove(j);

						}
					}
					getSprinters().add(new Sprinter(name, age, state, ID));
					break;
				case SUPER:
					for (int j = 0; j < getSuperAthletes().size(); j++) {

						if (getSuperAthletes().get(j).getUniqueID().contains(ID) == true) {

							getSuperAthletes().remove(j);

						}
					}
					getSuperAthletes().add(new SuperAthlete(name, age, state, ID));
					break;
				default:
					for (int j = 0; j < getOfficials().size(); j++) {

						if (getOfficials().get(j).getUniqueID().contains(ID) == true) {

							getOfficials().remove(j);

						}
					}
					getOfficials().add(new Official(name, age, state, ID));
					break;
				}
			}

		}

	}
}
