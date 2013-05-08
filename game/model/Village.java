package model;

import java.util.ArrayList;

import model.buildings.Building;
import model.buildings.Headquarter;
import model.units.Units;

public class Village {

	private int x_koord;
	private int y_koord;
	private String owner;
	private String name;
	
	//weitere Eigenschaften
	
	private int res1;
	private int res2;
	private int res3;
	private int res4;
	private int res1prod;
	private int res2prod;
	private int res3prod;
	private int res4prod;
	private long timestamp;
	
	private ArrayList<Building> buildings;
	private ArrayList<Units> units;
	
	
	public Village() {
		this.owner = "Natur";
		this.name = "Naturfeld";
	}
	
	//neues Village erstellen
	public Village(int x_koord, int y_koord, String owner) {
		this.x_koord = x_koord;
		this.y_koord = y_koord;
		this.owner = owner;
		this.name = "Neue Siedlung";
		this.res1 = 100000;
		this.res2 = 100000;
		this.res3 = 100000;
		this.res4 = 100000;
		this.res1prod = 10;
		this.res2prod = 10;
		this.res3prod = 10;
		this.res4prod = 10;
		this.timestamp = System.currentTimeMillis();
		this.buildings = new ArrayList<>();
		this.buildings.add(new Headquarter(1));
		this.units = new ArrayList<>();
	}
	
	//Getter + Setter

	public int getX_koord() {
		return x_koord;
	}

	public void setX_koord(int x_koord) {
		this.x_koord = x_koord;
	}

	public int getY_koord() {
		return y_koord;
	}

	public void setY_koord(int y_koord) {
		this.y_koord = y_koord;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRes1() {
		return res1;
	}

	public void setRes1(int res1) {
		this.res1 = res1;
	}

	public int getRes2() {
		return res2;
	}

	public void setRes2(int res2) {
		this.res2 = res2;
	}

	public int getRes3() {
		return res3;
	}

	public void setRes3(int res3) {
		this.res3 = res3;
	}

	public int getRes4() {
		return res4;
	}

	public void setRes4(int res4) {
		this.res4 = res4;
	}

	public int getRes1prod() {
		return res1prod;
	}

	public void setRes1prod(int res1prod) {
		this.res1prod = res1prod;
	}

	public int getRes2prod() {
		return res2prod;
	}

	public void setRes2prod(int res2prod) {
		this.res2prod = res2prod;
	}

	public int getRes3prod() {
		return res3prod;
	}

	public void setRes3prod(int res3prod) {
		this.res3prod = res3prod;
	}

	public int getRes4prod() {
		return res4prod;
	}

	public void setRes4prod(int res4prod) {
		this.res4prod = res4prod;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public ArrayList<Building> getBuildings() {
		return buildings;
	}

	public void setBuildings(ArrayList<Building> buildings) {
		this.buildings = buildings;
	}
	
}
