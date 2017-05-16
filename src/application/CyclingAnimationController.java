package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

/**
 *
 * 
 * @author : Carol Benita Saldanha
 * @version : 1 Class Description: The CyclingAnimation class is where the
 *          animation for swimming takes place. The UI elements are linked via
 *          CyclingAnimation.fxml
 * 
 * 
 * 
 * 
 */

public class CyclingAnimationController extends RefereeController implements Initializable {

	/**
	 * 
	 * These are the FXML variables that are set in CyclingAnimation.fxml and
	 * linked to this controller.
	 * 
	 */

	@FXML
	private ImageView participant2;

	@FXML
	private Circle path;

	@FXML
	private ImageView participant1;

	@FXML
	private Circle innerCircle;

	@FXML
	private ImageView participant8;

	@FXML
	private ImageView participant7;

	@FXML
	private ImageView participant6;

	@FXML
	private ImageView participant5;

	@FXML
	private ImageView participant4;

	@FXML
	private ImageView participant3;

	@FXML
	private Label label1;

	@FXML
	private Label label2;

	@FXML
	private Label label3;

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
	private JFXButton displayResultsPage;

	/**
	 * 
	 * This method is an Action event that takes place when the View Results
	 * button is clicked. The DisplayController class for Cycling is invoked
	 * next.
	 * 
	 */

	@FXML
	void displayResults(ActionEvent event) throws Exception {
		Utility utility = new Utility();
		utility.displayUX(DisplayController.class, "application/Display.fxml", null);

	}

