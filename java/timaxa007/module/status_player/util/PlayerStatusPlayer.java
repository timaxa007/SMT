package timaxa007.module.status_player.util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class PlayerStatusPlayer implements IExtendedEntityProperties {

	public final static String WEIGHT_NAME = "StatusPlayer";

	private static float p_health;
	private static float p_blood;

	private static float p_protein;
	private static float p_fat;
	private static float p_carbohydrate;

	private static float p_oxygen;
	private static float p_water;

	private static float p_salt;
	private static float p_sugar;

	private static float p_herb;
	private static float p_meat;

	private static float p_temperature;
	private static float p_humidity;

	private static float p_stomach;

	static {

		p_health = 1.0F;
		p_blood = 1.0F;

		p_protein = 1.0F;
		p_fat = 1.0F;
		p_carbohydrate = 1.0F;

		p_oxygen = 1.0F;
		p_water = 1.0F;

		p_salt = 1.0F;
		p_sugar = 1.0F;

		p_herb = 1.0F;
		p_meat = 1.0F;

		p_temperature = 1.0F;
		p_humidity = 1.0F;

		p_stomach = 1.0F;

	}

	@Override
	public void init(Entity entity, World world) {

	}

	public PlayerStatusPlayer() {

	}

	public static void reg(EntityPlayer player) {
		player.registerExtendedProperties(WEIGHT_NAME, new PlayerStatusPlayer());
	}

	public static PlayerStatusPlayer get(EntityPlayer player) {
		return (PlayerStatusPlayer)player.getExtendedProperties(WEIGHT_NAME);
	}

	@Override
	public void saveNBTData(NBTTagCompound nbt) {
		NBTTagCompound nbt_tag = new NBTTagCompound();

		nbt_tag.setFloat("Health", p_health);
		nbt_tag.setFloat("Blood", p_blood);

		nbt_tag.setFloat("Protein", p_protein);
		nbt_tag.setFloat("Fat", p_fat);
		nbt_tag.setFloat("Carbohydrate", p_carbohydrate);

		nbt_tag.setFloat("Oxygen", p_oxygen);
		nbt_tag.setFloat("Water", p_water);

		nbt_tag.setFloat("Salt", p_salt);
		nbt_tag.setFloat("Sugar", p_sugar);

		nbt_tag.setFloat("Herb", p_herb);
		nbt_tag.setFloat("Meat", p_meat);

		nbt_tag.setFloat("Temperature", p_temperature);
		nbt_tag.setFloat("Humidity", p_humidity);

		nbt_tag.setFloat("Stomach", p_stomach);

		nbt.setTag(WEIGHT_NAME, nbt_tag);
	}

	@Override
	public void loadNBTData(NBTTagCompound nbt) {
		NBTTagCompound nbt_tag = (NBTTagCompound)nbt.getTag(WEIGHT_NAME);

		p_health = nbt_tag.getFloat("Health");
		p_blood = nbt_tag.getFloat("Blood");

		p_protein = nbt_tag.getFloat("Protein");
		p_fat = nbt_tag.getFloat("Fat");
		p_carbohydrate = nbt_tag.getFloat("Carbohydrate");

		p_oxygen = nbt_tag.getFloat("Oxygen");
		p_water = nbt_tag.getFloat("Water");

		p_salt = nbt_tag.getFloat("Salt");
		p_sugar = nbt_tag.getFloat("Sugar");

		p_herb = nbt_tag.getFloat("Herb");
		p_meat = nbt_tag.getFloat("Meat");

		p_temperature = nbt_tag.getFloat("Temperature");
		p_humidity = nbt_tag.getFloat("Humidity");

		p_stomach = nbt_tag.getFloat("Stomach");

	}
	//-----------------------------------
	public void addHealth(float health) {p_health += health;}
	public void setHealth(float health) {p_health = health;}
	public float getHealth() {return p_health;}
	//-----------------------------------
	public void addBlood(float blood) {p_blood += blood;}
	public void setBlood(float blood) {p_blood = blood;}
	public float getBlood() {return p_blood;}
	//-----------------------------------
	public void addProtein(float protein) {p_protein += protein;}
	public void setProtein(float protein) {p_protein = protein;}
	public float getProtein() {return p_protein;}
	//-----------------------------------
	public void addFat(float fat) {p_fat += fat;}
	public void setFat(float fat) {p_fat = fat;}
	public float getFat() {return p_fat;}
	//-----------------------------------
	public void addCarbohydrate(float carbohydrate) {p_carbohydrate += carbohydrate;}
	public void setCarbohydrate(float carbohydrate) {p_carbohydrate = carbohydrate;}
	public float getCarbohydrate() {return p_carbohydrate;}
	//-----------------------------------
	public void addOxygen(float oxygen) {p_oxygen += oxygen;}
	public void setOxygen(float oxygen) {p_oxygen = oxygen;}
	public float getOxygen() {return p_oxygen;}
	//-----------------------------------
	public boolean isAddWater() {return (((p_water /*+ nutriment*/) < p_stomach) ? true : false );}
	public void addWater(float water) {p_water += water;}
	public void setWater(float water) {p_water = water;}
	public float getWater() {return p_water;}
	//-----------------------------------
	public void addSalt(float salt) {p_salt += salt;}
	public void setSalt(float salt) {p_salt = salt;}
	public float getSalt() {return p_salt;}
	//-----------------------------------
	public void addSugar(float sugar) {p_sugar += sugar;}
	public void setSugar(float sugar) {p_sugar = sugar;}
	public float getSugar() {return p_sugar;}
	//-----------------------------------
	public void addHerb(float herb) {p_herb += herb;}
	public void setHerb(float herb) {p_herb = herb;}
	public float getHerb() {return p_herb;}
	//-----------------------------------
	public void addMeat(float meat) {p_meat += meat;}
	public void setMeat(float meat) {p_meat = meat;}
	public float getMeat() {return p_meat;}
	//-----------------------------------
	public void addTemperature(float temperature) {p_temperature += temperature;}
	public void setTemperature(float temperature) {p_temperature = temperature;}
	public float getTemperature() {return p_temperature;}
	//-----------------------------------
	public void addHumidity(float humidity) {p_humidity += humidity;}
	public void setHumidity(float humidity) {p_humidity = humidity;}
	public float getHumidity() {return p_humidity;}
	//-----------------------------------
	public void addStomach(float stomach) {p_stomach += stomach;}
	public void setStomach(float stomach) {p_stomach = stomach;}
	public float getStomach() {return p_stomach;}
	//-----------------------------------
}
