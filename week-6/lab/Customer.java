//Justin Friends
//CSCI 165 Java
//Lab 6

public class Customer {
	private String firstName;
	private String lastName;
	private String email;
	private Address address;
	
	Customer() {}
	
	Customer(String firstName, String lastName, String email, Address address){
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = emailCheck(email);
		this.address = address;
	}
	
	Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	//Copy Constructor
	public Customer(Customer toClone) {
		this.firstName = toClone.firstName;
		this.lastName = toClone.lastName;
		this.email = toClone.email;
		this.address = new Address(toClone.address);
	}
	
	//Setters
	public void setName(String first, String last) {
		this.firstName = first;
		this.lastName = last;
	}
	
	public void setEmail(String email ) {
		this.email = emailCheck(email);
	}
	
	//Getters
	public String getName() {
		return this.firstName + " " + this.lastName;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	//Methods
	public boolean equals(Customer otherCustomer) {
		if(this.firstName == otherCustomer.firstName && this.lastName == otherCustomer.lastName &&
		   this.email == otherCustomer.email && this.address == otherCustomer.address) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		String state = "";
		state = "Customer: " + this.getName() + "\n" +
				"Email: " + this.getEmail() + "\n" +
				"Address: " + this.address;
		
		return state;
	}
	
	//Domain validations
	public String emailCheck(String email) {
		int countOfAts = 0;
		for(int i = 0; i < email.length(); i++) {
			if(email.charAt(i) == '@') {
				countOfAts++;
			}
		}
		
		int posOfDomainPeriod = email.lastIndexOf('.');
		int posOfAt = email.lastIndexOf('@');
		
		if(countOfAts > 1 || countOfAts < 1 || posOfAt > posOfDomainPeriod || (email.length() - 1 - posOfDomainPeriod) > 3) {
			return "No valid e-mail on record";
		}
		else {
			return email;
		}
	}
	
}
