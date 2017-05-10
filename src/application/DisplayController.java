package application;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class DisplayController extends RefereeController implements Initializable{

    @FXML
    private JFXButton button;


    @FXML
    private Label label4;

    @FXML
    private Label label5;

    @FXML
    private Label label6;

    @FXML
    private Label label7;

    @FXML
    private Label label8;

    @FXML
    private Label label1;

    @FXML
    private Label label2;

    @FXML
    private Label label3;

    @FXML
    void display(ActionEvent event) {
    	
    	//label.setText(driver.displayResults().get(0));
    }
    
    public void initialize(URL url, ResourceBundle rb) {
    	for(int i=0;i<driver.displayResults().size();i++){
    	if(i==0){
    	label1.setText(driver.displayResults().get(i));}
    	else if(i==1){
    		label2.setText(driver.displayResults().get(i));
    	}
    	else if(i==2){
    		label3.setText(driver.displayResults().get(i));
    	}
    	else if(i==3){
    		label4.setText(driver.displayResults().get(i));
    	}
    	else if(i==4){
    		label5.setText(driver.displayResults().get(i));
    	}
    	else if(i==5){
    		label6.setText(driver.displayResults().get(i));
    	}
    	else if(i==6){
    		label7.setText(driver.displayResults().get(i));
    	}
    	else{
    		label8.setText(driver.displayResults().get(i));
    	}
    	}
}
}