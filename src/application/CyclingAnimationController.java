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
import rmit.java.assignment.controller.Driver;
import rmit.java.assignment.model.Athlete;
import rmit.java.assignment.model.Cycling;
import rmit.java.assignment.model.Game;

/**
 *
 * 
 * @author : Carol Benita Saldanha
 * @version : 5.0
 * @classDescription Class Description: The CyclingAnimation class is where the
 *                   animation for swimming takes place. The UI elements are
 *                   linked via CyclingAnimation.fxml
 * 
 * 
 * 
 * 
 */

public class CyclingAnimationController implements Initializable {

	/**
	 * 
	 * These are the FXML variables that are set in CyclingAnimation.fxml and
	 * linked to this controller.
	 * 
	 */

	@FXML
	private Circle path;

	@FXML
	private Circle innerCircle;

	@FXML
	private ImageView participant1;
	@FXML
	private ImageView participant2;
	@FXML
	private ImageView participant3;

	@FXML
	private ImageView participant4;

	@FXML
	private ImageView participant5;
	@FXML
	private ImageView participant6;
	@FXML
	private ImageView participant7;

	@FXML
	private ImageView participant8;

	@FXML
	private Label playerOne;

	@FXML
	private Label playerTwo;

	@FXML
	private Label playerThree;

	@FXML
	private Label playerFour;

	@FXML
	private Label playerFive;

	@FXML
	private Label playerSix;

	@FXML
	private Label playerSeven;

	@FXML
	private Label playerEight;

	private ArrayList<Label> names = new ArrayList<Label>();

	// TO AVOID MAGIC NUMBERS
	private final int FORWARD = 40;

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
		 * time and name are two Array Lists that are created which fetch the
		 * time and name of all the players.
		 * 
		 */

		ArrayList<Float> time = new ArrayList<Float>();
		ArrayList<String> name = new ArrayList<String>();

		Game game = Ozlympic.driver.getGame();
		game.setCurrentGame(Driver.CYCLING);
		int size = game.getCyclingGames().get(game.getCyclingGames().size() - 1).getContestants().size();

		for (int i = 0; i < game.getCyclingGames().size(); i++) {
			ArrayList<Cycling> games = Ozlympic.driver.getGame().getCyclingGames();
			Cycling gameCycling = games.get(games.size() - 1);
			for (Athlete athlete : gameCycling.getTimings().keySet()) {
				time.add(gameCycling.getTimings().get(athlete));

			}
		}

		for (Athlete athlete : game.getCyclingGames().get(game.getCyclingGames().size() - 1).getContestants()) {

			name.add(athlete.getAName());

		}

		/**
		 * 
		 * This method is used to create a circular parallel transition for
		 * Cycling Animation and then play all these animations.These animations
		 * will vary depending on the number of participants that the user will
		 * choose.
		 * 
		 */

		Circle circle = new Circle();

		circle.setRadius(175);
		circle.setCenterX(0);
		circle.setCenterY(0);
		circle.setTranslateX(185);

		circle.setCursor(participant1.getCursor());

		PathTransition transition1 = new PathTransition();
		PathTransition transition2 = new PathTransition();
		PathTransition transition3 = new PathTransition();
		PathTransition transition4 = new PathTransition();
		PathTransition transition5 = new PathTransition();
		PathTransition transition6 = new PathTransition();
		PathTransition transition7 = new PathTransition();
		PathTransition transition8 = new PathTransition();

		ArrayList<PathTransition> transitions = new ArrayList<PathTransition>();
		transitions.add(transition1);
		transitions.add(transition2);
		transitions.add(transition3);
		transitions.add(transition4);
		transitions.add(transition5);
		transitions.add(transition6);
		transitions.add(transition7);
		transitions.add(transition8);

		createArrayListOfLabels();
		ArrayList<ImageView> images = createArrayListOfImages();
		ParallelTransition parallel = new ParallelTransition();

		for (int index = 0; index < size; index++) {
			transitions.get(index).setPath(circle);
			transitions.get(index).setNode(images.get(index));
			transitions.get(index).setDuration(Duration.seconds(time.get(index) / FORWARD));
			parallel.getChildren().add(transitions.get(index));
			names.get(index).setText(Integer.toString((index + 1)) + ". " + name.get(index));

		}
		for (int index = size; index < 8; index++) {
			images.get(index).setVisible(false);
		}
		parallel.play();

	}

	private void createArrayListOfLabels() {
		names.add(playerOne);
		names.add(playerTwo);
		names.add(playerThree);
		names.add(playerFour);
		names.add(playerFive);
		names.add(playerSix);
		names.add(playerSeven);
		names.add(playerEight);
	}

	private ArrayList<ImageView> createArrayListOfImages() {
		ArrayList<ImageView> images = new ArrayList<ImageView>();
		images.add(participant1);
		images.add(participant2);
		images.add(participant3);
		images.add(participant4);
		images.add(participant5);
		images.add(participant6);
		images.add(participant7);
		images.add(participant8);
		return images;
	}

}
