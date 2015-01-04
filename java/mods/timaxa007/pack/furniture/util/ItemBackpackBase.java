package mods.timaxa007.pack.furniture.util;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ItemBackpackBase extends Item implements IBackpack {

	@Override
	public void openBackpackGui(ItemStack is) {
		NBTTagCompound tag = is.getTagCompound();
		if (tag == null) tag = new NBTTagCompound();
		
	}

	@Override
	public void closeBackpackGui(ItemStack is) {
		NBTTagCompound tag = is.getTagCompound();
		if (tag == null) tag = new NBTTagCompound();
		
	}

}
