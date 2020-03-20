import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CylinderTest {

	@Test
	void testGetVolume() {
		MyPoint p1 = new MyPoint(2, 3);
		Cylinder cy1 = new Cylinder(p1, 3.0, 5.0);
		
		//Formula for volume of a cylinder is Pi * r^2 * height.  So 3.14 * 3.0^2 * 5.0 = 141.3.
		double expectedVolume = 141.3;
		
		assertEquals(expectedVolume, cy1.getVolume());
	}
	
	@Test
	void testEqualsTo() {
		MyPoint p1 = new MyPoint(2, 3);
		Cylinder cy1 = new Cylinder(p1, 3.0, 5.0);
		Cylinder cy2 = new Cylinder(p1, 3.0, 5.0);
		
		boolean expectedBoolean = true;
		
		assertEquals(expectedBoolean, cy1.equals(cy2));
	}

}
