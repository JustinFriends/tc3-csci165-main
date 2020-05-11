import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class GoombaTest {
	
	//Tests for attackFlag condition to become true when 6 or more friendlies are within sight range.
	@Test
	void AttackFlagTrueTest() {
		ArrayList<Creature> creatureList = new ArrayList<Creature>();
		ArrayList<Item> itemList = new ArrayList<Item>();
		
		Goomba g = new Goomba(20, 20);
		g.setPositionX(10);
		g.setPositionY(10);
		Goomba g2 = new Goomba(20, 20);
		g2.setPositionX(11);
		g2.setPositionY(11);
		Goomba g3 = new Goomba(20, 20);
		g3.setPositionX(12);
		g3.setPositionY(12);
		KoopaTroopa k = new KoopaTroopa(20, 20);
		k.setPositionX(9);
		k.setPositionY(9);
		KoopaTroopa k2 = new KoopaTroopa(20, 20);
		k2.setPositionX(8);
		k2.setPositionY(8);
		PiranhaPlant p = new PiranhaPlant(20, 20);
		p.setPositionX(7);
		p.setPositionY(7);
		PiranhaPlant p2 = new PiranhaPlant(20, 20);
		p2.setPositionX(6);
		p2.setPositionY(6);
		
		creatureList.add(g);
		creatureList.add(g2);
		creatureList.add(g3);
		creatureList.add(k);
		creatureList.add(k2);
		creatureList.add(p);
		creatureList.add(p2);
		
		boolean expected = true;
		
		creatureList.get(0).observe(creatureList.get(0).neighborhoodCheck(creatureList), creatureList.get(0).itemWorldCheck(itemList));
		
		assertEquals(expected, creatureList.get(0).getAttackFlag());
	}
	
	//Tests that random move was called from the observe method when attackFlag is false, no friendlies with attackFlag true are in range, and no enemies are in range.
	@Test
	void ObserveCheckAttackFlagFalseNoFriendlyAttackFlagsMoveTest() {
		ArrayList<Creature> creatureList = new ArrayList<Creature>();
		ArrayList<Item> itemList = new ArrayList<Item>();
		
		Goomba g = new Goomba(20, 20);
		g.setPositionX(10);
		g.setPositionY(10);
		
		int startingX = 10;
		int startingY = 10;
		
		creatureList.add(g);
		
		creatureList.get(0).observe(creatureList.get(0).neighborhoodCheck(creatureList), creatureList.get(0).itemWorldCheck(itemList));
		
		assertNotEquals(startingX, creatureList.get(0).getPositionX());
		assertNotEquals(startingY, creatureList.get(0).getPositionY());
	}
	
	//Tests that this creature with attackFlag false moves towards friendly within sight range with attackFlag true.
	@Test
	void ObserveCheckAttackFlagFalseFriendlyAttackFlagTrueMoveTest() {
		ArrayList<Creature> creatureList = new ArrayList<Creature>();
		ArrayList<Item> itemList = new ArrayList<Item>();
		
		Goomba g = new Goomba(20, 20);
		g.setPositionX(10);
		g.setPositionY(10);
		Goomba g2 = new Goomba(20, 20);
		g2.setPositionX(15);
		g2.setPositionY(15);
		g2.setAttackFlag(true);
		
		int expectedX = 13;  //Moves 3 per turn, towards friendly's direction.
		int expectedY = 13;
		
		creatureList.add(g);
		creatureList.add(g2);
		
		creatureList.get(0).observe(creatureList.get(0).neighborhoodCheck(creatureList), creatureList.get(0).itemWorldCheck(itemList));
		
		assertEquals(expectedX, creatureList.get(0).getPositionX());
		assertEquals(expectedY, creatureList.get(0).getPositionY());
	}
	
	//Tests that random move was called form the observe method when attackFlag is true and no enemies are in range.
	@Test
	void ObserveCheckAttackFlagTrueMoveTest() {
		ArrayList<Creature> creatureList = new ArrayList<Creature>();
		ArrayList<Item> itemList = new ArrayList<Item>();
		
		Goomba g = new Goomba(20, 20);
		g.setPositionX(10);
		g.setPositionY(10);
		g.setAttackFlag(true);
		
		int startingX = 10;
		int startingY = 10;
		
		creatureList.add(g);
		
		creatureList.get(0).observe(creatureList.get(0).neighborhoodCheck(creatureList), creatureList.get(0).itemWorldCheck(itemList));
		
		assertNotEquals(startingX, creatureList.get(0).getPositionX());
		assertNotEquals(startingY, creatureList.get(0).getPositionY());
	}
	
	//Tests the get attack range method.
	@Test
	void GetAttackRangeTest() {
		Goomba g = new Goomba(20, 20);
		
		int expected = 2;
		
		assertEquals(expected, g.getAttackRange());
	}
	
	//Tests to make sure the attack method is called instead of flee if a friendly attackFlag is present and is within attack range (2).
	@Test
	void ObserveCheckFriendlyAttackFlagTrueAttackEnemyTest() {
		ArrayList<Creature> creatureList = new ArrayList<Creature>();
		ArrayList<Item> itemList = new ArrayList<Item>();
		
		Goomba g = new Goomba(20, 20);
		g.setPositionX(10);
		g.setPositionY(10);
		Goomba g2 = new Goomba(20, 20);
		g2.setPositionX(15);
		g2.setPositionY(15);
		g2.setAttackFlag(true);
		Mario m = new Mario(20, 20);
		m.setPositionX(12);
		m.setPositionY(12);
		
		creatureList.add(g);
		creatureList.add(g2);
		creatureList.add(m);
		
		creatureList.get(0).observe(creatureList.get(0).neighborhoodCheck(creatureList), creatureList.get(0).itemWorldCheck(itemList));
		
		int expectedHealth = 90;  //Goomba attack power is 10, Mario health is 100, so 100 - 10 should be 90.
				
		assertEquals(expectedHealth, creatureList.get(2).getHealth());
	}
	
	//Tests to make sure creature moves toward enemy not in range if attackFlag is false, and friendly attackFlag is true.
	@Test
	void ObserveCheckFriendlyAttackFlagTrueMoveTowardsEnemy() {
		ArrayList<Creature> creatureList = new ArrayList<Creature>();
		ArrayList<Item> itemList = new ArrayList<Item>();
		
		Goomba g = new Goomba(20, 20);
		g.setPositionX(10);
		g.setPositionY(10);
		Goomba g2 = new Goomba(20, 20);
		g2.setPositionX(15);
		g2.setPositionY(15);
		g2.setAttackFlag(true);
		Mario m = new Mario(20, 20);
		m.setPositionX(14);
		m.setPositionY(14);
		
		creatureList.add(g);
		creatureList.add(g2);
		creatureList.add(m);
		
		creatureList.get(0).observe(creatureList.get(0).neighborhoodCheck(creatureList), creatureList.get(0).itemWorldCheck(itemList));
		
		int expectedX = 13;  //Goomba moves 3 spaces.
		int expectedY = 13;
		
		assertEquals(expectedX, creatureList.get(0).getPositionX());
		assertEquals(expectedY, creatureList.get(0).getPositionY());
	}
	


}
