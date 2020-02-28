//Justin Friends
//CSCI 165 Java
//Temperature Lab

public class TemperatureDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
						
		Temperature t = new Temperature(1, Temperature.Degree.F);
		Temperature t2 = new Temperature(100, Temperature.Degree.C);
		Temperature t3 = new Temperature(25, Temperature.Degree.C);
		Temperature t4 = new Temperature(77, Temperature.Degree.F);
		Temperature t5 = new Temperature();
		
		System.out.println(t.getTempCelsius());
		System.out.println(t.getTempFahrenheit());
		
		System.out.println();
		
		System.out.println(t2.getTempCelsius());
		System.out.println(t2.getTempFahrenheit());
		
		System.out.println();
		
		System.out.println(t3.getTempCelsius());
		System.out.println(t3.getTempFahrenheit());
		
		System.out.println();
		
		System.out.println(t3.equals(t4));
		System.out.println(t3.equals(t));
		
		System.out.println();
		
		System.out.println(t3.compareTo(t4));
		System.out.println(t3.compareTo(t));
		
		System.out.println();
		
		System.out.println(t);
		
		System.out.println();
		
		t5.setAll(212, Temperature.Degree.F);
		System.out.println(t5.getDegree());
		System.out.println(t5.getTempFahrenheit());
		
	}
}
