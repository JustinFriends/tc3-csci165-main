
public class Mushroom extends Item{
	private int healthRestoration = 50;
	
	public Mushroom() {
		
	}
	
	public Mushroom(int positionX, int positionY) {
		super(positionX, positionY);
		this.setDefaultColor(0, 255, 255);  //Cyan.
		setName("Mushroom");
	}
	
	
	//Setters
	public void setHealthRestoration(int healthRestoration) {
		this.healthRestoration = healthRestoration;
	}
	
	
	//Getters
	public int getHealthRestoration() {
		return healthRestoration;
	}
	
	
	//Methods
	public void itemUsed() {
		if (getPickedUpFlag() == true) {
			setAliveFlag(false);
			
		}
	}
	
}
