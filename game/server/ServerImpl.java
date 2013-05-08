package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;

import DB.BuildingOperations;
import DB.Connect;
import DB.UserOperations;
import DB.VillageOperations;

import model.Village;

public class ServerImpl extends UnicastRemoteObject implements ServerInterface {

	private UserOperations uo;
	private VillageOperations vo;
	private BuildingOperations bo;
	private Connect con;

	public ServerImpl(UserOperations uo, VillageOperations vo, BuildingOperations bo, Connect con) throws RemoteException {
		this.uo = uo; 
		this.vo = vo;
		this.bo = bo;
		this.con = con;
	}


	public ServerImpl() throws RemoteException {
	}
	
	//UserOperations
	public int checkUser(String nameIn, String passIn) throws RemoteException {
		int ret = -1;
		try {
			ret = uo.checkUser(nameIn, passIn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}


	public int registerUser(String nameIn, String passIn) throws RemoteException {
		int ret = -1;
		try {
			ret = uo.registerUser(nameIn, passIn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}


	//VillageOperations
	public Village getVillagebyKoordinates(int x_koord, int y_koord) throws RemoteException {
		try {
			Village vil = vo.getVillagebyKoordinates(x_koord, y_koord);
			return vil;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	public boolean createNewVillage(int x_koord, int y_koord, String owner) throws RemoteException {
		try {
			if(vo.createNewVillage(x_koord, y_koord, owner)) {
				return true;
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


	public boolean changeVillageName(int x_koord, int y_koord, String name) throws RemoteException {
		try {
			if(vo.changeVillageName(x_koord, y_koord, name)) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//BuildingOperations

	public boolean downgradeBuilding(int x_koord, int y_koord, int buildingID) throws RemoteException {
		try {
			if(bo.downgradeBuilding(x_koord, y_koord, buildingID)) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean upgradeBuilding(int x_koord, int y_koord, int buildingID) throws RemoteException {
		try {
			if(bo.upgradeBuilding(x_koord, y_koord, buildingID)) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
