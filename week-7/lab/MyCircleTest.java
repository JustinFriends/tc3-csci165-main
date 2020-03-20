import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyCircleTest {

	@Test
	void testGetArea() {
		MyCircle c1 = new MyCircle(3.0);
		
		//Area for a circle is Pi * r^2.  So 3.14 * 3.0^2 = 28.26.
		//And as I write this Jtest, it just dawned on me I could have made Pi
		//a global variable in the Driver, perhaps with more accuracy even.  And upon
		//further inspection, I see there is a built in Math.PI function which probably
		//would have worked better.  Next time.
		
		double expectedArea = 28.26;
		
		assertEquals(expectedArea, c1.getArea());
	}
	
	@Test
	void testGetCircumference() {
		MyCircle c1 = new MyCircle(3.0);
		
		//Circumference is 2 * Pi * r, which is 2 * 3.14 * 3 = 18.84.
		double expectedCircumference = 18.84;
		
		assertEquals(expectedCircumference, c1.getCircumference());
	}
	
	@Test
	void testDistance() {
		MyPoint p1 = new MyPoint(1,3);
		MyPoint p2 = new MyPoint(3,9);
		MyCircle c1 = new MyCircle(p1, 2.0);
		MyCircle c2 = new MyCircle(p2, 2.0);
		
		//Same distance formula as used in the MyPoint class.  3 - 1 = 2; 9 - 3 = 6; 2^2 + 6^2 = square root of 40.
		double expectedDifference = Math.sqrt(40);
		
		assertEquals(expectedDifference, c1.distance(c2));
		
	}

}
