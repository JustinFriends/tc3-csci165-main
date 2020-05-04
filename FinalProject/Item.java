
public abstract class Item {
	private String name;
	private boolean pickedUpFlag = false;
	
	public Item() {};
	
	public Item(String name) {
		this.name = name;
	}
	
	
	//Setters
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPickedUpFlag(boolean condition) {
		this.pickedUpFlag = condition;
	}
	
	
	//Getters
	public String getName() {
		return name;
	}
	
	public boolean getPickedUpFlag() {
		return pickedUpFlag;
	}
	
}
