//Justin Friends
//CSCI 165 Java
//Inheritance Lab

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//MyPoints array stuff.
		MyPoint[] points = new MyPoint[10];
		
		for(int i = 0; i < points.length; i++) {
			MyPoint p = new MyPoint(i + 1, i + 1);
			points[i]= p;
		}
		
		for(int i = 0; i < points.length; i++) {
			System.out.println(points[i]);
		}
		
		//MyCircle array stuff.
		MyCircle[] circles = new MyCircle[10];
		
		for(int i = 0; i < circles.length; i++) {
			MyCircle c = new MyCircle(points[i], i + 1);
			circles[i] = c; 
		}
		
		for(int i = 0; i < circles.length; i++) {
			System.out.println(circles[i]);
		}
		
		//Cylinder objects plus MyCircle method calls.
		Cylinder c1 = new Cylinder();
		Cylinder c2 = new Cylinder(6);
		Cylinder c3 = new Cylinder(4, 8);
		Cylinder c4 = new Cylinder(points[5], 10, 12);
		
		System.out.println("C1's Radius is: " + c1.getRadius());
		System.out.println("C2's Area is: " + c2.getArea());
		System.out.print("C3's Circumference is: " + c3.getCircumference());
		System.out.println();
		
		//Mixed objects array.
		MyCircle[] cirButReallyCyl = new MyCircle[10];
		
		for(int i = 0; i < 5; i++) {
			cirButReallyCyl[i] = circles[i];
			Cylinder cy = new Cylinder(points[i + 5], i + 2, i + 4);
			cirButReallyCyl[i + 5] = cy;
		}
		
		for(int i = 0; i < cirButReallyCyl.length; i++) {
			System.out.println(cirButReallyCyl[i]);
		}
		
		//Second mixed objects array.
		Object[] moarObjects = new Object[9];
		
		for(int i = 0; i < 3; i++) {
			moarObjects[i]= points[i + 2];
			
			moarObjects[i + 3] = circles[i + 5];
			
			Cylinder cy = new Cylinder(points[i + 5], i + 2, i + 4);
			moarObjects[i + 6] = cy;
		}
		
		for(int i = 0; i < moarObjects.length; i++) {
			System.out.println(moarObjects[i]);
		}
		
		//Second mixed objects array with added Temperature values.
		//Second mixed objects array.
		Object[] moarObjects2 = new Object[12];
		
		for(int i = 0; i < 3; i++) {
			moarObjects2[i]= points[i + 2];
			
			moarObjects2[i + 3] = circles[i + 5];
			
			Cylinder cy = new Cylinder(points[i + 5], i + 2, i + 4);
			moarObjects2[i + 6] = cy;
			
			Temperature t = new Temperature(i + 50, Temperature.Degree.F);
			moarObjects2[i + 9] = t;
		}
		
		for(int i = 0; i < moarObjects2.length; i++) {
			System.out.println(moarObjects2[i]);
		}
		
		//I'm not entirely sure why this is happening, but I'm guessing it's because even though upcasting loses
		//variables/added things from the subclasses, it still retains which class type it is, which then calls
		//the overridden toString for that class.
		
	}

}
