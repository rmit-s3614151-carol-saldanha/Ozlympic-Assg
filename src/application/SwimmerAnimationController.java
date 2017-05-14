package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import rmit.java.assignment.model.Swimming;

public class SwimmerAnimationController extends RefereeController implements Initializable {

    @FXML
    private ImageView participant2;

    @FXML
    private ImageView participant1;

    @FXML
    private ImageView swimPath;

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
    
    private Swimming swimming;
    
    public void initialize(URL url, ResourceBundle rb) {
    	
    	
    	
    	if(driver.displaySwimmingResults().size() == 8)
    	{
    	TranslateTransition transition1 = new TranslateTransition();
    	transition1.setDuration(Duration.seconds(5));
    	transition1.setNode(participant1);
    	transition1.setToY(-435);
    	
    	TranslateTransition transition2 = new TranslateTransition();
    	transition2.setDuration(Duration.seconds(10));
    	transition2.setNode(participant2);
    	transition2.setToY(-435);
    	
    	TranslateTransition transition3 = new TranslateTransition();
    	transition3.setDuration(Duration.seconds(6));
    	transition3.setNode(participant3);
    	transition3.setToY(-435);
    	
    	TranslateTransition transition4 = new TranslateTransition();
    	transition4.setDuration(Duration.seconds(7));
    	transition4.setNode(participant4);
    	transition4.setToY(-435);
    	
    	TranslateTransition transition5 = new TranslateTransition();
    	transition5.setDuration(Duration.seconds(4));
    	transition5.setNode(participant5);
    	transition5.setToY(-435);
    	
    	TranslateTransition transition6 = new TranslateTransition();
    	transition6.setDuration(Duration.seconds(11));
    	transition6.setNode(participant6);
    	transition6.setToY(-435);
    	
    	TranslateTransition transition7 = new TranslateTransition();
    	transition7.setDuration(Duration.seconds(3));
    	transition7.setNode(participant7);
    	transition7.setToY(-435);
    	
    	TranslateTransition transition8 = new TranslateTransition();
    	transition8.setDuration(Duration.seconds(12));
    	transition8.setNode(participant8);
    	transition8.setToY(-435);
    	
    	ParallelTransition parallel = new ParallelTransition(transition1,transition2,transition3,transition4,transition5,transition6,transition7,transition8);
    	parallel.play();
    	}
    	
    
    	else if(driver.displaySwimmingResults().size() == 4)
    	{
    		
    	participant5.setVisible(false);
    	participant6.setVisible(false);
    	participant7.setVisible(false);
    	participant8.setVisible(false);
    	
    	TranslateTransition transition1 = new TranslateTransition();
    	transition1.setDuration(Duration.seconds(3));
    	transition1.setNode(participant1);
    	transition1.setToY(-435);
    	
    	TranslateTransition transition2 = new TranslateTransition();
    	transition2.setDuration(Duration.seconds(12));
    	transition2.setNode(participant2);
    	transition2.setToY(-435);
    	
    	TranslateTransition transition3 = new TranslateTransition();
    	transition3.setDuration(Duration.seconds(12));
    	transition3.setNode(participant3);
    	transition3.setToY(-435);
    	
    	
    	TranslateTransition transition4 = new TranslateTransition();
    	transition4.setDuration(Duration.seconds(12));
    	transition4.setNode(participant4);
    	transition4.setToY(-435);
    	ParallelTransition parallel = new ParallelTransition(transition1,transition2,transition3,transition4);
    	parallel.play();
    }
    	if(driver.displaySwimmingResults().size() == 5)
    	{
    	participant6.setVisible(false);
        participant7.setVisible(false);
        participant8.setVisible(false);
    	TranslateTransition transition1 = new TranslateTransition();
    	transition1.setDuration(Duration.seconds(5));
    	transition1.setNode(participant1);
    	transition1.setToY(-435);
    	
    	TranslateTransition transition2 = new TranslateTransition();
    	transition2.setDuration(Duration.seconds(10));
    	transition2.setNode(participant2);
    	transition2.setToY(-435);
    	
    	TranslateTransition transition3 = new TranslateTransition();
    	transition3.setDuration(Duration.seconds(6));
    	transition3.setNode(participant3);
    	transition3.setToY(-435);
    	
    	TranslateTransition transition4 = new TranslateTransition();
    	transition4.setDuration(Duration.seconds(7));
    	transition4.setNode(participant4);
    	transition4.setToY(-435);
    	
    	TranslateTransition transition5 = new TranslateTransition();
    	transition5.setDuration(Duration.seconds(4));
    	transition5.setNode(participant5);
    	transition5.setToY(-435);
    	
    	
    	ParallelTransition parallel = new ParallelTransition(transition1,transition2,transition3,transition4,transition5);
    	parallel.play();
    	}
    	if(driver.displaySwimmingResults().size() == 6)
    	{
    	participant7.setVisible(false);
        participant8.setVisible(false);
    	TranslateTransition transition1 = new TranslateTransition();
    	transition1.setDuration(Duration.seconds(5));
    	transition1.setNode(participant1);
    	transition1.setToY(-435);
    	
    	TranslateTransition transition2 = new TranslateTransition();
    	transition2.setDuration(Duration.seconds(10));
    	transition2.setNode(participant2);
    	transition2.setToY(-435);
    	
    	TranslateTransition transition3 = new TranslateTransition();
    	transition3.setDuration(Duration.seconds(6));
    	transition3.setNode(participant3);
    	transition3.setToY(-435);
    	
    	TranslateTransition transition4 = new TranslateTransition();
    	transition4.setDuration(Duration.seconds(7));
    	transition4.setNode(participant4);
    	transition4.setToY(-435);
    	
    	TranslateTransition transition5 = new TranslateTransition();
    	transition5.setDuration(Duration.seconds(4));
    	transition5.setNode(participant5);
    	transition5.setToY(-435);
    	
    	TranslateTransition transition6 = new TranslateTransition();
    	transition6.setDuration(Duration.seconds(11));
    	transition6.setNode(participant6);
    	transition6.setToY(-435);
    	
    	
    	ParallelTransition parallel = new ParallelTransition(transition1,transition2,transition3,transition4,transition5,transition6);
    	parallel.play();
    	}
    	if(driver.displaySwimmingResults().size() == 7)
    	{
    		
        participant8.setVisible(false);
    	TranslateTransition transition1 = new TranslateTransition();
    	transition1.setDuration(Duration.seconds(5));
    	transition1.setNode(participant1);
    	transition1.setToY(-435);
    	
    	TranslateTransition transition2 = new TranslateTransition();
    	transition2.setDuration(Duration.seconds(10));
    	transition2.setNode(participant2);
    	transition2.setToY(-435);
    	
    	TranslateTransition transition3 = new TranslateTransition();
    	transition3.setDuration(Duration.seconds(6));
    	transition3.setNode(participant3);
    	transition3.setToY(-435);
    	
    	TranslateTransition transition4 = new TranslateTransition();
    	transition4.setDuration(Duration.seconds(7));
    	transition4.setNode(participant4);
    	transition4.setToY(-435);
    	
    	TranslateTransition transition5 = new TranslateTransition();
    	transition5.setDuration(Duration.seconds(4));
    	transition5.setNode(participant5);
    	transition5.setToY(-435);
    	
    	TranslateTransition transition6 = new TranslateTransition();
    	transition6.setDuration(Duration.seconds(11));
    	transition6.setNode(participant6);
    	transition6.setToY(-435);
    	
    	TranslateTransition transition7 = new TranslateTransition();
    	transition7.setDuration(Duration.seconds(3));
    	transition7.setNode(participant7);
    	transition7.setToY(-435);
    	
    	
    	ParallelTransition parallel = new ParallelTransition(transition1,transition2,transition3,transition4,transition5,transition6,transition7);
    	parallel.play();
    	}
}

}
