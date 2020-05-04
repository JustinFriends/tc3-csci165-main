
public class Goomba extends Creature {
	
	
	public Goomba() {
		this.setHealth(50);
		this.setAttackPower(10);
		this.setDefense(0);
		this.setMoveNumberOfSpaces(3);
		this.setSightRange(3);
		this.setAttackRange(1);
	}
	
	public Goomba(int health, int attackPower, int defense) {
		super(health, attackPower, defense);
	}
	
	public Goomba(int health, int attackPower, int defense, Weapon equippeWeapon, Armor equippedArmor, 
			int[] color, int[] location) {
		super(health, attackPower, defense, equippeWeapon, equippedArmor, 
			color, location);
	}
	
	public Goomba(int health, int attackPower, int defense, Weapon equippeWeapon, Armor equippedArmor, 
					int[] color, int x, int y) {
		super(health, attackPower, defense, equippeWeapon, equippedArmor, 
				color, x, y);
	}
	
	
	//Methods
	@Override
	public void move() {
		System.out.println("Goomba's move method was called.");
	}
	
	@Override
	public void attack(Creature creature) {
		System.out.println("Goomba's attack method was called.");
	}
	
	@Override
	public void observe() {
		System.out.println("Goomba's observe method was called.");
	}
}
