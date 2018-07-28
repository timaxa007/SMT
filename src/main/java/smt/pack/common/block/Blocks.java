package smt.pack.common.block;

import java.util.HashSet;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import smt.pack.common.SMTCommon;
import smt.pack.common.api.IRegisterItem;

public final class Blocks {

	public static final void init() {
		final HashSet<Block> set = new HashSet<Block>();
		set.add(new BlockBlocksCommon().setBlockName("blocks_common").setBlockTextureName(SMTCommon.MODID + ":blocks_common").setCreativeTab(SMTCommon.tabCommon).setHardness(1.0F));
		set.add(new BlockAnimation().setBlockName("animation").setBlockTextureName(SMTCommon.MODID + ":animation").setCreativeTab(SMTCommon.tabCommon).setHardness(1.0F));
		set.add(new BlockTest().setBlockName("test").setCreativeTab(SMTCommon.tabCommon).setHardness(1.0F));

		for (Block block : set) {
			if (block instanceof IRegisterItem) {
				IRegisterItem regItem = (IRegisterItem)block;
				GameRegistry.registerBlock(block, regItem.getRegisterName());
				regItem.getRegisterItem(smt.pack.common.api.RegisteredItems.get());
			} else
				GameRegistry.registerBlock(block, block.getUnlocalizedName().substring(5));
		}

	}

}
