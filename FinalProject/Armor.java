
public class Armor extends Item {
	private int defense;
	
	public Armor() {}
	
	public Armor(int defense) {
		this.defense = defense;
	}
	
	public Armor(String name, int defense) {
		super(name);
		this.defense = defense;
	}
	
	
	//setters
	public void setDefense(int defense) {
		this.defense = defense;
	}
	
	//getters
	public int getDefense() {
		return defense;
	}
	
}
