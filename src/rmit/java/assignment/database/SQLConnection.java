package rmit.java.assignment.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLConnection {

	// public static final String DB_URL = "jdbc:sqlite:Ozlympic.db";
	// jdbc:sqlite:/Users/MacBook_Main/Documents/workspace/Ozlympic/ozlympic.db"

	public SQLConnection() {

	}

	public boolean createConnection() throws SQLException {
		Connection connection = null;

		try {

			Class.forName("org.sqlite.JDBC");
			// ADD DATA ON SCREEN
			connection = DriverManager.getConnection("jdbc:sqlite:/Users/MacBook_Main/Documents/workspace/Ozlympic/Ozlympic.db");
			connection.setAutoCommit(false);

			
			// create a Statement from the connection
			Statement statement = connection.createStatement();
			

			// insert the data
			statement.executeUpdate("INSERT INTO participants " + "VALUES ('oz1000' , 'swimmers','Niraj Bohra','22','VIC');");
			statement.executeUpdate("INSERT INTO participants " + "VALUES ('oz1000' ,'swimmers','Niraj Bohra','22','VIC');");
			statement.executeUpdate("INSERT INTO participants " + "VALUES ('oz1001','swimmers','Eashan Tilve','25','VIC');");
			statement.executeUpdate("INSERT INTO participants " + "VALUES ('oz1002','swimmers','Deep Sharna','26','SA');");
			statement.executeUpdate("INSERT INTO participants " + "VALUES ('oz1003','swimmers','Soumil Roy','29','NSW');");
			statement.executeUpdate("INSERT INTO participants " + "VALUES ('oz1004','swimmers','Naresh Devlani','21','WA');");
			statement.executeUpdate("INSERT INTO participants " + "VALUES ('oz1005','swimmers','Rohan Bopana','23','WA');");
			statement.executeUpdate("INSERT INTO participants " + "VALUES ('oz1006','swimmers','Shivang Desai','22','SA');");
			statement.executeUpdate("INSERT INTO participants " + "VALUES ('oz1007','swimmers','Siddarth Shewale','29','NSW');");
			statement.executeUpdate("INSERT INTO participants " + "VALUES ('oz1008','sprinters','Lakshay','22','VIC');");
			statement.executeUpdate("INSERT INTO participants " + "VALUES ('oz1008','sprinters','Lakshay','22','VIC');");
			statement.executeUpdate("INSERT INTO participants " + "VALUES ('oz1008','sprinters','Lakshay','22','VIC');");
			statement.executeUpdate("INSERT INTO participants " + "VALUES ('oz1008','sprinters','Lakshay','22','VIC');");
			statement.executeUpdate("INSERT INTO participants " + "VALUES ('oz1008','sprinters','Lakshay','22','VIC');");
			statement.executeUpdate("INSERT INTO participants " + "VALUES ('oz1008','sprinters','Lakshay','22','VIC');");
			statement.executeUpdate("INSERT INTO participants " + "VALUES ('oz1008','sprinters','Lakshay','22','VIC');");
			statement.executeUpdate("INSERT INTO participants " + "VALUES ('oz1008','sprinters','Lakshay','22','VIC');");
			statement.executeUpdate("INSERT INTO participants " + "VALUES ('oz1009','sprinters','Ramcharan','23','VIC');");
			statement.executeUpdate("INSERT INTO participants " + "VALUES ('oz1010','sprinters','Robert','25','SA');");
			statement.executeUpdate("INSERT INTO participants " + "VALUES ('oz1011','sprinters','Sachin','29','SA');");
			statement.executeUpdate("INSERT INTO participants " + "VALUES ('oz1012','sprinters','Dhoni','26','QLD');");
			statement.executeUpdate("INSERT INTO participants " + "VALUES ('oz1013','sprinters','Yogesh','24','QLD');");
			statement.executeUpdate("INSERT INTO participants " + "VALUES ('oz1014','sprinters','Shane','24','TAS');");
			statement.executeUpdate("INSERT INTO participants " + "VALUES ('oz1015','sprinters','Steve','23','WA');");
			statement.executeUpdate("INSERT INTO participants " + "VALUES ('oz1016','sprinters','Rahane','20','WA');");
			statement.executeUpdate("INSERT INTO participants " + "VALUES ('oz1017','sprinters','Symonds','29','TAS');");
			statement.executeUpdate("INSERT INTO participants " + "VALUES ('oz1018','cyclists','Saske','26','NSW');");
			statement.executeUpdate("INSERT INTO participants " + "VALUES ('oz1019','cyclists','Madara','24','SA');");
			statement.executeUpdate("INSERT INTO participants " + "VALUES ('oz1020','cyclists','Aditya','26','NSW');");
			statement.executeUpdate("INSERT INTO participants " + "VALUES ('oz1021','cyclists','Rajesh','24','SA');");
			statement.executeUpdate("INSERT INTO participants " + "VALUES ('oz1022','cyclists','Mitchel','26','NSW');");
			statement.executeUpdate("INSERT INTO participants " + "VALUES ('oz1023','cyclists','Raymond','24','SA');");
			statement.executeUpdate("INSERT INTO participants " + "VALUES ('oz1024','cyclists','Virat','26','NSW');");
			statement.executeUpdate("INSERT INTO participants " + "VALUES ('oz1025','cyclists','Arjun','24','SA');");
			statement.executeUpdate("INSERT INTO participants " + "VALUES ('oz1026','cyclists','Satya','22','QLD');");
		    statement.executeUpdate("INSERT INTO participants " + "VALUES ('oz1020','cyclists','Aditya','26','NSW');");
			statement.executeUpdate("INSERT INTO participants " + "VALUES ('oz1020','cyclists',' Aditya', '26' , 'NSW');");
			statement.executeUpdate("INSERT INTO participants " + "VALUES ('oz1020','cyclists','Aditya','26','NSW');");
			statement.executeUpdate("INSERT INTO participants " + "VALUES ('oz1027','cyclists','Doremon', '23','TAS');");
			statement.executeUpdate("INSERT INTO participants " + "VALUES ('oz1028','cyclists','Abhijeet','22','QLD');");
			statement.executeUpdate("INSERT INTO participants " + "VALUES ('oz1029','cyclists','Luke','23','TAS');");
			statement.executeUpdate("INSERT INTO participants " + "VALUES ('oz1030','cyclists','Root','22','QLD');");
			statement.executeUpdate("INSERT INTO participants " + "VALUES ('oz1031','cyclists','David','23','TAS');");
			statement.executeUpdate("INSERT INTO participants " + "VALUES ('oz1032','super','Satya','22','QLD');");
			statement.executeUpdate("INSERT INTO participants " + "VALUES ('oz1033','super','Doremon','23','TAS');");
			statement.executeUpdate("INSERT INTO participants " + "VALUES ('oz1034','super','Abhijeet','22','QLD');");
			statement.executeUpdate("INSERT INTO participants " + "VALUES ('oz1033','super','Doremon','23','TAS');");
			statement.executeUpdate("INSERT INTO participants " + "VALUES ('oz1033','super','Doremon','23','TAS');");
			statement.executeUpdate("INSERT INTO participants " + "VALUES ('oz1033','super','Doremon','23','TAS');");
			statement.executeUpdate("INSERT INTO participants " + "VALUES ('oz1034','super','Abhijeet','22','QLD');");
			statement.executeUpdate("INSERT INTO participants " + "VALUES ('oz1035','super','Luke','23','TAS');");
			statement.executeUpdate("INSERT INTO participants " + "VALUES ('oz1036','super','Root','22','QLD');");
			statement.executeUpdate("INSERT INTO participants " + "VALUES ('oz1037','super','David','23','TAS');");
			statement.executeUpdate("INSERT INTO participants " + "VALUES ('oz1038','official','RAMLAL','42','WA');");
			statement.executeUpdate("INSERT INTO participants " + "VALUES ('oz1039','official','Google','42','QLD');");
			statement.executeUpdate("INSERT INTO participants " + "VALUES ('oz1040','official','Facebook','42','TAS');");
		    statement.executeUpdate("INSERT INTO participants " + "VALUES ('oz1041','official','Windows','42','SA');");
		    statement.executeUpdate("INSERT INTO participants " + "VALUES ('oz1042','official','Carol', '42','VIC');");
	
		    if (connection.isClosed()) {
				return false;
			} else {
				return true;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally {
	
			connection.close();
		
		}
		
	}

}
