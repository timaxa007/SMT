package timaxa007.module.weight.util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class PlayerWeight implements IExtendedEntityProperties {

	public final static String WEIGHT_NAME = "SystemWeight";
//	private float weight;
	private float weight_max;

	@Override
	public void init(Entity entity, World world) {
//		weight = 0.0F;
		weight_max = 100.0F;
	}

	public PlayerWeight() {
//		weight = 0.0F;
		weight_max = 100.0F;
	}

	public static void reg(EntityPlayer player) {
		player.registerExtendedProperties(WEIGHT_NAME, new PlayerWeight());
	}

	public static PlayerWeight get(EntityPlayer player) {
		return (PlayerWeight)player.getExtendedProperties(WEIGHT_NAME);
	}

	@Override
	public void saveNBTData(NBTTagCompound nbt) {
		NBTTagCompound nbt_tag = new NBTTagCompound();
//		nbt_tag.setFloat("Weight", weight);
		nbt_tag.setFloat("WeightMax", weight_max);
		nbt.setTag(WEIGHT_NAME, nbt_tag);
	}

	@Override
	public void loadNBTData(NBTTagCompound nbt) {
		NBTTagCompound nbt_tag = (NBTTagCompound)nbt.getTag(WEIGHT_NAME);
//		weight = nbt_tag.getFloat("Weight");
		weight_max = nbt_tag.getFloat("WeightMax");
	}

	public void addWeightMax(float weight_max) {
		this.weight_max += weight_max;
	}

	public void setWeightMax(float weight_max) {
		this.weight_max = weight_max;
	}

	public float getWeightMax() {
		return weight_max;
	}
/*
	public void setWeight(float weight) {
		this.weight = weight;
	}

	public float getWeight() {
		return weight;
	}
*/
}
