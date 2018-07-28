package smt.pack.vehicle.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public final class Blocks {

	public static Block
	blocksVehicle
	;

	public static final void init() {

		blocksVehicle = new BlockBlocksVehicle().setBlockName("blocks_vehicle");
		GameRegistry.registerBlock(blocksVehicle, "block_blocks_vehicle");

	}

}
