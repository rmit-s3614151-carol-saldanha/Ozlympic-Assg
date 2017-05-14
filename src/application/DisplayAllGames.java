package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import rmit.java.assignment.database.SQLConnection;
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
    
    private SQLConnection con = new SQLConnection();
    private Connection connection = con.createConnection();

    @FXML
    void homeMenu(ActionEvent event) throws Exception {
    	Utility util =  new Utility();
    	util.displayUX(OzlympicController.class, "application/Ozlympic.fxml", null);
    }
    
    
	public void initialize(URL url, ResourceBundle rb) {
	
		
	}
    
	void display(){
		ArrayList<String> results = new ArrayList<String>();
		// GET CONNECTION 
				try {
					Statement stm = connection.createStatement();
					String sql = "SELECT * FROM RESULTS";
					ResultSet rs =stm.executeQuery(sql);
					
					String aID;
					String oID ;
					String gID;
					float time;
					String points;
					
					while (rs.next()) {
						gID = rs.getString("gameID"); 
						oID = rs.getString("officialID");
						aID = rs.getString("athleteID");
						time = rs.getFloat("Results");
						points = rs.getString("Score");
						
						System.out.println(aID +"|"+time+"|"+points);
						results.add(gID +","+oID+","+","+aID+","+","+Float.toString(time) +","+ points);
						
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				for ( int i = 0 ; i < results.size() ; i++ ){
					System.out.println();
					if ( results.get(i).contains("R")) {
						System.out.println(results.get(i));
					}
					
				}
				
	}
}