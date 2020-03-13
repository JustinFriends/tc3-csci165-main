//Justin Friends
//CSCI 165 Java
//Lab 6

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Driver {
	
	private static ArrayList<String> zipCodes = new ArrayList<String>();
	private static ArrayList<String> cities = new ArrayList<String>();
	private static ArrayList<String> states = new ArrayList<String>();
	private static ArrayList<Customer> customers = new ArrayList<Customer>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		HashMap<String, String> zipCityState = new HashMap<String, String>();
		
		fillZipCodeList();
		
		//Filling HashMap with the keys and values.
		for(int i = 0; i < zipCodes.size(); i++) {
			zipCityState.put(zipCodes.get(i), cities.get(i) + ", " + states.get(i));
		}		
		
		fillCustomerArray(zipCityState);
		
		for(int j = 0; j < customers.size(); j++)
			System.out.println(customers.get(j));
		
	}
	
	public static void fillZipCodeList() {
		
		try {
			
			File zipCodeList = new File("zip_code_database.csv");
			Scanner zipCodeInfoScanner = new Scanner(zipCodeList);
			
			String lineInfo = "SetMe";
			
			zipCodeInfoScanner.nextLine();
			
			while(zipCodeInfoScanner.hasNextLine()) {
				lineInfo = zipCodeInfoScanner.nextLine();
				
				//String[] zipLine = lineInfo.split(",");
				//String[] extras = lineInfo.split(",", 5);
				
				//String[] checkForCommas = extras[4].split("\"");
				
				String[] testZipLine = lineInfo.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
				
				zipCodes.add(testZipLine[0]);
				cities.add(testZipLine[3].replaceAll("\"", ""));
				states.add(testZipLine[6]);
				
				//Couldn't get this to work for all cases, then stumbled upon the above through the wonders
				//of the web.  Sets constraints to split on commas unless the commas are in a quote (presumably
				//like we just learned about for JavaScript).
				
				/*for(int i = 0; i < checkForCommas.length; i++) {
					int count = 0;
					for(int j = 0; j < checkForCommas[i].length(); j++) {
						if(checkForCommas[i].charAt(j) == '"') {
							count++;
						}
					}
					
					if(checkForCommas[i].indexOf(",") == -1) {
						zipCodes.add(zipLine[0]);
						cities.add(zipLine[3]);
						states.add(zipLine[6]);
					}
					else if(count == 4){
						zipCodes.add(zipLine[0]);
						cities.add(zipLine[3]);
						states.add(zipLine[6]);
					}
					else {
						zipCodes.add(zipLine[0]);
						cities.add(zipLine[3]);
						states.add(zipLine[7]);
					}
				}*/
			}
			
			zipCodeInfoScanner.close();
			
		}
		catch(FileNotFoundException fnf){
			System.out.println("Error: File not found.");
		}
		
	}
	
	public static void fillCustomerArray(HashMap<String, String> zipCityState) {
		try {
			
			File customerList = new File("customers.txt");
			Scanner customerInfoScanner = new Scanner(customerList);
			
			String lineInfo = "SetMe";
			String addressInfo = "SetMe";
			String firstName = "SetMe";
			String lastName = "SetMe";
			String email = "SetMe";
			String zip = "SetMe";
			String streetAddress = "SetMe";
			String city = "SetMe";
			String state = "SetMe";
			
			
			
			while(customerInfoScanner.hasNextLine()) {
				lineInfo = customerInfoScanner.nextLine();
				
				String[] custLine = lineInfo.split("\t", 4);
				addressInfo = custLine[3];
				
				int pos = addressInfo.lastIndexOf("\t");
				streetAddress = addressInfo.substring(0, pos).replaceAll("\t", " ");
				zip = addressInfo.substring(pos).replaceAll("\t", "");
				
				firstName = custLine[0];
				lastName = custLine[1];
				email = custLine[2];
				
				String cityState = zipCityState.get(zip);
				pos = cityState.indexOf(",");
				city = cityState.substring(0, pos);
				state = zipCityState.get(zip).substring(pos + 1);
				
				Address addr = new Address(streetAddress, city, state, zip);
				
				Customer cust = new Customer(firstName, lastName, email, addr);
				
				customers.add(cust);
			}
			
			customerInfoScanner.close();
			
		}
		catch(FileNotFoundException fnf){
			System.out.println("Error: File not found.");
		}
		
	}
	
	//public static void

}
