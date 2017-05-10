package application;

import java.util.ArrayList;
import java.util.Random;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import rmit.java.assignment.model.Swimmer;

public class Animation extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		Pane pane = new Pane(); // Create a pane1
		Image img = new Image("application/images/run.png");

		ImageView view1 = new ImageView(img);
		ImageView view2 = new ImageView(img);
		ImageView view3 = new ImageView(img);
		ImageView view4 = new ImageView(img);
		ImageView view5 = new ImageView(img);
		ImageView view6 = new ImageView(img);
		ImageView view7 = new ImageView(img);
		ImageView view8 = new ImageView(img);
		ArrayList<ImageView> add = new ArrayList<ImageView>();
		add.add(view1);
		add.add(view2);
		add.add(view3);
		add.add(view4);
		add.add(view5);
		add.add(view6);
		add.add(view7);
		add.add(view8);
		
		ArrayList<Integer> time = new ArrayList<Integer>();
		time.add(7);
		time.add(10);
		time.add(12);
		time.add(11);
		time.add(20);
		time.add(20);
		time.add(3);
		time.add(2);

		Random rand = new Random();

		int numOfPlayers = rand.nextInt(8);
		 Circle circle = new Circle(200); 
		 circle.fillProperty().set(Color.ALICEBLUE);

		if (numOfPlayers < 4) {
			System.out.println("Error");
		} else {
			PathTransition transition = new PathTransition();
			PathTransition transition1 = new PathTransition();
			PathTransition transition2 = new PathTransition();
			PathTransition transition3 = new PathTransition();
			PathTransition transition4 = new PathTransition();
			PathTransition transition5 = new PathTransition();
			PathTransition transition6 = new PathTransition();
			PathTransition transition7 = new PathTransition();
			transition.setPath(circle);
			pane.getChildren().add(circle);
			circle.setTranslateX(200);
			circle.setTranslateY(350);
			
			for (int i = 0; i < numOfPlayers; i++) {
				 
				
				pane.getChildren().add(add.get(i));
				
				transition.setNode(add.get(i));
				transition.setDuration(Duration.seconds(time.get(i)));
				
			}
			transition.play();
		}

		/*
		 * ImageView view = new ImageView(img); ImageView view1 = new
		 * ImageView(img); ImageView view2 = new ImageView(img); ImageView view3
		 * = new ImageView(img);
		 * 
		 * view.setFitHeight(100); view.setFitWidth(100);
		 * view1.setFitHeight(100); view1.setFitWidth(100);
		 * view2.setFitHeight(100); view2.setFitWidth(100);
		 * view3.setFitHeight(100); view3.setFitWidth(100);
		 * 
		 * view.setX(20); view1.setX(24);
		 * 
		 * view.setY(22); view1.setY(24);
		 * 
		 * view2.setX(24); view3.setX(24);
		 * 
		 * view2.setY(26); view3.setY(24);
		 * 
		 * Circle circle = new Circle(200); Circle circle1 = new Circle(200);
		 * Circle circle2 = new Circle(200); Circle circle3 = new Circle(200);
		 * 
		 * circle.setTranslateX(200); circle.setTranslateY(200);
		 * circle1.setTranslateX(200); circle1.setTranslateY(200);
		 * circle2.setTranslateX(200); circle2.setTranslateY(200);
		 * circle3.setTranslateX(200); circle3.setTranslateY(200);
		 * 
		 * circle.fillProperty().set(Color.ALICEBLUE);
		 * circle1.fillProperty().set(Color.ALICEBLUE);
		 * circle2.fillProperty().set(Color.ALICEBLUE);
		 * circle3.fillProperty().set(Color.ALICEBLUE);
		 * 
		 * Rectangle rect = new Rectangle(20,100,600,300); Rectangle rect1 = new
		 * Rectangle(22,102,600,300); Rectangle rect2 = new
		 * Rectangle(24,104,600,300); Rectangle rect3 = new
		 * Rectangle(26,106,600,300);
		 * 
		 * rect.fillProperty().set(Color.ALICEBLUE);
		 * rect1.fillProperty().set(Color.ALICEBLUE);
		 * rect2.fillProperty().set(Color.ALICEBLUE);
		 * rect3.fillProperty().set(Color.ALICEBLUE);
		 * 
		 * // circle.fillProperty().set(Color.BLUE);
		 * 
		 * // TODO Auto-generated method stub PathTransition transition = new
		 * PathTransition(); //transition.setPath(rect);
		 * transition.setPath(circle); transition.setNode(view);
		 * transition.setDuration(Duration.seconds(6));
		 * //transition.setCycleCount(PathTransition.INDEFINITE);
		 * transition.play();
		 * 
		 * PathTransition transition1 = new PathTransition();
		 * //transition1.setPath(rect1); transition1.setPath(circle1);
		 * transition1.setNode(view1);
		 * transition1.setDuration(Duration.seconds(10));
		 * //transition1.setCycleCount(PathTransition.INDEFINITE);
		 * transition1.play();
		 * 
		 * PathTransition transition2 = new PathTransition();
		 * //transition2.setPath(rect2); transition2.setPath(circle2);
		 * transition2.setNode(view2);
		 * transition2.setDuration(Duration.seconds(12)); transition2.play();
		 * 
		 * PathTransition transition3 = new PathTransition();
		 * transition3.setPath(circle3); //transition3.setPath(rect3);
		 * transition3.setNode(view3);
		 * transition3.setDuration(Duration.seconds(13)); //
		 * transition3.setCycleCount(PathTransition.INDEFINITE);
		 * transition3.play();
		 * 
		 * 
		 * 
		 * // pane.getChildren().add(circle);
		 * 
		 * pane.getChildren().add(rect); pane.getChildren().add(rect1);
		 * pane.getChildren().add(rect2); pane.getChildren().add(rect3);
		 * 
		 * pane.getChildren().add(circle); pane.getChildren().add(circle1);
		 * pane.getChildren().add(circle2); pane.getChildren().add(circle3);
		 * pane.getChildren().add(view); pane.getChildren().add(view1);
		 * pane.getChildren().add(view2); pane.getChildren().add(view3);
		 */
		Scene scene = new Scene(pane, 650, 600);
		primaryStage.setTitle("PathTransitionDemo");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] cmdArgs) {
		launch(cmdArgs);
	}

}
