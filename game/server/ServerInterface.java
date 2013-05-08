package server;

import java.rmi.*;

import model.Village;

public interface ServerInterface extends Remote {
	
	//UserOperations
	
	int checkUser(String nameIn, String passIn) throws RemoteException;
	
	int registerUser(String nameIn, String passIn) throws RemoteException;
	
	//VillageOperations
	
	Village getVillagebyKoordinates(int x_koord, int y_koord) throws RemoteException;
	
	boolean createNewVillage(int x_koord, int y_koord, String owner) throws RemoteException;
	
	boolean changeVillageName(int x_koord, int y_koord, String name) throws RemoteException;
	
	//BuildingOperations
	
	boolean downgradeBuilding(int x_koord, int y_koord, int buildingID) throws RemoteException;
	
	boolean upgradeBuilding(int x_koord, int y_koord, int buildingID) throws RemoteException;
}
