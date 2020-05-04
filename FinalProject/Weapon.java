
public class Weapon extends Item {
	private int attack;
	
	public Weapon() {}
	
	public Weapon(int attack) {
		this.attack = attack;
	}
	
	public Weapon(String name, int attack) {
		super(name);
		this.attack = attack;
	}
	
	
	//setters
	public void setAttack(int attack) {
		this.attack = attack;
	}
	
	//getters
	public int getAttack() {
		return attack;
	}
	
}
