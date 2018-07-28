package smt.pack.common.tile;

import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TileEntityCommonTest extends TileEntity {

	private ItemStack displayItem = null;

	public TileEntityCommonTest() {

	}

	public void setDisplayItem(ItemStack itemStack) {
		displayItem = itemStack;
	}

	public ItemStack getDisplayItem() {
		return displayItem;
	}

}
