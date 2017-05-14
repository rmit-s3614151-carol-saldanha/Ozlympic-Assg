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

public class DisplayController extends RefereeController implements Initializable {

    @FXML
    private TableView<String> table;
	
    @FXML
    private TableColumn<String, String> name;

    @FXML
    private TableColumn<String, String> state;

    @FXML
    private TableColumn<String, String> id;

    @FXML
    private TableColumn<String, String> time;

    @FXML
    private TableColumn<String, String> type;



    @FXML
    private TableColumn<String, String> age;

	@FXML
	private JFXButton home;
	
	
	
	public static final ObservableList<String> athletes = FXCollections.observableArrayList();

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
		//System.out.println("TIMINGS" + driver.getGame().getSwimmwerTimings());
		 name.setCellValueFactory(new PropertyValueFactory<String, String>("name"));
	        age.setCellValueFactory(new PropertyValueFactory<String, String>("age"));
	        state.setCellValueFactory(new PropertyValueFactory<String, String>("state"));
	        id.setCellValueFactory(new PropertyValueFactory<String, String>("ID"));
	        type.setCellValueFactory(new PropertyValueFactory<String, String>("type"));
	        time.setCellValueFactory(new PropertyValueFactory<String, String>("Time"));
	       // table.getColumns().addAll(name,age,state,id,type,time);

	        
	    
		if (game.getCurrentGame().equals("SWIMMING")) {
			for (int i = 0; i < driver.displaySwimmingResults().size(); i++) {
				athletes.add(driver.displaySwimmingResults().get(i));
				
			}
			//System.out.println(athletes);
			table.setItems(athletes);
			
			
			
		}
	}
}