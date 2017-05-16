package application;

// imports 
import java.net.URL;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Alert.AlertType;
import rmit.java.assignment.controller.Driver;
import rmit.java.assignment.database.ParticipantList;
import rmit.java.assignment.model.Game;
import rmit.java.assignment.model.Swimming;
import rmit.java.assignment.model.SuperAthlete;

/**
 * 
 * @author Niraj Bohra
 * @version 1.0
 * @ClassDescrption Swimming Controller is a class that controls all data
 *                  manipulation on Cycling.fxml
 * 
 *
 */
public class SwimmingController implements Initializable {

	// Defined constants values
	private static final int MAXIMUM_PARTICIPANTS = 8;

	private static final int MINIMUM_PARTICIPANTS = 4;

	private static final String TYPE_1 = "Swimmers";

	private static final String TYPE_2 = "Super Athletes";

	// Private instance variables for the FXML files.

	@FXML
	private ListView<String> selectedParticipants;

	@FXML
	private Button left;

	@FXML
	private Button right;

	@FXML
	private ListView<String> addParticipants;

	@FXML
	private JFXButton Next;

	@FXML
	private JFXButton back;

	@FXML
	private JFXDialog except;

	// Instance variables

	private String selectedAddParticipantList = "";

	private String selectedParticipantList = "";

	// For Athletes
	public static final ObservableList<String> athletes = FXCollections.observableArrayList();

	// Call Objects

	Driver driver = Ozlympic.driver;
	ParticipantList get = driver.getParticipantList();
	Game get1 = driver.getGame();
	Swimming swimming = new Swimming();

	/**
	 * 
	 * @param event
	 * @return void addParticipants(event) is a function that adds events from
	 *         list of selected participants
	 * 
	 */
	@FXML
	void addParticipants(ActionEvent event) {

		addParticipants.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

	}

	/**
	 * 
	 * @param event
	 * @throws Exception
	 * @return void
	 * 
	 *         back( event) is an event that helps the user get back to home
	 *         screen.
	 */
	@FXML
	void back(ActionEvent event) throws Exception {

		Utility utility = new Utility();
		utility.displayUX(OzlympicController.class, "application/Ozlympic.fxml", null);

	}

	/**
	 * 
	 * @param event
	 * @throws Exception
	 * @return void
	 * 
	 *         nextPage(event) is used to check for exception and if not found
	 *         then the user can proceed with his game.
	 */
	@FXML
	void nextPage(ActionEvent event) throws Exception {
		if (selectedParticipants.getItems().size() < MINIMUM_PARTICIPANTS) {
			try {
				throw new TooFewAthleteException();
			} catch (TooFewAthleteException e) {
				// Throw Too Few Athlete exception in Dialog box
				System.out.println(e.getMessage());
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Message");
				alert.setHeaderText("Error: To Few Athlete Exception ");
				alert.setContentText(e.getMessage());
				alert.showAndWait();

			}
		} else {

			// Select Participants
			swimming.setCurrentGame(Driver.SWIMMING);

			for (int i = 0; i < get.getSwimmers().size(); i++) {
				for (int j = 0; j < selectedParticipants.getItems().size(); j++) {
					String item = selectedParticipants.getItems().get(j);
					if (get.getSwimmers().get(i).getUniqueID()
							.equals(item.substring(item.indexOf("ID=") + 3, item.indexOf("ID=") + 9))) {

						swimming.addContestant(get.getSwimmers().get(i));
					}

				}

			}

			for (int i = 0; i < get.getSuperAthletes().size(); i++) {
				for (int j = 0; j < selectedParticipants.getItems().size(); j++) {
					String item = selectedParticipants.getItems().get(j);
					if (get.getSuperAthletes().get(i).getUniqueID()
							.equals(item.substring(item.indexOf("ID=") + 3, item.indexOf("ID=") + 9))) {
						((SuperAthlete) (get.getSuperAthletes().get(i))).setCurrentGame(Driver.SWIMMING);
						swimming.addContestant(get.getSuperAthletes().get(i));
					}

				}

			}

			get1.getSwimmingGames().add(swimming);
			Ozlympic.driver.getGame().setCurrentGame(Driver.SWIMMING);
			Utility utility = new Utility();
			utility.displayUX(RefereeController.class, "application/Referee.fxml", null);
		}

	}

