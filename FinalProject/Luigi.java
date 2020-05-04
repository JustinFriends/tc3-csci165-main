
public class Luigi extends Creature {
	
	
	public Luigi() {
		this.setHealth(100);
		this.setAttackPower(20);
		this.setDefense(0);
		this.setMoveNumberOfSpaces(2);
		this.setSightRange(5);
		this.setAttackRange(5);
	}
	
	public Luigi(int health, int attackPower, int defense) {
		super(health, attackPower, defense);
	}
	
	public Luigi(int health, int attackPower, int defense, Weapon equippeWeapon, Armor equippedArmor, 
			int[] color, int[] location) {
		super(health, attackPower, defense, equippeWeapon, equippedArmor, 
			color, location);
	}
	
	public Luigi(int health, int attackPower, int defense, Weapon equippeWeapon, Armor equippedArmor, 
					int[] color, int x, int y) {
		super(health, attackPower, defense, equippeWeapon, equippedArmor, 
				color, x, y);
	}
	
	
	//Methods
	@Override
	public void move() {
		System.out.println("Luigi's move method was called.");
	}
	
	@Override
	public void attack(Creature creature) {
		System.out.println("Luigi's attack method was called.");
	}
	
	@Override
	public void observe() {
		System.out.println("Luigi's observe method was called.");
	}
}
