package mods.timaxa007.pack.furniture.util;

import mods.timaxa007.tms.util.ModifiedItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ItemBackpackBase extends ModifiedItem implements IBackpack {

	public ItemBackpackBase(String tag) {
		super(tag);
	}

	@Override
	public void openBackpackGui(ItemStack is) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt == null) nbt = new NBTTagCompound();

	}

	@Override
	public void closeBackpackGui(ItemStack is) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt == null) nbt = new NBTTagCompound();

	}

}
