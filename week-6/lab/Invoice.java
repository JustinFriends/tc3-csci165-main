//Justin Friends
//CSCI 165 Java
//Lab 6

import java.util.ArrayList;

public class Invoice {
	
	private String invoiceNumber;
	private Account account;
	private double amount;
	private Date orderDate;
	private ArrayList<Product> products = new ArrayList<Product>();
	
	public Invoice() {}
	
	public Invoice(String inv_num, Account acct, double amount, Date date) {
		this.invoiceNumber = inv_num;
		this.account = acct;
		this.amount = amount;
		this.orderDate = date;
	}
	
	//Setters
	public void setDate(Date orderDate) {
		
	}
	
	
	//Getters
	public Account getAccount() {
		return new Account(account);
	}
	
	public double getAmount() {
		return this.amount;
	}
	
	public Date getDate() {
		return new Date(orderDate);
	}
	
	
	//Methods
	@Override
	public String toString() {
		String state = "";
		
		return state;
	}
	
	/*public int compareTo(Invoice otherInvoice) {
		
		
		return 
	}*/
	
}
