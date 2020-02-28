//Justin Friends
//CSCI 165 Java
//Lab 5 2016 Election Results Stuff

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class ElectionDriverTest {
	
	@Test
	void testFindLargestMargin() {
		ElectionDriver.fillList();
		
		//Obtained by opening the csv in Excel, running the formula '=MAX(G2:G3142)', which is the diff of every county, which returns 1,273,485.
		//Using CTRL + F for that number gives only one instance in G206, for the county Los Angeles County.
		String expectedCounty = "Los Angeles County";
		
		assertEquals(expectedCounty, ElectionDriver.findLargestMargin());
	}
	
	@Test
	void testFindLargestMarginOverloadedState() {
		ElectionDriver.fillList();
		
		//Obtained by opening the csv in Excel, running the formula '=IF(I31="AL", G31, "")', and the equivalent for every row in order
		//to get every row with the state AL (Alabama).  Then running '=MAX(N31:N97)', all the diff rows that are from AL, which returned 
		//54371, which is the county Baldwin County.  Repeat the process but for WY.
		String expectedCounty = "Baldwin County";
		String expectedCounty2 = "Natrona County";
		
		assertEquals(expectedCounty, ElectionDriver.findLargestMargin("AL"));
		assertEquals(expectedCounty2, ElectionDriver.findLargestMargin("WY"));
	}
	
	//I'm not sure why this is erroring.  It's saying Index 55 out of bounds for length 55, which is the size of the array I made to hold the states 
	//(50 states + DC, plus if they add more) string info, but I'm not calling that index higher than the last entry, so I'm not sure why it's 
	//doing that.  I did test it in Excel though and get the same numbers/results.
	@Test
	void testGetStateTotals() {
		ElectionDriver.fillList();
		ElectionDriver.getStateTotals();
		
		//Obtained by opening the csv in Excel, running the formula '=IF(I3120="WY", B3120, "")' for every row, giving dem votes if the state was
		//WY.  Then running a '=SUM()' on that data.  Then repeating similar processes for each data point in the string.
		String expectedArrayElement = "WY, 55949.0, 174248.0, 118299.0, GOP";
		//String arrayElement = ElectionDriver.getStateTotals()[50];
		
		assertEquals(expectedArrayElement, ElectionDriver.getStateTotals()[50]);
	}

}
