package timaxa007.pack.decorative.block;

import net.minecraft.block.Block;
import timaxa007.core.object.BlockDummy;
import cpw.mods.fml.common.registry.GameRegistry;

public class ListBlock {

	public static Block
	test
	;

	public static Block[] list;

	public static void init() {

		//test = new BlockTest("test");

		list = new Block[] {
				test
		};

		for (Block block : list) {
			if (block != null && block instanceof BlockDummy)
				GameRegistry.registerBlock(block, "block_" + ((BlockDummy)block).getTag());
		}

		//GameRegistry.registerTileEntity(TileEntityTest.class, "TileEntityTest");

	}

}
