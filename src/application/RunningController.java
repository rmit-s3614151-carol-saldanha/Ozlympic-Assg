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
import rmit.java.assignment.database.ParticipantList;

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


	@FXML
	void e80606(ActionEvent event) {

	}

	// For Athletes
	public static final ObservableList<String> athletes = FXCollections.observableArrayList();

	// For Officials
	public static final ObservableList<String> officials = FXCollections.observableArrayList();

	// For Playing 8
	public static final ObservableList<String> playerList = FXCollections.observableArrayList();

	public static final ObservableList<String> selected = FXCollections.observableArrayList();
	private static final Object Sprinters = "Sprinters";

	ParticipantList get = new ParticipantList();

	@FXML
	void addParticipants(ActionEvent event) {

		addParticipants.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		addParticipants.getSelectionModel().selectedItemProperty().addListener((obs, ov, nv) -> {
			// gameList.setItems(addParticipants.getSelectionModel().getSelectedItems());
		});
	}

	@FXML
	void nextPage(ActionEvent event) throws Exception {
		if(selectedParticipants.getItems().size() <= 3){
			try{
				  throw  new TooFewAthleteException();
			  }
			  catch(TooFewAthleteException e)
			  {
				  System.out.println(e.getMessage());
				  exception.setText(e.getMessage());
				
			  }
		}
		
			else 
			{	
				Utility utility = new Utility();
				utility.displayUX(RefereeController.class, "application/Referee.fxml", null);
				}
			}
		
		

	public void initialize(URL url, ResourceBundle rb) {

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
		System.out.println("a" + addParticipants.getItems());

		right.setOnAction((ActionEvent event) -> {

			addParticipants.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
			String potential = addParticipants.getSelectionModel().getSelectedItem();
			int index = potential.indexOf(potential);
			if (selectedParticipants.getItems().size()<=7) {
//				if(selectedParticipants.){
//					System.out.println("sprint");
//				}
				addParticipants.getSelectionModel().clearSelection();
				addParticipants.getItems().remove(index);
				selectedParticipants.getItems().addAll(potential);
			}
			
			
			if (selectedParticipants.getItems().size() == 8) {

				try {
					throw new GameFullException();
				} catch (GameFullException e) {
					System.out.println(e.getMessage());
					exception.setText(e.getMessage());

				}
			}

		});

		left.setOnAction((ActionEvent event) -> {
			String s = selectedParticipants.getSelectionModel().getSelectedItem();
			int index = s.indexOf(s);
			if (s != null) {
				selectedParticipants.getSelectionModel().clearSelection();
				selectedParticipants.getItems().remove(s);
				addParticipants.getItems().addAll(s);
			}
		});

	}

}
