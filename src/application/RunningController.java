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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class RunningController  implements Initializable{

    @FXML
    private ListView<String> addReferee;

    @FXML
    private Button startGame;

    @FXML
    private Label label1;


    
    @FXML
    private ListView<String> addParticipants;

	
    
    


    

    @FXML
    void addParticipants(ActionEvent event) {
    	
     	addParticipants.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        addParticipants.getSelectionModel().selectedItemProperty().addListener((obs,ov,nv)->{
            addParticipants.setItems(addParticipants.getSelectionModel().getSelectedItems());
        });
 
    	

     

    	
    }

    void addReferee(ActionEvent event) {
   
    }
    public void initialize(URL url, ResourceBundle rb) {
    	
    	ListView<String> listView = new ListView<String>();

    	addParticipants.getItems().add("Carol");
    	addParticipants.getItems().add("Eashan");
    	addParticipants.getItems().add("Niraj");
    	
    	
    	
    	ListView<String> listView1 = new ListView<String>();
    	addReferee.getItems().add("Chaitrali");
    	addReferee.getItems().add("Soumil");
    	addReferee.getItems().add("Naruto");		
		
    	listView1.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    	
    	addParticipants.setOnMousePressed(new EventHandler<Event>() {
    	@Override

    	public void handle(Event event) {
    		int count = 3;
    		addParticipants.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    		ObservableList<String> selectedItems = addParticipants.getSelectionModel().getSelectedItems();
    		for (String s : selectedItems) {
    		System.out.println("removed item " + s);
    		addParticipants.getItems().add(s);
    		addParticipants.getSelectionModel().select(-1);
    		addParticipants.getItems().remove(s);
    		count --;
    		
    		//exception.setText("");

    		}




    	}

    	
    	});
    	
    	addReferee.setOnMousePressed(new EventHandler<Event>() {
        	@Override

        	public void handle(Event event) {
        		int count =3;
        		addReferee.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        		ObservableList<String> selectedItems = addReferee.getSelectionModel().getSelectedItems();
        		for (String s : selectedItems) {
        		System.out.println("removed item " + s);
        		addReferee.getItems().add(s);
        		addReferee.getSelectionModel().select(-1);
        		addReferee.getItems().remove(s);
        		
        		//exception.setText("");

        		}




        	}

        	
        	});
        	
    	
}

}
