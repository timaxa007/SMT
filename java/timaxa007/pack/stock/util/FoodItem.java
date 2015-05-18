package timaxa007.pack.stock.util;

import net.minecraft.util.StatCollector;
import timaxa007.module.environment.Temperature;
import timaxa007.smt.util.UtilString;

public class FoodItem {

	private String tag;
	private String name;

	private int food_level;
	private float saturation;
	private int drink_level;
	private float quenching;
	private int speed_eating;

	public Temperature temperature;

	public FoodItem(String tag) {
		this.tag = tag;
		food_level = 0;
		saturation = 0.0F;
		drink_level = 0;
		quenching = 0.0F;
		speed_eating = 32;
		this.temperature = Temperature.create(32.0F, 16.0F, 48.0F);
	}
	//--------------------------------------------------------
	public String getTag() {
		return tag;
	}

	public FoodItem setName(String name) {
		this.name = name;
		return this;
	}

	public String getName() {
		return UtilString.hasString(name) ? name : UtilString.hasString(tag) ? tag : "unname";
	}

	public String getLocalizedName() {
		return StatCollector.translateToLocal("food." + getName() + ".name");
	}

	public FoodItem setSpeedOfEating(int speed_eating) {
		this.speed_eating = speed_eating;
		return this;
	}

	public int getSpeedOfEating() {return speed_eating;}

	public FoodItem setFoodStat(int food_level, float saturation) {
		this.food_level = food_level;
		this.saturation = saturation;
		return this;
	}

	public int getFoodLevel() {return food_level;}
	public float getFoodSaturation() {return saturation;}

	public FoodItem setDrinkStat(int drink_level, float quenching) {
		this.drink_level = drink_level;
		this.quenching = quenching;
		return this;
	}

	public int getDrinkLevel() {return drink_level;}
	public float getThirstQuenching() {return quenching;}

	public FoodItem setNutriment(int food_level, float saturation, int drink_level, float quenching) {
		this.food_level = food_level;
		this.saturation = saturation;
		this.drink_level = drink_level;
		this.quenching = quenching;
		return this;
	}

	public FoodItem setNutriment(int food_level, float saturation, int drink_level, float quenching, int speed_eating) {
		this.food_level = food_level;
		this.saturation = saturation;
		this.drink_level = drink_level;
		this.quenching = quenching;
		this.speed_eating = speed_eating;
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
	/*
	public FoodForItem setTextureFood(String str1, String str2) {
		txr_tmp[0] = "foods/" + str1;
		txr_tmp[1] = str2 == "O" ? "foods/" + str1 + "_overlay" : "foods/" + str2 + str2;
		setTexture(txr_tmp);
		//setTexture("foods/" + str1, str2 == "O" ? "foods/" + str1 + "_overlay" : "foods/" + str2);
		return this;
	}

	public FoodForItem setTexture(String[] str) {
		for (int i = 0; i < str.length; i++) {
			if (str[i] == "0" || str[i] == "foods/0") {
				str[i] = "empty";
			}
			if (str[i] == "O") {
				str[i] = str[i - 1] + "_overlay";
			}
			if (str[i] == "foods/O") {
				str[i] = "foods/" + str[i - 1] + "_overlay";
			}
		}
		texture_name = str;
		return this;
	}
	 */
	public String toString() {
		return "FoodItem: " + getTag() + ".";
	}

}
