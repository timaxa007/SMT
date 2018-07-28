package smt.pack.weapon.inventory;

import net.minecraft.entity.player.EntityPlayer;
import smt.pack.weapon.tile.TileEntityAssemblyTable;

public class AssemblyTableContainer extends net.minecraft.inventory.Container {

	final EntityPlayer player;
	final TileEntityAssemblyTable tile;

	public AssemblyTableContainer(EntityPlayer player, TileEntityAssemblyTable tile) {
		this.player = player;
		this.tile = tile;
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return true;
	}

}
