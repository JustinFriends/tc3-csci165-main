public abstract class Creature {
	private int health;
	private int attackPower;
	private int defense;
	private int moveNumberOfSpaces;
	private int sightRange;
	private int attackRange;
	private Weapon equippedWeapon;
	private Armor equippedArmor;
	//private Item equippedItem;
	private int[] color;
	private int positionX;
	private int positionY;
	private int[] location;
	private boolean aliveFlag = true;
	private boolean attackFlag = false;
	private boolean weaponEquippedFlag = false;
	private boolean armorEquippedFlag = false;
	private boolean activeEffectFlag = false;
	
	public Creature() {}
	
	public Creature(int health, int attackPower, int defense) {
		this.health = health;
		this.attackPower = attackPower;
		this.defense = defense;
	}
	
	
	
	public Creature(int health, int attackPower, int defense, Weapon equippeWeapon, Armor equippedArmor, 
			int[] color, int[] location) {
		this.health = health;
		this.attackPower = attackPower;
		this.defense = defense;
		this.equippedWeapon = equippeWeapon;
		this.equippedArmor = equippedArmor;
		this.color = color;
		this.location = location;
}
	
	public Creature(int health, int attackPower, int defense, Weapon equippeWeapon, Armor equippedArmor, 
					int[] color, int x, int y) {
		this.health = health;
		this.attackPower = attackPower;
		this.defense = defense;
		this.equippedWeapon = equippeWeapon;
		this.equippedArmor = equippedArmor;
		this.color = color;
		this.positionX = x;
		this.positionY = y;
	}
	
	
	//Setters
	public void setHealth(int health) {
		this.health = health;
	}
	
	public void setAttackPower(int attackPower) {
		this.attackPower = attackPower;
	}
	
	public void setDefense(int defense) {
		this.defense = defense;
	}
	
	public void setMoveNumberOfSpaces(int numOfMove) {
		this.moveNumberOfSpaces = numOfMove;
	}
	
	public void setSightRange(int range) {
		this.sightRange = range;
	}
	
	public void setAttackRange(int range) {
		this.attackRange = range;
	}
	
	public void setEquippedWeapon(Weapon weapon) {
		this.equippedWeapon = weapon;
	}
	
	public void setEquippedArmor(Armor armor) {
		this.equippedArmor = armor;
	}
	
	public void setColor(int[] color) {
		this.color = color;
	}
	
	public void setPositionX(int x) {
		this.positionX = x;
	}
	
	public void setPositionY(int y) {
		this.positionY = y;
	}
	
	public void setLocation(int[] location) {
		this.location = location;
	}
	
	public void setAliveFlag(boolean condition) {
		this.aliveFlag = condition;
	}
	
	public void setAttackFlag(boolean condition) {
		this.attackFlag = condition;
	}
	
	public void setWeaponEquippedFlag(boolean condition) {
		this.weaponEquippedFlag = condition;
	}
	
	public void setArmorEquippedFlag(boolean condition) {
		this.armorEquippedFlag = condition;
	}
	
	public void setActiveEffectFlag(boolean condition) {
		this.activeEffectFlag = condition;
	}
	
	
	//Getters
	public int getHealth() {
		return health;
	}
	
	public int getAttackPower()
	{
		return attackPower;
	}
	
	public int getDefense() {
		return defense;
	}
	
	public int getMoveNumberOfSpaces() {
		return moveNumberOfSpaces;
	}
	
	public int getSightRange() {
		return sightRange;
	}
	
	public int getAttackRange() {
		return attackRange;
	}
	
	public int[] getColor() {
		return color;
	}
	
	public int getPositionX() {
		return positionX;
		//return getLocation().location[0];
	}
	
	public int getPositionY() {
		return positionY;
		//return getLocation().location[1];
	}
	
	public int[] getLocation() {
		return location;
	}
	
	public boolean getAliveFlag() {
		return aliveFlag;
	}
	
	public boolean getAttackFlag() {
		return attackFlag;
	}
	
	public boolean getWeaponEquippedFlag() {
		return weaponEquippedFlag;
	}
	
	public boolean getArmorEquippedFlag() {
		return armorEquippedFlag;
	}
	
	public boolean getActiveEffectFlag() {
		return activeEffectFlag;
	}
	
	
	//Methods
	public abstract void move();  //Sets ruleset for character moves.
	
	public abstract void attack(Creature creature);  //Attacks up to one other creature per turn, potentially moving as well.
	
	public abstract void observe();  //Sets 'driver' for creature decision every turn.
	
	public void itemWorldCheck() {
		
	}
	
	public void itemPickUpCheck() {
		
	}
	
	public void neighborhoodCheck() {
		
	}
	
	public void creatureStatCheck() {
		
	}
	
	public void activeEffectcheck() {
		
	}
	
}
