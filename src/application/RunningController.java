package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;



public class RunningController  {

    @FXML
    private ComboBox<?> addReferee;

    @FXML
    private Button startGame;

    @FXML
    private Label label1;

    @FXML
    private ComboBox<String> addParticipants;

    final ObservableList options = FXCollections.observableArrayList();
	
    
    @FXML
    void clickMe(ActionEvent event) {
    	
    
    	
    	addParticipants.setItems(options);
     

    	
    }

    
    

    @FXML
    void startRunning(ActionEvent event) {

    }
    
//    public void initialize(URL url, ResourceBundle rb){
//    	System.out.println("initializing");
//    	options = 
//    		    FXCollections.observableArrayList(
//    		        "Option 1",
//    		        "Option 2",
//    		        "Option 3"
//    		    );
//    	
//    	addParticipants.setItems(options);
//    }

}
