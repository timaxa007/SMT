package smt.pack.magic.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import smt.pack.magic.SMTMagic;

public final class Blocks {

	public static Block
	blocksMagic,
	altar,
	teleport,
	chestExp,
	disenchanter,
	infuser
	;

	public static final void init() {

		blocksMagic = new BlockBlocksMagic().setBlockName("blocks_magic");
		GameRegistry.registerBlock(blocksMagic, "block_blocks_magic");

		altar = new BlockAltar().setBlockName("altar").setCreativeTab(SMTMagic.tabMagic).setHardness(1.0F).setBlockTextureName(SMTMagic.MODID + ":altar");
		GameRegistry.registerBlock(altar, "block_altar");

		teleport = new BlockTeleport().setBlockName("teleport").setCreativeTab(SMTMagic.tabMagic);
		GameRegistry.registerBlock(teleport, "block_teleport");

		chestExp = new BlockChestExp().setBlockName("chest_exp").setCreativeTab(SMTMagic.tabMagic);
		GameRegistry.registerBlock(chestExp, "block_chest_exp");

		disenchanter = new BlockDisenchanter().setBlockName("disenchanter").setCreativeTab(SMTMagic.tabMagic);
		GameRegistry.registerBlock(disenchanter, "block_disenchanter");

		infuser = new BlockInfuser().setBlockName("infuser").setCreativeTab(SMTMagic.tabMagic);
		GameRegistry.registerBlock(infuser, "block_infuser");

	}

}
