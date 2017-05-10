package application;

import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class DisplayController extends RefereeController{

    @FXML
    private JFXTextField text;

    @FXML
    void display(ActionEvent event) {
    		text.setText(driver.displayResults());
    }

}
