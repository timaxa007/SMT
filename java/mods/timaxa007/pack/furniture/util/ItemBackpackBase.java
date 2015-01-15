package mods.timaxa007.pack.furniture.util;

import mods.timaxa007.tms.util.ItemFixReg;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ItemBackpackBase extends ItemFixReg implements IBackpack {

	public ItemBackpackBase(String tag) {
		super(tag);
	}

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
