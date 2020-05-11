import java.util.ArrayList;
import java.util.Random;

public class Mario extends Creature {
	
	
	public Mario() {
		this.setHealth(100);
		this.setMaxHealth(100);
		this.setAttackPower(30);
		this.setDefense(0);
		this.setMoveNumberOfSpaces(4);
		this.setSightRange(18);
		this.setAttackRange(4);
		this.setDefaultColor(255, 0, 0);
	}
	
	public Mario(int maxX, int maxY) {
		super(maxX, maxY);
		this.setHealth(100);
		this.setMaxHealth(100);
		this.setAttackPower(30);
		this.setDefaultAttackPower(30);
		this.setDefense(0);
		this.setDefaultDefense(0);
		this.setMoveNumberOfSpaces(4);
		this.setDefaultMoveNumberOfSpaces(4);
		this.setSightRange(18);
		this.setAttackRange(4);
		this.setDefaultColor(255, 0, 0);  //Red.
		
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
	/*@Override
	public void move1() {
		System.out.println("Mario's move method was called.");
		
		this.setPositionX(this.getPositionX() + this.getMoveNumberOfSpaces());
		this.setPositionY(this.getPositionY() + this.getMoveNumberOfSpaces());
		
		
		
		
		 
	} */
	
	@Override
	public void attack(Creature creature) {
		System.out.println("Mario's attack method was called.");
		
		creature.setHealth(creature.getHealth() - this.getAttackPower());
		
		/*if (this.getItemEquippedFlag() == false) {
			creature.setHealth(creature.getHealth() - this.getAttackPower());
		}
		else if (this.getItemEquippedFlag() == true) {
			if (this.getEquippedItem() instanceof Star) {
				creature.setHealth(creature.getHealth() - this.getAttackPower());
			}
		} */
	}
	
	@Override
	public void observe(ArrayList<Creature> creatureProximity, ArrayList<Item> itemProximity) {
		System.out.println("Mario's observe method was called.");
		
		int[] distanceToCreatures = new int[creatureProximity.size()];
		int[] distanceToItems = new int[itemProximity.size()];
		int smallestDistanceToEnemy = 200, smallestDistanceToStar = 201, smallestDistanceToMushroom = 202;
		int reference = creatureProximity.size() + 1, reference2, referenceStar = itemProximity.size() + 1, referenceMushroom = itemProximity.size() + 1;
		
		for (int i = 0; i < creatureProximity.size(); i++) {
			distanceToCreatures[i] = Math.abs(this.getPositionX() - creatureProximity.get(i).getPositionX()) + Math.abs(this.getPositionY() - creatureProximity.get(i).getPositionY());
			
			if (distanceToCreatures[i] < smallestDistanceToEnemy && (creatureProximity.get(i) instanceof Goomba || creatureProximity.get(i) instanceof KoopaTroopa || 
					creatureProximity.get(i) instanceof PiranhaPlant)) {
				//smallest3 = smallest2;
				//smallest2 = smallest;
				smallestDistanceToEnemy = distanceToCreatures[i];
				reference = i;  //Index of nearest enemy creature.
			}
			//else if() {
				
			//}
		}//End for loop to give nearest enemy creature, creatureProximity.get(reference).
		
		for (int i = 0; i < itemProximity.size(); i++) {
			distanceToItems[i] = Math.abs(this.getPositionX() - itemProximity.get(i).getPositionX()) + Math.abs(this.getPositionY() - itemProximity.get(i).getPositionY());
			
			if (distanceToItems[i] < smallestDistanceToStar && (itemProximity.get(i) instanceof Star)) {
				//smallest3 = smallest2;
				//smallest2 = smallest;
				smallestDistanceToStar = distanceToItems[i];
				referenceStar = i;  //Index of nearest Star.
			}
			else if (distanceToItems[i] < smallestDistanceToMushroom && (itemProximity.get(i) instanceof Mushroom)) {
				smallestDistanceToMushroom = distanceToItems[i];
				referenceMushroom = i;
			}
			
		}//End for loop to give nearest Star and Mushroom, itemProximity.get(referenceStar) and itemProximity.get(referenceMushroom) respectively.
		
		if (this.getItemEquippedFlag() == true) {
			if (this.getEquippedItem() != null && this.getEquippedItem() instanceof Star) {
				this.getEquippedStar().itemDegredation();
				if (this.getEquippedStar().getAliveFlag() == false) {
					this.itemUnequip();
				}
			}
		}
		
		if (this.getHealth() <= 50 && referenceMushroom <= itemProximity.size()) {
			if((itemProximity.get(referenceMushroom).getPositionX() - this.getPositionX()) <= this.getAttackRange() && 
					(itemProximity.get(referenceMushroom).getPositionY() - this.getPositionY()) <= this.getAttackRange()) {
				itemPickUp(itemProximity.get(referenceMushroom));
				//if(creatureProximity.get(reference).getHealth() < 1) {
				//	creatureProximity.get(reference).setAliveFlag(false);
				//}  //If enemy creature's health falls below 0, sets enemy's alive flag to false.
			}  //Check to see if closest Mushroom is within attack range.
			else {
				if ((itemProximity.get(referenceMushroom).getPositionX() - this.getPositionX()) < 0) {
					if((this.getPositionX() - this.getMoveNumberOfSpaces()) < 0) {
						this.setPositionX(0);
					}
					else {
						this.setPositionX(this.getPositionX() - this.getMoveNumberOfSpaces());
					}
				}
				else if((itemProximity.get(referenceMushroom).getPositionX() - this.getPositionX()) > 0) {
					if((this.getPositionX() + this.getMoveNumberOfSpaces()) > this.getMaxX()) {
						this.setPositionX(this.getMaxX());
					}
					else {
						this.setPositionX(this.getPositionX() + this.getMoveNumberOfSpaces());
					}
				}
				
				if ((itemProximity.get(referenceMushroom).getPositionY() - this.getPositionY()) < 0) {
					if((this.getPositionY() - this.getMoveNumberOfSpaces()) < 0) {
						this.setPositionY(0);
					}
					else {
						this.setPositionY(this.getPositionY() - this.getMoveNumberOfSpaces());
					}
				}
				else if((itemProximity.get(referenceMushroom).getPositionY() - this.getPositionY()) > 0) {
					if((this.getPositionY() + this.getMoveNumberOfSpaces()) > this.getMaxY()) {
						this.setPositionY(this.getMaxY());
					}
					else {
						this.setPositionY(this.getPositionY() + this.getMoveNumberOfSpaces());
					}
				}
			}  //If closest enemy is not within attack range, moves full amount towards closest enemy.
		}
		else if (referenceStar <= itemProximity.size()) {
			if ((itemProximity.get(referenceStar).getPositionX() - this.getPositionX()) <= this.getAttackRange() && 
					(itemProximity.get(referenceStar).getPositionY() - this.getPositionY()) <= this.getAttackRange()) {
				itemPickUp(itemProximity.get(referenceStar));
				//if(creatureProximity.get(reference).getHealth() < 1) {
				//	creatureProximity.get(reference).setAliveFlag(false);
				//}  //If enemy creature's health falls below 0, sets enemy's alive flag to false.
			}  //Check to see if closest enemy is within attack range.
			else {
				if ((itemProximity.get(referenceStar).getPositionX() - this.getPositionX()) < 0) {
					if((this.getPositionX() - this.getMoveNumberOfSpaces()) < 0) {
						this.setPositionX(0);
					}
					else {
						this.setPositionX(this.getPositionX() - this.getMoveNumberOfSpaces());
					}
				}
				else if((itemProximity.get(referenceStar).getPositionX() - this.getPositionX()) > 0) {
					if((this.getPositionX() + this.getMoveNumberOfSpaces()) > this.getMaxX()) {
						this.setPositionX(this.getMaxX());
					}
					else {
						this.setPositionX(this.getPositionX() + this.getMoveNumberOfSpaces());
					}
				}
				
				if ((itemProximity.get(referenceStar).getPositionY() - this.getPositionY()) < 0) {
					if((this.getPositionY() - this.getMoveNumberOfSpaces()) < 0) {
						this.setPositionY(0);
					}
					else {
						this.setPositionY(this.getPositionY() - this.getMoveNumberOfSpaces());
					}
				}
				else if((itemProximity.get(referenceStar).getPositionY() - this.getPositionY()) > 0) {
					if((this.getPositionY() + this.getMoveNumberOfSpaces()) > this.getMaxY()) {
						this.setPositionY(this.getMaxY());
					}
					else {
						this.setPositionY(this.getPositionY() + this.getMoveNumberOfSpaces());
					}
				}
			}  //If closest enemy is not within attack range, moves full amount towards closest enemy.
		}
		else {
		
			//Move randomly if no enemies are detected within sight range.
			if (reference > creatureProximity.size()) {
				Random randomNumber = new Random();
				int rNum = randomNumber.nextInt(4);
				
				if(rNum + 1 == 1) {
					move1();
				}
				else if(rNum + 1 == 2) {
					move2();
				}
				else if(rNum + 1 == 3) {
					move3();
				}
				else {
					move4();
				}
			}
			else if (reference <= creatureProximity.size()) {
				if((creatureProximity.get(reference).getPositionX() - this.getPositionX()) <= this.getAttackRange() && 
						(creatureProximity.get(reference).getPositionY() - this.getPositionY()) <= this.getAttackRange()) {
					attack(creatureProximity.get(reference));
					if(creatureProximity.get(reference).getHealth() < 1) {
						creatureProximity.get(reference).setAliveFlag(false);
					}  //If enemy creature's health falls below 0, sets enemy's alive flag to false.
				}  //Check to see if closest enemy is within attack range.
				else {
					if ((creatureProximity.get(reference).getPositionX() - this.getPositionX()) < 0) {
						if((this.getPositionX() - this.getMoveNumberOfSpaces()) < 0) {
							this.setPositionX(0);
						}
						else {
							this.setPositionX(this.getPositionX() - this.getMoveNumberOfSpaces());
						}
					}
					else if((creatureProximity.get(reference).getPositionX() - this.getPositionX()) > 0) {
						if((this.getPositionX() + this.getMoveNumberOfSpaces()) > this.getMaxX()) {
							this.setPositionX(this.getMaxX());
						}
						else {
							this.setPositionX(this.getPositionX() + this.getMoveNumberOfSpaces());
						}
					}
					
					if ((creatureProximity.get(reference).getPositionY() - this.getPositionY()) < 0) {
						if((this.getPositionY() - this.getMoveNumberOfSpaces()) < 0) {
							this.setPositionY(0);
						}
						else {
							this.setPositionY(this.getPositionY() - this.getMoveNumberOfSpaces());
						}
					}
					else if((creatureProximity.get(reference).getPositionY() - this.getPositionY()) > 0) {
						if((this.getPositionY() + this.getMoveNumberOfSpaces()) > this.getMaxY()) {
							this.setPositionY(this.getMaxY());
						}
						else {
							this.setPositionY(this.getPositionY() + this.getMoveNumberOfSpaces());
						}
					}
				}  //If closest enemy is not within attack range, moves full amount towards closest enemy.
			}
		
		}
			
	}
	
}
