package smt.pack.weapon.tile;

import cpw.mods.fml.common.registry.GameRegistry;
import smt.pack.weapon.SMTWeapon;

public final class TileEntites {

	public static final void init() {

		GameRegistry.registerTileEntity(TileEntityBlocksWeapon.class, SMTWeapon.MODID + "BlocksWeapon");
		GameRegistry.registerTileEntity(TileEntityAssemblyTable.class, SMTWeapon.MODID + "AssemblyTable");

	}

}
