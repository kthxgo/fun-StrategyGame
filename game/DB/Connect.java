package DB;

import java.sql.*;

public class Connect {

	private Statement stmt;
	private Connection con1;
	
	public Connect() throws Exception  {
		Class.forName("com.mysql.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost/strategygame";
		con1 = DriverManager.getConnection(url, "root", "");
		stmt = con1.createStatement();
		
		
	}

	public void closeIt(Connect con) throws SQLException {
		con1.close();
		
	}
	
	public Statement getstmt() {
		return stmt;
	}
	
	public Connection getConnection() {
		return con1;
	}
	
}
