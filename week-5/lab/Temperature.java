//Justin Friends
//CSCI 165 Java
//Temperature Lab

public class Temperature {
	
	public static enum Degree{F, C};
	private double temp;
	private Degree degree;

	
	//Constructors
	public Temperature() {}
	
	public Temperature(double temp, Degree degree) {
		this.temp = temp;
		this.degree = degree;
	}
	
	
	//Setters
	public void setTemp(double temp) {
		this.temp = temp;
	}
	
	public void setDegree(Degree degree) {
		if (degree == Degree.F) {
			this.degree = Degree.F;
		}
		else if(degree == Degree.C) {
			this.degree = Degree.C;			
		}
	}
	
	public void setAll(double temp, Degree degree) {
		this.temp = temp;
		this.degree = degree;
	}
	
	
	//Getters
	public double getTempCelsius() {
		if(degree == Degree.C) {
			return temp;
		}
		else {
			return this.convertToC(temp);
		}
	}
	
	public double getTempFahrenheit() {
		if(degree == Degree.F) {
			return temp;
		}
		else {
			return this.convertToF(temp);
		}
	}
	
	public Degree getDegree() {
		return degree;
	}
	

	//Helpers
	private double convertToC(double temp) {
		temp = Math.round(5 * (temp - 32) / 9);
		return temp;
	}
	
	private double convertToF(double temp) {
		temp = Math.round((9 * (temp) / 5 ) + 32);
		return temp;
	}
	
	
	//Methods
	public boolean equals(Temperature t) {
		if(this.getTempCelsius() == t.getTempCelsius()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int compareTo(Temperature t) {
		if(this.getTempCelsius() > t.getTempCelsius()) {
			return 1;
		}
		else if(this.getTempCelsius() < t.getTempCelsius()) {
			return -1;
		}
		else {
			return 0;
		}
	}
	
	@Override
	public String toString() {
		String state = "";
		state = "The temperature is: " + temp + " " + (degree == Degree.F ? "F" : "C");
		return state;
	}
	
}
