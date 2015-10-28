package timaxa007.pack.cookery.registry;


public abstract class Nutrient {
	//-----------------------------------------------------------------------------------------------
	private String tag;

	private int food_level;
	private int saturation;

	private int liquid_level;
	private int quenching;

	/**В тиках\In ticks.**/
	private int speed_eating;

	/**<b>false</b> - item, <b>true</b> - block.**/
	private boolean form;
	//-----------------------------------------------------------------------------------------------
	@Deprecated public Nutrient() {}

	public Nutrient(String tag) {
		this.tag = tag;

		food_level = 0;
		saturation = 0;
		liquid_level = 0;
		quenching = 0;
		speed_eating = 20;

		form = false;
	}

	public Nutrient(String tag, boolean form) {
		this.tag = tag;

		food_level = 0;
		saturation = 0;
		liquid_level = 0;
		quenching = 0;
		speed_eating = 20;

		this.form = form;
	}
	//-----------------------------------------------------------------------------------------------
	public String getTag() {return tag;}

	public Nutrient setForm(boolean form) {this.form = form;return this;}
	public boolean isItem() {return !form;}
	public boolean isBlock() {return form;}

	public Nutrient setStat(int food_level, int saturation, int liquid_level, int quenching) {
		this.food_level = food_level;
		this.saturation = saturation;
		this.liquid_level = liquid_level;
		this.quenching = quenching;
		return this;
	}

	public Nutrient setFood(int food_level, int saturation) {
		this.food_level = food_level;
		this.saturation = saturation;
		return this;
	}
	public int getFoodLevel() {return food_level;}
	public int getSaturation() {return saturation;}

	public Nutrient setLiquid(int liquid_level, int quenching) {
		this.liquid_level = liquid_level;
		this.quenching = quenching;
		return this;
	}
	public int getLiquidLevel() {return liquid_level;}
	public int getQuenching() {return quenching;}


	public Nutrient setSpeedEating(int speed_eating) {this.speed_eating = speed_eating;return this;}
	public int getSpeedEating() {return speed_eating;}
	//-----------------------------------------------------------------------------------------------
}
