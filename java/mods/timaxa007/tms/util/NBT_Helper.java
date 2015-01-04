package mods.timaxa007.tms.util;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class NBT_Helper {

	public void saveNBTData(NBTTagCompound tag) {

	}

	public void loadNBTData(NBTTagCompound tag) {

	}

	public ItemStack saveNBTData(ItemStack is) {
		NBTTagCompound tag = is.getTagCompound();
		if (tag == null) {tag = new NBTTagCompound();}
		return is;
	}

	public ItemStack loadNBTData(ItemStack is) {
		NBTTagCompound tag = is.getTagCompound();
		if (tag == null) {tag = new NBTTagCompound();}
		return is;
	}

	public void readFromNBT(NBTTagCompound nbt) {

	}

	public void writeToNBT(NBTTagCompound nbt) {

	}

}