	public void initialize(URL url, ResourceBundle rb) {
		System.out.println("initializing ");
		addParticipants.getItems().clear();
		athletes.clear();
		selectedParticipants.getItems().clear();
		System.out.println(addParticipants.getItems().size());
		for (int i = 0; i < get.getSwimmers().size(); i++) {
			athletes.add(get.getSwimmers().get(i).toString());
		}
		for (int i = 0; i < get.getCyclists().size(); i++) {
			athletes.add(get.getCyclists().get(i).toString());
		}
		for (int i = 0; i < get.getSprinters().size(); i++) {
			athletes.add(get.getSprinters().get(i).toString());
		}
		for (int i = 0; i < get.getSuperAthletes().size(); i++) {
			athletes.add(get.getSuperAthletes().get(i).toString());
		}

		addParticipants.setItems(athletes);

		// When top and bottom buttons are clicked

		right.setOnAction((ActionEvent event) -> {

			addParticipants.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
			if (addParticipants.getSelectionModel().getSelectedItem() != null)

				selectedAddParticipantList = addParticipants.getSelectionModel().getSelectedItem();
			if (selectedAddParticipantList.equals("")) {
				// Do nothing
			} else {
				boolean isValid = false;
				String type = "";
				while (!isValid) {
					if (selectedParticipants.getItems().size() + 1 <= MAXIMUM_PARTICIPANTS) {

						addParticipants.getSelectionModel().clearSelection();

						type = selectedAddParticipantList.substring(selectedAddParticipantList.indexOf("type=") + 5,
								selectedAddParticipantList.length());

						if (!type.equals(TYPE_1) && !type.equals(TYPE_2)) {
							try {
								throw new WrongTypeException();
							} catch (WrongTypeException e) {

								// Throw Dialog box
								Alert alert = new Alert(AlertType.ERROR);
								alert.setTitle("Error Message");
								alert.setHeaderText("Error : Wrong Type Exception");
								alert.setContentText(e.getMessage());
								alert.showAndWait();
							}

						} else {

							addParticipants.getItems().remove(selectedAddParticipantList);
							if (selectedParticipants.getItems().contains(selectedAddParticipantList)) {
								// Do nothing
							} else {
								selectedParticipants.getItems().addAll(selectedAddParticipantList);

							}
						}
					}
					isValid = true;

				}

				if (selectedParticipants.getItems().size() == MAXIMUM_PARTICIPANTS) {

					try {
						throw new GameFullException();
					} catch (GameFullException e) {
						// Throw Dialog box
						Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("Error Message");
						alert.setHeaderText("Error : Game Full Exception");
						alert.setContentText(e.getMessage());
						alert.showAndWait();

					}
					isValid = true;

				}
			}

		});

		left.setOnAction((ActionEvent event) -> {
			selectedParticipants.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
			if (selectedParticipants.getSelectionModel().getSelectedItem() != null)

				selectedParticipantList = selectedParticipants.getSelectionModel().getSelectedItem();
			if (selectedParticipantList.equals("")) {
				// Do nothing
			} else {
				boolean isValid = false;
				while (!isValid) {

					if (selectedParticipants.getSelectionModel().getSelectedItem() != null) {
						System.out.println(selectedParticipantList);
						selectedParticipants.getItems().remove(selectedParticipantList);
					}
					if (addParticipants.getItems().contains(selectedParticipantList)) {
						// Do nothing
					} else {
						addParticipants.getItems().addAll(selectedParticipantList);

					}
					isValid = true;
				}

			}

		});

	}

}
