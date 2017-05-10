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
import rmit.java.assignment.model.Swimming;

public class RefereeController implements Initializable {

	@FXML
	private ListView<String> selectedReferee;

	@FXML
	private Button left;

	@FXML
	private Button right;

	@FXML
	private Label exception;

	@FXML
	private ListView<String> addReferee;

	@FXML
	private Button Next;

	private static final int MAXIMUM_REFEREE = 1;
	
	private String selectedAddRefereeList="";
	
	private String selectedRefereeList="";
	
	private Swimming swimming;
	
	


	// For Athletes
	public static final ObservableList<String> athletes = FXCollections.observableArrayList();

	// For Officials
	public static final ObservableList<String> officials = FXCollections.observableArrayList();

	// For Playing 8
	public static final ObservableList<String> playerList = FXCollections.observableArrayList();

	public static final ObservableList<String> selected = FXCollections.observableArrayList();
	

	//private Game game;
	 
	Driver driver = Ozlympic.driver;
	ParticipantList get = driver.getParticipantList();
	
	Game game = driver.getGame();

	@FXML
	void addReferee(ActionEvent event) {

		addReferee.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		System.out.println("adding referee");
		
		
	}
	
	

	@FXML
	void runGame(ActionEvent event) throws Exception {
		if (selectedReferee.getItems().size()+1 == MAXIMUM_REFEREE) {
			try {
				throw new NoRefereeException();
			} catch (NoRefereeException e) {
				System.out.println(e.getMessage());
				exception.setText(e.getMessage());

			}
		}

		else {
			for (int i = 0; i < get.getOfficials().size(); i++) {
				for (int j = 0; j < selectedReferee.getItems().size(); j++) {
					String item = selectedReferee.getItems().get(j);
					
					if (get.getOfficials().get(i).getUniqueID()
							.equals(item.substring(item.indexOf("ID=") + 3, item.indexOf("ID=") + 9))) {
						
						game.getSwimmingGames().get(game.getSwimmingGames().size()-1).setOfficial(get.getOfficials().get(i));
					}
					//System.out.println("new referee" + game.getSwimmingGames().get(game.getSwimmingGames().size()-1).getOfficial());
			
				}
				
			}
		 
			driver.startGame();
			//driver.displayResults();
			driver.displayPoints();
			Utility utility = new Utility();
			utility.displayUX(RunningController.class, "application/Running.fxml", null);
		}
	}

	public void initialize(URL url, ResourceBundle rb) {

	
		
		for (int i = 0; i< get.getOfficials().size();i++) {
			officials.add(get.getOfficials().get(i).toString());
		}

		addReferee.setItems(officials);
		

		right.setOnAction((ActionEvent event) -> {
			
			

			addReferee.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
			System.out.println(selectedReferee.getItems().size()+1);
			if(addReferee.getSelectionModel().getSelectedItem()!=null)
				
				selectedAddRefereeList = addReferee.getSelectionModel().getSelectedItem();
			if(selectedAddRefereeList.equals(""))
			{
				exception.setText("");
			}
			else if(selectedReferee.getItems().size()+1 == MAXIMUM_REFEREE)
			{
						exception.setText("");
						addReferee.getItems().remove(selectedAddRefereeList);
						selectedReferee.getItems().addAll(selectedAddRefereeList);
						
					
			}
		
			
			
			
			

		});

		left.setOnAction((ActionEvent event) -> {
			selectedReferee.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
			if(selectedReferee.getSelectionModel().getSelectedItem()!=null)
				
			selectedRefereeList = selectedReferee.getSelectionModel().getSelectedItem();
			if(selectedRefereeList.equals(""))
			{
				exception.setText("");
			}
			else
			{
			boolean isValid = false;
			while (!isValid) {
				
					 
						exception.setText("");
						selectedReferee.getItems().remove(selectedRefereeList);
						if(addReferee.getItems().contains(selectedRefereeList)){
							exception.setText("");
						}
						else
						{
						addReferee.getItems().addAll(selectedRefereeList);
						}
						isValid = true;
					}
					
				}
				

		
		});

	}

}
