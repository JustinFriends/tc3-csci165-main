
public class WorldItemHealth extends Item {
	private int healthHealed;
	
	public WorldItemHealth() {}
	
	public WorldItemHealth(int heal) {
		this.healthHealed = heal;
	}
	
	
	//setters
	public void setHealValue(int heal) {
		this.healthHealed = heal;
	}
	
	//getters
	public int getHealValue() {
		return healthHealed;
	}
	
}
