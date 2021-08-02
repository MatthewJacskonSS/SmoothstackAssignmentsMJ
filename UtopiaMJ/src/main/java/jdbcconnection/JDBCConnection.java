package jdbcconnection;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;


public class JDBCConnection {

	public static Connection conn = null;

	public static Connection getConnection(){
		
	try {
		if (conn == null) {
			Class.forName("com.mysql.cj.jdbc.Driver");	
			 
		
			 Properties props = new Properties();
			 FileInputStream input = new FileInputStream(JDBCConnection.class.getClassLoader().getResource("connection.properties").getFile());
			 props.load(input);
			 
			 String endpoint = props.getProperty("endpoint");
			 String username = props.getProperty("username");
			 String password = props.getProperty("password");
			 
			 
			 conn = DriverManager.getConnection(endpoint, username, password);
			 conn.setAutoCommit(Boolean.FALSE);
			 //System.out.println(conn);
			 return conn;
		 } else
			 return conn;
	} catch (Exception e) {
		e.printStackTrace();
		}
		return null;
	}
}