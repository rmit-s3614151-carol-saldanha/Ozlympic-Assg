package application;
	

import java.io.IOException;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import rmit.java.assignment.controller.Driver;
import rmit.java.assignment.database.FileHandler;
import rmit.java.assignment.database.ParticipantList;
import rmit.java.assignment.model.Athlete;
import rmit.java.assignment.model.Swimming;
import javafx.scene.Parent;
import javafx.scene.Scene;




public class Ozlympic extends Application {
	public static Driver driver = new Driver();


	@Override
	public void start(Stage primaryStage) throws Exception {
//		try {
//			Parent root = FXMLLoader.load(getClass().getResource("/application/Ozlympic.fxml"));
//			Scene scene = new Scene(root);
//			primaryStage.setScene(scene);
//			primaryStage.setTitle("Ozlympic");
//			primaryStage.show();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		Utility utility = new Utility();
		utility.displayUX(OzlympicController.class, "application/Ozlympic.fxml", null);
	}
	
	public static void main(String[] args) {
		
		launch(args);


	}
}


