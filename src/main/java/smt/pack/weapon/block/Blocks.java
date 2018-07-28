package smt.pack.weapon.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import smt.pack.weapon.SMTWeapon;

public final class Blocks {

	public static Block
	blocksWeapon
	;

	public static final void init() {

		blocksWeapon = new BlockBlocksWeapon().setBlockName("blocks_weapon").setCreativeTab(SMTWeapon.tabWeapon);
		GameRegistry.registerBlock(blocksWeapon, "block_blocks_weapon");

	}

}
