//Justin Friends
//CSCI 165 Java
//Lab 5 Temperature

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TemperatureTest {
	
	//Temperature g = new Temperature();

	@Test
	void testConstructorWithArguments() {
		Temperature g = new Temperature(32, Temperature.Degree.F);
		
		double expectedTemp = 32;
		Temperature.Degree expectedDegree = Temperature.Degree.F;
		
		assertEquals(expectedTemp, g.getTempFahrenheit());
		assertEquals(expectedDegree, g.getDegree());
	}
	
	@Test
	void testSetterMethods() {
		Temperature g = new Temperature();
		
		double expectedTemp = 100;
		Temperature.Degree expectedDegree = Temperature.Degree.C;
		
		g.setTemp(100);
		g.setDegree(Temperature.Degree.C);
		
		assertEquals(expectedTemp, g.getTempCelsius());
		assertEquals(expectedDegree, g.getDegree());
		
		Temperature e = new Temperature();
		
		e.setAll(100, Temperature.Degree.C);
		
		assertEquals(expectedTemp, e.getTempCelsius());
		assertEquals(expectedDegree, e.getDegree());
	}
	
	@Test
	void testGetTempCfromF() {
		Temperature g = new Temperature(32, Temperature.Degree.F);
		
		double expected = 0;
		
		assertEquals(expected, g.getTempCelsius());
	}
	
	@Test
	void testGetTempFfromC() {
		Temperature g = new Temperature(0, Temperature.Degree.C);
		
		double expected = 32;
		
		assertEquals(expected, g.getTempFahrenheit());
	}
	
	@Test
	void testBooleanEqualTo() {
		Temperature c = new Temperature(0, Temperature.Degree.C);
		Temperature f = new Temperature(32, Temperature.Degree.F);
		
		boolean expectedBoolean = true;
		
		assertEquals(true, c.equals(f));
	}
	
	@Test
	void testCompareEqualTo() {
		Temperature c = new Temperature(100, Temperature.Degree.C);
		Temperature f = new Temperature(212, Temperature.Degree.F);
		
		int expectedComparisonNum = 0;
		
		assertEquals(expectedComparisonNum, c.compareTo(f));
	}

}
