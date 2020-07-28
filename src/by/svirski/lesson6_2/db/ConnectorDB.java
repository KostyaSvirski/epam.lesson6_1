package by.svirski.lesson6_2.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectorDB {
	
	public static Connection getConnection() throws SQLException {		
		ResourceBundle rb = ResourceBundle.getBundle("database");
		String url = rb.getString("db.url");
		Connection cn = DriverManager.getConnection(url, "root", "root");
		return cn;
	}
}
