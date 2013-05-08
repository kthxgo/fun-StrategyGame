package GUI;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.Scanner;

import server.ServerInterface;

import DB.Connect;
import DB.UserOperations;

public class Startup {
	
	private ServerInterface impl;
	private boolean flag;
	private String username;
	

	public Startup(ServerInterface impl) throws SQLException {
		this.impl = impl;
	}
	
	public void start() throws SQLException, RemoteException {
		int i;
		
		Scanner keyboardReader = new Scanner(System.in);
		
		System.out.println("#1 Einloggen");
		System.out.println("#2 Registrieren");
		i = keyboardReader.nextInt();
				
		switch(i) {
		case 1: flag = login(); break;
		case 2: flag = register(); break;
		}
		
		if(!flag) {
			start();
		}
	}

	public boolean login() throws SQLException, RemoteException {
		String name, pass;
		
		Scanner keyboardReader = new Scanner(System.in);
		
		System.out.println("Login: Name eingeben: ");
		name = keyboardReader.nextLine();
		
		System.out.println("Login: Passwort eingeben: ");
		pass = keyboardReader.nextLine();
		
		int check = impl.checkUser(name, pass);
		if(check == 1) {
			this.username = name;
			System.out.println("Login erfolgreich!");
			return true;
		} else if(check == 0) {
			System.out.println("Passwort falsch!");
			return false;
		} else if(check == -1) {
			System.out.println("Login fehlerhaft!");
			return false;
		}
		return false;
	}
	
	public boolean register() throws SQLException, RemoteException {
		String name, pass;
		
		Scanner keyboardReader = new Scanner(System.in);
		
		System.out.println("Name eingeben: ");
		name = keyboardReader.nextLine();
		
		System.out.println("Passwort eingeben: ");
		pass = keyboardReader.nextLine();
		int check = impl.registerUser(name, pass);
		if(check == 1) {
			System.out.println("Anmeldung erfolgreich!");
			return true;
		} else if(check == 0) {
			System.out.println("Nutzername bereits vergeben!");
			return false;
		} else if(check == -1) {
			System.out.println("Registrierung fehlerhaft!");
			return false;
		}
		return false;
	}
	
	public boolean isFlag() {
		return flag;
	}
	
	public String getUsername() {
		return username;
	}
	
}
