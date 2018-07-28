package smt.pack.decorative.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import smt.pack.decorative.SMTDecorative;

public final class Blocks {

	public static Block
	blocks_decorative,
	dirt,
	wood,
	stone,
	metal,
	cloth,
	glass,
	foliage,
	sit,
	stand,
	chest,
	barrier,
	fake,
	crasher,
	model_view,
	test
	;

	public static final void init() {

		blocks_decorative = new BlockBlocksDecorative().setBlockName("blocks_decorative").setCreativeTab(SMTDecorative.tabDecorative);
		GameRegistry.registerBlock(blocks_decorative, "block_blocks_decorative");

		dirt = new BlockDecorativeDirt().setBlockName("dirt").setCreativeTab(SMTDecorative.tabDecorative);
		GameRegistry.registerBlock(dirt, "block_dirt");

		wood = new BlockDecorativeWood().setBlockName("wood").setCreativeTab(SMTDecorative.tabDecorative);
		GameRegistry.registerBlock(wood, "block_wood");

		stone = new BlockDecorativeStone().setBlockName("stone").setCreativeTab(SMTDecorative.tabDecorative);
		GameRegistry.registerBlock(stone, "block_stone");

		metal = new BlockDecorativeMetal().setBlockName("metal").setCreativeTab(SMTDecorative.tabDecorative);
		GameRegistry.registerBlock(metal, "block_metal");

		cloth = new BlockDecorativeCloth().setBlockName("cloth").setCreativeTab(SMTDecorative.tabDecorative);
		GameRegistry.registerBlock(cloth, "block_cloth");

		glass = new BlockDecorativeGlass().setBlockName("glass").setCreativeTab(SMTDecorative.tabDecorative);
		GameRegistry.registerBlock(glass, "block_glass");

		foliage = new BlockDecorativeFoliage().setBlockName("foliage").setCreativeTab(SMTDecorative.tabDecorative);
		GameRegistry.registerBlock(foliage, "block_foliage");

		sit = new BlockSit().setBlockName("sit").setCreativeTab(SMTDecorative.tabDecorative);
		GameRegistry.registerBlock(sit, "block_sit");

		stand = new BlockStand().setBlockName("stand").setCreativeTab(SMTDecorative.tabDecorative);
		GameRegistry.registerBlock(stand, "block_stand");

		chest = new BlockChest().setBlockName("chest").setCreativeTab(SMTDecorative.tabDecorative);
		GameRegistry.registerBlock(chest, "block_chest");

		barrier = new BlockBarrier().setBlockName("barrier").setCreativeTab(SMTDecorative.tabDecorative);
		GameRegistry.registerBlock(barrier, "block_barrier");

		fake = new BlockFake().setBlockName("fake").setCreativeTab(SMTDecorative.tabDecorative);
		GameRegistry.registerBlock(fake, "block_fake");

		crasher = new BlockCrasher().setBlockName("crasher").setCreativeTab(SMTDecorative.tabDecorative);
		GameRegistry.registerBlock(crasher, "block_crasher");

		model_view = new BlockModelView().setBlockName("model_view").setCreativeTab(SMTDecorative.tabDecorative);
		GameRegistry.registerBlock(model_view, "block_model_view");

		test = new BlockTest().setBlockName("test").setCreativeTab(SMTDecorative.tabDecorative);
		GameRegistry.registerBlock(test, "block_test");

	}

}
