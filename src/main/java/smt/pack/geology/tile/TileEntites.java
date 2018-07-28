package smt.pack.geology.tile;

import cpw.mods.fml.common.registry.GameRegistry;
import smt.pack.geology.SMTGeology;

public final class TileEntites {

	public static final void init() {

		GameRegistry.registerTileEntity(TileEntityBlockOres.class, SMTGeology.MODID + "BlockOres");

	}

}
