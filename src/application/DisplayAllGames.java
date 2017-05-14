package application;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import rmit.java.assignment.model.Athlete;

public class DisplayAllGames {

    @FXML
    private TableColumn<Athlete, String> id;

    @FXML
    private TableColumn<Athlete, String> time;

    @FXML
    private TableView<Athlete> table;

    @FXML
    private TableColumn<Athlete, String> points;

    @FXML
    private JFXButton home;

    @FXML
    void homeMenu(ActionEvent event) {

    }

}
