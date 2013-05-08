package GUI;

import java.rmi.RemoteException;

import javax.swing.JFrame;

import DB.BuildingOperations;
import DB.Connect;
import DB.UserOperations;
import DB.VillageOperations;

import server.ServerImpl;

public class TestGUI {

	public static void main(String[] args) throws Exception {
		//nur GUI-Test
//		new GUI (null);
		
		//mit Funktion
		Connect con = new Connect();
		UserOperations uo = new UserOperations(con);
		VillageOperations vo = new VillageOperations(con);
		BuildingOperations bo = new BuildingOperations(con);
		new GUI(new ServerImpl(uo, vo, bo, con));
	}

}
