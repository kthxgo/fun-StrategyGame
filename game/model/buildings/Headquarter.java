package model.buildings;

public class Headquarter extends Building {

	//Gebaeude neu bauen
	public Headquarter() {
		this.id = 1;
		this.name = "Rathaus";
		this.currentLevel = 1;
		this.maxLevel = 10;
//		this.neededRes = new int[maxLevel][4];
		int[][] cost = {
				{10, 10, 10, 10},
				{20, 20, 20, 20},
				{30, 30, 30, 30},
				{40, 40, 40, 40},
				{50, 50, 50, 50},
				{60, 60, 60, 60},
				{70, 70, 70, 70},
				{80, 80, 80, 80},
				{90, 90, 90, 90},
				{100, 100, 100, 100},
				};
		this.neededRes = cost;
		int[] time = {10000, 20000, 30000, 40000, 50000, 60000, 70000, 80000, 90000, 100000};
		this.neededTime = time;
	}
	
	//bereits gebautes Gebaeude
	public Headquarter(int currentLevel) {
		this.id = 1;
		this.name = "Rathaus";
		this.currentLevel = currentLevel;
		this.maxLevel = 10;
		int[][] cost = {
				{10, 10, 10, 10},
				{20, 20, 20, 20},
				{30, 30, 30, 30},
				{40, 40, 40, 40},
				{50, 50, 50, 50},
				{60, 60, 60, 60},
				{70, 70, 70, 70},
				{80, 80, 80, 80},
				{90, 90, 90, 90},
				{100, 100, 100, 100},
				};
		this.neededRes = cost;
		int[] time = {10000, 20000, 30000, 40000, 50000, 60000, 70000, 80000, 90000, 100000};
		this.neededTime = time;
	}
	
}
