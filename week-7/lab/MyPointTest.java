import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MyPointTest {

	@Test
	void testDistanceTwoInts() {
		MyPoint p1 = new MyPoint();
		
		//Random (x, y) point for the method.
		int a = 3, b = 5;
		
		//MyPoint() gives (0,0).  The formula for distance here being Pythagorean's theorem, 
		//3^2 + 5^2 = the square root of 34.
		double expectedDistance = Math.sqrt(34);
		
		assertEquals(expectedDistance, p1.distance(a, b));
	}
	
	@Test
	void testDistanceWithPoint() {
		MyPoint p1 = new MyPoint();
		MyPoint p2 = new MyPoint(5, 10);
		
		//Same principle as above, except 5 and 10.  5^2 + 10^2 = square root of 125.
		double expectedDistance = Math.sqrt(125);
		
		assertEquals(expectedDistance, p1.distance(p2));
	}
	
	@Test
	void testDistanceNoArgs() {
		MyPoint p2 = new MyPoint(2, 4);
		
		//Same principle as above, using 2 and 4.  2^2 + 4^2 = square root of 20.
		double expectedDistance = Math.sqrt(20);
		
		assertEquals(expectedDistance, p2.distance());
	}
	
	@Test
	void testEqualsTo() {
		MyPoint p1 = new MyPoint();
		MyPoint p2 = new MyPoint();
		
		boolean expectedBoolean = true;
		
		assertEquals(expectedBoolean, p1.equals(p2));
	}

}
