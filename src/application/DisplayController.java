package application;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import rmit.java.assignment.model.Athlete;
import rmit.java.assignment.model.Cyclist;

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
	private JFXButton home;

	@FXML
	private Label refereeID;

	@FXML
	private Label gameID;
	
    @FXML
    private Label refereeName;

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
		
		if (game.getCurrentGame().equals(driver.SWIMMING)) {
			athletes = FXCollections.observableArrayList(driver.displaySwimmingResults());
			refereeID.setText(game.getSwimmingGames().get(game.getSwimmingGames().size() - 1).getOfficial().getUniqueID()
					.toString());
			gameID.setText(game.getSwimmingGames().get(game.getSwimmingGames().size() -1 ).getGameID() );
			refereeName.setText(game.getSwimmingGames().get(game.getSwimmingGames().size() - 1 ).getOfficial().getName());

		} else if (game.getCurrentGame().equals(driver.CYCLING)) {
			athletes = FXCollections.observableArrayList(driver.displayCyclingResults());
		} else if (game.getCurrentGame().equals(driver.RUNNING)) {
			athletes = FXCollections.observableArrayList(driver.displayRunningResults());
		}

		id.setMinWidth(100);
		id.setCellValueFactory(new PropertyValueFactory<Athlete, String>("uniqueID"));

		name.setMinWidth(100);
		name.setCellValueFactory(new PropertyValueFactory<Athlete, String>("name"));

		age.setMinWidth(100);
		age.setCellValueFactory(new PropertyValueFactory<Athlete, String>("age"));

		state.setMinWidth(100);
		state.setCellValueFactory(new PropertyValueFactory<Athlete, String>("state"));

		type.setMinWidth(100);
		type.setCellValueFactory(new PropertyValueFactory<Athlete, String>("type"));

		time.setCellValueFactory(new PropertyValueFactory<Athlete, Float>("atime"));

		table.setItems(athletes);

	}
}