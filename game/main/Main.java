package main;


import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import server.Server;
import server.ServerImpl;
import server.ServerInterface;

import model.Village;
import model.buildings.Building;
import DB.BuildingOperations;
import DB.Connect;
import DB.UserOperations;
import DB.VillageOperations;
import GUI.Startup;

public class Main {

	public static void main(String args[]) throws Exception {
		System.setSecurityManager(new RMISecurityManager());
		Connect con = new Connect();
		
//		Startup start = new Startup(con);
//		start.start();
//		if(start.isFlag()) {
//			System.out.println("Ab ins Dorf");
//		} else {
//			System.out.println("fail");
//		}
//		
//		String username = start.getUsername();
		
		UserOperations uo = new UserOperations(con);
		VillageOperations vo = new VillageOperations(con);
		BuildingOperations bo = new BuildingOperations(con);
//		
//		Village vil = vo.getVillagebyKoordinates(99, 99);
//		System.out.println("Koordinaten: " + vil.getX_koord() + "/" + vil.getY_koord());
//		System.out.println("Besitzer: " + vil.getOwner());
//		System.out.println("Dorfname: " + vil.getName());
//		System.out.println("Rohstoff 1: " + vil.getRes1()/1000 + " (+" + vil.getRes1prod() + ")");
//		System.out.println("Rohstoff 2: " + vil.getRes2()/1000 + " (+" + vil.getRes2prod() + ")");
//		System.out.println("Rohstoff 3: " + vil.getRes3()/1000 + " (+" + vil.getRes3prod() + ")");
//		System.out.println("Rohstoff 4: " + vil.getRes4()/1000 + " (+" + vil.getRes4prod() + ")");
//		ArrayList<Building> buildings = vil.getBuildings();
//		for(int i = 0; i<buildings.size(); i++) {
//			System.out.println(buildings.get(i).getName() + " -> " + buildings.get(i).getCurrentLevel());
//		}
		
//		vo.changeVillageName(99, 99, "Musterstadt #2");

//		bo.upgradeBuilding(99, 99, 1);
		
//		vo.createNewVillage(99, 99, username);
		
		Server server = new Server();
		server.startServer(uo, vo, bo, con);
		
		con.closeIt(con);
	}
	
}
