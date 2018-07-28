package smt.pack.decorative.tile;

import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityChest extends TileEntity {

	public ItemStack mimickStack;
	public int prevLidAngle;
	public int lidAngle;
	public ForgeDirection orientation;

	public TileEntityChest() {

	}

	public boolean func_145830_o() {
		return false;
	}

	public int func_145832_p() {
		return 0;
	}

}
