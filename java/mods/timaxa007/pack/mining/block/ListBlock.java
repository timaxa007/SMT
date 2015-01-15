package mods.timaxa007.pack.mining.block;

import mods.timaxa007.pack.mining.tile.*;
import mods.timaxa007.tms.util.UtilTMS;
import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;

public class ListBlock {

	public static Block 
	ore_rock_ores, 
	ore_nether_ores, 
	ore_ender_ores, 
	cristals;

	public static Block[] list_block;

	public static void preInit() {

		ore_rock_ores = new OreOres("ore_rock_ores").setBlockTextureName("stone");
		ore_nether_ores = new OreOres("ore_nether_ores").setBlockTextureName("netherrack");
		ore_ender_ores = new OreOres("ore_ender_ores").setBlockTextureName("end_stone");
		cristals = new BlockCristals("cristals");

		list_block = new Block[] {
				ore_rock_ores, 
				ore_nether_ores, 
				ore_ender_ores, 
				cristals
		};

		for (int i = 0; i < list_block.length; i++) 
			UtilTMS.UtilBlock.RegBlock(list_block[i]);

		GameRegistry.registerTileEntity(TileEntityCristals.class, "TileEntityCristals");
		GameRegistry.registerTileEntity(TileEntityOreOres.class, "TileEntityOreOres");

	}

}
