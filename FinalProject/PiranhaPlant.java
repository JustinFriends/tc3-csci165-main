
public class PiranhaPlant extends Creature {
	
	
public PiranhaPlant() {
	this.setHealth(25);
	this.setAttackPower(15);
	this.setDefense(0);
	this.setMoveNumberOfSpaces(1);
	this.setSightRange(6);
	this.setAttackRange(6);
}
	
	public PiranhaPlant(int health, int attackPower, int defense) {
		super(health, attackPower, defense);
	}
	
	public PiranhaPlant(int health, int attackPower, int defense, Weapon equippeWeapon, Armor equippedArmor, 
			int[] color, int[] location) {
		super(health, attackPower, defense, equippeWeapon, equippedArmor, 
			color, location);
	}
	
	public PiranhaPlant(int health, int attackPower, int defense, Weapon equippeWeapon, Armor equippedArmor, 
					int[] color, int x, int y) {
		super(health, attackPower, defense, equippeWeapon, equippedArmor, 
				color, x, y);
	}
	
	
	//Methods
	@Override
	public void move() {
		System.out.println("PiranhaPlant's move method was called.");
	}
	
	@Override
	public void attack(Creature creature) {
		System.out.println("PiranhaPlant's attack method was called.");
	}
	
	@Override
	public void observe() {
		System.out.println("PiranhaPlant's observe method was called.");
	}
}
