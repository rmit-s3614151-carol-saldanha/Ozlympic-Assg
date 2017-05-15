package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import rmit.java.assignment.database.SQLConnection;
import rmit.java.assignment.model.Athlete;

public class DisplayAllGames implements Initializable {

	@FXML
	private ListView<String> list;

	@FXML
	private Pagination pagination;

	@FXML
	private TableColumn<String, String> id;

	@FXML
	private TableColumn<Athlete, String> time;

	@FXML
	private TableView<Athlete> table;

	@FXML
	private TableColumn<Athlete, String> points;

	@FXML
	private JFXButton home;

	public int itemsPerPage() {
		return 8;
	}

	private SQLConnection con = new SQLConnection();
	private Connection connection = con.createConnection();

	ArrayList<String> running = new ArrayList<String>();
	ArrayList<String> cycling = new ArrayList<String>();
	ArrayList<String> swimming = new ArrayList<String>();

	@FXML
	void homeMenu(ActionEvent event) throws Exception {
		Utility util = new Utility();
		util.displayUX(OzlympicController.class, "application/Ozlympic.fxml", null);
	}

	public void initialize(URL url, ResourceBundle rb) {

		// GET CONNECTION
		try {
			Statement stm = connection.createStatement();
			String sql = " select * from results where score<='5'AND score>'0'; ;";
			ResultSet rs = stm.executeQuery(sql);

			String aID;
			String oID;
			String gID;
			float time;
			String points;
			ObservableList<String> rAthletes = FXCollections.observableArrayList();
			int count = 0;

			while (rs.next()) {
				gID = rs.getString("gameID");
				oID = rs.getString("officialID");
				aID = rs.getString("athleteID");
				time = rs.getFloat("Results");
				points = rs.getString("Score");

				// System.out.println(aID +"|"+time+"|"+points);
				if (gID.contains("R")) {

					

					running.add(gID +" | "+aID + " |" + Float.toString(time) + "|" + points + "\n");
					
					count++;

				}

				else if (gID.contains("S"))
					swimming.add(gID + "," + oID + "," + "," + aID + "," + "," + Float.toString(time) + "," + points);
				else if (gID.contains("C"))
					cycling.add(gID + "," + oID + "," + "," + aID + "," + "," + Float.toString(time) + "," + points);
				else
					continue;

			}

			for (int i = 0; i < running.size(); i++) {
				rAthletes.add(running.get(i));
			}
			for (int i = 0; i < cycling.size(); i++) {
				rAthletes.add(cycling.get(i));
			}
			for (int i = 0; i < swimming.size(); i++) {
				rAthletes.add(swimming.get(i));
			}

			list.setItems(rAthletes);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	void display() {

	}
}