import java.awt.Color;
import java.util.ArrayList;

public abstract class Creature {
	private int health;
	private int maxHealth;
	private int attackPower;
	private int defaultAttackPower;
	private int defense;
	private int defaultDefense;
	private int moveNumberOfSpaces;
	private int defaultMoveNumberOfSpaces;
	private int sightRange;
	private int attackRange;
	private int defaultAttackRange;
	private Weapon equippedWeapon;
	private Armor equippedArmor;
	private Item equippedItem;
	private Star equippedStar;
	private int[] defaultColor;
	private int[] color;
	//private int[] currentHealth;
	private int positionX;
	private int positionY;
	private int maxX;
	private int maxY;
	private int[] location;
	private boolean aliveFlag = true;
	private boolean attackFlag = false;
	private boolean weaponEquippedFlag = false;
	private boolean armorEquippedFlag = false;
	private boolean itemEquippedFlag = false;
	private boolean activeEffectFlag = false;
	
	public Creature() {}
	
	public Creature(int maxX, int maxY) {
		this.maxX = maxX;
		this.maxY = maxY;
	}
	
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
	
	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}
	
	public void setAttackPower(int attackPower) {
		this.attackPower = attackPower;
	}
	
	public void setDefaultAttackPower(int defaultAttackPower) {
		this.defaultAttackPower = defaultAttackPower;
	}
	
	public void setDefense(int defense) {
		this.defense = defense;
	}
	
	public void setDefaultDefense(int defaultDefense) {
		this.defaultDefense = defaultDefense;
	}
	
	public void setMoveNumberOfSpaces(int numOfMove) {
		this.moveNumberOfSpaces = numOfMove;
	}
	
	public void setDefaultMoveNumberOfSpaces(int defaultMoveNumberOfSpaces) {
		this.defaultMoveNumberOfSpaces = defaultMoveNumberOfSpaces;
	}
	
	public void setSightRange(int range) {
		this.sightRange = range;
	}
	
	public void setAttackRange(int range) {
		this.attackRange = range;
	}
	
	public void setDefaultAttackRange(int defaultAttackRange) {
		this.defaultAttackRange = defaultAttackRange;
	}
	
	public void setEquippedWeapon(Weapon weapon) {
		this.equippedWeapon = weapon;
	}
	
	public void setEquippedArmor(Armor armor) {
		this.equippedArmor = armor;
	}
	
	public void setEquippedItem(Item item) {
		this.equippedItem = item;
	}
	
	public void setEquippedStar(Star star) {
		this.equippedStar = star;
	}
	
	public void setDefaultColor(int rgb1, int rgb2, int rgb3) {
		this.defaultColor = new int[] { rgb1, rgb2, rgb3 };
	}
	
	public void setColor(int rgb1, int rgb2, int rgb3) {
		this.color = new int[] { rgb1, rgb2, rgb3 };
	}
	
	public void setPositionX(int x) {
		this.positionX = x;
	}
	
	public void setPositionY(int y) {
		this.positionY = y;
	}
	
	public void setMaxX(int maxX) {
		this.maxX = maxX;
	}
	
	public void setMaxY(int maxY) {
		this.maxY = maxY;
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
	
	public void setItemEquippedFlag(boolean condition) {
		this.itemEquippedFlag = condition;
	}
	
	public void setActiveEffectFlag(boolean condition) {
		this.activeEffectFlag = condition;
	}
	
	
	//Getters
	public int getHealth() {
		return health;
	}
	
	public int getMaxHealth() {
		return maxHealth;
	}
	
	public int getAttackPower() {
		return attackPower;
	}
	
	public int getDefaultAttackPower() {
		return defaultAttackPower;
	}
	
	public int getDefense() {
		return defense;
	}
	
	public int getDefaultDefense() {
		return defaultDefense;
	}
	
	public int getMoveNumberOfSpaces() {
		return moveNumberOfSpaces;
	}
	
	public int getDefaultMoveNumberOfSpaces() {
		return defaultMoveNumberOfSpaces;
	}
	
	public int getSightRange() {
		return sightRange;
	}
	
	public int getAttackRange() {
		return attackRange;
	}
	
	public int getDefaultAttackRange() {
		return defaultAttackRange;
	}
	
	public Weapon getEquippedWeapon() {
		return equippedWeapon;
	}
	
	public Armor getEquippedArmor() {
		return equippedArmor;
	}
	
	public Item getEquippedItem() {
		return equippedItem;
	}
	
	public Star getEquippedStar() {
		return equippedStar;
	}
	
	public int[] getDefaultcolor() {
		return defaultColor;
	}
	
	public int[] getColor() {
		
		if((health * 100) / maxHealth >= 50 && (health * 100) / maxHealth < 100) {
			setColor(defaultColor[0] - (defaultColor[0] / 4), defaultColor[1] - (defaultColor[1] / 4), defaultColor[2] - (defaultColor[2] / 4));
			//color[0] = defaultColor[0] - (defaultColor[0] / 4);
			//color[1] = defaultColor[1] - (defaultColor[1] / 4);
			//color[2] = defaultColor[2] - (defaultColor[2] / 4);
			
			return color;
		}
		else if(health * 100 / maxHealth > 0 && (health * 100 / maxHealth < 50)) {
			setColor(defaultColor[0] - (defaultColor[0] / 2), defaultColor[1] - (defaultColor[1] / 2), defaultColor[2] - (defaultColor[2] / 2));
			//color[0] = defaultColor[0] - (defaultColor[0] / 2);
			//color[1] = defaultColor[1] - (defaultColor[1] / 2);
			//color[2] = defaultColor[2] - (defaultColor[2] / 2);
			
			return color;
		}
		
		setColor(defaultColor[0], defaultColor[1], defaultColor[2]);
		//color[0] = defaultColor[0];
		//color[1] = defaultColor[1];
		//color[2] = defaultColor[2];
	
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
	
	public int getMaxX() {
		return maxX;
	}
	
	public int getMaxY() {
		return maxY;
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
	
	public boolean getItemEquippedFlag() {
		return itemEquippedFlag;
	}
	
	public boolean getActiveEffectFlag() {
		return activeEffectFlag;
	}
	
	
	//Methods
	
	//Moves right (+ X) and down (+ Y).
	public void move1() {
		if((this.getPositionX() + this.getMoveNumberOfSpaces()) > this.getMaxX()) {
			this.setPositionX(this.getMaxX());
		}
		else {
			this.setPositionX(this.getPositionX() + this.getMoveNumberOfSpaces());
		}
		
		if((this.getPositionY() + this.getMoveNumberOfSpaces()) > this.getMaxY()) {
			this.setPositionY(this.getMaxY());
		}
		else {
			this.setPositionY(this.getPositionY() + this.getMoveNumberOfSpaces());
		}
				
		//this.setPositionX(this.getPositionX() + this.getMoveNumberOfSpaces());
		//this.setPositionY(this.getPositionY() + this.getMoveNumberOfSpaces());
	
	}
	
	//Moves right (+ X) and up (+ Y).
	public void move2() {
		if((this.getPositionX() + this.getMoveNumberOfSpaces()) > this.getMaxX()) {
			this.setPositionX(this.getMaxX());
		}
		else {
			this.setPositionX(this.getPositionX() + this.getMoveNumberOfSpaces());
		}
		if((this.getPositionY() - this.getMoveNumberOfSpaces()) < 0) {
			this.setPositionY(0);
		}
		else {
			this.setPositionY(this.getPositionY() - this.getMoveNumberOfSpaces());
		}
		
		//this.setPositionX(this.getPositionX() + this.getMoveNumberOfSpaces());
		//this.setPositionY(this.getPositionY() - this.getMoveNumberOfSpaces());
	}

	//Moves left (- X) and up (- Y).
	public void move3() {
		if((this.getPositionX() - this.getMoveNumberOfSpaces()) < 0) {
			this.setPositionX(0);
		}
		else {
			this.setPositionX(this.getPositionX() - this.getMoveNumberOfSpaces());
		}
		
		if((this.getPositionY() - this.getMoveNumberOfSpaces()) < 0) {
			this.setPositionY(0);
		}
		else {
			this.setPositionY(this.getPositionY() - this.getMoveNumberOfSpaces());
		}
		
		//this.setPositionX(this.getPositionX() - this.getMoveNumberOfSpaces());
		//this.setPositionY(this.getPositionY() - this.getMoveNumberOfSpaces());
	}
	
	//Moves left (- X) and down (+ Y).
	public void move4() {
		if((this.getPositionX() - this.getMoveNumberOfSpaces()) < 0) {
			this.setPositionX(0);
		}
		else {
			this.setPositionX(this.getPositionX() - this.getMoveNumberOfSpaces());
		}
		
		if((this.getPositionY() + this.getMoveNumberOfSpaces()) > this.getMaxY()) {
			this.setPositionY(this.getMaxY());
		}
		else {
			this.setPositionY(this.getPositionY() + this.getMoveNumberOfSpaces());
		}
		
		//this.setPositionX(this.getPositionX() - this.getMoveNumberOfSpaces());
		//this.setPositionY(this.getPositionY() + this.getMoveNumberOfSpaces());
	}
	
	//Attacks up to one other creature per turn, potentially moving as well.
	public abstract void attack(Creature creature);  
	
	//Sets 'driver' for creature decision every 'turn'.
	public abstract void observe(ArrayList<Creature> creatureProximity, ArrayList<Item> itemProximity);  
	
	//Checks the surrounding area based on sight range.  Returns an arraylist of type Item with the items within sight range.
	public ArrayList<Item> itemWorldCheck(ArrayList<Item> itemList) {
		ArrayList<Item> itemProximity = new ArrayList<Item>();
		
		for (int i = 0; i < itemList.size(); i++) {
			if (itemList.get(i).getAliveFlag() == true && itemList.get(i).getPickedUpFlag() == false) {
				
				if ((Math.abs(itemList.get(i).getPositionX() - this.getPositionX()) <= this.getSightRange()) && 
						Math.abs(itemList.get(i).getPositionY() - this.getPositionY()) <= this.getSightRange()) {
					
					itemProximity.add(itemList.get(i));
				}  //If check for line of sight.
				
			}  //If check for alive flag.
			
		}  //Loops through the entire item list array.
		
		return itemProximity;
	}
	
	//What happens when an item is picked up by creature.
	public void itemPickUp(Item item) {
		if (item instanceof Mushroom) {
			item.setAliveFlag(false);
			item.setPickedUpFlag(true);
			//this.setItemEquippedFlag(true);
			if ((this.getHealth() + 50) > this.getMaxHealth()) {
				this.setHealth(this.getMaxHealth());
			}
			else {
				this.setHealth(this.getHealth() + 50);
			}
		}
		else if (item instanceof Star) {
			this.equippedStar = (Star)item;
			item.setPickedUpFlag(true);
			this.setItemEquippedFlag(true);
			this.setAttackPower(this.getDefaultAttackPower() * 2);
			this.setAttackRange(this.getDefaultAttackRange() * 2);
			this.setDefense(this.getDefaultDefense() + 100);
			this.setMoveNumberOfSpaces(this.getDefaultMoveNumberOfSpaces() * 2);
		}
	}
	
	//What happens when an item is unequipped.
	public void itemUnequip() {
		this.setItemEquippedFlag(false);
		this.setEquippedItem(null);
		this.setEquippedStar(null);
		this.setItemEquippedFlag(false);
		this.setAttackPower(this.getDefaultAttackPower());
		this.setAttackRange(this.getDefaultAttackRange());
		this.setDefense(this.getDefaultDefense());
		this.setMoveNumberOfSpaces(this.getDefaultMoveNumberOfSpaces());
	}
	
	//Checks the surrounding area based on sight range.  Returns an arraylist of type creature with the creatures within sight range.
	public ArrayList<Creature> neighborhoodCheck(ArrayList<Creature> creatureList) {
		ArrayList<Creature> creatureProximity = new ArrayList<Creature>();
		
		for (int i = 0; i < creatureList.size(); i++) {
			if (creatureList.get(i).getAliveFlag() == true) {
			
				if (creatureList.get(i).getPositionX() != this.getPositionX() && creatureList.get(i).getPositionY() != this.getPositionY()) {
					if ((Math.abs(creatureList.get(i).getPositionX() - this.getPositionX()) <= this.getSightRange()) && 
						Math.abs(creatureList.get(i).getPositionY() - this.getPositionY()) <= this.getSightRange()) {
						
						creatureProximity.add(creatureList.get(i));
					}  //If check for line of sight.
					
				}  //If check to make sure it's not this creature.
				
			}  //If check for alive flag.
			
		}  //Loops through the entire creature list array.
		
		return creatureProximity;
	}
	
	public void creatureStatCheck() {
		
	}
	
	public void activeEffectcheck() {
		
	}
	
	
	@Override
	public String toString() {
		return "Health: " + this.getHealth() +
				"\nColor: " + this.getColor()[0] + ", " + this.getColor()[1] + ", " + this.getColor()[2] + 
				"\nLocation: " + this.getPositionX() + ", " + this.getPositionY();
	}
	
}
