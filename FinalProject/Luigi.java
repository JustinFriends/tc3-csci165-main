import java.util.ArrayList;
import java.util.Random;

public class Luigi extends Creature {
	
	
	public Luigi() {
		this.setHealth(100);
		this.setMaxHealth(100);
		this.setAttackPower(20);
		this.setDefense(0);
		this.setMoveNumberOfSpaces(5);
		this.setSightRange(22);
		this.setAttackRange(5);
		this.setDefaultColor(0, 255, 0);
	}
	
	public Luigi(int maxX, int maxY) {
		super(maxX, maxY);
		this.setHealth(100);
		this.setMaxHealth(100);
		this.setAttackPower(20);
		this.setDefaultAttackPower(20);
		this.setDefense(0);
		this.setDefaultDefense(0);
		this.setMoveNumberOfSpaces(5);
		this.setDefaultMoveNumberOfSpaces(5);
		this.setSightRange(22);
		this.setAttackRange(5);
		this.setDefaultColor(0, 255, 0);  //Green.
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
	/*@Override
	public void move() {
		System.out.println("Luigi's move method was called.");
	}*/
	
	@Override
	public void attack(Creature creature) {
		System.out.println("Luigi's attack method was called.");
		
		creature.setHealth(creature.getHealth() - this.getAttackPower());
		
	}
	
	@Override
	public void observe(ArrayList<Creature> creatureProximity, ArrayList<Item> itemProximity) {
		System.out.println("Luigi's observe method was called.");
		
		int[] distanceToCreatures = new int[creatureProximity.size()];
		int[] distanceToItems = new int[itemProximity.size()];
		int smallest = 50, smallest2 = 51, smallest3 = 52;
		int reference = creatureProximity.size() + 1, reference2, reference3;
		
		for (int i = 0; i < creatureProximity.size(); i++) {
			distanceToCreatures[i]= Math.abs(this.getPositionX() - creatureProximity.get(i).getPositionX()) + Math.abs(this.getPositionY() - creatureProximity.get(i).getPositionY());
			if (distanceToCreatures[i] < smallest && (creatureProximity.get(i) instanceof Goomba || creatureProximity.get(i) instanceof KoopaTroopa || 
					creatureProximity.get(i) instanceof PiranhaPlant)) {
				//smallest3 = smallest2;
				//smallest2 = smallest;
				smallest = distanceToCreatures[i];
				reference = i;
			}
			//else if() {
				
			//}
		}//End for loop to give nearest enemy creature, creatureProximity.get(i).
		
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
