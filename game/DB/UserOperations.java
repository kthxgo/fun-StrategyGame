package DB;

import java.sql.*;
import DB.Connect;

public class UserOperations {

	private Statement stmt;
	private ResultSet rs;
	private Connection con;
	
	public UserOperations(Connect con1) {
		con = con1.getConnection();
		stmt = con1.getstmt();
	}
	
	public int checkUser(String nameIn, String passIn) throws SQLException {
		rs = stmt.executeQuery("SELECT name, pass FROM users");
		String name = "", pass = "";
		while(rs.next()) {
			name = rs.getString("name");
			pass = rs.getString("pass");
			if(name.equals(nameIn)) {
				if(pass.equals(passIn)) {
					return 1;
				} else {
					return 0;
				}
			}
		}
		
		return -1;
	}
	
	public int registerUser(String nameIn, String passIn) throws SQLException {
		rs = stmt.executeQuery("SELECT name FROM users");
		String name = "";
		while(rs.next()) {
			name = rs.getString("name");
			if(name.equals(nameIn)) {
				return 0;
			}
		}
		
		
		String sql = "INSERT INTO users (name, pass) VALUES(?, ?)";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, nameIn);
        preparedStatement.setString(2, passIn);
        preparedStatement.executeUpdate();
		
        
		int check = checkUser(nameIn, passIn);
		if(check == 1) {
			return 1;
		} else {
			return -1;
		}
	}
}
