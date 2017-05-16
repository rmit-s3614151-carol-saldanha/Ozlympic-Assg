package rmit.java.assignment.database;

// imports 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * 
 * @author Niraj Bohra
 * @version 1.0
 * @classDescription SQL Connection file is a connectivity to database
 *
 */
public class SQLConnection {

	// empty constructor

	public SQLConnection() {

	}

	/**
	 * 
	 * @return connection
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public Connection createConnection() throws SQLException, ClassNotFoundException {
		Connection connection = null;
		// ADD DATA ON SCREEN
		Class.forName("org.sqlite.JDBC");
		connection = DriverManager
				.getConnection("jdbc:sqlite:/Users/MacBook_Main/Documents/workspace/Ozlympic/Ozlympic.db");
		connection.setAutoCommit(true);
		return connection;

	}
}
