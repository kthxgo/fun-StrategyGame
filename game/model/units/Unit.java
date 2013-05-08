package model.units;

public abstract class Unit {
	
	protected int id;
	protected String name;
	protected int attackPower;
	protected int defendPower;
	protected int researchLevel;
	
	
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
	public int getAttackPower() {
		return attackPower;
	}
	public void setAttackPower(int attackPower) {
		this.attackPower = attackPower;
	}
	public int getDefendPower() {
		return defendPower;
	}
	public void setDefendPower(int defendPower) {
		this.defendPower = defendPower;
	}
	public int getResearchLevel() {
		return researchLevel;
	}
	public void setResearchLevel(int researchLevel) {
		this.researchLevel = researchLevel;
	}
	
}
