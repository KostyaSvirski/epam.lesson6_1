package by.svirski.lesson6_1.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectorDB {
	
	//FIXME 23.07.2020 1:58 not working with Strings
	public static Connection getConnection() throws SQLException {		
		
		ResourceBundle rb = ResourceBundle.getBundle("database");
		String url = rb.getString("db.url");
		String user = rb.getString("db.user");
		String pass = rb.getString("db.password");
		Connection cn = DriverManager.getConnection(url, "root", "root");
		return cn;
	}
}
