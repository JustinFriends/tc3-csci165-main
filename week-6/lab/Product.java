//Justin Friends
//CSCI 165 Java
//Lab 6

public class Product {
	
		private String name;
		private String description;
		private double price;
		private String sku;
		
		public Product() {}
		
		public Product(String name, String description, double price, String sku) {
			this.name = name;
			this.description = description;
			this.price = price;
			this.sku = sku;
		}
		
		public Product(String sku) {
			this.sku = sku;
		}
		
		
		//Setters
		public void setName(String name) {
			this.name = name;
		}
		
		public void setPrice(double price) {
			this.price = price;
		}
		
		
		//Getters
		public String getName() {
			return name;
		}
		
		public double getPrice() {
			return price;
		}
		
		
		//Methods
		public Boolean equals(Product otherProduct) {
			
			
			return true;
		}
		
		@Override
		public String toString() {
			String state = "";
			
			return state;
		}
		
		//Domain validations
		//public 
		
		
}
