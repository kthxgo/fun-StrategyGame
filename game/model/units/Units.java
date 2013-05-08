package model.units;

public class Units {

	private Unit unit;
	private int amount;
	private String owner;
	
	public Units() {
		
	}
	
	public Units(Unit unit, int amount, String owner) {
		this.unit = unit;
		this.amount = amount;
		this.owner = owner;
	}
	
}
