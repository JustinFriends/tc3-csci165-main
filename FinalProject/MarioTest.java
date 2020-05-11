import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

import javax.sound.midi.VoiceStatus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class MarioTest {

	//Tests correct call of creature move range.
	@Test
	void GetNumberOfMovesTest() {
		Mario m = new Mario();
		
		int expected = 4;
		
		assertEquals(expected, m.getMoveNumberOfSpaces());
	}
	
	//Tests the move1() method to make sure it works as intended, moving the max amount of spaces right (+ X) and down (+ Y).
	@Test
	void Move1Test() {
		Mario m = new Mario(10, 10);
		m.setPositionX(0);
		m.setPositionY(0);
		
		//int expectedX = 4;
		//int expectedY = 4;
		int expectedX = m.getMoveNumberOfSpaces();
		int expectedY = m.getMoveNumberOfSpaces();
		
		m.move1();
		
		assertEquals(expectedX, m.getPositionX());
		assertEquals(expectedY, m.getPositionY());
	}
	
	//Tests the move1() method to ensure it doesn't go out of bounds.
	@Test
	void Move1Test2() {
		Mario m = new Mario(10, 10);
		m.setPositionX(7);
		m.setPositionY(8);
		
		int expectedX = 10;
		int expectedY = 10;
		
		m.move1();
		
		assertEquals(expectedX, m.getPositionX());
		assertEquals(expectedY, m.getPositionY());
	}
	
	//Tests move2() method, which should go right (+ X) and up (- Y).
	@Test
	void Move2Test() {
		Mario m = new Mario(10, 10);
		m.setPositionX(1);
		m.setPositionY(6);
		
		int expectedX = 5;
		int expectedY = 2;
		
		m.move2();
		
		assertEquals(expectedX, m.getPositionX());
		assertEquals(expectedY, m.getPositionY());
	}
	
	//Tests move2() method to ensure it doesn't go out of bounds.
	@Test
	void Move2Test2() {
		Mario m = new Mario(10, 10);
		m.setPositionX(9);
		m.setPositionY(3);
		
		int expectedX = 10;
		int expectedY = 0;
		
		m.move2();
		
		assertEquals(expectedX, m.getPositionX());
		assertEquals(expectedY, m.getPositionY());
	}
	
	//Tests move3() method for proper movement, left (- X) and up (- Y).
	@Test
	void Move3Test() {
		Mario m = new Mario(10, 10);
		m.setPositionX(7);
		m.setPositionY(7);
		
		int expectedX = 3;
		int expectedY = 3;
		
		m.move3();
		
		assertEquals(expectedX, m.getPositionX());
		assertEquals(expectedY, m.getPositionY());
	}
	
	//Tests move3() method to ensure it doesn't go out of bounds.
	@Test
	void Move3Test2() {
		Mario m = new Mario(10, 10);
		m.setPositionX(3);
		m.setPositionY(2);
		
		int expectedX = 0;
		int expectedY = 0;
		
		m.move3();
		
		assertEquals(expectedX, m.getPositionX());
		assertEquals(expectedY, m.getPositionY());
	}
	
	//Tests move4() method for proper movement, left (- X) and down (+ Y).
	@Test
	void Move4Test() {
		Mario m = new Mario(10, 10);
		m.setPositionX(5);
		m.setPositionY(2);
		
		int expectedX = 1;
		int expectedY = 6;
		
		m.move4();
		
		assertEquals(expectedX, m.getPositionX());
		assertEquals(expectedY, m.getPositionY());
	}
	
	//Tests move4() method to ensure it doesn't go out of bounds.
	@Test
	void Move4Test2() {
		Mario m = new Mario(10, 10);
		m.setPositionX(0);
		m.setPositionY(7);
		
		int expectedX = 0;
		int expectedY = 10;
		
		m.move4();
		
		assertEquals(expectedX, m.getPositionX());
		assertEquals(expectedY, m.getPositionY());
	}
	
	//Tests correct call of sight range.
	@Test
	void GetSightRangeTest() {
		Mario m = new Mario();
		
		int expected = 18;
		
		assertEquals(expected, m.getSightRange());
	}
	
	//Tests whether creatureProxmity array list properly fills with enemies in range.
	@Test
	void NeighborhoodCheckTest() {
		ArrayList<Creature> creatureList = new ArrayList<Creature>();
		
		Mario m = new Mario(20, 20);
		m.setPositionX(0);
		m.setPositionY(0);
		Luigi l = new Luigi(20, 20);
		l.setPositionX(4);
		l.setPositionY(4);
		Goomba g = new Goomba(20, 20);
		g.setPositionX(5);
		g.setPositionY(5);
		KoopaTroopa k = new KoopaTroopa(20, 20);
		k.setPositionX(8);
		k.setPositionY(12);
		PiranhaPlant p = new PiranhaPlant(20, 20);
		p.setPositionX(0);
		p.setPositionY(15);
				
		creatureList.add(m);
		creatureList.add(l);
		creatureList.add(g);
		creatureList.add(k);
		creatureList.add(p);
		
		int expected = 3; //There should be three creatures within the 12 sight range, every creature but PiranhaPlant.
		
		assertEquals(expected, creatureList.get(0).neighborhoodCheck(creatureList).size());
	}
	
	//Tests that random move is called from observe method when no enemies are present.
	@Test
	void ObserveCheckMoveTest() {
		ArrayList<Creature> creatureList = new ArrayList<Creature>();
		ArrayList<Item> itemList = new ArrayList<Item>();
		
		Mario m = new Mario(20, 20);
		m.setPositionX(10);
		m.setPositionY(10);
		
		creatureList.add(m);
		
		creatureList.get(0).observe(creatureList.get(0).neighborhoodCheck(creatureList), creatureList.get(0).itemWorldCheck(itemList));
		
		int startingX = 10;
		int startingY = 10;
		
		assertNotEquals(startingX, creatureList.get(0).getPositionX());  //Means the creature moved, which means the method was called correctly.
		assertNotEquals(startingY, creatureList.get(0).getPositionY());
	}
	
	//Tests correct attack range.
	@Test
	void GetAttackRangeTest() {
		Mario m = new Mario(20, 20);
		
		int expected = 4;
		
		assertEquals(expected, m.getAttackRange());
	}
	
	//Tests to make sure attack method is called while creature is within attack range and that it does correct damage.
	@Test
	void ObserveCheckAttackTest() {
		ArrayList<Creature> creatureList = new ArrayList<Creature>();
		ArrayList<Item> itemList = new ArrayList<Item>();
		
		Mario m = new Mario(20, 20);
		m.setPositionX(10);
		m.setPositionY(10);
		Goomba g = new Goomba(20,20);
		g.setPositionX(13);
		g.setPositionY(13);
		
		creatureList.add(m);
		creatureList.add(g);
		
		creatureList.get(0).observe(creatureList.get(0).neighborhoodCheck(creatureList), creatureList.get(0).itemWorldCheck(itemList));
		
		int fullHealth = 50;  //The starting health of a Goomba.
		int expectedHealth = 20;  //One attack should be 30, so 50 - 30 should be 20.
		
		assertNotEquals(fullHealth, creatureList.get(1).getHealth());  //Means the Goomba no longer has full health.
		assertEquals(expectedHealth, creatureList.get(1).getHealth());
	}
	
	//Tests to make sure creature moves towards enemy to attack it.
	@Test
	void ObserveMoveTowardsEnemyTest() {
		ArrayList<Creature> creatureList = new ArrayList<Creature>();
		ArrayList<Item> itemList = new ArrayList<Item>();
		
		Mario m = new Mario(20, 20);
		m.setPositionX(10);
		m.setPositionY(10);
		Goomba g = new Goomba(20,20);
		g.setPositionX(15);
		g.setPositionY(15);
		
		creatureList.add(m);
		creatureList.add(g);
		
		creatureList.get(0).observe(creatureList.get(0).neighborhoodCheck(creatureList), creatureList.get(0).itemWorldCheck(itemList));
		
		int expectedX = 14;  //The expected position of the move towards the enemy, full amount in both X and Y directions.
		int expectedY = 14;
		
		assertEquals(expectedX, creatureList.get(0).getPositionX());
		assertEquals(expectedY, creatureList.get(0).getPositionY());
	}
	
	//Tests to see if aliveFlag is correctly set to false on creatures with health < 1.
	@Test
	void ObserveAttackAliveFlagToFalseTest() {
		ArrayList<Creature> creatureList = new ArrayList<Creature>();
		ArrayList<Item> itemList = new ArrayList<Item>();
		
		Mario m = new Mario(20, 20);
		m.setPositionX(10);
		m.setPositionY(10);
		Goomba g = new Goomba(20,20);
		g.setPositionX(13);
		g.setPositionY(13);
		
		creatureList.add(m);
		creatureList.add(g);
		
		creatureList.get(0).observe(creatureList.get(0).neighborhoodCheck(creatureList), creatureList.get(0).itemWorldCheck(itemList));
		creatureList.get(0).observe(creatureList.get(0).neighborhoodCheck(creatureList), creatureList.get(0).itemWorldCheck(itemList));  //Needs the second attack because one attack is only 30 damage.
		
		boolean expected = false;
		
		assertEquals(expected, creatureList.get(1).getAliveFlag());
	}
	
	//Tests getColor method for full health.
	@Test
	void GetColorTest() {
		Mario m = new Mario();
		
		int expected = 255;  //rgb colors for red.
		int expected2 = 0;
		int expected3 = 0;
		
		assertEquals(expected, m.getColor()[0]);
		assertEquals(expected2, m.getColor()[1]);
		assertEquals(expected3, m.getColor()[2]);
	}
	
	//Tests getColor with changing health, at 50-99% it's the (current health - (current health / 4)), at 1-49% it's the (current health - (current health / 2)), meaning the lower the health in two increments, the darker the color.
	@Test
	void GetColorHealthTest() {
		Mario m = new Mario();
				
		int expectedHalfHealth = 255 - (255 / 4);
		int expectedHalfHealth2 = 0 - (0 / 4);
		int expectedHalfHealth3 = 0 - (0 / 4);
		
		int expectedLessThanHalfHealth = 255 - (255 / 2);
		int expectedLessThanHalfHealth2 = 0 - (0 / 2);
		int expectedLessThanHalfHealth3 = 0 - (0 / 2);
		
		m.setHealth(50);  //Sets health to 50, which is half of the max health of 100 for Mario class.
		
		assertEquals(expectedHalfHealth, m.getColor()[0]);
		assertEquals(expectedHalfHealth2, m.getColor()[1]);
		assertEquals(expectedHalfHealth3, m.getColor()[2]);
		
		m.setHealth(25);  //Sets health to 25, which is a quarter of the max health of 100 for Mario class.
		
		assertEquals(expectedLessThanHalfHealth, m.getColor()[0]);
		assertEquals(expectedLessThanHalfHealth2, m.getColor()[1]);
		assertEquals(expectedLessThanHalfHealth3, m.getColor()[2]);
	}
	
	//Tests to make sure toString has been successfully overwritten.
	@Test
	void ToStringTest() {
		Mario m = new Mario();
		m.setPositionX(10);
		m.setPositionY(10);
		
		String expected = "Health: 100"
						+ "\nColor: 255, 0, 0"
						+ "\nLocation: 10, 10";
		
		assertEquals(expected, m.toString());
	}
	
	//Tests whether creature ignores Mushroom if health over 50.
	@Test
	void IgnoreMushroomIfHealthOver50Test() {
		ArrayList<Creature> creatureList = new ArrayList<Creature>();
		ArrayList<Item> itemList = new ArrayList<Item>();
		
		Mario m = new Mario(20, 20);
		m.setPositionX(10);
		m.setPositionY(10);
		
		Star s = new Star(20, 20);
		s.setPositionX(15);
		s.setPositionY(15);
		
		creatureList.add(m);
		itemList.add(s);
		
		
	}
	
	//Tests whether creature moves towards Mushroom when health is less than 50.
	@Test
	void LessThan50HealthMoveToMushroomTest() {
		ArrayList<Creature> creatureList = new ArrayList<Creature>();
		ArrayList<Item> itemList = new ArrayList<Item>();
		
		Mario mario = new Mario(20, 20);
		mario.setPositionX(10);
		mario.setPositionY(10);
		
		Mushroom mushroom = new Mushroom(20, 20);
		mushroom.setPositionX(15);
		mushroom.setPositionY(15);
		
		creatureList.add(mario);
		itemList.add(mushroom);
		
		
	}
	
	//Tests to see if creature successfully picks up Mushroom (based on attack range) and is healed by it.
	@Test
	void PickUpMushroomAndGetHealedTest() {
		ArrayList<Creature> creatureList = new ArrayList<Creature>();
		ArrayList<Item> itemList = new ArrayList<Item>();
		
		Mario mario = new Mario(20, 20);
		mario.setPositionX(10);
		mario.setPositionY(10);
		mario.setHealth(50);
		
		Mushroom mushroom = new Mushroom(20, 20);
		mushroom.setPositionX(13);  //Within creature's attack range.
		mushroom.setPositionY(13);
		
		creatureList.add(mario);
		itemList.add(mushroom);
		
		creatureList.get(0).observe(creatureList.get(0).neighborhoodCheck(creatureList), creatureList.get(0).itemWorldCheck(itemList));
		
		int expectedHealth = 100;  //Current health is 50, Mushroom should heal 50, 50 + 50 = should be 100.
		
		assertEquals(expectedHealth, creatureList.get(0).getHealth());
	}
	
	//Tests to see if Star Item is equipped when in range.
	@Test
	void EquipStarItemWhenInRangeTest() {
		ArrayList<Creature> creatureList = new ArrayList<Creature>();
		ArrayList<Item> itemList = new ArrayList<Item>();
		
		Mario mario = new Mario(20, 20);
		mario.setPositionX(10);
		mario.setPositionY(10);
		
		Star star = new Star(20, 20);
		star.setPositionX(12);
		star.setPositionY(12);
		
		creatureList.add(mario);
		itemList.add(star);
		
		boolean expectedItemEquippedFlagPrior = false;
		Item expectedEuippedItemPrior = null;
		
		assertEquals(expectedItemEquippedFlagPrior, creatureList.get(0).getItemEquippedFlag());
		assertEquals(expectedEuippedItemPrior, creatureList.get(0).getEquippedItem());
		
		creatureList.get(0).observe(creatureList.get(0).neighborhoodCheck(creatureList), creatureList.get(0).itemWorldCheck(itemList));
		
		boolean expectedItemEquippedFlagAfter = true;
		Item expectedEquippedItemAfer = star;
		
		assertEquals(expectedItemEquippedFlagAfter, creatureList.get(0).getItemEquippedFlag());
		assertEquals(expectedEquippedItemAfer, creatureList.get(0).getEquippedStar());
	}
	
	//Tests observe method when Star item is equipped.
	@Test
	void ObserveWhenItemEquippedTest() {
		ArrayList<Creature> creatureList = new ArrayList<Creature>();
		ArrayList<Item> itemList = new ArrayList<Item>();
		
		Mario mario = new Mario(20, 20);
		mario.setPositionX(10);
		mario.setPositionY(10);
		
		Star star = new Star(20, 20);
		star.setPositionX(12);
		star.setPositionY(12);
		
		creatureList.add(mario);
		itemList.add(star);

		creatureList.get(0).observe(creatureList.get(0).neighborhoodCheck(creatureList), creatureList.get(0).itemWorldCheck(itemList));
		
		int expectedAttackPower = 60;  //Default is 30, Star should * 2, means should be 60.
		int expectedDefense = 100;  //Default is 0, making it 100 is effectively invulnerability with the current numbers.
		int expectedMoveNumberOfSpaces = 8;  //Default is 4, Star should * 2, should be 8;
		
		assertEquals(expectedAttackPower, creatureList.get(0).getAttackPower());
		assertEquals(expectedDefense, creatureList.get(0).getDefense());
		assertEquals(expectedMoveNumberOfSpaces, creatureList.get(0).getMoveNumberOfSpaces());
	}
	
	//Tests observe to see if item unequips properly.
	@Test
	void ObserveWhenItemShouldUnequipTest() {
		ArrayList<Creature> creatureList = new ArrayList<Creature>();
		ArrayList<Item> itemList = new ArrayList<Item>();
		
		Star star = new Star(20, 20);
		
		Mario mario = new Mario(20, 20);
		mario.setPositionX(10);
		mario.setPositionY(10);
		mario.setEquippedStar(star);
		mario.setItemEquippedFlag(true);
		star.setItemDuration(0);
		
		creatureList.add(mario);
		itemList.add(star);
		
		creatureList.get(0).observe(creatureList.get(0).neighborhoodCheck(creatureList), creatureList.get(0).itemWorldCheck(itemList));
		
		boolean expectedItemEquippedFlag = false;
		Item expectedEquippedItem = null;
		
		assertEquals(expectedItemEquippedFlag, creatureList.get(0).getItemEquippedFlag());
	}
	

}
