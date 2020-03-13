//Justin Friends
//CSCI 165 Java
//Lab 6

public class Address {
	
	private String street;
	private String city;
	private String state;
	private String zip;
	
	Address() {}
	
	Address(String street, String city, String state, String zip) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	//Copy Constructor
	public Address(Address toClone) {
		this.street = toClone.street;
		this.city = toClone.city;
		this.state = toClone.state;
		this.zip = toClone.zip;
	}
	
	//Setters
	public void setStreet(String street) {
		this.street = street;
	}
	
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	//Getters
	public String getStreet() {
		return this.street;
	}
	
	public String getCity() {
		return this.city;
	}
	
	public String getState() {
		return this.state;
	}
	
	public String getZip() {
		return this.zip;
	}
	
	//Methods
	public boolean equals(Address otherAddress) {
		if(this.street == otherAddress.street && this.city == otherAddress.city &&
			this.state == otherAddress.state && this.zip == otherAddress.zip) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		String state = "";
		state = this.street + " " + this.city + "," + this.state + " " + this.zip;
		
		return state;
	}
	
	
	//Domain validations
	
	
}
