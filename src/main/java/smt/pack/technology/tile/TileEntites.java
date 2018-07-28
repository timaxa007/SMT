package smt.pack.technology.tile;

import cpw.mods.fml.common.registry.GameRegistry;
import smt.pack.technology.SMTTechnology;

public final class TileEntites {

	public static final void init() {

		GameRegistry.registerTileEntity(TileEntityBlocksTechnology.class, SMTTechnology.MODID + "BlocksTechnology");
		GameRegistry.registerTileEntity(TileEntityElectricMachine.class, SMTTechnology.MODID + "ElectricMachine");

	}

}
