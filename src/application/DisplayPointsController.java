package application;

import java.net.URL;
import java.util.HashMap;
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

public class DisplayPointsController extends RefereeController implements Initializable {

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

	//public static final ObservableList<Athlete> athletes = FXCollections.observableArrayList();

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

//		if (game.getCurrentGame().equals(driver.SWIMMING)) {
//			athletes = FXCollections.observableArrayList(driver.displaySwimmingResults());
//		} else if (game.getCurrentGame().equals(driver.CYCLING)) {
//			athletes = FXCollections.observableArrayList(driver.displayCyclingResults());
//		} else if (game.getCurrentGame().equals(driver.RUNNING)) {
//			athletes = FXCollections.observableArrayList(driver.displayRunningResults());
//		}
//		for (int i = 0; i < driver.displayPoints().size(); i++) {
//			athletes.add(driver.displayPoints().get(i));
//		}
		
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
		points.setSortable(false);
		ObservableList<Athlete> list = FXCollections.observableArrayList();;
		//table.setItems(athletes1);
		System.out.println("adding to list "+ driver.displayPoints());
//		for(Athlete athlete:driver.displayPoints().keySet()){
//			list.add(athlete);
//			System.out.println("adding to list " + athlete);
//			}
//			table.setItems(list);
		System.out.println("size"+driver.displayPoints().size());
		for(int i =0;i<driver.displayPoints().size();i++){
		list.add(driver.displayPoints().get(i));

	}	//table.setBackground();
		System.out.println("LIST" +list);
		
		
		table.setItems(list);
		points.setSortable(true);


		points.setSortType(TableColumn.SortType.DESCENDING);
		table.getSortOrder().add(points);
		points.setSortable(true);
		table.sort();

		

	}	
}