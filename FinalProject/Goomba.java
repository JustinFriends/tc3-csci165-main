import java.util.ArrayList;
import java.util.Random;

public class Goomba extends Creature {
	
	
	public Goomba() {
		this.setHealth(50);
		this.setMaxHealth(50);
		this.setAttackPower(10);
		this.setDefense(0);
		this.setMoveNumberOfSpaces(3);
		this.setSightRange(10);
		this.setAttackRange(2);
		this.setDefaultColor(139, 69, 19);
	}
	
	public Goomba(int maxX, int maxY) {
		super(maxX, maxY);
		this.setHealth(50);
		this.setMaxHealth(50);
		this.setAttackPower(10);
		this.setDefaultAttackPower(10);
		this.setDefense(0);
		this.setDefaultDefense(0);
		this.setMoveNumberOfSpaces(3);
		this.setDefaultMoveNumberOfSpaces(3);
		this.setSightRange(10);
		this.setAttackRange(2);
		this.setDefaultColor(139, 69, 19);  //Saddle brown.
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
	/*@Override
	public void move() {
		System.out.println("Goomba's move method was called.");
	}*/
	
	@Override
	public void attack(Creature creature) {
		System.out.println("Goomba's attack method was called.");
		
		creature.setHealth(creature.getHealth() - this.getAttackPower());
	}
	
	@Override
	public void observe(ArrayList<Creature> creatureProximity, ArrayList<Item> itemProximity) {
		System.out.println("Goomba's observe method was called.");
		
		int[] distanceToCreatures = new int[creatureProximity.size()];
		int[] distanceToItems = new int[itemProximity.size()];
		int smallest = 200, smallest2 = 201, smallest3 = 202;
		int reference = creatureProximity.size() + 1, reference2 = creatureProximity.size() + 1, reference3;
		int counter = 0, counter2 = 0, counter3 = 0;
		
		for (int i = 0; i < creatureProximity.size(); i++) {
			distanceToCreatures[i]= Math.abs(this.getPositionX() - creatureProximity.get(i).getPositionX()) + Math.abs(this.getPositionY() - creatureProximity.get(i).getPositionY());
			
			if (distanceToCreatures[i] < smallest && (creatureProximity.get(i) instanceof Mario || creatureProximity.get(i) instanceof Luigi ||
					creatureProximity.get(i) instanceof Toad || creatureProximity.get(i) instanceof Peach)) {
				//smallest3 = smallest2;
				//smallest2 = smallest;
				smallest = distanceToCreatures[i];
				reference = i;  //Index of closest enemy creature.
			}
			
			if(distanceToCreatures[i] < smallest && ((creatureProximity.get(i) instanceof Goomba && creatureProximity.get(i).getAttackFlag() == true) || 
					(creatureProximity.get(i) instanceof KoopaTroopa && creatureProximity.get(i).getAttackFlag() == true) || 
					(creatureProximity.get(i) instanceof PiranhaPlant && creatureProximity.get(i).getAttackFlag() == true))) {
				smallest2 = distanceToCreatures[i];  //Smallest distance to friendly  with attack flag on.
				reference2 = i;  //Index of closest friendly creature with attack flag on.
				counter3++;  //Counter for friendlies with attackFlag on.
			}
				
			//}
		}//End for loop to give nearest enemy creature, creatureProximity.get(i).
		
		for (int i = 0; i < creatureProximity.size(); i++) {
			if(creatureProximity.get(i) instanceof Goomba || creatureProximity.get(i) instanceof KoopaTroopa || creatureProximity.get(i) instanceof PiranhaPlant) {
				counter++;  //Counter for friendly creatures.
				//System.out.println("Number of friendly creatures in sight: " + counter);
			}
			else if(creatureProximity.get(i) instanceof Mario || creatureProximity.get(i) instanceof Luigi ||
					creatureProximity.get(i) instanceof Toad || creatureProximity.get(i) instanceof Peach) {
				counter2++;  //Counter for enemy creatures.
			}
		}
		
		if(counter > 5 && counter3 == 0) {
			this.setAttackFlag(true);  //If at least 6 friendlies are present in the neighborhoodCheck, none of which have attackFlag set to true, this creature switches from fleeing to attacking.
		}
		//else if(counter < 5) {
		//	this.setAttackFlag(false);
		//}
		
		if(this.getAttackFlag() == false) {
			if(counter3 == 0 && reference > creatureProximity.size()) {
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
			}  //Move randomly if no friendly attack flags are found and no enemies are detected within sight range.
			else if(counter3 > 0 && reference > creatureProximity.size()) {
				if ((creatureProximity.get(reference2).getPositionX() - this.getPositionX()) < 0) {
					if((this.getPositionX() - this.getMoveNumberOfSpaces()) < 0) {
						this.setPositionX(0);
					}
					else {
						this.setPositionX(this.getPositionX() - this.getMoveNumberOfSpaces());
					}
				}
				else if((creatureProximity.get(reference2).getPositionX() - this.getPositionX()) > 0) {
					this.setPositionX(this.getPositionX() + this.getMoveNumberOfSpaces());
				}
				
				if ((creatureProximity.get(reference2).getPositionY() - this.getPositionY()) < 0) {
					if((this.getPositionY() - this.getMoveNumberOfSpaces()) < 0) {
						this.setPositionY(0);
					}
					else {
						this.setPositionY(this.getPositionY() - this.getMoveNumberOfSpaces());
					}
				}
				else if((creatureProximity.get(reference2).getPositionY() - this.getPositionY()) > 0) {
					if((this.getPositionY() + this.getMoveNumberOfSpaces()) > this.getMaxY()) {
						this.setPositionY(this.getMaxY());
					}
					else {
						this.setPositionY(this.getPositionY() + this.getMoveNumberOfSpaces());
					}
				}
			}  //If no enemies are near, moves towards friendly with attackFlag set to true.
			else if(counter3 > 0 && reference <= creatureProximity.size()) {
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
				
			}  //If friendlies have attack flag and enemy creatures are present.
			else if(counter3 == 0 && reference <= creatureProximity.size()) {
				if ((creatureProximity.get(reference).getPositionX() - this.getPositionX()) < 0) {
					if((this.getPositionX() + this.getMoveNumberOfSpaces()) > this.getMaxX()) {
						this.setPositionX(this.getMaxX());
					}
					else {
						this.setPositionX(this.getPositionX() + this.getMoveNumberOfSpaces());
					}
				}
				else if((creatureProximity.get(reference).getPositionX() - this.getPositionX()) > 0) {
					if((this.getPositionX() - this.getMoveNumberOfSpaces()) < 0) {
						this.setPositionX(0);
					}
					else {
						this.setPositionX(this.getPositionX() - this.getMoveNumberOfSpaces());
					}
				}
				
				if ((creatureProximity.get(reference).getPositionY() - this.getPositionY()) < 0) {
					if((this.getPositionY() + this.getMoveNumberOfSpaces()) > this.getMaxY()) {
						this.setPositionY(this.getMaxY());
					}
					else {
						this.setPositionY(this.getPositionY() + this.getMoveNumberOfSpaces());
					}
				}
				else if((creatureProximity.get(reference).getPositionY() - this.getPositionY()) > 0) {
					if((this.getPositionY() - this.getMoveNumberOfSpaces()) < 0) {
						this.setPositionY(0);
					}
					else {
						this.setPositionY(this.getPositionY() - this.getMoveNumberOfSpaces());
					}
				}
			}  //If no friendlies have attack flag and enemy creatures are present, creature should flee from closest enemy.
			
		}  //Choices based on this creature's attack flag being false.
				
		if(this.getAttackFlag() == true) {
			if(reference <= creatureProximity.size()) {
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
			else if(reference > creatureProximity.size()) {
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
			
		}  //Choices if this creature's attack flag is set to true and there are enemies nearby.
		
		
	}
}
