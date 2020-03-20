//Justin Friends
//CSCI 165 Java
//Inheritance Lab

public class MyPoint {
	private int x = 0;
	private int y = 0;
	
	public MyPoint() {
		this.x = 0;
		this.y = 0;
	}
	
	public MyPoint(int x, int y ) {
		this.x = x;
		this.y = y;
	}
	
	//Copy Constructor
	public MyPoint(MyPoint copy) {
		this(copy.x, copy.y);
	}
	
	
	//Setters
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setXY(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	
	//Getters
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int[] getXY(){
		int[] coordinates = new int[] {this.x, this.y};
		
		return coordinates;
	}
	
	
	//Methods
	public double distance(int x, int y) {
		double distance = Math.sqrt(Math.pow(Math.abs(this.x - x), 2) + Math.pow(Math.abs(this.y - y), 2));
		
		return distance;
	}
	
	public double distance(MyPoint another) {
		double distance = Math.sqrt(Math.pow(Math.abs(this.x - another.x), 2) + Math.pow(Math.abs(this.y - another.y), 2));
		
		return distance;
	}
	
	public double distance() {
		double distance = Math.sqrt(Math.pow(Math.abs(this.x - 0), 2) + Math.pow(Math.abs(this.y - 0), 2));
		
		return distance;
	}
	
	@Override
	public String toString() {
		String state = "";
		
		state = "(" + x + ", " + y + ")";
		
		return state;
	}
	
	@Override
	public boolean equals(Object otherPoint) {
		if(this == otherPoint) {
			return true;
		}
		if(otherPoint == null) {
			return false;
		}
		if(getClass() != otherPoint.getClass()) {
			return false;
		}
		
		MyPoint point = (MyPoint) otherPoint;
		if(this.x == point.x && this.y == point.y) {
			return true;
		}
		else {
			return false;
		}
		//return true;
	}
	
	
	
	
}
