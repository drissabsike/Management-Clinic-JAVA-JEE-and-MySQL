package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
	
	//Class de Connection avec MySQL
	public String driver ="com.mysql.jdbc.Driver";
	public String url = "jdbc:mysql://localhost:3306/gestion_clinique";
	public  String username ="root";
	public String password ="";
	
	public Connection getConnection() throws SQLException {
		try {
			Class.forName(driver);
		}catch(ClassNotFoundException ex) {
			System.out.println("Connection Class Erreur :"+ex.getMessage());
		}
		return DriverManager.getConnection(url,username,password);
	}
	
}