	public void initialize(URL url, ResourceBundle rb) {
		
		/**
		 * 
		 * time and name are two Array Lists that are created which fetch the time and name of all the players.
		 * 
		 */

		ArrayList<Float> time = new ArrayList<Float>();
		ArrayList<String> name = new ArrayList<String>();

		System.out.println(driver.displayCyclingResults().get(0).getATime());
		for (int i = 0; i < driver.displayCyclingResults().size(); i++) {

			time.add(driver.displayCyclingResults().get(i).getATime());

		}
		for (int i = 0; i < driver.displayCyclingResults().size(); i++) {

			String result = driver.displayCyclingResults().get(i).toString();
			System.out.println(result);
			name.add(result.substring(result.indexOf("name=") + 5, result.indexOf(",")));

		}
		
		/**
		 * 
		 * This method is used to create a circular parallel transition for Cycling Animation and then play all these animations.These
		 * animations will vary depending on the number of participants that the user will chose.
		 * 
		 */

		Circle circle = new Circle();
		System.out.println(innerCircle.getLayoutX());
		System.out.println(innerCircle.getLayoutY());
		System.out.println(innerCircle.getRadius());
		System.out.println(innerCircle.getCenterX());
		System.out.println(innerCircle.getCenterX());
		System.out.println(innerCircle.getTranslateX());
		System.out.println(innerCircle.getTranslateX());

		circle.setRadius(175);
		circle.setCenterX(0);
		circle.setCenterY(0);
		circle.setTranslateX(185);

		circle.setCursor(participant1.getCursor());

		PathTransition transition1 = new PathTransition();
		transition1.setPath(circle);
		transition1.setNode(participant1);

		transition1.setDuration(Duration.seconds(time.get(0) /40));

		PathTransition transition2 = new PathTransition();
		transition2.setPath(circle);
		transition2.setNode(participant2);
		transition2.setDuration(Duration.seconds(time.get(1) /40));

		PathTransition transition3 = new PathTransition();
		transition3.setPath(circle);
		transition3.setNode(participant3);
		transition3.setDuration(Duration.seconds(time.get(2) /40));

		PathTransition transition4 = new PathTransition();
		transition4.setPath(circle);
		transition4.setNode(participant4);
		transition4.setDuration(Duration.seconds(time.get(3) /40));

		PathTransition transition5 = new PathTransition();
		transition5.setPath(circle);
		transition5.setNode(participant5);
		transition5.setDuration(Duration.seconds(time.get(4) /40));

		PathTransition transition6 = new PathTransition();
		transition6.setPath(circle);
		transition6.setNode(participant6);
		transition6.setDuration(Duration.seconds(time.get(5) /40));

		PathTransition transition7 = new PathTransition();
		transition7.setPath(circle);
		transition7.setNode(participant7);
		transition7.setDuration(Duration.seconds(time.get(6) /40));

		PathTransition transition8 = new PathTransition();
		transition8.setPath(circle);
		transition8.setNode(participant8);
		transition1.setDuration(Duration.seconds(time.get(7) /40));

		if (driver.displayCyclingResults().size() == 8) {

			transition5.setDuration(Duration.seconds(time.get(4) /40));
			transition6.setDuration(Duration.seconds(time.get(5) /40));
			transition7.setDuration(Duration.seconds(time.get(6) /40));
			transition8.setDuration(Duration.seconds(time.get(7) /40));
			ParallelTransition parallel = new ParallelTransition(transition1, transition2, transition3, transition4,
					transition5, transition6, transition7, transition8);
			parallel.play();
			label1.setText("1) " + name.get(0));
			label2.setText("2) " + name.get(1));
			label3.setText("3) " + name.get(2));
			label4.setText("4) " + name.get(3));
			label5.setText("5) " + name.get(4));
			label6.setText("6) " + name.get(5));
			label7.setText("7) " + name.get(6));
			label8.setText("8) " + name.get(7));
		}

		else if (driver.displayCyclingResults().size() == 4) {

			participant5.setVisible(false);
			participant6.setVisible(false);
			participant7.setVisible(false);
			participant8.setVisible(false);

			ParallelTransition parallel = new ParallelTransition(transition1, transition2, transition3, transition4);
			parallel.play();

			label1.setText("1) " + name.get(0));
			label2.setText("2) " + name.get(1));
			label3.setText("3) " + name.get(2));
			label4.setText("4) " + name.get(3));

		} else if (driver.displayCyclingResults().size() == 5) {

			participant6.setVisible(false);
			participant7.setVisible(false);
			participant8.setVisible(false);

			transition5.setDuration(Duration.seconds(time.get(4) /40));

			ParallelTransition parallel = new ParallelTransition(transition1, transition2, transition3, transition4,
					transition5);
			parallel.play();

			label1.setText("1) " + name.get(0));
			label2.setText("2) " + name.get(1));
			label3.setText("3) " + name.get(2));
			label4.setText("4) " + name.get(3));
			label5.setText("5) " + name.get(4));
		} else if (driver.displayCyclingResults().size() == 6) {

			transition5.setDuration(Duration.seconds(time.get(4) /40));
			transition6.setDuration(Duration.seconds(time.get(5) /40));
			participant7.setVisible(false);
			participant8.setVisible(false);
			ParallelTransition parallel = new ParallelTransition(transition1, transition2, transition3, transition4,
					transition5, transition6);
			parallel.play();
			label1.setText("1) " + name.get(0));
			label2.setText("2) " + name.get(1));
			label3.setText("3) " + name.get(2));
			label4.setText("4) " + name.get(3));
			label5.setText("5) " + name.get(4));
			label6.setText("6) " + name.get(5));

		} else {

			transition5.setDuration(Duration.seconds(time.get(4) /40));
			transition6.setDuration(Duration.seconds(time.get(5) /40));
			transition7.setDuration(Duration.seconds(time.get(6) /40));
			participant8.setVisible(false);
			ParallelTransition parallel = new ParallelTransition(transition1, transition2, transition3, transition4,
					transition5, transition6, transition7);
			parallel.play();
			label1.setText("1) " + name.get(0));
			label2.setText("2) " + name.get(1));
			label3.setText("3) " + name.get(2));
			label4.setText("4) " + name.get(3));
			label5.setText("5) " + name.get(4));
			label6.setText("6) " + name.get(5));
			label7.setText("7) " + name.get(6));

		}

	}
}
