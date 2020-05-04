
public class Mario extends Creature {
	
	
	public Mario() {
		this.setHealth(100);
		this.setAttackPower(30);
		this.setDefense(0);
		this.setMoveNumberOfSpaces(4);
		this.setSightRange(4);
		this.setAttackRange(2);
	}
	
	public Mario(int health, int attackPower, int defense) {
		super(health, attackPower, defense);
	}
	
	public Mario(int health, int attackPower, int defense, Weapon equippeWeapon, Armor equippedArmor, 
			int[] color, int[] location) {
		super(health, attackPower, defense, equippeWeapon, equippedArmor, 
			color, location);
	}
	
	public Mario(int health, int attackPower, int defense, Weapon equippeWeapon, Armor equippedArmor, 
					int[] color, int x, int y) {
		super(health, attackPower, defense, equippeWeapon, equippedArmor, 
				color, x, y);
	}
	
	
	//Methods
	@Override
	public void move() {
		System.out.println("Mario's move method was called.");
		
		/*
		
		
		
		
		
		
		 */
	}
	
	@Override
	public void attack(Creature creature) {
		System.out.println("Mario's attack method was called.");
		
		/*
		
		
		
		
		
		 */
	}
	
	@Override
	public void observe() {
		System.out.println("Mario's observe method was called.");
	}
	
}
