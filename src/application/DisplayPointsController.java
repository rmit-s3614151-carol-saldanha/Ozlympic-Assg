package application;
// imports 

import java.net.URL;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import rmit.java.assignment.model.Athlete;

/**
 * 
 * @author Carol Benita Saldanha
 * @version 1.0 
 * @ClassDescription Display points controller loads the points of all athletes in a ascending format.
 *
 */
public class DisplayPointsController extends RefereeController implements Initializable {
	
	// Private instance variables for the FXML files.
	
	@FXML
	private TableView<Athlete> table;

	@FXML
	private TableColumn<Athlete, String> name;

	@FXML
	private TableColumn<Athlete, String> state;

	@FXML
	private TableColumn<Athlete, String> id;

	@FXML
	private TableColumn<Athlete, Float> points;

	@FXML
	private TableColumn<Athlete, String> type;

	@FXML
	private TableColumn<Athlete, String> age;

	@FXML
	private JFXButton home;

	/**
	 * 
	 * @param event
	 * @throws Exception
	 *             homeMenu(event) is a method that takes the user to the home
	 *             page or the menu page.
	 * 
	 */
	
	@FXML
	void homeMenu(ActionEvent event) throws Exception {
		Utility utility = new Utility();
		utility.displayUX(OzlympicController.class, "application/Ozlympic.fxml", null);
	}

	public void initialize(URL url, ResourceBundle rb) {

		// Display data to columns and set min width of each column 
		
		id.setMinWidth(20);
		id.setCellValueFactory(new PropertyValueFactory<Athlete, String>("uniqueID"));

		name.setMinWidth(30);
		name.setCellValueFactory(new PropertyValueFactory<Athlete, String>("name"));

		age.setMinWidth(5);
		age.setCellValueFactory(new PropertyValueFactory<Athlete, String>("age"));

		state.setMinWidth(30);
		state.setCellValueFactory(new PropertyValueFactory<Athlete, String>("state"));

		type.setMinWidth(40);
		type.setCellValueFactory(new PropertyValueFactory<Athlete, String>("type"));

		points.setMinWidth(30);
		points.setCellValueFactory(new PropertyValueFactory<Athlete, Float>("points"));
	
		
		ObservableList<Athlete> list = FXCollections.observableArrayList();;
		
	
		for(int i =0;i<driver.displayPoints().size();i++){
			// adds to observable list to display on UI
			list.add(driver.displayPoints().get(i));
		}	
	
		// Set itmes to table 
		table.setItems(list);
		
		// sort list 
		points.setSortType(TableColumn.SortType.DESCENDING);
		table.getSortOrder().add(points);
		

	}	
}