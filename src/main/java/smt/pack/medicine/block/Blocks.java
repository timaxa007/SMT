package smt.pack.medicine.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import smt.pack.medicine.SMTMedicine;

public final class Blocks {

	public static Block
	blocksMedicine
	;

	public static final void init() {

		blocksMedicine = new BlockBlocksMedicine().setBlockName("blocks_medicine").setCreativeTab(SMTMedicine.tabMedicine);
		GameRegistry.registerBlock(blocksMedicine, "block_blocks_medicine");

	}

}
