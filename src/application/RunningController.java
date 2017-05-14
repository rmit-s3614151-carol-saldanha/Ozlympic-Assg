package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import rmit.java.assignment.controller.Driver;
import rmit.java.assignment.database.ParticipantList;
import rmit.java.assignment.model.Game;
import rmit.java.assignment.model.Running;
import rmit.java.assignment.model.SuperAthlete;

public class RunningController implements Initializable {

	@FXML
	private ListView<String> selectedParticipants;

	@FXML
	private Button left;

	@FXML
	private Button right;

	@FXML
	private Label exception;

	@FXML
	private ListView<String> addParticipants;

	@FXML
	private Button Next;

	private static final String TYPE_1 = "Sprinters";

	private static final String TYPE_2 = "Super Athletes";

	private static final int MAXIMUM_PARTICIPANTS = 8;

	private static final int MINIMUM_PARTICIPANTS = 4;

	private String selectedAddParticipantList = "";

	private String selectedParticipantList = "";

	// For Athletes
	public static final ObservableList<String> athletes = FXCollections.observableArrayList();

	// For Officials
	public static final ObservableList<String> officials = FXCollections.observableArrayList();

	// For Playing 8
	public static final ObservableList<String> playerList = FXCollections.observableArrayList();

	public static final ObservableList<String> selected = FXCollections.observableArrayList();

	Driver driver = Ozlympic.driver;
	ParticipantList get = driver.getParticipantList();

	Game get1 = driver.getGame();

	Running running = new Running();

	@FXML
	void addParticipants(ActionEvent event) {

		addParticipants.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

	}

	@FXML
	void nextPage(ActionEvent event) throws Exception {
		if (selectedParticipants.getItems().size() < MINIMUM_PARTICIPANTS) {
			try {
				throw new TooFewAthleteException();
			} catch (TooFewAthleteException e) {
				System.out.println(e.getMessage());
				exception.setText(e.getMessage());

			}
		}

		else {

			System.out.println(selectedParticipants.getItems());
			running.setCurrentGame(Driver.RUNNING);
			System.out.println("current game " + running.getCurrentGame());

			for (int i = 0; i < get.getSprinters().size(); i++) {
				for (int j = 0; j < selectedParticipants.getItems().size(); j++) {
					String item = selectedParticipants.getItems().get(j);
					if (get.getSprinters().get(i).getUniqueID()
							.equals(item.substring(item.indexOf("ID=") + 3, item.indexOf("ID=") + 9))) {

						running.addContestant(get.getSprinters().get(i));
					}

				}
				// System.out.println("new" + swimming.getContestants());
			}

			for (int i = 0; i < get.getSuperAthletes().size(); i++) {
				for (int j = 0; j < selectedParticipants.getItems().size(); j++) {
					String item = selectedParticipants.getItems().get(j);
					if (get.getSuperAthletes().get(i).getUniqueID()
							.equals(item.substring(item.indexOf("ID=") + 3, item.indexOf("ID=") + 9))) {
						((SuperAthlete) (get.getSuperAthletes().get(i))).setCurrentGame(Ozlympic.driver.RUNNING);
						running.addContestant(get.getSuperAthletes().get(i));
					}

				}
				// System.out.println("new" + swimming.getContestants());

			}

			get1.getRunningGames().add(running);
			Ozlympic.driver.getGame().setCurrentGame(Driver.RUNNING);

			Utility utility = new Utility();
			utility.displayUX(RefereeController.class, "application/Referee.fxml", null);
		}

	}

	public void initialize(URL url, ResourceBundle rb) {
		athletes.clear();

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

		right.setOnAction((ActionEvent event) -> {

			addParticipants.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
			if (addParticipants.getSelectionModel().getSelectedItem() != null)

				selectedAddParticipantList = addParticipants.getSelectionModel().getSelectedItem();
			if (selectedAddParticipantList.equals("")) {
				exception.setText("");
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
								System.out.println(e.getMessage());
								exception.setText(e.getMessage());

							}

						} else {
							exception.setText("");
							addParticipants.getItems().remove(selectedAddParticipantList);
							if (selectedParticipants.getItems().contains(selectedAddParticipantList)) {
								exception.setText("");
							} else {
								exception.setText("");
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
						System.out.println(e.getMessage());
						exception.setText(e.getMessage());

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
				exception.setText("");
			} else {
				boolean isValid = false;
				while (!isValid) {

					if (selectedParticipantList != null) {
						exception.setText("");
						selectedParticipants.getItems().remove(selectedParticipantList);
						if (addParticipants.getItems().contains(selectedParticipantList)) {
							exception.setText("");
						} else {
							addParticipants.getItems().addAll(selectedParticipantList);
						}
						isValid = true;
					}

				}

			}
		});

	}

}
