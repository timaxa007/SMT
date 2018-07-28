package smt.pack.magic.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import smt.pack.magic.tile.TileEntityChestExp;

public class ChestExpContainer extends Container {

	final TileEntityChestExp tile;

	public ChestExpContainer(final EntityPlayer player, final TileEntityChestExp te) {
		tile = te;
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return true;
	}

}
