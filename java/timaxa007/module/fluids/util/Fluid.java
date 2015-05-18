package timaxa007.module.fluids.util;

import net.minecraft.util.StatCollector;
import timaxa007.smt.util.UtilString;

/**
 * @author timaxa007
 * @param 
 * @param 
 * @param 
 **/
public class Fluid {

	private String tag;
	private String name;
	private int color_hex;
	private float temperature;
	private String texture;

	private int food_level;
	private float saturation;
	private int drink_level;
	private float quenching;
	private int speed_drinking;
	private boolean safe_drink;

	public Fluid(String tag) {
		this.tag = tag;
		color_hex = 0x00FFFFFF;
		temperature = 0.0F;
		food_level = 0;
		saturation = 0.0F;
		drink_level = 0;
		quenching = 0.0F;
		speed_drinking = 32;
		safe_drink = false;
	}
	//--------------------------------------------------------
	public String getTag() {return tag;}

	public Fluid setName(String name) {
		this.name = name;
		return this;
	}

	public String getName() {
		return UtilString.hasString(name) ? name : UtilString.hasString(tag) ? tag : "unname";
	}

	public String getLocalizedName() {
		return StatCollector.translateToLocal("fluid." + getName() + ".name");
	}

	/**0 x AA RR GG BB**/
	public Fluid setColor(int color) {
		color_hex = color;
		return this;
	}

	/**0 x AA RR GG BB**/
	public int getColor() {return color_hex;}

	public Fluid setTemperature(float f) {
		temperature = f;
		return this;
	}

	public float getTemperature() {return temperature;}

	public Fluid setTexture(String path) {
		texture = path;
		return this;
	}

	public String getTexture() {
		return texture == null ? getName() : texture;
	}

	public Fluid setFoodStat(int food_level, float saturation) {
		this.food_level = food_level;
		this.saturation = saturation;
		this.safe_drink = true;
		return this;
	}

	public int getFoodLevel() {return food_level;}
	public float getFoodSaturation() {return saturation;}

	public Fluid setDrinkStat(int drink_level, float quenching) {
		this.drink_level = drink_level;
		this.quenching = quenching;
		this.safe_drink = true;
		return this;
	}

	public int getDrinkLevel() {return drink_level;}
	public float getThirstQuenching() {return quenching;}

	public Fluid setNutriment(int food_level, float saturation, int drink_level, float quenching) {
		this.food_level = food_level;
		this.saturation = saturation;
		this.drink_level = drink_level;
		this.quenching = quenching;
		this.safe_drink = true;
		return this;
	}

	public Fluid setNutriment(int food_level, float saturation, int drink_level, float quenching, int speed_drinking) {
		this.food_level = food_level;
		this.saturation = saturation;
		this.drink_level = drink_level;
		this.quenching = quenching;
		this.speed_drinking = speed_drinking;
		this.safe_drink = true;
		return this;
	}

	public boolean isNutriment() {
		return (food_level > 0 || saturation > 0.0F || drink_level > 0 || quenching > 0.0F);
	}

	public boolean isFeeding() {
		return (food_level > 0 || saturation > 0.0F);
	}

	public boolean isDrinking() {
		return (drink_level > 0 || quenching > 0.0F);
	}

	public Fluid setSpeedDrinking(int speed_drinking) {
		this.speed_drinking = speed_drinking;
		return this;
	}

	public int getSpeedDrinking() {return speed_drinking;}

	public Fluid setSafeDrink(boolean safe_drink) {
		this.safe_drink = safe_drink;
		return this;
	}

	public boolean getSafeDrink() {return safe_drink;}

	public String toString() {
		return "Fluid: " + getTag() + ".";
	}

}

