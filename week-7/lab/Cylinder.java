//Justin Friends
//CSCI 165 Java
//Inheritance Lab

public class Cylinder extends MyCircle {
	private double height;
	
	
	public Cylinder() {
		super();
		height = 1.0;
	}
	
	public Cylinder(double height) {
		super();
		this.height = height;
	}
	
	public Cylinder(double radius, double height) {
		super(radius);
		this.height = height;
	}
	
	public Cylinder(MyPoint center, double radius, double height) {
		super(center, radius);
		this.height = height;
		
	}
	
	
	//Setters
	public void setHeight(double height) {
		this.height = height;
	}
	
	
	//Getters
	public double getHeight() {
		return this.height;
	}
	
	public double getVolume() {
		double pi = 3.14;
		double volume = pi * Math.pow(getRadius(), 2) * height;
		
		return volume;
	}
	
	
	//Methods
	
	@Override
	public String toString() {
		String state = "";
		
		state = super.toString() + "\n Height: " + this.height + "\n Volume: " + getVolume();
				
		return state;
	}
	
	@Override
	public boolean equals(Object otherCylinder) {
		if(this == otherCylinder) {
			return true;
		}
		if(otherCylinder == null) {
			return false;
		}
		if(getClass() != otherCylinder.getClass()) {
			return false;
		}
		
		Cylinder cylinder = (Cylinder) otherCylinder;
		if(this.getCenter().equals(cylinder.getCenter()) && this.height == cylinder.getHeight()) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
}
