
public class KoopaTroopa extends Creature {
	
	
public KoopaTroopa() {
	this.setHealth(30);
	this.setAttackPower(10);
	this.setDefense(0);
	this.setMoveNumberOfSpaces(5);
	this.setSightRange(8);
	this.setAttackRange(2);
}
	
	public KoopaTroopa(int health, int attackPower, int defense) {
		super(health, attackPower, defense);
	}
	
	public KoopaTroopa(int health, int attackPower, int defense, Weapon equippeWeapon, Armor equippedArmor, 
			int[] color, int[] location) {
		super(health, attackPower, defense, equippeWeapon, equippedArmor, 
			color, location);
	}
	
	public KoopaTroopa(int health, int attackPower, int defense, Weapon equippeWeapon, Armor equippedArmor, 
					int[] color, int x, int y) {
		super(health, attackPower, defense, equippeWeapon, equippedArmor, 
				color, x, y);
	}
	
	
	//Methods
	@Override
	public void move() {
		System.out.println("KoopaTroopa's move method was called.");
	}
	
	@Override
	public void attack(Creature creature) {
		System.out.println("KoopaTroopa's attack method was called.");
	}
	
	@Override
	public void observe() {
		System.out.println("KoopaTroopa's observe method was called.");
	}
}
