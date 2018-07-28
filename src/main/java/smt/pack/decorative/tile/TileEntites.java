package smt.pack.decorative.tile;

import cpw.mods.fml.common.registry.GameRegistry;
import smt.pack.decorative.SMTDecorative;

public final class TileEntites {

	public static final void init() {

		GameRegistry.registerTileEntity(TileEntityBlocksDecorative.class, SMTDecorative.MODID + "BlocksDecorative");
		GameRegistry.registerTileEntity(TileEntitySit.class, SMTDecorative.MODID + "Sit");
		GameRegistry.registerTileEntity(TileEntityStand.class, SMTDecorative.MODID + "Stand");
		GameRegistry.registerTileEntity(TileEntityChest.class, SMTDecorative.MODID + "Chest");
		GameRegistry.registerTileEntity(TileEntityCrusher.class, SMTDecorative.MODID + "Crusher");
		GameRegistry.registerTileEntity(TileEntityModelView.class, SMTDecorative.MODID + "ModelView");

	}

}
