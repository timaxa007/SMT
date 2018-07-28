package smt.pack.cookery.tile;

import cpw.mods.fml.common.registry.GameRegistry;
import smt.pack.cookery.SMTCookery;

public final class TileEntites {

	public static final void init() {

		GameRegistry.registerTileEntity(TileEntityGrill.class, SMTCookery.MODID + "Grill");

	}

}
