package smt.pack.magic.tile;

import cpw.mods.fml.common.registry.GameRegistry;
import smt.pack.magic.SMTMagic;

public final class TileEntites {

	public static final void init() {

		GameRegistry.registerTileEntity(TileEntityAltar.class, SMTMagic.MODID + "Altar");
		GameRegistry.registerTileEntity(TileEntityTeleport.class, SMTMagic.MODID + "Teleport");
		GameRegistry.registerTileEntity(TileEntityChestExp.class, SMTMagic.MODID + "ChestExp");
		GameRegistry.registerTileEntity(TileEntityDisenchanter.class, SMTMagic.MODID + "Disenchanter");
		GameRegistry.registerTileEntity(TileEntityInfuser.class, SMTMagic.MODID + "Infuser");

	}

}
