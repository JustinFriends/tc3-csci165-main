//Justin Friends
//CSCI 165 Java
//Lab 6

public class Account {
	private int accountID;
	private Customer customer;
	private double balance = 0.0;
	private double creditLimit = 0.0;
	private Date dateCreated;
	private double discountLevel = 0.0;
	
	Account() {}
	
	Account(int id, Customer customer){
		this.accountID = id;
		this.customer = customer;
	}
	
	Account(int id, Customer customer, double balance, double creditLimit){
		this.accountID = id;
		this.customer = customer;
		this.balance = balance;
		this.creditLimit = creditLimit;
	}
	
	//Copy Constructor
	public Account(Account toClone) {
		this.accountID = toClone.accountID;
		this.customer = new Customer(customer);
		this.balance = toClone.balance;
		this.creditLimit = toClone.creditLimit;
		this.dateCreated = new Date(dateCreated);
		this.discountLevel = toClone.discountLevel;
	}
	
	
	//Setters
	public void setBalance(double b) {
		this.balance = b;
	}
	
	public void setCreditLimit(double cl) {
		this.creditLimit = cl;
	}
	
	
	//Getters
	public Customer getCustomer() {
		return new Customer(customer);
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public double getCreditLimit() {
		return this.creditLimit;
	}
	
	
	//Methods
	@Override
	public String toString() {
		String state = "";
		state = "AccountID: " + this.accountID + "\n" +
				"Customer: " + this.customer + "\n" +
				"Balance: " + this.balance + "\n" +
				"Credit limit: " + this.creditLimit + "\n" +
				"Date created: " + this.dateCreated + "\n" +
				"Discount level: " + this.discountLevel;
		
		return state;
	}
	
	
	
}
