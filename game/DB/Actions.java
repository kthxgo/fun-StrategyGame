package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Actions {

//	Später mal für Zeitliche Aktionen
//	
//	private Statement stmt;
//	private ResultSet rs;
//	private Connection con;
//	
//	public Actions(Connect con1) {
//		stmt = con1.getstmt();
//		con = con1.getConnection();
//	}
//	
//	public boolean checkActions(int x_koord, int y_koord) throws SQLException {
//		String sql = "SELECT action1ID, action1Ready FROM villages WHERE x_koord = ? && y_koord = ?";
//		PreparedStatement preparedStatement = con.prepareStatement(sql);
//        preparedStatement.setInt(1, x_koord);
//        preparedStatement.setInt(2, y_koord);
//        rs = preparedStatement.executeQuery();
//		
//        int action1ID = -1;
//        long action1Ready = -1;
//        while(rs.next()) {
//			action1ID = rs.getInt("action1ID");
//			action1Ready = rs.getLong("action1Ready");
//        }
//        if(action1Ready!=0 && action1Ready<System.currentTimeMillis()) {
//        	executeAction(action1ID);
//        }
//		return false;
//	}
//
//	private void executeAction(int action1ID) {
//		switch(action1ID) {
//		case 1: 
//		}
//	}


}
