package smt.pack.technology.api;

import net.minecraft.item.ItemStack;

public interface IItemEIM {

	boolean hasEIM(ItemStack itemStack);
	boolean callEIM(ItemStack item, int findID);

}
