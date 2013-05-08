package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import DB.BuildingOperations;
import DB.Connect;
import DB.UserOperations;
import DB.VillageOperations;


public class Server {

	public Server() {
		
	}
	
	public boolean startServer(UserOperations uo, VillageOperations vo, BuildingOperations bo, Connect con) throws RemoteException {
		try {
			Registry registry = LocateRegistry.createRegistry(4242);
			ServerImpl obj = new ServerImpl(uo, vo, bo, con);
			registry.rebind("Game", obj);
			System.out.println("Server laeuft ...");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}
	
}
