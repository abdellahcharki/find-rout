package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnection {

	private final String DB_URL="jdbc:mysql://localhost/trajecto?user=root";
	
    protected Connection connect = null;
    protected Statement statement = null;
    protected ResultSet resultSet = null;
    
	public MySQLConnection() throws InstantiationException, IllegalAccessException, SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
        connect = DriverManager.getConnection(DB_URL);
        statement = connect.createStatement();
	}
 
}
