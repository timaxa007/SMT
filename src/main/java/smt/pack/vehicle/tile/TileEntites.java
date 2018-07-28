package smt.pack.vehicle.tile;

import cpw.mods.fml.common.registry.GameRegistry;
import smt.pack.vehicle.SMTVehicle;

public final class TileEntites {

	public static Class/*<? extends TileEntity>*/[] tiles;

	public static final void init() {

		tiles = new Class[] {
				//TileEntityAltar.class
		};

		for (Class tile : tiles)
			if (tile != null)
				GameRegistry.registerTileEntity(tile, SMTVehicle.MODID + "_"  + tile.getSimpleName());

	}

}
