package smt.pack.common.tile;

import cpw.mods.fml.common.registry.GameRegistry;
import smt.pack.common.SMTCommon;

public final class TileEntites {

	public static final void init() {

		GameRegistry.registerTileEntity(TileEntityCommonTest.class, SMTCommon.MODID + "CommonTest");
		GameRegistry.registerTileEntity(TileEntityAnimation.class, SMTCommon.MODID + "Animation");

	}

}
