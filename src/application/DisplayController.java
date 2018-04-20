package application;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import rmit.java.assignment.controller.Driver;
import rmit.java.assignment.model.Athlete;

public class DisplayController extends RefereeController implements Initializable {

	@FXML
	private TableView<Athlete> table;

	@FXML
	private TableColumn<Athlete, String> name;

	@FXML
	private TableColumn<Athlete, String> state;

	@FXML
	private TableColumn<Athlete, String> id;

	@FXML
	private TableColumn<Athlete, Float> time;

	@FXML
	private TableColumn<Athlete, String> type;

	@FXML
	private TableColumn<Athlete, String> age;
	
	@FXML
    private TableColumn<Athlete, ImageView> medals;

	@FXML
	private JFXButton home;

	@FXML
	private Label refereeID;

	@FXML
	private Label gameID;
	
    @FXML
    private Label refereeName;
    
    @FXML
    private Label winner;
    
    @FXML
    private Label winner2;
    
    @FXML
    private Label winner3;
    
    @FXML
    private ImageView WinnerImg;

    @FXML
    private ImageView tropheeImg;
    
    private ObservableList<Athlete> athletes;

	@FXML
	void homeMenu(ActionEvent event) throws Exception {
		Utility utility = new Utility();
		utility.displayUX(OzlympicController.class, "application/Ozlympic.fxml", null);
	}

	@FXML
	void display(ActionEvent event) {

		// label.setText(driver.displayResults().get(0));
	}

	public void initialize(URL url, ResourceBundle rb) {
		refereeID.setText("");
	
		if (game.getCurrentGame().equals(Driver.SWIMMING)) {
			athletes = FXCollections.observableArrayList(driver.displaySwimmingResults());
			refereeID.setText(game.getSwimmingGames().get(game.getSwimmingGames().size() - 1).getOfficial().getUniqueID()
					.toString());
			gameID.setText(game.getSwimmingGames().get(game.getSwimmingGames().size() -1 ).getGameID() );
			refereeName.setText(game.getSwimmingGames().get(game.getSwimmingGames().size() - 1 ).getOfficial().getName());

		} else if (game.getCurrentGame().equals(Driver.CYCLING)) {
			athletes = FXCollections.observableArrayList(driver.displayCyclingResults());
			refereeID.setText(game.getCyclingGames().get(game.getCyclingGames().size() - 1).getOfficial().getUniqueID()
					.toString());
			gameID.setText(game.getCyclingGames().get(game.getCyclingGames().size() -1 ).getGameID() );
			refereeName.setText(game.getCyclingGames().get(game.getCyclingGames().size() - 1 ).getOfficial().getName());
		} else if (game.getCurrentGame().equals(Driver.RUNNING)) {
			athletes = FXCollections.observableArrayList(driver.displayRunningResults());
			refereeID.setText(game.getRunningGames().get(game.getRunningGames().size() - 1).getOfficial().getUniqueID()
					.toString());
			gameID.setText(game.getRunningGames().get(game.getRunningGames().size() -1 ).getGameID() );
			refereeName.setText(game.getRunningGames().get(game.getRunningGames().size() - 1 ).getOfficial().getName());
		}

		id.setMinWidth(40);
		id.setCellValueFactory(new PropertyValueFactory<Athlete, String>("uniqueID"));

		name.setMinWidth(100);
		name.setCellValueFactory(new PropertyValueFactory<Athlete, String>("name"));

		age.setMinWidth(10);
		age.setCellValueFactory(new PropertyValueFactory<Athlete, String>("age"));

		state.setMinWidth(20);
		state.setCellValueFactory(new PropertyValueFactory<Athlete, String>("state"));

		type.setMinWidth(60);
		type.setCellValueFactory(new PropertyValueFactory<Athlete, String>("type"));

		time.setCellValueFactory(new PropertyValueFactory<Athlete, Float>("atime"));
		
		//medals.setCellValueFactory(new PropertyValueFactory<Athlete, ImageView>("winners"));
		

		table.setItems(athletes);
		
		
		String firstPlace= table.getItems().get(0).toString();
		winner.setText(firstPlace.substring(firstPlace.indexOf("name=")+5, firstPlace.indexOf(",")));
		
		String secondPlace= table.getItems().get(1).toString();
		winner2.setText(secondPlace.substring(secondPlace.indexOf("name=")+5, secondPlace.indexOf(",")));
		
		
		String thirdPlace= table.getItems().get(2).toString();
		winner3.setText(thirdPlace.substring(thirdPlace.indexOf("name=")+5, thirdPlace.indexOf(",")));
//		star1.setVisible(true);
//		star2.setVisible(true);
//		star3.setVisible(true);
	}
}