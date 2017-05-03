package application;
	

import javafx.application.Application;
import javafx.stage.Stage;
import rmit.java.assignment.database.ParticipantList;


public class Ozlympic extends Application {
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
		utility.displayUX(RunningController.class, "application/Ozlympic.fxml", null);
	}
	
	public static void main(String[] args) {
		

		ParticipantList run = new ParticipantList();
	
		launch(args);

	}
}


