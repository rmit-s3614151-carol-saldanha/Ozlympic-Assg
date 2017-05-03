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
    private ComboBox<?> addReferee;

    @FXML
    private Button startGame;

    @FXML
    private Label label1;


    
    @FXML
    private ListView<String> addParticipants;

	
    
    


    

    @FXML
    void clickMe(ActionEvent event) {
    	

    	
    	
   
     

    	
    }

    
   
    
    public void initialize(URL url, ResourceBundle rb) {
    	
    	ListView<String> listView = new ListView<String>();

    	addParticipants.getItems().add("item 1");
    	addParticipants.getItems().add("item 2");
    	
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

    }
    
//    @Override

//    public void handle(Event event) {
//
//    ObservableList<String> selectedItems = selectedAthletes.getSelectionModel().getSelectedItems();
//
//
//    for (String s : selectedItems) {
//
//    System.out.println("removed item " + s);
//
//    athletes.getItems().add(s);
//
//    selectedAthletes.getSelectionModel().select(-1);
//
//    selectedAthletes.getItems().remove(s);
//
//    count--;
//
//    exception.setText("");
//
//    }




    

//    });
}