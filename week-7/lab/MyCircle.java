//Justin Friends
//CSCI 165 Java
//Inheritance Lab

public class MyCircle {
	private MyPoint center;
	private double radius;
	
	MyCircle(){
		//this.center = center.setXY(0, 0);
		//So this doesn't seem like a great way to do this, or perhaps elegant is
		//a better word, but I was having trouble getting it to work otherwise.
		MyPoint p1 = new MyPoint();
		this.center = p1;
		//this.center.setXY(0, 0);
		//this.center.setX(0);
		this.radius = 1;
	}
	
	MyCircle(MyPoint center, double radius){
		this.center = center;
		this.radius = radius;
	}
	
	MyCircle(int x, int y, double radius){
		center.setXY(x, y);
		this.radius = radius;
	}
	
	MyCircle(double radius) {
		//center.setXY(0, 0);
		MyPoint p1 = new MyPoint();
		this.center = p1;
		this.radius = radius;
	}
	
	//Copy Constructor
	MyCircle(MyCircle copy){
		this.center = new MyPoint(center);
		this.radius = copy.radius;
	}
	
	
	//Setters
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public void setCenter(MyPoint center) {
		this.center = center;
	}
	
	public void setCenterX(int x) {
		center.setX(x);
	}
	
	public void setCenterY(int y) {
		center.setY(y);
	}
	
	public void setCenterXY(int x, int y) {
		center.setXY(x, y);
	}
	
	
	//Getters
	public double getRadius() {
		return this.radius;
	}
	
	public MyPoint getCenter() {
		return new MyPoint(center);
	}
	
	public int getCenterX() {
		return center.getX();
	}
	
	public int getCenterY() {
		return center.getY();
	}
	
	public int[] getXY(){
		int[] coordinates = new int[] {getCenterX(), getCenterY()};
		
		return coordinates;
	}
	
	
	//Methods

	//@Override  The directions say to use @Override, but Java Object doesn't have a method called
	//getArea() to override?
	public double getArea() {
		double pi = 3.14;
		double area = pi * Math.pow(this.radius, 2);
		
		return area;
	}

	//@Override  Same as above.
	public double getCircumference() {
		double pi = 3.14;
		double circumference = 2 * pi * this.radius;
		
		return circumference;
	}
	
	public double distance(MyCircle anotherCircle) {
		double distance = center.distance(anotherCircle.getCenter());
				
		return distance;
	}
	
	@Override
	public String toString() {
		String state = "";
		
		state = "MyCircle[radius = " + radius + ", center = " + center.toString() + "]";
				
		return state;
	}
	
	
}
