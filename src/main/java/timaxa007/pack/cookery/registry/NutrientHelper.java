package timaxa007.pack.cookery.registry;

import net.minecraft.nbt.NBTTagCompound;

public class NutrientHelper {
	//-----------------------------------------------------------------------------------------------
	public void readFromNBT(NBTTagCompound nbt) {
		NBTTagCompound nbt_tag = (NBTTagCompound)nbt.getTag("Nutrient");
		if (nbt_tag != null) {
			//tag = nbt_tag.getString("Tag");
		}
	}

	public void writeToNBT(NBTTagCompound nbt) {
		NBTTagCompound nbt_tag = new NBTTagCompound();
		//nbt_tag.setString("Tag", tag);
		nbt.setTag("Nutrient", nbt_tag);
	}

	public String getTag(NBTTagCompound nbt) {
		NBTTagCompound nbt_tag = (NBTTagCompound)nbt.getTag("Nutrient");
		if (nbt_tag != null) {
			return nbt_tag.getString("Tag");
		}
		return null;
	}
	//-----------------------------------------------------------------------------------------------
}
