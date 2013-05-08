package DB;

import java.sql.*;

public class BuildingOperations {

	private Statement stmt;
	private ResultSet rs;
	private Connection con;
	
	public BuildingOperations(Connect con1) {
		stmt = con1.getstmt();
		con = con1.getConnection();
	}
	
	public boolean downgradeBuilding(int x_koord, int y_koord, int buildingID) throws SQLException {
		String sql = "SELECT building? FROM villages WHERE x_koord = ? && y_koord = ?";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1, buildingID);
		preparedStatement.setInt(2, x_koord);
        preparedStatement.setInt(3, y_koord);
        rs = preparedStatement.executeQuery();
        
        int build = -1;
        while(rs.next()) {
        	build = rs.getInt(1);
        }
		
        if(build!=-1) {
        	build--;
        	String sql2 = "UPDATE villages SET building? = ? WHERE x_koord = ? && y_koord = ?";
        	PreparedStatement preparedStatement2 = con.prepareStatement(sql2);
        	preparedStatement2.setInt(1, buildingID);
        	preparedStatement2.setInt(2, build);
        	preparedStatement2.setInt(3, x_koord);
        	preparedStatement2.setInt(4, y_koord);
        	preparedStatement2.executeUpdate();
        	return true;
        }
        
		return false;
	}
	
	public boolean upgradeBuilding(int x_koord, int y_koord, int buildingID) throws SQLException {
		String sql = "SELECT building? FROM villages WHERE x_koord = ? && y_koord = ?";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1, buildingID);
		preparedStatement.setInt(2, x_koord);
        preparedStatement.setInt(3, y_koord);
        rs = preparedStatement.executeQuery();
        
        int build = -1;
        while(rs.next()) {
        	build = rs.getInt(1);
        }
		
        if(build!=-1) {
        	build++;
        	String sql2 = "UPDATE villages SET building? = ? WHERE x_koord = ? && y_koord = ?";
        	PreparedStatement preparedStatement2 = con.prepareStatement(sql2);
        	preparedStatement2.setInt(1, buildingID);
        	preparedStatement2.setInt(2, build);
        	preparedStatement2.setInt(3, x_koord);
        	preparedStatement2.setInt(4, y_koord);
        	preparedStatement2.executeUpdate();
        	return true;
        }
        
		return false;
	}
	
}
