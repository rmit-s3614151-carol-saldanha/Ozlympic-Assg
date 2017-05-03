package application;

import java.net.URL;
import java.util.ResourceBundle;

import com.sun.glass.events.MouseEvent;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import rmit.java.assignment.database.ParticipantList;

public class RunningController implements Initializable {

	@FXML
	private ListView<String> addReferee;

	@FXML
	private ListView<String> gameList;

	@FXML
	private Button startGame;

	@FXML
	private Label label1;

	@FXML
	private Label gameListHeader;

	@FXML
	private ListView<String> addParticipants;

	// For Athletes
	public static final ObservableList<String> athletes = FXCollections.observableArrayList();

	// For Officials
	public static final ObservableList<String> officials = FXCollections.observableArrayList();

	// For Playing 8
	public static final ObservableList<String> playerList = FXCollections.observableArrayList();

	ParticipantList get = new ParticipantList();
	
	private String selectedPrev  = "";

	@FXML
	void addParticipants(ActionEvent event) {

		addParticipants.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		addParticipants.getSelectionModel().selectedItemProperty().addListener((obs, ov, nv) -> {
			  gameList.setItems(addParticipants.getSelectionModel().getSelectedItems());
		});
	}

	void addReferee(ActionEvent event) {
		
		addReferee.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		addReferee.getSelectionModel().selectedItemProperty().addListener((obs, ov, nv) -> {
			 gameList.setItems(addParticipants.getSelectionModel().getSelectedItems());
		});
	}
	
	void removeParticipant(ActionEvent event){
		gameList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		gameList.getSelectionModel().selectedItemProperty().addListener((obs, ov, nv) -> {
			  addParticipants.setItems(gameList.getSelectionModel().getSelectedItems());
		});
	}

	public void initialize(URL url, ResourceBundle rb) {

		for ( int i = 0 ; i < get.getSwimmers().size();i++ ){
			athletes.add(get.getSwimmers().get(i).toString());
		}
		for ( int i = 0 ; i < get.getCyclists().size();i++ ){
			athletes.add(get.getCyclists().get(i).toString());
		}
		for ( int i = 0 ; i < get.getSprinters().size();i++ ){
			athletes.add(get.getSprinters().get(i).toString());
		}
		for ( int i = 0 ; i < get.getSuperAthletes().size();i++ ){
			athletes.add(get.getSuperAthletes().get(i).toString());
		}
		for ( int i = 0 ; i < get.getOfficials().size();i++ ){
			officials.add(get.getOfficials().get(i).toString());
		}
		
		
		addReferee.setItems(officials);
		
		addParticipants.setItems(athletes);


		addParticipants.setOnMousePressed(new EventHandler<Event>() {
			@Override

			public void handle(Event event) {
				int count = 3;
				addParticipants.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
			
				ObservableList<String> selectedItems = addParticipants.getSelectionModel().getSelectedItems();
				for (String s : selectedItems) {
					System.out.println("removed item " + s);
					gameList.getItems().addAll(s);
					addParticipants.getSelectionModel().select(-1);
					addParticipants.getItems().remove(s);
				
					 exception.setText("");
				}

			}

		});

		addReferee.setOnMousePressed(new EventHandler<Event>() {
			@Override

			public void handle(Event event) {
			
				addReferee.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
				String selectedItems = addReferee.getSelectionModel().getSelectedItem();
					
					gameList.getItems().add(selectedItems);
					addParticipants.getSelectionModel().select(-1);
					

					// exception.setText("");
				
				
					
			}
		});
		
		gameList.setOnMousePressed(new EventHandler<Event>() {
			@Override

			public void handle(Event event) {
			
				int count = 3 ;
				gameList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
				ObservableList<String> selectedItems = gameList.getSelectionModel().getSelectedItems();
				for (String s : selectedItems) {
					System.out.println("removed item " + s);

					addParticipants.getItems().addAll(s);
					addParticipants.getSelectionModel().select(-1);
					gameList.getItems().remove(s);

					// exception.setText("");
				}
				
				
					
			}
		});

	}

}
