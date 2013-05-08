package model.buildings;

public abstract class Building {

	protected int id;
	protected String name;
	protected int currentLevel;
	protected int maxLevel;
	protected int[][] neededRes;
	protected int[] neededTime;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCurrentLevel() {
		return currentLevel;
	}
	public void setCurrentLevel(int currentLevel) {
		this.currentLevel = currentLevel;
	}
	public int getMaxLevel() {
		return maxLevel;
	}
	public void setMaxLevel(int maxLevel) {
		this.maxLevel = maxLevel;
	}
	public int[][] getNeededRes() {
		return neededRes;
	}
	public void setNeededRes(int[][] neededRes) {
		this.neededRes = neededRes;
	}
	public int[] getNeededTime() {
		return neededTime;
	}
	public void setNeededTime(int[] neededTime) {
		this.neededTime = neededTime;
	}
	
	
}
