package smt.pack.phytology.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import smt.pack.phytology.SMTPhytology;

public final class Blocks {

	public static Block
	blocksPhytology,
	mushroom,
	log,
	leaves,
	sapling
	;

	public static final void init() {

		blocksPhytology = new BlockBlocksPhytology().setBlockName("blocks_phytology").setCreativeTab(SMTPhytology.tabPhytology);
		GameRegistry.registerBlock(blocksPhytology, "block_blocks_phytology");

		mushroom = new BlockMushroom().setBlockName("mushroom").setCreativeTab(SMTPhytology.tabPhytology);
		GameRegistry.registerBlock(mushroom, "block_mushroom");

		log = new BlockLog().setBlockName("log").setCreativeTab(SMTPhytology.tabPhytology).setBlockTextureName(SMTPhytology.MODID + ":log");
		GameRegistry.registerBlock(log, "block_log");

		leaves = new BlockLeaves().setBlockName("leaves").setCreativeTab(SMTPhytology.tabPhytology).setBlockTextureName(SMTPhytology.MODID + ":leaves");
		GameRegistry.registerBlock(leaves, ItemBlockLeaves.class, "block_leaves");

		sapling = new BlockSapling().setBlockName("sapling").setCreativeTab(SMTPhytology.tabPhytology);
		GameRegistry.registerBlock(sapling, ItemBlockSapling.class, "block_sapling");

	}

}
