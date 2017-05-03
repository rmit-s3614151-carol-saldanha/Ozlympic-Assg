package rmit.java.assignment.database;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Connection {
	
	   // JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "root";
		
	   Connection con = null ;
		Statement st  = null ;
		
	public void createConnection() {
		

	}
}
