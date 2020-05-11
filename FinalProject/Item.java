
public abstract class Item {
	private String name;
	private int positionX;
	private int positionY;
	private int maxX;
	private int maxY;
	private int[] defaultColor;
	private int[] color;
	private boolean aliveFlag = true;
	private boolean pickedUpFlag = false;
	
	public Item() {};
	
	public Item(String name) {
		this.name = name;
	}
	
	public Item(int maxX, int maxY) {
		this.maxX = maxX;
		this.maxY = maxY;
	}
	
	
	//Setters
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPositionX(int x) {
		this.positionX = x;
	}
	
	public void setPositionY(int y) {
		this.positionY = y;
	}
	
	public void setMaxX(int maxX) {
		this.maxX = maxX;
	}
	
	public void setMaxY(int maxY) {
		this.maxY = maxY;
	}
	
	public void setDefaultColor(int rgb1, int rgb2, int rgb3) {
		this.defaultColor = new int[] { rgb1, rgb2, rgb3 };
	}
	
	public void setColor(int rgb1, int rgb2, int rgb3) {
		this.color = new int[] { rgb1, rgb2, rgb3 };
	}
	
	public void setAliveFlag(boolean condition) {
		this.aliveFlag = condition;
	}
	
	public void setPickedUpFlag(boolean condition) {
		this.pickedUpFlag = condition;
	}
	
	
	//Getters
	public String getName() {
		return name;
	}
	
	public int getPositionX() {
		return positionX;
	}
	
	public int getPositionY() {
		return positionY;
	}
	
	public int getMaxX() {
		return maxX;
	}
	
	public int getMaxY() {
		return maxY;
	}
	
	public int[] getDefaultcolor() {
		return defaultColor;
	}
	
	public int[] getColor() {
		setColor(defaultColor[0], defaultColor[1], defaultColor[2]);
		
		return color;
	}
	
	public boolean getAliveFlag() {
		return aliveFlag;
	}
	
	public boolean getPickedUpFlag() {
		return pickedUpFlag;
	}
	
	
	//Methods
	
	
	
	
	@Override
	public String toString() {
		return "Item: " + getName();
	}
	
	//public void itemPerished() {
	//	if (getAliveFlag() == false) {
	//		setPositionX(-9999);
	//		setPositionY(-9999);
	//	}
	//}
	
	
}
