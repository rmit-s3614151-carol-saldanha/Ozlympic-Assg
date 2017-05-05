package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class OzlympicController {

    @FXML
    private Button running;

    @FXML
    private Text displayText;

    @FXML
    private Button displayGames;

    @FXML
    private Text welcomeText;

    @FXML
    private Button cycling;

    @FXML
    private Button displayAthletePoints;
    
    private static boolean isDBConnect = false;		
    Utility utility = new Utility();
    
    public static boolean isDBConnectSuccessful()
	{
		return isDBConnect;
	}

        


    @FXML
    void clickRunning(ActionEvent event) throws Exception {

//    		Stage primaryStage = new Stage();
//    		primaryStage.hide();
    		utility.displayUX(RunningController.class, "application/Running.fxml", null);
			//Parent root = FXMLLoader.load(getClass().getResource("/application/Running.fxml"));
	
	
    }

    @FXML
    void clickCycling(ActionEvent event) throws Exception {
    	utility.displayUX(CyclingController.class, "application/Cycling.fxml", null);
    }

    @FXML
    void clickSwimming(ActionEvent event) throws Exception {
    	utility.displayUX(SwimmingController.class, "application/Swimming.fxml", null);
    }

    @FXML
    void clickDisplay(ActionEvent event) throws Exception {
    	
    }

}
