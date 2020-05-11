
public class Star extends Item {
	private int itemDuration = 5;
	
	public Star() {
	
	}
	
	public Star(int positionX, int positionY) {
		super(positionX, positionY);
		this.setDefaultColor(255, 255, 0);  //Yellow.
		setName("Star");
	}
	
	
	//Setters
	public void setItemDuration(int itemDuration) {
		this.itemDuration = itemDuration;
	}
	
	
	//Getters
	public int getItemDuration() {
		return itemDuration;
	}
	
	
	//Methods
	public void itemDegredation() {
		setItemDuration(getItemDuration() - 1);
		
		if (getItemDuration() < 1) {
			setAliveFlag(false);
		}
	}
}
