//Justin Friends
//CSCI 165 Java
//Lab 5 2016 Election Results Stuff

public class CountyResults2016 {
	
	//Instance variables
	private double demVotes;
	private double gopVotes;
	private double totalVotes;
	private double percentDem;
	private double percentGOP;
	private double difference;
	private double percentDifference;
	private String stateAbbreviation;
	private String county;
	private int fips;
	
	
	//Constructors
	public CountyResults2016() {}
	
	public CountyResults2016(double demVotes, double gopVotes, double totalVotes, double percentDem, double percentGOP, 
							double difference, double percentDifference, String stateAbbreviation, String county, int fips) {
		this.demVotes = demVotes;
		this.gopVotes = gopVotes;
		this.totalVotes = totalVotes;
		this.percentDem = percentDem;
		this.percentGOP = percentGOP;
		this.difference = difference;
		this.percentDifference = percentDifference;
		this.stateAbbreviation = stateAbbreviation;
		this.county = county;
		this.fips = fips;		
	}
	
	//Setters
	
	
	//Getters
	public double getTotalVotes() {
		
		return totalVotes;
	}
	
	public double getDemVotes() {
		return demVotes;
	}
	
	public double getGOPVotes() {
		return gopVotes;
	}
	
	public double getDifference() {
		return difference;
	}
	
	public double getPercentDifference() {
		return percentDifference;
	}
	
	public String getState() {
		return stateAbbreviation;
	}
	
	public String getCounty() {
		return county;
	}
	
	
	
	//Methods
	
	@Override
	public String toString() {
		String state = "";
		state = getCounty() + " in the state of " + getState() + " had " + getDemVotes() + " Democratic votes, " + getGOPVotes() + " GOP votes, " + getTotalVotes() + " total votes, a difference of " + 
				getDifference() + ", and a percentage difference of " + getPercentDifference() + "%.";
		return state;
	}
	
	
}
