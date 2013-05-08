package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import GUI.Startup;

import model.Village;
import model.buildings.Building;

import server.ServerInterface;

public class Client {

	private String username;
	
	public static void main(String[] args) {
		Client client = new Client();
		client.start();
	}

	private void start() {
		try {
			Registry myRegistry = LocateRegistry.getRegistry("192.168.56.1", 4242);
			ServerInterface impl = (ServerInterface) myRegistry.lookup("Game");
			System.out.println("connected ...");
			
			Startup start = new Startup(impl);
			start.start();
			username = start.getUsername();
			if(start.isFlag()) {
				System.out.println("los gehts");
			} else {
				System.out.println("Fehler beim Anmelden!");
			}

			
//			Village vil = impl.getVillagebyKoordinates(99, 99);
//			System.out.println("Koordinaten: " + vil.getX_koord() + "/" + vil.getY_koord());
//			System.out.println("Besitzer: " + vil.getOwner());
//			System.out.println("Dorfname: " + vil.getName());
//			System.out.println("Rohstoff 1: " + vil.getRes1()/1000 + " (+" + vil.getRes1prod() + ")");
//			System.out.println("Rohstoff 2: " + vil.getRes2()/1000 + " (+" + vil.getRes2prod() + ")");
//			System.out.println("Rohstoff 3: " + vil.getRes3()/1000 + " (+" + vil.getRes3prod() + ")");
//			System.out.println("Rohstoff 4: " + vil.getRes4()/1000 + " (+" + vil.getRes4prod() + ")");
//			ArrayList<Building> buildings = vil.getBuildings();
//			for(int i = 0; i<buildings.size(); i++) {
//				System.out.println(buildings.get(i).getName() + " -> " + buildings.get(i).getCurrentLevel());
//			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
