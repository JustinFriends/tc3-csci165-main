import java.util.ArrayList;

public class FinalProjectDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Creature> creatureList = new ArrayList<Creature>(); 
		
		creatureList.add(new Mario());
		creatureList.add(new Luigi());
		creatureList.add(new Goomba());
		creatureList.add(new KoopaTroopa());
		creatureList.add(new PiranhaPlant());
		
		for (Creature creature : creatureList) {
			creature.move();
			creature.attack(new Goomba());
			creature.observe();
		}
		
	}

}
