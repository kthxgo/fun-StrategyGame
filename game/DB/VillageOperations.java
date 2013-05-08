package DB;

import java.sql.*;
import java.util.ArrayList;

import model.Village;
import model.buildings.Building;
import model.buildings.Headquarter;

public class VillageOperations {

	private Statement stmt;
	private ResultSet rs;
	private Connection con;
	
	public VillageOperations(Connect con1) {
		stmt = con1.getstmt();
		con = con1.getConnection();
	}
	
	public boolean createNewVillage(int x_koord, int y_koord, String owner) throws SQLException {
		String sql = "SELECT x_koord, y_koord FROM villages";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
        rs = preparedStatement.executeQuery();
        int x = 0, y = 0;
        while(rs.next()) {
        	x = rs.getInt("x_koord");
        	y = rs.getInt("y_koord");
        	if(x == x_koord && y == y_koord) {
        		return false;
        	}
        }
        
        Village vil = new Village(x_koord, y_koord, owner);
        
        String sql2 = "INSERT INTO villages (x_koord, y_koord, owner, name, res1, res2, res3, res4, res1prod, res2prod, res3prod, res4prod, timestamp, building1) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement preparedStatement2 = con.prepareStatement(sql2);
        preparedStatement2.setInt(1, vil.getX_koord());
        preparedStatement2.setInt(2, vil.getY_koord());
        preparedStatement2.setString(3, vil.getOwner());
        preparedStatement2.setString(4, vil.getName());
        preparedStatement2.setInt(5, vil.getRes1());
        preparedStatement2.setInt(6, vil.getRes2());
        preparedStatement2.setInt(7, vil.getRes3());
        preparedStatement2.setInt(8, vil.getRes4());
        preparedStatement2.setInt(9, vil.getRes1prod());
        preparedStatement2.setInt(10, vil.getRes2prod());
        preparedStatement2.setInt(11, vil.getRes3prod());
        preparedStatement2.setInt(12, vil.getRes4prod());
        preparedStatement2.setLong(13, vil.getTimestamp());
        preparedStatement2.setInt(14, vil.getBuildings().get(1).getCurrentLevel());
        preparedStatement2.executeUpdate();
		
		return false;
	}
	
	public Village getVillagebyKoordinates(int x_koord, int y_koord) throws SQLException {
		Village vil = new Village();
		
		String sql = "SELECT * FROM villages WHERE x_koord = ? && y_koord = ?";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1, x_koord);
        preparedStatement.setInt(2, y_koord);
        rs = preparedStatement.executeQuery();
		
		String owner = "", name = "";
		int res1 = -1, res2 = -1, res3 = -1, res4 = -1, res1prod = -1, res2prod = -1, res3prod = -1, res4prod = -1, building1 = -1;
		long timestamp = 0;
		while(rs.next()) {
			owner = rs.getString("owner");
			name = rs.getString("name");
			res1 = rs.getInt("res1");
			res2 = rs.getInt("res2");
			res3 = rs.getInt("res3");
			res4 = rs.getInt("res4");
			res1prod = rs.getInt("res1prod");
			res2prod = rs.getInt("res2prod");
			res3prod = rs.getInt("res3prod");
			res4prod = rs.getInt("res4prod");
			timestamp = rs.getLong("timestamp");
			building1 = rs.getInt("building1");
		}
		
		vil.setX_koord(x_koord);
		vil.setY_koord(y_koord);
		if(owner.equals("")) {
			
		} else {
			vil.setOwner(owner);
			vil.setName(name);
		}
		
		if(timestamp != 0) {
			vil.setTimestamp(timestamp);
		}
		
		res1 = updateRes(res1, res1prod, timestamp);
		res2 = updateRes(res2, res2prod, timestamp);
		res3 = updateRes(res3, res3prod, timestamp);
		res4 = updateRes(res4, res4prod, timestamp);
		
		updateResDB(x_koord, y_koord, res1, res2, res3, res4);
		
		vil.setRes1(res1);
		vil.setRes2(res2);
		vil.setRes3(res3);
		vil.setRes4(res4);
		
		vil.setRes1prod(res1prod);
		vil.setRes2prod(res2prod);
		vil.setRes3prod(res3prod);
		vil.setRes4prod(res4prod);
		
		ArrayList<Building> buildings = new ArrayList<>();
		if(building1 != -1) {
			buildings.add(new Headquarter(building1));
		}
		vil.setBuildings(buildings);
		
		return vil;
	}
	
	private void updateResDB(int x_koord, int y_koord, int res1, int res2, int res3, int res4) throws SQLException {
		String sql = "UPDATE villages SET res1 = ?, res2 = ?, res3 = ?, res4 = ?, timestamp = ? WHERE x_koord = ? && y_koord = ?";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1, res1);
        preparedStatement.setInt(2, res2);
        preparedStatement.setInt(3, res3);
        preparedStatement.setInt(4, res4);
        preparedStatement.setLong(5, System.currentTimeMillis());
        preparedStatement.setInt(6, x_koord);
        preparedStatement.setInt(7, y_koord);
        preparedStatement.executeUpdate();
	}

	private int updateRes(int res, int resprod, long timestamp) {
		long missedTime = (System.currentTimeMillis() - timestamp)/1000; //verpasste Zeit in Sekunden
		double missedResProd = resprod * missedTime;
		return res + ((int) Math.round(missedResProd/3.6));
	}
	
	public boolean changeVillageName(int x_koord, int y_koord, String name) throws SQLException {
		String sql = "UPDATE villages SET name = ? WHERE x_koord = ? && y_koord = ?";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setString(1, name);
		preparedStatement.setInt(2, x_koord);
		preparedStatement.setInt(3, y_koord);
		preparedStatement.executeUpdate();
		
		return true;
	}
	
}
