//Justin Friends
//CSCI 165 Java
//Lab 5 2016 Election Results Stuff

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ElectionDriver {
	
	private static ArrayList<CountyResults2016> results = new ArrayList<CountyResults2016>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<CountyResults2016> election2016 = new ArrayList<CountyResults2016>();
		
		fillList();
		
		System.out.println(findLargestMargin());
		
		System.out.println(findLargestMargin("AL"));
		
		System.out.println(results.get(37));
		
		getStateTotals();
		System.out.println(getStateTotals()[50]);
	}

	public static void fillList() {
		
		try {
					
			File presidentialElectionData2016 = new File("2016_US_County_Level_Presidential_Results.csv");
			Scanner voteDataScanner = new Scanner(presidentialElectionData2016);
			
			int counter = 0;
			String lineInfo = "SetMe";
			
			voteDataScanner.nextLine();
			
			while(voteDataScanner.hasNextLine()) {
				lineInfo = voteDataScanner.nextLine();
				
				String[] data = lineInfo.split(",");
				String[] dataQuotationMarks = lineInfo.split("\"");
				
				double demVotes = Double.parseDouble(data[1]);
				double gopVotes = Double.parseDouble(data[2]);
				double totalVotes = Double.parseDouble(data[3]);
				double percentDem = Double.parseDouble(data[4]);
				double percentGOP = Double.parseDouble(data[5]);
				double difference;
				String percentDiff;
				int pos;
				String stateAbrev;
				String county;
				int fips;
				if(lineInfo.indexOf("\"") == -1) {
					difference = Double.parseDouble(data[6]);
					percentDiff = data[7];
					pos = data[7].indexOf("%");
					stateAbrev = data[8];
					county = data[9];
					fips = Integer.parseInt(data[10]);
				}
				else {
					difference = Double.parseDouble(dataQuotationMarks[1].replaceAll(",", ""));
					if(dataQuotationMarks[1].replaceAll(",", "").length() > 6) {
						percentDiff = data[9];
						pos = data[9].indexOf("%");
						stateAbrev = data[10];
						county = data[11];
						fips = Integer.parseInt(data[12]);
					}
					else {
						percentDiff = data[8];
						pos = data[8].indexOf("%");
						stateAbrev = data[9];
						county = data[10];
						fips = Integer.parseInt(data[11]);
					}
					
				}
				double percentDifference = Double.parseDouble(percentDiff.substring(0, pos));
				
				CountyResults2016 cr = new CountyResults2016(demVotes, gopVotes, totalVotes, percentDem, percentGOP, difference, percentDifference, stateAbrev, county, fips);
				
				results.add(cr);
				
				//System.out.println(counter);
				//System.out.println(cr);
				counter++;
			}
			
			voteDataScanner.close();
			
		}
		
		catch(FileNotFoundException fnf){
			System.out.println("Error: File not found.");
		}
		
		
	}
	
	public static String findLargestMargin() {
		double largest = results.get(0).getDifference();
		int counter = 0;
		
		for(int x = 0; x < results.size(); x++) {
			if(largest < results.get(x).getDifference()) {
				largest = results.get(x).getDifference();
				counter = x;
			}
		}
		
		String largestMargin = results.get(counter).getCounty();
		
		return largestMargin;
	}
	
	public static String findLargestMargin(String state) {
		double largest = 0;
		int counter = 0;
		
		for(int x = 0; x < results.size(); x++) {
			if((results.get(x).getState()).equals(state)) {
				if(largest < results.get(x).getDifference()) {
					largest = results.get(x).getDifference();
					counter = x;
				}
			}
		}
		
		String largestMargin = results.get(counter).getCounty();
		
		return largestMargin;
	}
	
	public static String[] getStateTotals() {
		String[] stateTotals = new String[55];
		String state = results.get(0).getState();
		String winningParty = "";
		double totalDem = 0, totalGOP = 0, marginOfVic = 0, totalDemLast = 0, totalGOPLast = 0;
		int counter = 0;
		
		for(int x = 0; x < results.size(); x++) {
			if(results.get(x).getState().equals(state)){
				totalDem = totalDem + results.get(x).getDemVotes();
				totalGOP = totalGOP + results.get(x).getGOPVotes();
				totalDemLast = totalDem;
				totalGOPLast = totalGOP;
			}
			else {								
				if(totalDem > totalGOP) {
					winningParty = "Democrats";
					marginOfVic = totalDem - totalGOP;
				}
				else {
					winningParty = "GOP";
					marginOfVic = totalGOP - totalDem;
				}
				stateTotals[counter] = results.get(x-1).getState() + ", " + Double.toString(totalDem) + ", " + Double.toString(totalGOP) + 
										", " + Double.toString(marginOfVic) + " " + winningParty;
				totalDem = 0 + results.get(x).getDemVotes(); 
				totalGOP = 0 + results.get(x).getGOPVotes();
				state = results.get(x).getState();
				counter++;
				
			}
		}//End for loop.
		if(totalDemLast > totalGOPLast) {
			winningParty = "Democrats";
			marginOfVic = totalDemLast - totalGOPLast;
		}
		else {
			winningParty = "GOP";
			marginOfVic = totalGOPLast - totalDemLast;
		}
		stateTotals[counter] = results.get(results.size() - 1).getState() + ", " + Double.toString(totalDemLast) + ", " + Double.toString(totalGOPLast) + 
								", " + Double.toString(marginOfVic) + " " + winningParty;
		
		return stateTotals;
	}
	
}