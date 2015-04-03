package timaxa007.module.status_player.util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class PlayerStatusPlayer implements IExtendedEntityProperties {

	public final static String WEIGHT_NAME = "StatusPlayer";
	private float health;
	private float blood;

	private float protein;
	private float fat;
	private float carbohydrate;
	private float vitamin;
	private float minerals;
	private float micronutrients;

	private float water;
	private float oxygen;
	private float temperature;
	private float salt;
	private float sugar;
	private float stomach;

	@Override
	public void init(Entity entity, World world) {
		health = 100.0F;
		blood = 5.000F;
		//nutriment = 5.000F;
		water = 5.000F;
		oxygen = 5.000F;
		temperature = 5.000F;
		salt = 5.000F;
		sugar = 5.000F;
		stomach = 5.000F;
	}

	public PlayerStatusPlayer() {
		health = 100.0F;
		blood = 5.000F;
		//nutriment = 5.000F;
		water = 5.000F;
		oxygen = 5.000F;
		temperature = 5.000F;
		salt = 5.000F;
		sugar = 5.000F;
		stomach = 5.000F;
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
		nbt_tag.setFloat("Health", health);
		nbt_tag.setFloat("Blood", blood);
		//nbt_tag.setFloat("Nutriment", nutriment);
		nbt_tag.setFloat("Water", water);
		nbt_tag.setFloat("Oxygen", oxygen);
		nbt_tag.setFloat("Temperature", temperature);
		nbt_tag.setFloat("Salt", salt);
		nbt_tag.setFloat("Sugar", sugar);
		nbt_tag.setFloat("Stomach", stomach);
		nbt.setTag(WEIGHT_NAME, nbt_tag);
	}

	@Override
	public void loadNBTData(NBTTagCompound nbt) {
		NBTTagCompound nbt_tag = (NBTTagCompound)nbt.getTag(WEIGHT_NAME);
		health = nbt_tag.getFloat("Health");
		blood = nbt_tag.getFloat("Blood");
		//nutriment = nbt_tag.getFloat("Nutriment");
		water = nbt_tag.getFloat("Water");
		oxygen = nbt_tag.getFloat("Oxygen");
		temperature = nbt_tag.getFloat("Temperature");
		salt = nbt_tag.getFloat("Salt");
		sugar = nbt_tag.getFloat("Sugar");
		stomach = nbt_tag.getFloat("Stomach");
	}
	//-----------------------------------
	public void addHealth(float health) {this.health += health;}
	public void setHealth(float health) {this.health = health;}
	public float getHealth() {return health;}
	//-----------------------------------
	public void addBlood(float blood) {this.blood += blood;}
	public void setBlood(float blood) {this.blood = blood;}
	public float getBlood() {return blood;}
	//-----------------------------------
	/*public boolean isAddNutriment() {return (((nutriment + water) < stomach) ? true : false );}
	public void addNutriment(float nutriment) {this.nutriment += nutriment;}
	public void setNutriment(float nutriment) {this.nutriment = nutriment;}
	public float getNutriment() {return nutriment;}*/
	//-----------------------------------
	public boolean isAddWater() {return (((water /*+ nutriment*/) < stomach) ? true : false );}
	public void addWater(float water) {this.water += water;}
	public void setWater(float water) {this.water = water;}
	public float getWater() {return water;}
	//-----------------------------------
	public void addOxygen(float oxygen) {this.oxygen += oxygen;}
	public void setOxygen(float oxygen) {this.oxygen = oxygen;}
	public float getOxygen() {return oxygen;}
	//-----------------------------------
	public void addTemperature(float temperature) {this.temperature += temperature;}
	public void setTemperature(float temperature) {this.temperature = temperature;}
	public float getTemperature() {return temperature;}
	//-----------------------------------
	public void addSalt(float salt) {this.salt += salt;}
	public void setSalt(float salt) {this.salt = salt;}
	public float getSalt() {return salt;}
	//-----------------------------------
	public void addSugar(float sugar) {this.sugar += sugar;}
	public void setSugar(float sugar) {this.sugar = sugar;}
	public float getSugar() {return sugar;}
	//-----------------------------------
	public void addStomach(float stomach) {this.stomach += stomach;}
	public void setStomach(float stomach) {this.stomach = stomach;}
	public float getStomach() {return stomach;}
	//-----------------------------------
}
